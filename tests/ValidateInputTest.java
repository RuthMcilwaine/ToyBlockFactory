import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ValidateInputTest {

    @Test
    void customerNameInputIsValid() {
        boolean expected = ValidateInput.validateName("Mark Müller");
        Assert.assertTrue(expected);
    }

    @Test
    void customerNameInputIsInValid() {
        boolean expected = ValidateInput.validateName("Mark P*^arl");
        Assert.assertFalse(expected);
    }

    @Test
    void customerNameInputIsNullReturnsFalse() {
        boolean expected = ValidateInput.validateName(null);
        Assert.assertFalse(expected);
    }

    @Test
    void customerNameInputIsEmptyReturnsFalse() {
        boolean expected = ValidateInput.validateName("");
        Assert.assertFalse(expected);
    }

    @Test
    void customerNameInputOverMax100CharactersReturnsFalse() {
        boolean expected = ValidateInput.validateName("Ifdesigningaformordatabasethatwill acceptnamesfrompeoplewithavarietyofbackgroundsyoushouldaskyourselfwhether");
        Assert.assertFalse(expected);
    }

    @Test
    void customerAddressInputIsValid() {
        boolean expected = ValidateInput.validateAddress("1 Bob Avenue, Auckland");
        Assert.assertTrue(expected);
    }

    @Test
    void customerAddressInputIsInValid() {
        boolean expected = ValidateInput.validateAddress("1 Bob Av&*nue, Auckland");
        Assert.assertFalse(expected);
    }

    @Test
    void dueDateInputIsInValid() {
        boolean expected = ValidateInput.validateDueDate("19/14/2019");
        Assert.assertFalse(expected);
    }

    @Test
    void numberInputForOrderAcceptsZero() {
        boolean expected = ValidateInput.validateNumberInputForOrder(0);
        Assert.assertTrue(expected);
    }

    @Test
    void numberInputForOrderAcceptsMaximum20() {
        boolean expected = ValidateInput.validateNumberInputForOrder(21);
        Assert.assertFalse(expected);
    }
}
