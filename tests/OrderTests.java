
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class OrderTests {
    Order order = new Order();

    @Test
    void canGenerateNewOrderIdForNewOrder() {
        order.setOrderId("E0002");
        Assertions.assertEquals("E0002", order.getOrderId());
    }
    @Test
    void generateOrderWithNoBlocks() {
        int actual = order.getBlocks().size();
        Assert.assertEquals(0, actual);
    }

    @Test
    void generateOrderWithOneRedSquare() {
        Block expected = new Block(PaintColour.RED, Shape.SQUARE);
        order.add(expected);

        Assert.assertEquals(1, order.getBlocks().size());
        Assert.assertEquals(expected, order.getBlocks().get(0));
    }

    @Test
    void generateOrderWithTwoRedSquares() {
        order.add(new Block(PaintColour.RED, Shape.SQUARE));
        Block expected = new Block(PaintColour.RED, Shape.SQUARE);
        order.add(expected);

        Assert.assertEquals(2, order.getBlocks().size());
        Assert.assertEquals(expected, order.getBlocks().get(1));
    }

    @Test
    void canAddRedAndBlueSquaresToAnOrder() {
        order.add(new Block(PaintColour.RED, Shape.SQUARE));
        order.add(new Block(PaintColour.BLUE, Shape.SQUARE));
        List<Block> expected = order.getBlocks();
        List<Block> actual = new ArrayList<Block>(Arrays.asList(new Block(PaintColour.RED, Shape.SQUARE), new Block(PaintColour.BLUE, Shape.SQUARE)));

        Assert.assertEquals(expected, actual);
    }

    @Test
    void generateOrderWithFiveRedSquares() {
        order.add(new Block(PaintColour.RED, Shape.SQUARE));
        order.add(new Block(PaintColour.RED, Shape.SQUARE));
        order.add(new Block(PaintColour.RED, Shape.SQUARE));
        order.add(new Block(PaintColour.RED, Shape.SQUARE));
        Block expected = new Block(PaintColour.RED, Shape.SQUARE);
        order.add(expected);

        Assert.assertEquals(5, order.getBlocks().size());
        Assert.assertEquals(expected, order.getBlocks().get(4));
    }
}


