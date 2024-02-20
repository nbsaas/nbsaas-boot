package com.nbsaas.boot.generator.utils;

import java.io.File;

public class OsUtils {

    public static void main(String[] args) {
        String os = getOperatingSystem();
        System.out.println("Current Operating System: " + os);
        System.out.println(System.getProperty("os.name").toLowerCase());
        System.out.println(isLinuxOrMac());
        System.out.println(File.separator);
    }

    public static String getOperatingSystem() {
        String os = getOsInfo();

        if (os.contains("win")) {
            return "Windows";
        } else if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
            return "Unix / Linux / macOS";
        } else {
            return "Unknown";
        }
    }



    public static boolean isWindows() {
        String os = getOsInfo();
        return os.contains("win");
    }

    private static String getOsInfo() {
        return System.getProperty("os.name").toLowerCase();
    }

    public static boolean isLinuxOrMac() {
        String os = getOsInfo();
        return os.contains("nix") || os.contains("nux") || os.contains("mac");
    }
}
