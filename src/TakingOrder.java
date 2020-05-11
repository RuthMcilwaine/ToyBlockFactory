import java.util.Scanner;

public class TakingOrder {
    Order order = new Order();

    public TakingOrder() {
    }

    public void setOrder(Scanner input) {
        setCustomerDetails(input);
        setOrderDetails(input);
    }

    public void setCustomerDetails(Scanner input) {
        String name;
        String address;
        String dueDate;

        do {
            System.out.println("Please input your Name: ");
            name = input.nextLine();
            if (!ValidateInput.validateName(name)) {
                System.out.println("Not a valid name. Please try again");
            } else {
                break;
            }
        } while (true);
        do {
            System.out.println("Please input your Address: ");
            address = input.nextLine();
            if (!ValidateInput.validateAddress(address)) {
                System.out.println("Not a valid address. Please try again");
            } else {
                break;
            }
        } while (true);
        do {
            System.out.println("Please input your Due Date (eg.19/01/2019): ");
            dueDate = input.nextLine();
            if (!ValidateInput.validateDueDate(dueDate)) {
                System.out.println("Not a valid date. Please try again");
            } else {
                break;
            }
        } while (true);
        order.setCustomer(new Customer(name, address, dueDate));
    }


    public int questionAnswer(Scanner scanner, String block) {
        String question = "Please input the number of ";
        String newLIne = ": ";
        System.out.println(question + block + newLIne);
        return scanner.nextInt();
    }

    public void setOrderDetails(Scanner input) {
        int redSquareOrder = questionAnswer(input, "Red Squares");
        createBlocks(redSquareOrder, PaintColour.RED, Shape.SQUARE);
        int blueSquareOrder = questionAnswer(input, "Blue Squares");
        createBlocks(blueSquareOrder, PaintColour.BLUE, Shape.SQUARE);
        int yellowSquareOrder = questionAnswer(input, "Yellow Squares");
        createBlocks(yellowSquareOrder, PaintColour.YELLOW, Shape.SQUARE);
        int redTriangleOrder = questionAnswer(input, "Red Triangle");
        createBlocks(redTriangleOrder, PaintColour.RED, Shape.TRIANGLE);
        int blueTriangleOrder = questionAnswer(input, "Blue Triangle");
        createBlocks(blueTriangleOrder, PaintColour.BLUE, Shape.TRIANGLE);
        int yellowTriangleOrder = questionAnswer(input, "Yellow Triangle");
        createBlocks(yellowTriangleOrder, PaintColour.YELLOW, Shape.TRIANGLE);
        int redCircleOrder = questionAnswer(input, "Red Circle");
        createBlocks(redCircleOrder, PaintColour.RED, Shape.CIRCLE);
        int blueCircleOrder = questionAnswer(input, "Blue Circle");
        createBlocks(blueCircleOrder, PaintColour.BLUE, Shape.CIRCLE);
        int yellowCircleOrder = questionAnswer(input, "Yellow Circle");
        createBlocks(yellowCircleOrder, PaintColour.YELLOW, Shape.CIRCLE);
    }

    private void createBlocks(int numOfBlocks, PaintColour paintColour, Shape shape) {
        for (int i = 0; i < numOfBlocks; i++) {
            order.add(new Block(paintColour, shape));
        }
    }

    public Order getOrder() {
        return order;
    }
}


        