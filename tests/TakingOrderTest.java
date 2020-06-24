import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

class TakingOrderTest {
    TakingOrder takingOrder = new TakingOrder();
    String customerDetails = "Name: Mark Pearl, Address: 1 Bob Avenue, Due Date: 19/01/2019";

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
        Scanner input = getScanner("Mark Pearl\n1 Bob Avenue\n19/01/2019\n");
        takingOrder.setCustomerDetails(input);
        String expected = customerDetails;
        String actual = takingOrder.order.getCustomer().toString();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void customerNameIsInValid() {
        Scanner input = getScanner("Mark P&^rl\nMark Pearl\n1 Bob Avenue\n19/01/2019\n");
        takingOrder.setCustomerDetails(input);
        String expected = customerDetails;
        String actual = takingOrder.order.getCustomer().toString();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void customerAddressIsInValid() {
        Scanner input = getScanner("Mark Pearl\n1 B*b Avenue\n1 Bob Avenue\n19/01/2019\n");
        takingOrder.setCustomerDetails(input);
        String expected = customerDetails;
        String actual = takingOrder.order.getCustomer().toString();

        Assertions.assertEquals(expected, actual);
    }

    private Scanner getScanner(String userInput) {
        ByteArrayInputStream in = new ByteArrayInputStream(userInput.getBytes());
        return new Scanner(in);
    }
}

