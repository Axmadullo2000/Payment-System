package AbstractionTransaction;

public abstract class Transaction {
    private String TransactionType;
    protected double amount;

    public Transaction(String transactionType, double amount) {
        TransactionType = transactionType;
        this.amount = amount;
    }

    public String getTransactionType() {
        return TransactionType;
    }

    public void setTransactionType(String transactionType) {
        TransactionType = transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public abstract void processTransaction();

}
