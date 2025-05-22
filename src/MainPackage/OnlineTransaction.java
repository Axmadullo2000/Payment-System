package Main;

import abstractionTransaction.Transaction;
import paymentInterface.Payment;

public class OnlineTransaction extends Transaction {
    private Payment paymentMethod;

    public OnlineTransaction(double amount, Payment paymentMethod) {
        super(amount);
        this.paymentMethod = paymentMethod;
    }

    @Override
    public void processTransaction() {

    }
}
