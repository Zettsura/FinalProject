package auth;

import file.UserFileHandler;

import java.util.List;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

// TODO: Handle exceptions
public class Authentication {

    static private User authenticatedUser;
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

    // TODO: Create prompt
    public void loginPrompt(Scanner sc) throws AuthenticationException {
        sc.nextLine();
        System.out.println("Email: ");
        String email = sc.nextLine();
        System.out.println("Password: ");
        String password = sc.nextLine();

        int status = login(email, password);
        if (status == -1) {
            throw new AuthenticationException("Wrong username or password!");
        }

    }

    // TODO: Create prompt
    public void registerPrompt(Scanner sc) {
        sc.nextLine();
        User newUser = new User();
        newUser.setEmail(sc.nextLine());
        newUser.setPassword(sc.nextLine());
        newUser.setName(sc.nextLine());

        newUser.setUserId(ThreadLocalRandom.current().nextLong(10000, 99999));
        register(newUser);
    }

    // TODO: Handle exceptions
    public int login(String email, String password) {
        int status = -1;
        email = email.trim();
        password = password.trim();
        User user = userHashMap.get(email);
        if (user == null){
            return status;
        }

        if (user.getPassword().equals(password)) {
            setAuthenticatedUser(user);
        }
        return status;
    }

    // TODO: Handle exceptions
    public void register(User user) {
        userList.add(user);
        userHashMap.put(user.getEmail(), user);
        UserFileHandler.save(userList);
    };
}