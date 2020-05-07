

public class Invoice {
    private int sumOfCosts;
    private int totalSquareCount;
    private int totalTriangleCount;
    private int totalCircleCount;
    private int totalRedCount;
    private int totalBlueCount;
    private int totalYellowCount;
    private int redSquare;
    private int blueSquare;
    private int yellowSquare;
    private int redTriangle;
    private int blueTriangle;
    private int yellowTriangle;
    private int redCircle;
    private int blueCircle;
    private int yellowCircle;


    public Invoice(int sumOfCosts, int totalSquareCount, int totalTriangleCount, int totalCircleCount, int totalRedCount, int totalBlueCount, int totalYellowCount) {
        this.sumOfCosts = sumOfCosts;
        this.totalSquareCount = totalSquareCount;
        this.totalTriangleCount = totalTriangleCount;
        this.totalCircleCount = totalCircleCount;
        this.totalRedCount = totalRedCount;
        this.totalBlueCount = totalBlueCount;
        this.totalYellowCount = totalYellowCount;
    }

    public int getSumOfCosts() {
        return sumOfCosts;
    }

    public int getTotalRedCount() {
        return totalRedCount;
    }

    public int getTotalBlueCount() {
        return totalBlueCount;
    }

    public int getTotalYellowCount() {
        return totalYellowCount;
    }

    public int getTotalSquareCount() {
        return totalSquareCount;
    }

    public int getTotalTriangleCount() { return totalTriangleCount; }

    public int getTotalCircleCount() { return totalCircleCount; }

    public int getRedSquare() {
        return redSquare;
    }

    public int getBlueSquare() {
        return blueSquare;
    }

    public int getYellowSquare() {
        return yellowSquare;
    }

    public int getRedTriangle() { return redTriangle; }

    public int getBlueTriangle() { return blueTriangle; }

    public int getYellowTriangle() { return yellowTriangle; }

    public int getBlueCircle() { return blueCircle; }

    public int getRedCircle() { return redCircle; }

    public int getYellowCircle() { return yellowCircle; }

    public int getTriangleCounter() { return totalTriangleCount; }

    public int getCircleCounter() { return totalCircleCount; }

    public void setSquarePaintColours(int redSquare, int blueSquare, int yellowSquare) {
        this.redSquare = redSquare;
        this.blueSquare = blueSquare;
        this.yellowSquare = yellowSquare;
    }

    public void setCirclePaintColours(int redCircle, int blueCircle, int yellowCircle) {
        this.redCircle = redCircle;
        this.blueCircle = blueCircle;
        this.yellowCircle = yellowCircle;
    }

    public void setTrianglePaintColours(int redTriangle,int blueTriangle, int yellowTriangle) {
        this.redTriangle = redTriangle;
        this.blueTriangle = blueTriangle;
        this.yellowTriangle = yellowTriangle;
    }

    @Override
    public String toString() {
        return  "Your invoice report has been generated: \n" +

                "|          | red | blue | yellow | \n" +
                "|  square  |  " + getRedSquare() + "  |  " + getBlueSquare() + "   |   " + getYellowSquare() + "    | \n"
              + "| triangle |  "  + getRedTriangle() + "  |  "  + getBlueTriangle() +  "   |   "  + getYellowTriangle() +  "    | \n"
              + "|  circle  |  " + getRedCircle()+ "  |  " + getBlueCircle() + "   |   " + getYellowCircle() + "    | \n" +

                "Squares " + getTotalSquareCount() + " @ $1 ppi =  $" + getTotalSquareCount()* 1 + "\n" +
                "Triangles " + getTotalTriangleCount() + " @ $2 ppi =  $" + getTotalTriangleCount() * 2 + "\n" +
                "Circles " + getTotalCircleCount() + " @ $3 ppi =  $" + getTotalCircleCount() * 3 + "\n" +
                "Red colour surcharge " + getTotalRedCount() + " @ $1 ppi =  $" + getTotalRedCount() * 1 + "\n" + "\n" +
                "Total:  $" + sumOfCosts;
    }

}
