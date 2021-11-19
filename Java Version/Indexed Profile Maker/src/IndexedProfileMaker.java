/*
   Author: Collin Schofield
   Date Created: 8/26/2021
   Purpose: Create multiple indexed copies of Controller profiles for dolphin
*/
import java.util.*;
import java.io.*;

public class IndexedProfileMaker
{
   public static void main(String args[]) throws IOException
   {
      // Setup
      Scanner fileReader;
      Scanner keyboardReader = new Scanner(System.in);

      File profileDir;

      String profileName = new String();//.ini files
      File profileToCopy;

      int profileCount = -1;

      ArrayList<String> profileData = new ArrayList<String>();


      // Inputs
      do{// Get the path containing the gamepad profile
         String filePath = new String();

         System.out.print("Please enter the path to the folder where this profile is currently saved: ");
         filePath = keyboardReader.nextLine();

         profileDir = new File(filePath);

         if(!profileDir.isDirectory()){
            System.out.println("The path you entered was not a valid directory! Please enter a valid directory.");
         }
      }while(!profileDir.isDirectory());


      do{// Get the name of the controller profile to copy
         System.out.print("Please enter the name of the controller profile you would like to replicate: ");
         profileName = keyboardReader.nextLine();

         profileToCopy = new File(profileDir, profileName + ".ini");

         if(!profileToCopy.isFile()){
            System.out.println("No gamepad profile with that name exists! Please enter a valid profile name.");
         }
      }while(!profileToCopy.isFile());


      fileReader = new Scanner(profileToCopy);

      do{
         System.out.print("Please enter the number of controller profiles you would like to make: ");
         profileCount = keyboardReader.nextInt();

         if(profileCount <= 0){
            System.out.println("Please enter a count greater than 0");
         }
      }while(profileCount <= 0);


      while(fileReader.hasNext()){
         String line = fileReader.nextLine();
         profileData.add(line);
      }


      // Calculations
      String controllerProfileType = profileData.get(1);
      String controllerApiType = controllerProfileType.substring(0, controllerProfileType.indexOf("/")+1);
      String controllerName = controllerProfileType.substring(controllerProfileType.lastIndexOf("/"));


      // Outputs
      for(int profileNum = 0; profileNum < profileCount; profileNum++){
         File currProfile = new File(profileDir, profileName + " " + profileNum + ".ini");
         FileWriter fW = new FileWriter(currProfile);
         PrintWriter output = new PrintWriter(fW);

         profileData.set(1, controllerApiType + profileNum + controllerName);

         for(int lcv = 0; lcv < profileData.size(); lcv++){
            output.println(profileData.get(lcv));
         }

         output.close();
         fW.close();
      }

      fileReader.close();
      keyboardReader.close();
   }// End of Code
}
