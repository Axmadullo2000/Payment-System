package MainPackage;

import AbstractionTransaction.Transaction;
import PaymentInterface.Payment;

public class OnlineTransaction extends Transaction implements Payment {

    private final Payment paymentMethod;

    public OnlineTransaction(double amount, String TransactionType, Payment paymentMethod) {
        super(TransactionType, amount);
        this.paymentMethod = paymentMethod;
    }

    public void pay(double percent) {
        if (this.amount != 0) {
            System.out.printf("\nTotally price for transaction: %.2f", this.amount * (1 + percent / 100));
        }else {
            System.out.println("Error occured");
        }
    }

    public Payment getPaymentMethod() {
        return paymentMethod;
    }

    @Override
    public void processTransaction() {
        System.out.println("Transaction processed!");

        if (paymentMethod != null) {
            System.out.printf("The money was transferred through %s\n", getTransactionType());
            paymentMethod.pay(amount);

            System.out.println("Transaction successfully finished!");
        }else {
            System.out.println("Transaction method is not set!");
        }
    }

}
