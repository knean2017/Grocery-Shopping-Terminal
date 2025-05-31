import java.util.Scanner;

// Custom Exception class for Item Not Found
class ItemNotFoundException extends Exception {
    public ItemNotFoundException(String message) {
        super(message);
    }
}

public class GroceryShopping {

    public static void main(String[] args) {
        // Items and Prices
        String[] item = {"table", "chair", "pen", "water", "book", "paper", "phone", "mouse", "cat", "keyboard"};
        float[] price = {10f, 5f, 1f, 0.5f, 1.7f, 0.7f, 199f, 27.4f, 40f, 79.9f};
        Scanner scanner = new Scanner(System.in);

        // Opens Program
        while (true) {
            float totalBill = 0;

            // Open Basket
            while (true) {
                System.out.println("Enter the name of the item ('check' for checking current bill or 'finish' to end the purchase):");
                String input = scanner.nextLine();

                // Check Finish
                if (input.equalsIgnoreCase("finish")) {
                    System.out.println("Here is the total bill: " + totalBill);
                    break;
                }

                if (input.equalsIgnoreCase("check")) {
                    System.out.println("Here is the current bill: " + totalBill);
                    continue;
                }

                int itemIndex = -1;

                try {
                    // Checking the needed item
                    for (int i = 0; i < item.length; i++) {
                        if (item[i].equalsIgnoreCase(input)) {
                            itemIndex = i;
                            break;
                        }
                    }

                    // If not found, throw custom exception
                    if (itemIndex == -1) {
                        throw new ItemNotFoundException(input + " not found. Please try again.");
                    }

                    // Ask for quantity
                    System.out.println("Enter the quantity of " + item[itemIndex] + ":");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // consume newline

                    // Add to total
                    totalBill += quantity * price[itemIndex];
                    System.out.println("Added " + quantity + " x " + item[itemIndex] + " to basket.");

                } catch (ItemNotFoundException e) {
                    System.out.println(e.getMessage()); // Custom error message
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter a valid quantity."); // Catch other input errors
                    scanner.nextLine(); // Clear invalid input
                }
            }

            // Ask if user wants to exit
            System.out.println("Type 'exit' to leave or press Enter to start a new purchase:");
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }
        }
    }
}
