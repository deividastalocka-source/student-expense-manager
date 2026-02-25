public class Expense {

    // Fields (variables)
    private String title;
    private double amount;

    // Constructor
    public Expense(String title, double amount) {
        this.title = title;
        this.amount = amount;
    }

    // Getter for title
    public String getTitle() {
        return title;
    }

    // Setter for title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for amount
    public double getAmount() {
        return amount;
    }

    // Setter for amount
    public void setAmount(double amount) {
        this.amount = amount;
    }

    // Returns the amount (no discount for normal expenses)
    public double getFinalAmount() {
        return amount;
    }

    // Displays expense details
    public void showInfo() {
        System.out.println("Title: " + title);
        System.out.println("Original Amount: £" + amount);
        System.out.println("Final Amount: £" + getFinalAmount());
        System.out.println("Type: Normal");
        System.out.println("---------------------------");
    }
}
