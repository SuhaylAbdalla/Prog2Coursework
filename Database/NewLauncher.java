package com.example.studytracker;

import javafx.application.Application;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//launches program
public class NewLauncher {
    public static void main(String[] args) {
        Application.launch(HelloApplication.class, args);
        try {
            ProcessBuilder pb = new ProcessBuilder("python", "script.py");
            Process process = pb.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            int exitCode = process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}