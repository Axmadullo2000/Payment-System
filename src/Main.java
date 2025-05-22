import MainPackage.OnlineTransaction;
import PaymentInterface.Payment;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("""
                Choose company ->
                    1. Click
                    2. PayMe
                    3. PayPal
                    4. CreditCard
                """);


            int option = input.nextInt();

            if (option < 1 || option > 4) {
                System.out.println("Please enter a valid option (1-4) Try again.");
                continue;
            }

            System.out.print("How much money would you like to transfer?");
            double transferAmount = input.nextDouble();

            Payment paymentMethod = null;

            switch (option) {
                case 1 -> paymentMethod = amount -> System.out.printf("\nPaying via Click: %.2f\n", amount);
                case 2 -> paymentMethod = amount -> System.out.printf("\nPaying via Pay me: %.2f\n", amount);
                case 3 -> paymentMethod = amount -> System.out.printf("\nPaying via Pay Pal: %.2f\n", amount);
                case 4 -> paymentMethod = amount -> System.out.printf("\nPaying via Credit Card: %.2f\n", amount);
                default -> {
                    System.out.println("Please enter right option!");
                    return;
                }
            }

            String type = getCompanyName(option);

            OnlineTransaction transaction = new OnlineTransaction(transferAmount, type, paymentMethod);
            transaction.processTransaction();
            transaction.pay(getCommission(option));
        }



    }

    private static double getCommission(int option) {
        return switch (option) {
            case 1 -> 3.0;
            case 2 -> 1.5;
            case 3 -> 1;
            case 4 -> 2;
            default -> 0.0;
        };
    }

    private static String getCompanyName(int option) {
        return switch (option) {
            case 1 -> "Click";
            case 2 -> "PayMe";
            case 3 -> "PayPal";
            case 4 -> "CreditCard";
            default -> "Unknown";
        };
    }

}
