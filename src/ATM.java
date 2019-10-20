import java.util.Scanner;

public class ATM  {
    static Scanner userKeyboard = new Scanner(System.in);
    static String accountNumber, accountPass, result;
    static double oldBalance,currentBalance, amount = 0.00;

    static int choosePath;

    public static void main(String[] args) {
        for (int run = 0; run < 3; run++) {
            System.out.println("Enter your account number: ");
            accountNumber = userKeyboard.nextLine();
            System.out.println("Enter your account password: ");
            accountPass = userKeyboard.nextLine();

            result = checkId(accountNumber, accountPass);
            if (!result.equals("ERROR")) {
                break;
            } else if (run == 2) {
                System.out.println("MAXIMUM TRIES EXCEEDED!");
                return;
            }
        }
        menu();
    }

    public static String checkId(String accountNumber, Object accountPass) {
        String result = "ERROR";

        if (accountNumber.equals("0000") && accountPass.equals("0000")) {
            result = "Success!";    //  pointless message
        }
        System.out.println(result);
        return result;
    }

    public static int menu() {
        System.out.println("Choose one of the following: \n1.Display Balance\n2.Deposit\n3.Withdraw\n4.Log Out");
        choosePath = userKeyboard.nextInt();

        if (choosePath == 1) {
            displayBalance();
            menu();
            return 1;
        }
        if (choosePath == 2) {
            deposit();
            menu();
            return 2;
        }
        if (choosePath == 3) {
            withdraw();
            menu();
            return 3;
        }
        if (choosePath == 4) {
            System.out.println("You are logged out.");
            return 4;
        }
        if (choosePath <= 5) {
            System.out.println("System Error");
            menu();
            return 5;
        }
        if (choosePath >= 1) {
            System.out.println("System Error");
            menu();
            return 6;
        }
        //  return the user's choice.
        return choosePath;
    }

    public static void deposit() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter deposit amount:");
        amount = input.nextDouble();
        System.out.println("Your deposit amount: " + amount + "\n==== ==== ==== ====");
        currentBalance += amount;
        System.out.println("Your new balance is: " + currentBalance + "\n==== ==== ==== ====");
    }

    public static double displayBalance() {
        System.out.println("Total balance is: $" + currentBalance);
        oldBalance = 0.00;
        return 1;
    }

    public static void withdraw() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter withdrawal amount: ");
        amount = input.nextDouble();
        System.out.println("Your withdrawal amount: " + amount);
        currentBalance -= amount;
        System.out.println("Your new balance is: " + currentBalance);
    }
}