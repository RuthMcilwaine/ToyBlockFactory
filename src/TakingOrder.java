
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
        createBlocks(questionAnswer(input, "Red Squares"), PaintColour.RED, Shape.SQUARE);
        createBlocks(questionAnswer(input, "Blue Squares"), PaintColour.BLUE, Shape.SQUARE);
        createBlocks(questionAnswer(input, "Yellow Squares"), PaintColour.YELLOW, Shape.SQUARE);
        createBlocks(questionAnswer(input, "Red Triangle"), PaintColour.RED, Shape.TRIANGLE);
        createBlocks(questionAnswer(input, "Blue Triangle"), PaintColour.BLUE, Shape.TRIANGLE);
        createBlocks(questionAnswer(input, "Yellow Triangle"), PaintColour.YELLOW, Shape.TRIANGLE);
        createBlocks(questionAnswer(input, "Red Circle"), PaintColour.RED, Shape.CIRCLE);
        createBlocks(questionAnswer(input, "Blue Circle"), PaintColour.BLUE, Shape.CIRCLE);
        createBlocks(questionAnswer(input, "Yellow Circle"), PaintColour.YELLOW, Shape.CIRCLE);
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


        