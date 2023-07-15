import java.util.Scanner;
class BankAccount
{
    String name;
    String username;
    String password;
    String accountNo;
    float balance = 100000f;
    int transactions = 0;
    String transactionHistory = "";

    public void register()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your Name: ");
        this.name = sc.nextLine();
        System.out.println("Enter your Username: ");
        this.username = sc.nextLine();
        System.out.println("Enter your Password: ");
        this.password = sc.nextLine();
        System.out.println("Enter your Account Number: ");
        this.accountNo = sc.nextLine();
    }

    public boolean login()
    {
        boolean islogin = false;
        Scanner sc = new Scanner(System.in);
        while (!islogin)
        {
            System.out.println("Enter your Username: ");
            String Username = sc.nextLine();
            if (username.equals(Username))
            {
                while (!islogin)
                {
                    System.out.println("Enter your password");
                    String Password = sc.nextLine();
                    if(password.equals(Password))
                    {
                        System.out.println("Login successful!");
                        islogin = true;
                    }
                    else
                    {
                        System.out.println("Incorrect password");
                    }
                }
            }
            else
            {
                System.out.println("Username not found");
            }
        }
        return islogin;
    }

    public void withdraw()
    {
        System.out.println("Enter amount to be withdrawn: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try 
        {
            if(balance >= amount)
            {
                transactions++;
                balance = balance - amount;
                System.out.println("Withdrawn successfully!");
                String str = amount + "Rs. Withdrawn\n";
                transactionHistory = transactionHistory.concat(str);
            }
            else
            {
                System.out.println("Insufficient funds");
            }
        }
        catch ( Exception e)
        {}
    }

    public void deposit()
    {
        System.out.println("Enter the amount to be deposited: ");
        Scanner sc = new Scanner(System.in);
        float amount = sc.nextFloat();
        try
        {
            if(amount <= 100000f)
            {
                transactions++;
                balance = balance + amount;
                System.out.println("Successfully Deposited!");
                String str = amount + "Rs. Deposited";
                transactionHistory = transactionHistory.concat(str);
            }
            else
            {
                System.out.println("Deposit Limit is 100000.00!");
            }
        }
        catch( Exception e)
        {}
    }

    public void transfer()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Recepient's Name: ");
        String recepient = sc.nextLine();
        System.out.println("Enter Amount to transfer: ");
        float amount = sc.nextFloat();
        try
        {
            if(balance >= amount)
            {
                if(amount <= 50000f)
                {
                    transactions++;
                    balance = balance - amount;
                    System.out.println("Successfully transferred to " + recepient);
                    String str = amount + "Rs Transferred to" + recepient + "\n";
                    transactionHistory = transactionHistory.concat(str); 
                }
                else
                {
                    System.out.println("The Transaction limit is Rs.50000.00");
                }
            }
            else
            {
                System.out.println("Insufficient funds!");
            }
        }
        catch( Exception e)
        {}
    }

    public void checkBalance()
    {
        System.out.println("Your account balance is" + balance + "Rs.");
    }

    public void transactionHistory()
    {
        if(transactions == 0)
        {
            System.out.println("Empty");
        }
        else
        {
            System.out.println("\n" + transactionHistory);
        }
    }
}

public class atm
{
    public static int takeIntegerInput(int limit)
    {
        int input = 0;
        boolean flag = false;

        while(!flag)
        {
            try
            {
                Scanner sc = new Scanner(System.in);
                input = sc.nextInt();
                flag = true;

                if(flag && input > limit || input < 1)
                {
                    System.out.println("Choose the number 1 to " + limit);
                    flag = false;
                }
            }
            catch ( Exception e )
            {
                System.out.println("Enter only integer value");
                flag = false;
            }
        }
        return input;
    }

    public static void main(String[] args)
    {
       System.out.println("WELCOME TO THE ATM SYSTEM");
       System.out.println("Please Enter your choice: ");
       System.out.println("1. Register");
       System.out.println("2. Exit");
       int choice = takeIntegerInput(2);

       if(choice == 1)
       {
         BankAccount b = new BankAccount();
         b.register();
         while(true)
           {
            System.out.println("Please Enter your choice: ");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            int ch = takeIntegerInput(2);
            if(ch == 1)
              {
                if(b.login())
                {
                    System.out.println("WELCOME BACK " + b.name);
                    boolean isFinished = false;
                    while(!isFinished)
                    {
                        System.out.println("\n1. Withdraw \n2. Deposit \n3. Transfer \n4. Check Balance \n5. Transaction History \n6. Exit \n");
                        System.out.println("Enter Your Choice: ");
                        int c = takeIntegerInput(6);
                        switch(c)
                        {
                            case 1:
                            {
                                b.withdraw();
                            }
                            break;
                            case 2:
                            {
                                b.deposit();
                            }
                            break;
                            case 3:
                            {
                                b.transfer();
                            }
                            break;
                            case 4:
                            {
                                b.checkBalance();
                            }
                            break;
                            case 5:
                            {
                                b.transactionHistory();
                            }
                            break;
                            case 6: 
                            {
                                isFinished = true;
                            }
                            break;
                            default:
                            {
                                System.out.println("Please provide a valid choice.");
                            }
                        }
                    }
                }
            }
            else
            {
                System.exit(0);
            }
          }
       } 
       else
       {
        System.exit(0);
       }
    }
}
