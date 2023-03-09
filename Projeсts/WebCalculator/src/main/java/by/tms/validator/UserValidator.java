package by.tms.validator;

public class UserValidator {
    private static final String USERNAME = "[a-zA-Z]{4,8}$";
    private static final String PASSWORD = "[0-9]{8}$";

    public static boolean isValidUsername(String username) {
        return username.matches(USERNAME);
    }

    public static boolean isValidPassword(String password) {
        return password.matches(PASSWORD);
    }
}
