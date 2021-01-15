package be.intecbrussel.foodshop.config;

import java.io.File;

public enum FilePaths {
    CUSTOMER_FILEPATH("resources/CustomerFile.txt"),
    STOCK_FILEPATH("resources/StockFile.txt");

    private File file;

    private FilePaths(String path) {
        file = new File(path);
    }

    public File getFile() {
        return file;
    }
}
