import java.util.Scanner;

public class Canteen {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            String[] itemNames = {"Burger", "Pizza", "Pasta", "Sandwich", "Milk Tea"};
            double[] itemPrices = {80.00, 120.00, 100.00, 70.00, 90.00};

            int totalQuantity = 0;
            double totalBeforeDiscount = 0.0;
            double totalDiscount = 0.0;

            System.out.println("===== M E N U =====");
            for (int i = 0; i < itemNames.length; i++) {
                System.out.printf("%d. %s - dalc%.2f%n", i + 1, itemNames[i], itemPrices[i]);
            }

            char orderAgain = 'Y';

            while (orderAgain == 'Y' || orderAgain == 'y') {
                System.out.println();
                System.out.print("Enter item number: ");
                int itemNumber = scanner.nextInt();

                System.out.print("Enter quantity: ");
                int quantity = scanner.nextInt();

                boolean validItem = itemNumber >= 1 && itemNumber <= itemNames.length;
                boolean validQuantity = quantity >= 1 && quantity <= 10;

                if (!validItem || !validQuantity) {
                    System.out.println("Invalid order! Please enter a valid item and quantity.");
                } else {
                    System.out.print("Are you a student? (Y/N): ");
                    char studentAnswer = scanner.next().charAt(0);
                    boolean isStudent = studentAnswer == 'Y' || studentAnswer == 'y';

                    double price = itemPrices[itemNumber - 1];
                    double subtotal = price * quantity;

                    double discountRate;
                    if (isStudent && subtotal >= 500) {
                        discountRate = 0.15;
                    } else if (isStudent) {
                        discountRate = 0.10;
                    } else if (subtotal >= 500) {
                        discountRate = 0.05;
                    } else {
                        discountRate = 0.0;
                    }

                    double discount = subtotal * discountRate;
                    double orderTotal = subtotal - discount;

                    System.out.printf("Subtotal: dalc%.2f%n", subtotal);
                    System.out.printf("Discount: dalc%.2f%n", discount);
                    System.out.printf("Order total: dalc%.2f%n", orderTotal);

                    totalQuantity += quantity;
                    totalBeforeDiscount += subtotal;
                    totalDiscount += discount;
                }

                System.out.print("Do you want to order again? (Y/N): ");
                orderAgain = scanner.next().charAt(0);
            }

            double finalAmount = totalBeforeDiscount - totalDiscount;

            System.out.println();
            System.out.println("===== ORDER SUMMARY =====");
            System.out.println("Total items: " + totalQuantity);
            System.out.printf("Total before discount: dalc%.2f%n", totalBeforeDiscount);
            System.out.printf("Total discount: dalc%.2f%n", totalDiscount);
            System.out.printf("Final amount: dalc%.2f%n", finalAmount);
            System.out.println("Thank you for ordering!");

        }
    }
}