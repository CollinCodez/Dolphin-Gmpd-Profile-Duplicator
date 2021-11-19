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

      String filePath = new String();
      String fileName = new String();//.ini files
      int profileCount = -1;

      ArrayList<String> profileData = new ArrayList<String>();


      // Inputs
      System.out.print("Please enter the name of the controller profile you would like to replicate: ");
      fileName = keyboardReader.nextLine();

      System.out.print("Please enter the path to the folder where this profile is currently saved: ");
      filePath = keyboardReader.nextLine();

      fileReader = new Scanner(new File(filePath + fileName + ".ini"));

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
         FileWriter fW = new FileWriter(filePath + fileName + " " + profileNum + ".ini");
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
