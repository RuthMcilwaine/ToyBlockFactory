import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidateInputTest {

    @Test
    void customerNameInputIsValid() {
        boolean expected = ValidateInput.validateName("Mark Müller");
        Assertions.assertTrue(expected);
    }

    @Test
    void customerNameInputIsInValid() {
        boolean expected = ValidateInput.validateName("Mark P*^arl");
        Assertions.assertFalse(expected);
    }

    @Test
    void customerNameInputIsNullReturnsFalse() {
        boolean expected = ValidateInput.validateName(null);
        Assertions.assertFalse(expected);
    }

    @Test
    void customerNameInputIsEmptyReturnsFalse() {
        boolean expected = ValidateInput.validateName("");
        Assertions.assertFalse(expected);
    }

    @Test
    void customerNameInputOverMax100CharactersReturnsFalse() {
        boolean expected = ValidateInput.validateName("Ifdesigningaformordatabasethatwill acceptnamesfrompeoplewithavarietyofbackgroundsyoushouldaskyourselfwhether");
        Assertions.assertFalse(expected);
    }

    @Test
    void customerAddressInputIsValid() {
        boolean expected = ValidateInput.validateAddress("1 Bob Avenue, Auckland");
        Assertions.assertTrue(expected);
    }

    @Test
    void customerAddressInputIsInValid() {
        boolean expected = ValidateInput.validateAddress("1 Bob Av&*nue, Auckland");
        Assertions.assertFalse(expected);
    }

    @Test
    void dueDateInputIsInValid() {
        boolean expected = ValidateInput.validateDueDate("19/14/2019");
        Assertions.assertFalse(expected);
    }

    @Test
    void numberInputForOrderAcceptsZero() {
        boolean expected = ValidateInput.validateNumberInputForOrder(0);
        Assertions.assertTrue(expected);
    }

    @Test
    void numberInputForOrderAcceptsMaximum20() {
        boolean expected = ValidateInput.validateNumberInputForOrder(21);
        Assertions.assertFalse(expected);
    }
}
