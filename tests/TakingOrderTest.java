import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

class TakingOrderTest {
    TakingOrder takingOrder = new TakingOrder();
    String customerDetails = "Name: Mark Pearl, Address: 1 Bob Avenue, Due Date: 19/01/2019";

    private Scanner getScanner(String userInput) {
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        return new Scanner(in);
    }

    @Test
    void noBlocksAreSetInOrderWhenZeroIsEntered() {
        int actual = takingOrder.questionAnswer(getScanner("0"), "");
        Assertions.assertEquals(0, actual);
    }

    @Test
    void setsOneBlockToOrderWhenOneIsEntered() {
        int actual = takingOrder.questionAnswer(getScanner("1"), "");
        Assertions.assertEquals(1, actual);
    }

    @Test
    void totalNumberOfBlocksInTakingOrderAreSetToOrder() {
        takingOrder.setOrderDetails(getScanner("1\n0\n1\n1\n0\n1\n1\n0\n1\n"));
        int actual = takingOrder.getOrder().getBlocks().size();

        Assertions.assertEquals(6, actual);
    }

    @Test
    void customerDetailsAreEnteredAndSetToOrder() {
        takingOrder.setCustomerDetails(getScanner("Mark Pearl\n1 Bob Avenue\n19/01/2019\n"));
        String expected = customerDetails;
        String actual = takingOrder.getOrder().getCustomer().toString();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void customerNameIsInvalid() {
        takingOrder.setCustomerDetails(getScanner("Mark P&^rl\nMark Pearl\n1 Bob Avenue\n19/01/2019\n"));
        String expected = customerDetails;
        String actual = takingOrder.getOrder().getCustomer().toString();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void customerAddressIsInvalid() {
        takingOrder.setCustomerDetails(getScanner("Mark Pearl\n1 B*b Avenue\n1 Bob Avenue\n19/01/2019\n"));
        String expected = customerDetails;
        String actual = takingOrder.getOrder().getCustomer().toString();

        Assertions.assertEquals(expected, actual);
    }
}

