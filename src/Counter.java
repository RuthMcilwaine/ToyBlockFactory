public class Counter {
    private int squareCounter;
    private int triangleCounter;
    private int circleCounter;
    private int redSurcharge;
    private int bluePaintColour;
    private int yellowPaintColour;
    private Block block;

    public Counter(int squareCounter, int triangleCounter, int circleCounter, int redSurcharge, int bluePaintColour, int yellowPaintColour, Block block) {
        this.squareCounter = squareCounter;
        this.triangleCounter = triangleCounter;
        this.circleCounter = circleCounter;
        this.redSurcharge = redSurcharge;
        this.bluePaintColour = bluePaintColour;
        this.yellowPaintColour = yellowPaintColour;
        this.block = block;
    }

    public int getSquareCounter() {
        return squareCounter;
    }

    public int getTriangleCounter() {
        return triangleCounter;
    }

    public int getCircleCounter() {
        return circleCounter;
    }

    public int getRedSurcharge() {
        return redSurcharge;
    }

    public int getBluePaintColour() {
        return bluePaintColour;
    }

    public int getYellowPaintColour() {
        return yellowPaintColour;
    }

    public Counter invoke() {
        if (block.getShape().equals(Shape.SQUARE)) {
            squareCounter++;
        }
        if (block.getShape().equals(Shape.TRIANGLE)) {
            triangleCounter++;
        }
        if (block.getShape().equals(Shape.CIRCLE)) {
            circleCounter++;
        }
        if (block.getPaintcolour().equals(PaintColour.RED)) {
            redSurcharge++;
        }
        if (block.getPaintcolour().equals(PaintColour.BLUE)) {
            bluePaintColour++;
        }
        if (block.getPaintcolour().equals(PaintColour.YELLOW)) {
            yellowPaintColour++;
        }
        return this;
    }
}