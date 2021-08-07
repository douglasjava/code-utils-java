package com.example.demo.hundreddaysofjava;

import picocli.CommandLine;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Callable;

/**
 * Day 57 - Using Picocli to parse command line arguments
 */
@CommandLine.Command(
        mixinStandardHelpOptions = true,
        description = "Prints the contents of the specified file in the specified color")
public class Day057 implements Callable<Integer> {

    private static final String RESET_COLOR = "\u001B[0m";

    @CommandLine.Option(names = {"-c", "--collor"}, description = "BLACK, BLUE, RED, YELLOW or WHITE")
    private Color color;

    @CommandLine.Parameters(index = "0", description = "The file whose checksum to calculate.")
    private Path path;

    @Override
    public Integer call() throws Exception {
        print(Files.readString(path));
        return 0;
    }

    private void print(String text) {
        System.out.println(color.getAnsiColor() + text + RESET_COLOR);
    }

    public static void main(String... args) {
        int exitCode = new CommandLine(new Day057()).execute(args);
        System.exit(exitCode);
    }

    @SuppressWarnings("unused")
    enum Color {
        BLACK("\u001B[30m"),
        BLUE("\u001B[34m"),
        RED("\u001B[31m"),
        YELLOW("\u001B[33m"),
        WHITE("\u001B[37m");

        private final String ansiColor;

        Color(String ansiColor) {
            this.ansiColor = ansiColor;
        }

        public final String getAnsiColor() {
            return ansiColor;
        }
    }
}
