

public class ReportData {
    private Customer customerDetails;
    private int orderId;
    private int sumOfCosts;
    private int redSquare;
    private int blueSquare;
    private int yellowSquare;
    private int redTriangle;
    private int blueTriangle;
    private int yellowTriangle;
    private int redCircle;
    private int blueCircle;
    private int yellowCircle;
    private int redHexagon;
    private int blueHexagon;
    private int yellowHexagon;

    public int getRedHexagon() {
        return redHexagon;
    }

    public int getBlueHexagon() {
        return blueHexagon;
    }

    public int getYellowHexagon() {
        return yellowHexagon;
    }

    public Customer getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(Customer customerDetails) {
        this.customerDetails = customerDetails;
    }

    public String getOrderId() { return "000" + orderId; }

    public void setOrderId(int orderId) { this.orderId = orderId; }

    public int getSumOfCosts() {
        return sumOfCosts;
    }

    public void setSumOfCosts(int sumOfCosts) {
        this.sumOfCosts = sumOfCosts;
    }

    public int getTotalSquareCount() {
        return redSquare + blueSquare + yellowSquare;
    }

    public int getTotalTriangleCount() {
        return redTriangle + blueTriangle + yellowTriangle;
    }

    public int getTotalCircleCount() {
        return redCircle + blueCircle + yellowCircle;
    }

    public int getTotalHexagonCount() {
        return redHexagon + blueHexagon + yellowHexagon;
    }

    public int getRedSquare() {
        return redSquare;
    }

    public int getTotalRedCount() {
        return redTriangle + redSquare + redCircle + redHexagon;
    }

    public int getBlueSquare() {
        return blueSquare;
    }

    public int getYellowSquare() {
        return yellowSquare;
    }

    public int getRedTriangle() {
        return redTriangle;
    }

    public int getBlueTriangle() {
        return blueTriangle;
    }

    public int getYellowTriangle() {
        return yellowTriangle;
    }

    public int getRedCircle() {
        return redCircle;
    }

    public int getBlueCircle() {
        return blueCircle;
    }

    public int getYellowCircle() {
        return yellowCircle;
    }

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

    public void setTrianglePaintColours(int redTriangle, int blueTriangle, int yellowTriangle) {
        this.redTriangle = redTriangle;
        this.blueTriangle = blueTriangle;
        this.yellowTriangle = yellowTriangle;
    }
    public void setHexagonPaintColours(int redHexagon, int blueHexagon, int yellowHexagon) {
        this.redHexagon = redHexagon;
        this.blueHexagon = blueHexagon;
        this.yellowHexagon = yellowHexagon;
    }

}
