package com.example.demo.hundreddaysofjava;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.lang.StackWalker.Option.RETAIN_CLASS_REFERENCE;

/**
 * Day 68 - Using StackWalker from JDK 9 to find a Class on Stack Trace
 */
public class Day068 {

    public static void main(String[] args) {

        var interestingClasses = List.of(Integer.class, Number.class, String.class);

        // Instead of doing:
        List<String> interestingClassNames = interestingClasses.stream()
                .map(Class::getName)
                .toList();

        Optional<Class<?>> class1 = Arrays.stream(Thread.currentThread().getStackTrace())
                .map(StackTraceElement::getClassName)
                .filter(interestingClassNames::contains)
                .findFirst()
                .map(className -> {
                    try {
                        return Class.forName(className);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                });

        // Just do:
        Optional<Class<?>> class2 = StackWalker.getInstance(RETAIN_CLASS_REFERENCE).walk(
                stackFrameStream -> stackFrameStream.<Class<?>>map(StackWalker.StackFrame::getDeclaringClass)
                        .filter(interestingClasses::contains)
                        .findFirst()
        );

    }

}
