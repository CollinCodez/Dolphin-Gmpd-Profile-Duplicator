/*
   Author: Collin Schofield
   Date Created: 11/18/2021
   Purpose: Copy all gamepad profiles from one folder into the corresponding folders of multiple portable dolphin emulators.
*/
import java.util.*;
import java.io.*;

public class ProfileFolderCopier
{
   // Copy the proivided file to the path specified
   public static boolean copyFile(File fileToCopy, File destDir, String dolphinNames, String subPath, int numDolphins){
      if(fileToCopy.isDirectory()){
         for(File f : fileToCopy.listFiles())
         {
            copyFile(
               f,
               destDir,
               dolphinNames,
               subPath + "\\" + fileToCopy.getName(),
               numDolphins
            );// Recursive call when a subfolder is found
         }
         return true;
      }else{
         ArrayList<String> profileData = new ArrayList<String>();

         // Copy data from original file
         try{// Attempt to open the file
            Scanner fileReader = new Scanner(fileToCopy);

            while(fileReader.hasNext())
            {// Save all data from the file
               String line = fileReader.nextLine();
               profileData.add(line);
            }

            fileReader.close();

            System.out.println("\nFile read successfully: " + fileToCopy.getAbsolutePath());
         }catch(IOException e){
            System.out.println("ERROR: Failed to read " + fileToCopy.getAbsolutePath());
            return false;
         }


         // Save files to destination location
         for(int i = 1; i <= numDolphins; i++)
         {// Loop through all of the dolphin portables
            File currDolphinSubDir = new File(
               destDir,
               dolphinNames + i + subPath
            );


            if(!currDolphinSubDir.exists())
            {// Make the folder if it does not exist
               currDolphinSubDir.mkdirs();
               System.out.println("Making directory: " + currDolphinSubDir.getAbsolutePath());
            }

            File currFile = new File(currDolphinSubDir, fileToCopy.getName());

            //System.out.println("Copying to: " + currFile.getAbsolutePath());

            try{// Attempt to open the file
               FileWriter fW = new FileWriter(currFile);
               PrintWriter output = new PrintWriter(fW);


               for(int lcv = 0; lcv < profileData.size(); lcv++)
               {
                  output.println(profileData.get(lcv));
               }

               output.close();
               fW.close();

               System.out.println("File copied successfully: " + currFile.getAbsolutePath());
            }catch(IOException e){
               System.out.println("ERROR: Failed to write to " + currFile.getAbsolutePath());
               return false;
            }
         }// END of loop through dolphins


         return true;
      }
   }// END of copyFile()



   public static void main(String args[]) throws IOException
   {
      // Setup
      Scanner keyboardReader = new Scanner(System.in);

      File originalDir;

      File dolphinsDir;
      String dolphinsNames = new String();

      String profileSubpath = new String();

      int numPortables = -1;
      int profilesType = 0;


      // Inputs

      do{// Get the path containing the profiles to copy
         String originFolderPath = new String();

         System.out.print("Please enter the path of folder containing the profiles you would like to replicate: ");
         originFolderPath = keyboardReader.nextLine();

         originalDir = new File(originFolderPath);

         if(!originalDir.isDirectory()){
            System.out.println("The path you entered was not a valid directory! Please enter a valid directory.");
         }
      }while(!originalDir.isDirectory());



      do{// Get the path containing the portable dolphins
         String dolphinsPath = new String();

         System.out.print("Please enter the path of folder that contains all of the portable dolphins you would like to copy to: ");
         dolphinsPath = keyboardReader.nextLine();

         dolphinsDir = new File(dolphinsPath);

         if(!dolphinsDir.isDirectory()){
            System.out.println("The path you entered was not a valid directory! Please enter a valid directory.");
         }
      }while(!dolphinsDir.isDirectory());


      {// Block to restrict tempDir to this while loop
         File tempDir;

         do{// Get the names of the Portable Dolphin's folders
         System.out.println("Please enter the base name of folders containing the portable dolphins (Include any spaces!): ");
         System.out.print("Note: If your dolphins are simply numbered, simply press enter: ");
            dolphinsNames = keyboardReader.nextLine();

            tempDir = new File(dolphinsDir, dolphinsNames + 1);

            if(!tempDir.isDirectory()){
               System.out.println("No folders with that name existed! Please enter a valid directory.");
            }
         }while(!tempDir.isDirectory());
      }



      do{// Get the number of dolphins this will by copying to
         System.out.print("Please enter the number of portable dolphins you would like to replicate profiles into: ");
         numPortables = keyboardReader.nextInt();

         if(numPortables <= 0){
            System.out.println("Please enter a count greater than 0");
         }
      }while(numPortables <= 0);



      do{// Determine what kind of profiles the tool will be copying
         System.out.println("Select the type of profiles you are copying: ");
         System.out.println("   1 - Gamecube and Wii Profiles");
         System.out.println("   2 - Gamecube Profiles Only");
         System.out.println("   3 - Wii Profiles Only");
         System.out.print("Please enter the number for the mode you would like to select: ");
         profilesType = keyboardReader.nextInt();

         if((profilesType < 1) || (profilesType > 3)){
            System.out.println("You must enter a number between 1 and 3 (inclusive)!");
         }
      }while((profilesType < 1) || (profilesType > 3));



      // Calculations

      profileSubpath = "\\Sys\\Profiles\\";
      switch(profilesType){
         case 1:
            break;// profilesSubpath is good 
         case 2:
            profileSubpath += "GCPad\\";
            break;
         case 3:
            profileSubpath += "Wiimote\\";
            break;
         default:
            break;
      }


      // Output files
      System.out.println("\n\nBeginning File copying:");
      for(File f : originalDir.listFiles())
      {// Copy all the files to all of the dolphins
         copyFile(
            f,
            dolphinsDir,
            dolphinsNames,
            profileSubpath,
            numPortables
         );
      }

      keyboardReader.close();
   }// END of Main
}