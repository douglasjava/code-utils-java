package com.example.demo.hundreddaysofjava;

import java.io.File;

/**
 * Day 34 - Printing information about all java processes running on the machine.
 */
public class Day034 {

    public static final String JAVA_SUFFIX = File.separator + "java";

    public static void main(String[] args) {
        ProcessHandle.allProcesses()
                .filter(Day034::isJavaProcess)
                .map(ProcessHandle::info)
                .forEach(System.out::println);
    }

    private static boolean isJavaProcess(ProcessHandle processHandle) {
        return processHandle.info()
                .command()
                .map(command -> command.endsWith(JAVA_SUFFIX))
                .orElse(false);
    }

}
