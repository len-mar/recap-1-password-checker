import java.util.Arrays;
import java.util.regex.Pattern;

public class PasswordChecker {
    public static void main(String[] args) {
        System.out.println("Checked if 'hello' is valid: " + isValid("hello"));
        System.out.println("Checked if '12356789' is valid: " + isValid("12356789"));
        System.out.println("Checked if 'Password' is valid: " + isValid("Password"));
        System.out.println("Checked if 'dajsio12$fAFSfsaf35' is valid: " + isValid("dajsio12$fAFSfsaf35"));
    }

    // overall pw checker function, calls all util functions
    public static boolean isValid(String pw) {
        return hasMinLength(pw) && containsDigits(pw)
                && hasUpperAndLower(pw) && isNotCommonPW(pw) && hasSpecialChars(pw);
    }

    // checks if pw has minimum length
    public static boolean hasMinLength(String pw) {
        return pw.length() >= 8;
    }

    // checks if pw contains at least 1 digit
    public static boolean containsDigits(String pw) {
        for (char c : pw.toCharArray()) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    // checks if pw has at least one upper and one lower case character
    public static boolean hasUpperAndLower(String pw) {
        boolean hasUpper = false;
        boolean hasLower = false;
        for (char c : pw.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            }
            if (Character.isLowerCase(c)) {
                hasLower = true;
            }
            if (hasLower && hasUpper) {
                return true;
            }
        }
        return false;
    }

    // checks if pw is not one from a list of common weak pws
    public static boolean isNotCommonPW(String pw) {
        String[] weakPWs = {"Password1", "Password123", "Password", "Aa345678"};
        return !Arrays.asList(weakPWs).contains(pw);
    }

    // checks if pw has at least 1 special character
    public static boolean hasSpecialChars(String pw) {
        // creates regex pattern to include set of special characters
        Pattern specialChar = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
        // converts matcher to boolean via find()
        return specialChar.matcher(pw).find();
    }



}
