package file;


import java.io.File;
import java.util.ArrayList;;

class FileManager {
    private File filePath;

    // TODO: add explicit throw if file operation fails
    public FileManager() {
        try {
            filePath = new File(System.getProperty("user.home") +"/Documents/CarRental/");
            boolean status;

            if (!filePath.exists()) {
                status = filePath.mkdirs();
            }

        } catch (NullPointerException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public File getFilePath() {
        return filePath;
    }

    public void setFilePath(File filePath) {
        this.filePath = filePath;
    }

}