public class Application {

    public static void main(String[] args)
    {
        SavingsAccount saver1 = new SavingsAccount(2000.00);
        SavingsAccount saver2 = new SavingsAccount(3000.00);
        System.out.println("4% interest rate: ");
        SavingsAccount.ModifyInterestRate(.04);

        for(int i = 0; i < 24; i++)
        {
            if(i < 12)
                System.out.printf("Month %d: saver1 Balance: %.2f\n", (i + 1), saver1.CalculateMonthlyInterestRate());
            else
                System.out.printf("Month %d: saver2 Balance: %.2f\n", (i - 11), saver2.CalculateMonthlyInterestRate());
        }
        System.out.println();
        SavingsAccount.ModifyInterestRate(.05);
        System.out.println("5% interest rate for next month: ");
        System.out.printf("saver1 Balance: %.2f\n", saver1.CalculateMonthlyInterestRate());
        System.out.printf("saver2 Balance: %.2f\n", saver2.CalculateMonthlyInterestRate());
    }
}
