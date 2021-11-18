# Dolphin-Gmpd-Profile-Duplicator

This is a set of tools that will duplicate Gamepad Profiles for Dolphin Emulator in various ways. These are especially useful for running multiple instances of Dolphin Emulator with large numbers of controllers, and/or copying the profiles to all of the portable dolphins.

Future plans for this project include to:
 1. Create a tool to duplicate profiles between multiple portable dolphin emulators.
 2. Create versions of the tools in C, allowing it to be compiled into a standard executable and removing the requirement to have Java installed.
 3. Combine all the tools into one.

## Requirements
The Java versions of this project require Java to be installed on your system. You can check if it is installed by opening a command prompt and running `java -version`

## File Information
 - [IndexedProfileMaker.gpj](https://github.com/CollinCodez/Dolphin-Gmpd-Profile-Duplicator/blob/main/Java%20Version/Indexed%20Profile%20Maker/IndexedProfileMaker.gpj) is a JGrasp Java Project file. This is what was used to create the Jar file.

# Tools

## Indexed Profile Maker
This tool makes multiple copies of a Dolphin Gamepad Profile, each with its own unique gamepad index.

### Usage (Java Version)
 1. Open a command prompt at the location of `IndexedProfileMaker.jar`
 2. Run `java -jar IndexedProfileMaker.jar`
 3. Enter the name of the controller profile you want to replicate, then press Enter
    - Do not inlcude the .ini file extention - the tool will add that for you
 4. Enter the file path to the profile you want to replicate
     > Note that `/` and `\` can be used interchangeably in this step
    - If the profile is in the same folder as `IndexedProfileMaker.jar`, simply press Enter
    - If the profile is in a subfolder from where `IndexedProfileMaker.jar` is located, format it as follows: `path/to/profile/`
    - If the profile is on another drive, you may enter it as: `F:/path/to/profile/`
 5. Enter the number of copies of the profile you would like to make, then press Enter
 6. Enjoy the replicated profiles!