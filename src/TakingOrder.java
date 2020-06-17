
import java.util.Scanner;

class TakingOrder {
    Order order = new Order();

    TakingOrder() {
    }

    Order getOrder() {
        return order;
    }

    void setOrder(Scanner input) {
        setCustomerDetails(input);
        setOrderDetails(input);
    }

    void setCustomerDetails(Scanner input) {
        String name = validateAndSetInput(input, "name", "Please input your Name: ", "Not a valid name. Please try again");
        String address = validateAndSetInput(input, "address", "Please input your Address: ", "Not a valid address. Please try again");
        String dueDate = validateAndSetInput(input, "dueDate", "Please input your Due Date (eg.19/01/2019): ", "Not a valid date. Please try again");
        order.setCustomer(new Customer(name, address, dueDate));
    }

    private String validateAndSetInput(Scanner scanner, String type, String s, String error) {
        String input;
        do {
            System.out.println(s);
            input = scanner.nextLine();
            if (!ValidateInput.validate(type, input)) {
                System.out.println(error);
            } else {
                break;
            }
        } while (true);
        return input;
    }


    int questionAnswer(Scanner scanner, String block) {
        String question = "Please input the number of ";
        String newLIne = ": ";
        System.out.println(question + block + newLIne);
        return scanner.nextInt();
    }

    void setOrderDetails(Scanner input) {
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

}


        