
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderTests {

    @Test
    public void canGenerateNewOrderIdForNewOrder() {
        Order order = new Order();
        order.setOrderId("E0002");
        Assertions.assertEquals("E0002", order.getOrderId());
    }


    @Test
    public void canGenerateNewDueDateForNewOrder() {
        Order order = new Order();
        order.setDueDate(2020, 02, 27);
        Assertions.assertEquals(LocalDate.of(2020, 03, 19), order.getDueDate());
    }

    @Test
    public void canAddABlockToNewOrder() {

        Order order = new Order();

        order.add(new Block(PaintColour.RED, Shape.SQUARE));
        order.add(new Block(PaintColour.BLUE, Shape.SQUARE));
        List<Block> actual = new ArrayList<Block>(Arrays.asList(new Block(PaintColour.RED, Shape.SQUARE), new Block(PaintColour.BLUE, Shape.SQUARE)));
        List<Block> expected = order.getBlocks();

        Assert.assertEquals(actual, expected);

    }


}


