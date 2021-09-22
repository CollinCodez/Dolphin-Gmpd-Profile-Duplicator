# Dolphin-Gmpd-Profile-Duplicator
This tool makes multiple copies of a Dolphin Gamepad Profile, each with its own index.

### Requirements
The Java version of this project (the only one currently completed) requires Java to be installed on your system. You can check if it is installed by opening a command prompt and running `java -version`

### Usage
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

### File Information
 - [IndexedProfileMaker.gpj](https://github.com/CollinCodez/Dolphin-Gmpd-Profile-Duplicator/blob/main/Java%20Version/IndexedProfileMaker.gpj) is a JGrasp Java Project file. This is what was used to create the Jar file.
 - The [Classes](https://github.com/CollinCodez/Dolphin-Gmpd-Profile-Duplicator/tree/main/Java%20Version/classes) folder contains the compiled Java class files. If you compile this yourself, you can remake these files. 