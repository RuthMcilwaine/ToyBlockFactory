

public class Invoice {
    private int totalPrice;
    private int squareCounter;
    private int triangleCounter;
    private int circleCounter;
    private int redSurcharge;



    public Invoice(int totalPrice) {
        this.totalPrice = totalPrice;

    }

    public void setCounters(int squareCounter, int triangleCounter, int circleCounter, int redSurcharge) {
        this.squareCounter = squareCounter;
        this.triangleCounter = triangleCounter;
        this.circleCounter = circleCounter;
        this.redSurcharge = redSurcharge;

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

}
