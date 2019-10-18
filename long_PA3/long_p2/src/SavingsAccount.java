public class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;

    public SavingsAccount(double balance)
    {
        this.savingsBalance = balance;
    }

    public double CalculateMonthlyInterestRate()
    {
        double rate = (savingsBalance * annualInterestRate) / 12;
        savingsBalance += rate;
        return savingsBalance;
    }

    public static void ModifyInterestRate(double newRate)
    {
        annualInterestRate = newRate;
    }
}