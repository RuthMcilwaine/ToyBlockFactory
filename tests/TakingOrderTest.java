import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

class TakingOrderTest {

    @Test
    void noBlocksAreSetInOrderWhenZeroIsEntered() {
        TakingOrder takingOrder = new TakingOrder();
        ByteArrayInputStream in = new ByteArrayInputStream("0".getBytes());
        Scanner input = new Scanner(in);
        int actual = takingOrder.questionAnswer(input, "");

        Assert.assertEquals(0, actual);
    }

    @Test
    void setsOneBlockToOrderWhenNumberOneIsEntered() {
        TakingOrder takingOrder = new TakingOrder();
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        Scanner input = new Scanner(in);
        int actual = takingOrder.questionAnswer(input, "");

        Assert.assertEquals(1, actual);
    }

    @Test
    void totalNumberOfBlocksInTakingOrderAreSetToOrder() {
        TakingOrder takingOrder = new TakingOrder();
        ByteArrayInputStream userInput = new ByteArrayInputStream("1\n0\n1\n1\n0\n1\n1\n0\n1\n".getBytes());
        Scanner input = new Scanner(userInput);
        takingOrder.setOrderDetails(input);
        int actual = takingOrder.getOrder().getBlocks().size();

        Assert.assertEquals(6, actual);
    }

    @Test
    void customerDetailsAreEnteredAndSetToOrder() {
        TakingOrder takingOrder = new TakingOrder();
        ByteArrayInputStream userInput = new ByteArrayInputStream("Mark Pearl\n1 Bob Avenue\n19/01/2019\n".getBytes());
        Scanner input = new Scanner(userInput);
        takingOrder.setCustomerDetails(input);
        String expected = "Name: Mark Pearl, Address: 1 Bob Avenue, Due Date: 19/01/2019";
        String actual = takingOrder.order.getCustomer().toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    void customerNameIsInValid() {
        TakingOrder takingOrder = new TakingOrder();
        ByteArrayInputStream userInput = new ByteArrayInputStream("Mark P&^rl\nMark Pearl\n1 Bob Avenue\n19/01/2019\n".getBytes());
        Scanner input = new Scanner(userInput);
        takingOrder.setCustomerDetails(input);
        String expected = "Name: Mark Pearl, Address: 1 Bob Avenue, Due Date: 19/01/2019";
        String actual = takingOrder.order.getCustomer().toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    void customerAddressIsInValid() {
        TakingOrder takingOrder = new TakingOrder();
        ByteArrayInputStream userInput = new ByteArrayInputStream("Mark Pearl\n1 B*b Avenue\n1 Bob Avenue\n19/01/2019\n".getBytes());
        Scanner input = new Scanner(userInput);
        takingOrder.setCustomerDetails(input);
        String expected = "Name: Mark Pearl, Address: 1 Bob Avenue, Due Date: 19/01/2019";
        String actual = takingOrder.order.getCustomer().toString();

        Assert.assertEquals(expected, actual);
    }
}

