package auth;

import file.UserFileHandler;
import java.util.List;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Authentication {
    private static User authenticatedUser;
    private final List<User> userList;
    private HashMap<String, User> userHashMap;

    public Authentication() {
        UserFileHandler ufh = new UserFileHandler();
        userList = ufh.load();
        populateMap();
    }

    public Authentication(List<User> userList) {
        this.userList = userList;
        populateMap();
    }

    public static User getAuthenticatedUser() {
        return authenticatedUser;
    }

    public static void setAuthenticatedUser(User authenticatedUser) {
        Authentication.authenticatedUser = authenticatedUser;
    }

    private void populateMap() {
        userHashMap = new HashMap<>();
        for (User user : userList) {
            userHashMap.put(user.getEmail(), user);
        }
    }

    public void loginPrompt(Scanner sc) throws AuthenticationException {
        sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();

        int status = login(email, password);
        if (status == -1) {
            throw new AuthenticationException("Wrong username or password!");
        }
    }

    public void registerPrompt(Scanner sc) throws AuthenticationException {
        sc.nextLine();
        User newUser = new User();
        System.out.print("Email: ");
        newUser.setEmail(sc.nextLine());
        System.out.print("Password: ");
        newUser.setPassword(sc.nextLine());
        System.out.print("Name: ");
        newUser.setName(sc.nextLine());

        User user = userHashMap.get(newUser.getEmail());
        if (user != null) {
            throw new AuthenticationException("User with that email already exists");
        }

        newUser.setUserId(ThreadLocalRandom.current().nextLong(10000, 99999));
        register(newUser);
        setAuthenticatedUser(newUser);
    }

    private int login(String email, String password) {
        int status = -1;
        email = email.trim();
        password = password.trim();
        User user = userHashMap.get(email);
        if (user == null){
            return status;
        }

        if (user.getPassword().equals(password)) {
            setAuthenticatedUser(user);
            status = 1;
        }
        return status;
    }

    private void register(User user) {
        userList.add(user);
        userHashMap.put(user.getEmail(), user);
        UserFileHandler.save(userList);
    }

    public void delete(User user) {
        userList.remove(user);
        UserFileHandler.save(userList);
    }
}