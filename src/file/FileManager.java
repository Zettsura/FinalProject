package file;

import java.io.File;

class FileManager {
    static private File filePath;

    public FileManager() {
        try {
            filePath = new File(System.getProperty("user.home") +"/Documents/CarRental/");

            // Create the directory if it does not exist
            if (!filePath.exists()) {
                boolean mkdirs = filePath.mkdirs();
                if (!mkdirs) {
                    throw new RuntimeException("Unable to create the directory");
                }
            }

        } catch (NullPointerException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public File getFilePath() {
        return filePath;
    }

    public void setFilePath(File filePath) {
        FileManager.filePath = filePath;
    }

}