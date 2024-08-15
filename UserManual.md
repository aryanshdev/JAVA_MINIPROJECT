## About Project
Tried Solving a problem that everyone faces while building and testing apps in their **_Android Development_** process. 
The Problem of converting .aab (App Bundles) to _.apks_ (A kind of Zip containing app files) and further *.apk* (Android App).

## Problem 
According To Google :
> [**Important**: From August 2021, new apps are required to publish with the Android App Bundle on Google Play.](https://developer.android.com/guide/app-bundle)

But App Bundle Can't be directly installed or directly run in Android. We need to convert it into .apk to do so. For Testing on real life devices, this is a very important and tedious task.
The way to build .apk from .aab is to use .jar library provided by Google : **_bundletool_**, but it is a CLI library and required many arguments to be entered. hence a lot of scope for errors. Even a single typo can have you re-write all command and arguments again.

## Our Solution and Project
Create CLI for using bundletool, now you don't have to write tedious commands again and again. Even if something fails, you can just click a button to try again !!

## How To Use:
- Extract Project and Open it in your IDE, e.g. Eclipse or IntelliJ
- Download JavaFX SDK, You Can Download It From https://download2.gluonhq.com/openjfx/22.0.2/openjfx-22.0.2_windows-x64_bin-sdk.zip
- Add JavaFX To Project, Steps To Add It Are :
    - **Eclipse** : https://pragmaticways.com/how-to-add-javafx-to-eclipse-the-easy-way/
    - **IntelliJ** : https://medium.com/@laszlo.szlatki/step-by-step-guide-on-how-to-set-up-javafx-on-intellij-41bab92dfc46
    - **Preferred Method For IntelliJ** : On IntelliJ, Create a new JAVAFX project then copy and paste files from src folder of this project to newly created Java Project in IntelliJ.
      Also, Copy lib Folder To The Newly created project.
- Run Main.java
## GitHub Repo For Cloning
https://github.com/aryanshdev/JAVA_MINIPROJECT
