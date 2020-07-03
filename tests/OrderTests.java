
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class OrderTests {
    Order order = new Order();

    @Test
    void canGenerateNewOrderIdForNewOrder() {
        order.setOrderId(0001);
        Assertions.assertEquals(0001, order.getOrderId());
    }

    @Test
    void generateOrderWithNoBlocks() {
        int actual = order.getBlocks().size();
        Assertions.assertEquals(0, actual);
    }

    @Test
    void generateOrderWithOneRedSquare() {
        Block expected = new Block(PaintColour.RED, Shape.SQUARE);
        order.add(expected);


        Assertions.assertEquals(1, order.getBlocks().size());
        Assertions.assertEquals(expected, order.getBlocks().get(0));
    }

    @Test
    void generateOrderWithTwoRedSquares() {
        order.add(new Block(PaintColour.RED, Shape.SQUARE));
        Block expected = new Block(PaintColour.RED, Shape.SQUARE);
        order.add(expected);

        Assertions.assertEquals(2, order.getBlocks().size());
        Assertions.assertEquals(expected, order.getBlocks().get(1));
    }

    @Test
    void canAddRedAndBlueSquaresToAnOrder() {
        order.add(new Block(PaintColour.RED, Shape.SQUARE));
        order.add(new Block(PaintColour.BLUE, Shape.SQUARE));

        List<Block> expected = order.getBlocks();
        List<Block> actual = new ArrayList<>(Arrays.asList(new Block(PaintColour.RED, Shape.SQUARE), new Block(PaintColour.BLUE, Shape.SQUARE)));

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void generateOrderWithFiveRedSquares() {
        order.add(new Block(PaintColour.RED, Shape.SQUARE));
        order.add(new Block(PaintColour.RED, Shape.SQUARE));
        order.add(new Block(PaintColour.RED, Shape.SQUARE));
        order.add(new Block(PaintColour.RED, Shape.SQUARE));
        Block expected = new Block(PaintColour.RED, Shape.SQUARE);
        order.add(expected);

        Assertions.assertEquals(5, order.getBlocks().size());
        Assertions.assertEquals(expected, order.getBlocks().get(4));
    }
}


