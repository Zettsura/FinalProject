package auth;

import file.UserFileHandler;

import java.util.List;
import java.util.HashMap;
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

        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while (true) {

            // TODO: Prompt for login/registration
            System.out.println("1: login, 2: register: ");
            try {
                choice = sc.nextInt();
                switch (choice) {
                    case 1 -> loginPrompt(sc);
                    case 2 -> registerPrompt(sc);
                    default -> throw new RuntimeException();
                }
            } catch (RuntimeException ex) {
                System.out.println("ERROR: " + ex.getMessage());
                continue;
            }
            break;
        }
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
    public void loginPrompt(Scanner sc) {
        sc.nextLine();
        String email = sc.nextLine();
        String password = sc.nextLine();

        login(email, password);
    }

    // TODO: Create prompt
    public void registerPrompt(Scanner sc) {
        sc.nextLine();
        User newUser = new User();
        newUser.setEmail(sc.nextLine());
        newUser.setPassword(sc.nextLine());
        newUser.setName(sc.nextLine());

        newUser.setUserType("Customer");
        newUser.setUserId(ThreadLocalRandom.current().nextLong(10000,99999));
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
            status = 0;
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



