
public class ValidateInput {


    public static boolean validate(String type, String input) {
        if (type.equals("name")) {
            return validateName(input);
        }
        if (type.equals("address")){
            return validateAddress(input);
        }
        if (type.equals("dueDate")) {
            return validateDueDate(input);
        }
        return false;
    }

    public static boolean validateName(String name) {
        if (name == null || name.length() > 100) {
            return false;
        }
        return name.matches("^[\\p{L} .'-]+$");
    }

    public static boolean validateAddress(String address) {
        return address.matches("[A-Za-z0-9 .,'-]+$");
    }

    public static boolean validateDueDate(String dueDate) {
        return dueDate.matches("^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$");
    }

    public static boolean validateNumberInputForOrder(int number) {
        return number <= 20;
    }
}