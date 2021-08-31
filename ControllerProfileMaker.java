/*
   Author: Collin Schofield
   Date Created: 8/26/2021
   Purpose: Create DInput profiles for dolphin
*/
import java.util.*;
import java.io.*;

public class ControllerProfileMaker
{
    public static void main(String args[]) throws IOException
   {
      //Setup
      String filePath = "B:\\Wii Games & Saves\\Dolphins\\Dolphin 2\\Sys\\Profiles\\GCPad\\";
      String fileName = "DInput 0.ini";
      String controllerType = "DInput";
      Scanner fileReader = new Scanner(new File(filePath + fileName));
      ArrayList<String> profileData = new ArrayList<String>();


      
      //Inputs
      while(fileReader.hasNext()){
         String line = fileReader.nextLine();
         profileData.add(line);
      }
      
      
      //Calculations
      
      
      
      //Outputs
      for(int profileNum = 0; profileNum < 16; profileNum++){
         FileWriter fW = new FileWriter(filePath + controllerType + " " + profileNum + ".ini");
         PrintWriter output = new PrintWriter(fW);
         
         if(controllerType.equalsIgnoreCase("DInput")){
            profileData.set(1, "Device = DInput/" + profileNum + "/Wireless Controller");
         }else if(controllerType.equalsIgnoreCase("Dinput")){
            profileData.set(1, "Device = XInput/" + profileNum + "/Gamepad");
         }

         for(int lcv = 0; lcv < profileData.size(); lcv++){
            output.println(profileData.get(lcv));
         }
         
         output.close();
         fW.close();
      }
      
   }//End of Code
}