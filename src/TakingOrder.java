import org.jetbrains.annotations.NotNull;

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
        String name = validateAndSetInput(input, "name", "Please input your Name: ", "Not a valid name. Please try again");
        String address = validateAndSetInput(input, "address", "Please input your Address: ", "Not a valid address. Please try again");
        String dueDate = validateAndSetInput(input, "dueDate", "Please input your Due Date (eg.19/01/2019): ", "Not a valid date. Please try again");
        order.setCustomer(new Customer(name, address, dueDate));
    }

    @NotNull
    private String validateAndSetInput(Scanner scanner, String type, String s, String s2) {
        String input;
        do {
            System.out.println(s);
            input = scanner.nextLine();
            if (!ValidateInput.validate(type, input)) {
                System.out.println(s2);
            } else {
                break;
            }
        } while (true);
        return input;
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


        