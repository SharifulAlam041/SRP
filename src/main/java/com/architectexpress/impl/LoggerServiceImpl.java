package com.architectexpress.impl;

import com.architectexpress.interfaces.LoggerService;

import java.io.FileWriter;
import java.io.IOException;

public class LoggerServiceImpl implements LoggerService {
    private static final String LOG_FILE = "C:\\log\\log.txt";

    private void write(String prefix, String message) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            writer.write(prefix + ": " + message + System.lineSeparator());
        } catch (IOException e) {
            System.err.println("Logging failed: " + e.getMessage());
        }
    }

    @Override
    public void info(String message) { write("INFO", message); }

    @Override
    public void warn(String message) { write("WARNING", message); }

    @Override
    public void error(String message) { write("ERROR", message); }
}
