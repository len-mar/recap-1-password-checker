import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordCheckerTest {
    // hasMinLength
    @Test
    void hasMinLengthShouldReturnFalseWhenTooShort() {
        assertFalse(PasswordChecker.hasMinLength("testpw"));
    }

    @Test
    void hasMinLengthShouldReturnTrueWhen8() {
        assertTrue(PasswordChecker.hasMinLength("testtest"));

    }

    @Test
    void hasMinLengthShouldReturnTrueWhen12() {
        assertTrue(PasswordChecker.hasMinLength("testtesttest"));
    }

    // containsDigits
    @Test
    void containsDigitsShouldReturnFalseWhenWithoutDigits() {
        assertFalse(PasswordChecker.containsDigits("test"));

    }

    @Test
    void containsDigitsShouldReturnTrueWhenWithDigits() {
        assertTrue(PasswordChecker.containsDigits("test123"));

    }

    // hasUpperAndLower
    @Test
    void hasUpperAndLowerReturnsFalseWhenOnlyLower() {
        assertFalse(PasswordChecker.hasUpperAndLower("test"));
    }

    @Test
    void hasUpperAndLowerReturnsFalseWhenOnlyUpper() {
        assertFalse(PasswordChecker.hasUpperAndLower("TEST"));
    }

    @Test
    void hasUpperAndLowerReturnsTrueWhenUpperAndLower() {
        assertTrue(PasswordChecker.hasUpperAndLower("TeSt"));
    }

    // isNotCommonPW
    @Test
    void isNotCommonPWShouldReturnFalseWhenPassword() {
        assertFalse(PasswordChecker.isNotCommonPW("Password"));
    }

    @Test
    void isNotCommonPWShouldReturnTrueWhenTest123() {
        assertTrue(PasswordChecker.isNotCommonPW("Test123"));
    }

    // hasSpecialChars
    @Test
    void hasSpecialCharsShouldReturnFalseWhenNoSpecialChars() {
        assertFalse(PasswordChecker.hasSpecialChars("test123TEST456"));
    }

    @Test
    void hasSpecialCharsShouldReturnTrueWhenWithPercent() {
        assertTrue(PasswordChecker.hasSpecialChars("bla%bla"));
    }

    @Test
    void hasSpecialCharsShouldReturnTrueWhenWithQuestionMarks() {
        assertTrue(PasswordChecker.hasSpecialChars("?bla?bla?"));
    }

    @Test
    void generateValidPWShouldGenerateValidPW() {
        assertTrue(PasswordChecker.isValid(PasswordChecker.generateValidPW()));
    }
}