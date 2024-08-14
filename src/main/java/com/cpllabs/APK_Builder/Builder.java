package com.cpllabs.APK_Builder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Builder {

    public int buildAPKS(String aabPath, String outputPath, String keyStorePath, String keyStorePassword, String keyPassword, String keyAlias, boolean universalMode) {
        String cmd = "java -jar libs/bundletool-all-1.15.4.jar build-apks --bundle=\""
                + aabPath + "\" --output=\"" +
                Paths.get(outputPath, "OUTPUT.apks").toString() + "\"";
        if (keyStorePath != null) {
            cmd += " --ks=\"" + keyStorePath + "\" --ks-pass=pass:" + keyStorePassword + " --ks-key-alias=" + keyAlias + " --key-pass=pass:" + keyPassword;
        }

        if (universalMode) {
            cmd += " --mode=universal";
        }
        try {
            // Execute the command
            Process process = Runtime.getRuntime().exec(cmd);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            // Wait for the process to complete
            int exitCode = process.waitFor();
            System.out.println("Command executed with exit code: " + exitCode);
            return exitCode;

        } catch (IOException | InterruptedException e) {
            return 1;
        }
    }
}
