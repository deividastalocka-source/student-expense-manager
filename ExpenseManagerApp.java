import java.util.Scanner;
import java.util.ArrayList;

public class ExpenseManagerApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Store expenses (normal + discounted) in one list
        ArrayList<Expense> expenses = new ArrayList<>();

        boolean looping = true;

        while (looping)
        {
            // Menu header
            System.out.println("==== Student Expense Manager ====");

            // Menu options
            System.out.println("1. Add Expense");
            System.out.println("2. Add Discounted Expense");
            System.out.println("3. View All Expenses");
            System.out.println("4. Show Total Spending");
            System.out.println("5. Show Highest Expense");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int menuChoice = input.nextInt();
            input.nextLine(); // consume leftover newline

            switch (menuChoice)
            {
                case 1:
                    // Add a normal expense
                    System.out.print("Enter expense title: ");
                    String title = input.nextLine();

                    System.out.print("Enter amount: ");
                    double amount = input.nextDouble();

                    // Create Expense object
                    Expense newExpense = new Expense(title, amount);

                    // Add to list
                    expenses.add(newExpense);

                    System.out.println("Normal expense added successfully!");
                    break;

                case 2:
                    // Add Discounted Expense
                    System.out.print("Enter expense title: ");
                    String dTitle = input.nextLine();

                    System.out.print("Enter original amount: ");
                    double dAmount = input.nextDouble();

                    System.out.print("Enter discount percentage: ");
                    double dPercent = input.nextDouble();
                    input.nextLine(); // clear newline

                    // Create DiscountedExpense object
                    DiscountedExpense newDiscounted = new DiscountedExpense(dTitle, dAmount, dPercent);

                    // Add to list
                    expenses.add(newDiscounted);

                    System.out.println("Discounted expense added successfully!");
                    break;

                case 3:
                    // View all expenses
                    if (expenses.isEmpty()) {
                        System.out.println("No expenses recorded yet.");
                    } else {
                        System.out.println("---- All Expenses ----");
                        for (Expense e : expenses) {
                            e.showInfo(); // works for both Expense and DiscountedExpense
                        }
                    }
                    break;

                case 4:
                    // Show total spending
                    if (expenses.isEmpty()) {
                        System.out.println("No expenses recorded yet.");
                    } else {
                        double total = 0;

                        for (Expense e : expenses) {
                            total += e.getFinalAmount(); // works for normal + discounted expenses
                        }

                        System.out.println("Total Spending: £" + total);
                    }
                    break;

                case 5:
                    // Show highest expense
                    if (expenses.isEmpty()) {
                        System.out.println("No expenses recorded yet.");
                    } else {
                        Expense highestExpense = expenses.get(0);
                        double highestAmount = highestExpense.getFinalAmount();

                        for (Expense e : expenses) {
                            double currentAmount = e.getFinalAmount();
                            if (currentAmount > highestAmount) {
                                highestAmount = currentAmount;
                                highestExpense = e;
                            }
                        }

                        System.out.println("Highest Expense:");
                        System.out.println("Title: " + highestExpense.getTitle());
                        System.out.println("Final Amount: £" + highestAmount);
                    }
                    break;

                case 6:
                    System.out.println("Thank you for using Student Expense Manager");
                    looping = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                    break;
            }
        }
    }
}
