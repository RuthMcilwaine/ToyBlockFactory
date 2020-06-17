

public class ReportData {
    private Customer customerDetails;
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

    public ReportData(Customer customerDetails, int sumOfCosts, int totalSquareCount, int totalTriangleCount, int totalCircleCount, int totalRedCount, int totalBlueCount, int totalYellowCount) {
        this.customerDetails = customerDetails;
        this.sumOfCosts = sumOfCosts;
        this.totalSquareCount = totalSquareCount;
        this.totalTriangleCount = totalTriangleCount;
        this.totalCircleCount = totalCircleCount;
        this.totalRedCount = totalRedCount;
        this.totalBlueCount = totalBlueCount;
        this.totalYellowCount = totalYellowCount;
    }

    Customer getCustomerDetails() { return customerDetails; }

    int getSumOfCosts() {
        return sumOfCosts;
    }

    int getTotalRedCount() {
        return totalRedCount;
    }

    int getTotalBlueCount() {
        return totalBlueCount;
    }

    int getTotalYellowCount() {
        return totalYellowCount;
    }

    int getTotalSquareCount() {
        return totalSquareCount;
    }

    int getTotalTriangleCount() { return totalTriangleCount; }

    int getTotalCircleCount() { return totalCircleCount; }

    int getRedSquare() {
        return redSquare;
    }

    int getBlueSquare() {
        return blueSquare;
    }

    int getYellowSquare() {
        return yellowSquare;
    }

    int getRedTriangle() { return redTriangle; }

    int getBlueTriangle() { return blueTriangle; }

    int getYellowTriangle() { return yellowTriangle; }

    int getBlueCircle() { return blueCircle; }

    int getRedCircle() { return redCircle; }

    int getYellowCircle() { return yellowCircle; }

    int getTriangleCounter() { return totalTriangleCount; }

    int getCircleCounter() { return totalCircleCount; }

    void setCustomerDetails(Customer customerDetails) {
        this.customerDetails = customerDetails;
    }

    void setSquarePaintColours(int redSquare, int blueSquare, int yellowSquare) {
        this.redSquare = redSquare;
        this.blueSquare = blueSquare;
        this.yellowSquare = yellowSquare;
    }

    void setCirclePaintColours(int redCircle, int blueCircle, int yellowCircle) {
        this.redCircle = redCircle;
        this.blueCircle = blueCircle;
        this.yellowCircle = yellowCircle;
    }

    void setTrianglePaintColours(int redTriangle, int blueTriangle, int yellowTriangle) {
        this.redTriangle = redTriangle;
        this.blueTriangle = blueTriangle;
        this.yellowTriangle = yellowTriangle;
    }

}
