package be.intecbrussel.fileiodemo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteData {

    public void writeStringToFile(String myText) {
        File myTextFile = new File("resources/MyTextFile.txt");
//        File myTextFile = new File("E:\\OneDrive\\OneDrive - INTEC BRUSSEL vzw\\Intec\\Opleidingen\\Java September 2020\\Projects\\FileIO\\resources\\MyTextFile.txt");

        try {
            FileWriter fileWriter = new FileWriter(myTextFile, true);
            fileWriter.write(myText + "\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
