package file;

import auth.User;

import java.io.*;
import java.util.ArrayList;

// TODO: add explicit throw if file operation fails
public class UserFileHandler extends FileManager {
    private static File userListFile;

    public UserFileHandler() {
        super();
        userListFile = new File(getFilePath() + "/user_list.txt");
        try {
            boolean status;
            if (!userListFile.exists()) {
                status = userListFile.createNewFile();
            }

        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    // TODO: Properly handle exceptions
    static public void save(ArrayList<User> userList) {
        for (User user : userList) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(userListFile))) {
                bw.write("userId: " + user.getUserId() + "\n");
                bw.write("name: " + user.getName() + "\n");
                bw.write("email: " + user.getEmail() + "\n");
                bw.write("password: " + user.getPassword() + "\n");
                bw.write("userType: " + user.getUserType() + "\n");

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // TODO: Properly handle exceptions
    public ArrayList<User> load() {
        ArrayList<User> userList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(userListFile))) {
            User user = new User();
            String line;

            while((line = br.readLine()) != null) {
                if (line.isEmpty()) {
                    userList.add(user);
                    continue;
                }

                String[] buffer = line.split(":");
                String key = buffer[0].trim();
                String value = buffer[1].trim();

                switch (key) {
                    case "userId" -> user.setUserId(Long.parseLong(value));
                    case "name" -> user.setName(value);
                    case "email" -> user.setEmail(value);
                    case "password" -> user.setPassword(value);
                    case "userType" -> user.setUserType(value);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return userList;
    }
}
