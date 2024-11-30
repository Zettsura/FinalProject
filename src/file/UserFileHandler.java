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

    static public void save(List<User> userList) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(userListFile))) {
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
        List<User> userList = new ArrayList<>();
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
