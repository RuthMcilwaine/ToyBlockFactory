import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidateInputTest {

    @Test
    void customerNameInputUsingDiacriticIsValid() {
        boolean expected = ValidateInput.validateName("Mark Müller");
        Assertions.assertTrue(expected);
    }

    @Test
    void customerNameInputUsingSymbolsIsInvalid() {
        boolean expected = ValidateInput.validateName("Mark P*^arl");
        Assertions.assertFalse(expected);
    }

    @Test
    void customerNameInputWhenNullIsInvalid() {
        boolean expected = ValidateInput.validateName(null);
        Assertions.assertFalse(expected);
    }

    @Test
    void customerNameInputWhenEmptyIsInvalid() {
        boolean expected = ValidateInput.validateName("");
        Assertions.assertFalse(expected);
    }

    @Test
    void customerNameInputOverMax100CharactersIsInvalid() {
        boolean expected = ValidateInput.validateName("Ifdesigningaformordatabasethatwill acceptnamesfrompeoplewithavarietyofbackgroundsyoushouldaskyourselfwhether");
        Assertions.assertFalse(expected);
    }

    @Test
    void customerAddressInputIsValid() {
        boolean expected = ValidateInput.validateAddress("1 Bob Avenue, Auckland");
        Assertions.assertTrue(expected);
    }

    @Test
    void customerAddressInputUsingSymbolsIsInvalid() {
        boolean expected = ValidateInput.validateAddress("1 Bob Av&*nue, Auckland");
        Assertions.assertFalse(expected);
    }

    @Test
    void dueDateInputUsingDayMonthYearIsValid() {
        boolean expected = ValidateInput.validateDueDate("19/12/2019");
        Assertions.assertTrue(expected);
    }

    @Test
    void dueDateInputNotUsingDayMonthYearIsInvalid() {
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
