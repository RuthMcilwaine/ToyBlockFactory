

public class Invoice {
    private int totalPrice;
    private int squareCounter;
    private int triangleCounter;
    private int circleCounter;
    private int redSurcharge;
    private int bluePaintColour;
    private int yellowPaintColour;


    public Invoice(int totalPrice, int squareCounter, int triangleCounter, int circleCounter, int redSurcharge, int bluePaintColour, int yellowPaintColour) {
        this.totalPrice = totalPrice;
        this.squareCounter = squareCounter;
        this.triangleCounter = triangleCounter;
        this.circleCounter = circleCounter;
        this.redSurcharge = redSurcharge;
        this.bluePaintColour = bluePaintColour;
        this.yellowPaintColour = yellowPaintColour;
    }

    public int getTotalPrice() {
       return totalPrice;
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

    public int getBluePaintColour() { return bluePaintColour; }

    public int getYellowPaintColour() { return yellowPaintColour; }
}
