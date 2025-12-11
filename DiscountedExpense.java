public class DiscountedExpense extends Expense {

    private double discountPercent;

    // Constructor
    public DiscountedExpense(String title, double amount, double discountPercent) {
        super(title, amount); // call parent constructor
        this.discountPercent = discountPercent;
    }

    // Getter and setter for discountPercent
    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    // Override to return the discounted amount
    @Override
    public double getFinalAmount() {
        return getAmount() * (1 - (discountPercent / 100));
    }

    // Override to show full info
    @Override
    public void showInfo() {
        System.out.println("Title: " + getTitle());
        System.out.println("Original Amount: £" + getAmount());
        System.out.println("Discount: " + discountPercent + "%");
        System.out.println("Final Amount: £" + getFinalAmount());
        System.out.println("Type: Discounted");
        System.out.println("---------------------------");
    }
}
