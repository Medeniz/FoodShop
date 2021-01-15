package be.intecbrussel.fileiodemo;

public class DemoApp {
    public static void main(String[] args) {
        WriteData wd = new WriteData();
        //wd.writeStringToFile("Potato");

        ReadData rd = new ReadData();
        rd.readStringFromFile2();
    }
}
