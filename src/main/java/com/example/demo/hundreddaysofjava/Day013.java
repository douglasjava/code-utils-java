package com.example.demo.hundreddaysofjava;

import java.time.LocalDateTime;

/**
 * Day 13 - Creating a lazily initialized Singleton.
 */
public class Day013 {

    private final LocalDateTime creationDateTime;

    private Day013(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public static Day013 getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private static final class InstanceHolder {
        static final Day013 INSTANCE = new Day013(LocalDateTime.now());
    }

}
