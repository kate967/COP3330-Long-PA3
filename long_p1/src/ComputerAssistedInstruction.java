import java.security.SecureRandom;
import java.util.Scanner;

public class ComputerAssistedInstruction {

    public static String RandomCorrectResponse(int num)
    {
        String[] good = {"Very good!", "Excellent!", "Nice work!", "Keep up the good work!"};

        switch(num)
        {
            case 1:
                return (good[0]);
            case 2:
                return (good[1]);
            case 3:
                return (good[2]);
            case 4:
                return (good[3]);
            default:
                return "Invalid";
        }
    }

    public static String RandomWrongResponse(int num)
    {
        String[] bad = {"No. Please try again.", "Wrong. Try once more.", "Don’t give up!", "No. Keep trying."};

        switch(num)
        {
            case 1:
                return (bad[0]);
            case 2:
                return (bad[1]);
            case 3:
                return (bad[2]);
            case 4:
                return (bad[3]);
            default:
                return "Invalid";
        }
    }

    public static int ChosenDifficulty(int num)
    {
        SecureRandom rand = new SecureRandom();

        switch (num)
        {
            case 1:
                return rand.nextInt(10);
            case 2:
                return rand.nextInt(100);
            case 3:
                return rand.nextInt(1000);
            case 4:
                return rand.nextInt(10000);
            default:
                return 0;
        }
    }

    public static double ChosenOperator(int choice, int x, int y, int difficulty)
    {
        SecureRandom rand = new SecureRandom();

        if(choice == 5)
            choice = rand.nextInt(3) + 1;

        switch (choice){
            case 1:
                System.out.println("How much is " + x + " plus " + y + "?");
                return (x + y);
            case 2:
                System.out.println("How much is " + x + " minus " + y + "?");
                return (x - y);
            case 3:
                System.out.println("How much is " + x + " times " + y + "?");
                return (x * y);
            case 4:
                if(y == 0)
                    y++;
                System.out.println("How much is " + x + " divided by " + y + "?");
                return ((double)x/y);
            default:
                return 1;
        }
    }

    public static void GenerateQuestion()
    {
        SecureRandom rand = new SecureRandom();
        Scanner scnr = new Scanner(System.in);
        final double THRESHOLD = 0.01;
        int x, y;
        double answer, input = 9999;
        int difficulty = 1, operator = 0, session = 1;
        double correct = 0.0, incorrect = 0.0, score = 0.0;

        while(session != 0) {
            score = 0.0;
            correct = 0.0;
            incorrect = 0.0;

            System.out.printf("Choose A Difficulty:\n1 - Single Digits\n2 - Double Digits\n3 - Triple Digits\n4 - Quadruple Digits\n");
            difficulty = scnr.nextInt();
            System.out.printf("Choose Problem Type:\n1 - Addition\n2 - Subtraction\n3 - Multiplication\n4 - Division\n5 - Random\n");
            operator = scnr.nextInt();

            for (int i = 0; i < 10; i++) {
                x = ChosenDifficulty(difficulty);
                y = ChosenDifficulty(difficulty);
                System.out.printf("%d: ", i + 1);
                answer = ChosenOperator(operator, x, y, difficulty);
                input = scnr.nextDouble();

                if (Math.abs(answer - input) > THRESHOLD){
                    System.out.println(RandomWrongResponse(rand.nextInt(3) + 1));
                    incorrect++;
                }
                else {
                    System.out.println(RandomCorrectResponse(rand.nextInt(3) + 1));
                    correct++;
                }
            }

            score = (correct / 10.0) * 100;

            System.out.println();
            System.out.printf("Correct: %.0f\nIncorrect: %.0f\n", correct, incorrect);
            if (score > 75.0)
                System.out.println("Congratulations, you are ready to go to the next level!");
            else
                System.out.println("Please ask your teacher for extra help.");
            System.out.println();
            System.out.println("Would you like to begin a new session? (0) = No (1) = Yes");
            session = scnr.nextInt();
        }

        System.out.println("Goodbye!");
    }

    public static void main(String args[])
    {
        GenerateQuestion();
    }
}