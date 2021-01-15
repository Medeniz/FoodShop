package be.intecbrussel.fileiodemo;

import java.io.*;

public class ReadData {
    public String readStringFromFile() {
        File file = new File("resources/MyTextFile.txt");

        try {
            FileReader fileReader = new FileReader(file);

            int character;
            while((character = fileReader.read()) != -1){
                System.out.print((char) character);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void readStringFromFile2() {
        File file = new File("resources/MyTextFile.txt");

        try {
            InputStream inputStream = new FileInputStream(file);

            int character;
            while((character = inputStream.read()) != -1){
                System.out.print((char) character);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
