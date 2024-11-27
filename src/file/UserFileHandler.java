package file;

import auth.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

// TODO: add explicit throw if file operation fails
public class UserFileHandler extends FileManager {
    private File userListFile;

    public UserFileHandler() {
        super();
        userListFile = new File(getFilePath() + "user_list.txt");
        try {
            boolean status;
            if (!userListFile.exists()) {
                status = userListFile.createNewFile();
            }

        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public void save(User user) {
        try (FileWriter fw = new FileWriter(userListFile);){
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void load(ArrayList<User> userList) {

    }
}
