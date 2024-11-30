package file;

import auth.User;

import java.io.*;
import java.nio.file.FileSystemException;
import java.util.ArrayList;
import java.util.List;

public class UserFileHandler extends FileManager {
    private static File userListFile;

    public UserFileHandler() {
        super();
        userListFile = new File(getFilePath() + "/user_list.txt");
        try {
            if (!userListFile.exists()) {
                boolean status = userListFile.createNewFile();
                if (!status) {
                    throw new FileSystemException("The file user_list.txt already exists");
                }
            }
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    /**
     * Save the user list to a file named user_list.txt
     * Utilize BufferedWriter to write instead of directly using FileWriter for efficiency as
     * it first sends it to a buffer until the buffer is finally full only which then it finally call
     * write operation to the disk unlike FileWriter which calls writes operation everytime
     * @param userList the list to be saved
     */
    static public void save(List<User> userList) {

        // Try with resources to automatically close the objects instantiated at the end
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(userListFile))) {
            // Iterate through the list and write the properties and their corresponding value
            for (User user : userList) {
                bw.write("userId: " + user.getUserId() + "\n");
                bw.write("name: " + user.getName() + "\n");
                bw.write("email: " + user.getEmail() + "\n");
                bw.write("password: " + user.getPassword() + "\n");
                bw.write("vehicleId: " + user.getVehicleId() + "\n");
                bw.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> load() {
        // Defines the list that will hold the User object from reading the file
        List<User> userList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(userListFile))) {
            // Temporary user object where values read from the file are set to
            User user = new User();
            String line;

            // Read through the file until the end of file
            while((line = br.readLine()) != null) {

                // Each user data is separated by an empty line
                // If the line read is empty, it means that it finished reading the values for a user
                if (line.isEmpty()) {
                    userList.add(user); // Add the user to the list
                    user = new User(); // new instance of user object for next set of values for a user
                    continue;
                }

                /*
                 The format of the data consists of two parts: the property and the value
                 They are separated with a colon, with the left-hand side serving as the key
                 while the right-hand side are the values to be set to the user object with
                 its respective property
                */

                // split the line into two parts and store it in string array
                String[] buffer = line.split(":");
                String key = buffer[0].trim();     // set the left-hand side as the key
                String value = buffer[1].trim();   // set the right-hand side as the value

                // Enhanced switch statement for better readability
                switch (key) {
                    case "userId" -> user.setUserId(Long.parseLong(value));
                    case "name" -> user.setName(value);
                    case "email" -> user.setEmail(value);
                    case "password" -> user.setPassword(value);
                    case "vehicleId" -> user.setVehicleId(Long.parseLong(value));
                }
            }
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        return userList;
    }
}
