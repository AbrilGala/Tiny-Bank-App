import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static Scanner scan;
    public static void main(String[] args) {
       scan = new Scanner(System.in);
        int answer = 0;
        String response = "";
        int key = 0;
        boolean validation = false;
        BankAccount account;
        Person owner;
        Bank bank = new Bank("Citigroup", "New York");

        do {
            System.out.println("Bank Account Program");
            System.out.println("You have the following banking operations:");
            System.out.println("""
                    1- Create an empty account\s
                    2- Create an account with an initial balance
                    3- Deposit money
                    4- Extract money
                    5- View current balance
                    6- Exit menu""");
            System.out.println("Please enter here the chosen option: ");
            answer = scan.nextInt();
            switch (answer){
                case 1 -> {
                //Create an empty account
                    System.out.println("Creating a new and empty account....");
                    System.out.println("To create you a new account we need first some personal data");
                    owner = createPerson();
                    //Key:
                    do{
                        System.out.println("Set a number password with a minimum of 4 numbers and a maximum of 8 to protect your account: ");
                        key = scan.nextInt();
                        validation = bank.validateKey(key);
                    } while (!validation);
                    //Creating the bank account:
                    account = new BankAccount(owner,key);
                    //Adding the account into the Bank:
                    bank.addNewAccount(account,key);
                    System.out.println("Your Bank Account have been created!!");
                    System.out.println("Thanks for trusting us, "+owner.getFirstName());
                }
                case 2 -> {
                //Create an account with an initial balance
                    System.out.println("Creating a new account....");
                    //Person data:
                    System.out.println("To create you a new account we need first some personal data");
                    owner = createPerson();
                    //Key:
                    do{
                        System.out.println("Set a number password with a minimum of 4 numbers and a maximum of 8 to protect your account: ");
                        key = scan.nextInt();
                        validation = bank.validateKey(key);
                    } while (!validation);
                    //Creating the bank account:
                    account = new BankAccount(owner,key);
                    System.out.println("Your Bank Account have been created!!");
                    //Adding the account into the Bank:
                    bank.addNewAccount(account,key);
                    //Balance deposit:
                    System.out.println("Now enter the initial balance you want to deposit: ");
                    float money = scan.nextFloat();
                    account.deposit(money);
                    System.out.println("Now, "+owner.getFirstName()+" you have U$D "+account.getBalance()+" at your account");
                    System.out.println("Thanks for trusting us, "+owner.getFirstName());
                }
                case 3 -> {
                //Deposit money
                    System.out.println("To deposit money into one account, first yoy must enter the key of your account: ");
                    key = scan.nextInt();
                    account = bank.searchAccount(key);
                    if(account != null){
                        System.out.println("Now, please enter the amount of money you want to deposit into your bank account: ");
                        float deposit = scan.nextFloat();
                        account.deposit(deposit);
                        System.out.println("The deposit of U$D "+deposit+" is done!");
                        System.out.println("Your current balance is equal to: U$D "+account.getBalance());
                    }else {
                        System.out.println("Sorry, we could not find an account with the key entered.");
                    }
                }
                case 4 -> {
                //Extract money
                    System.out.println("To extract money into one account, first yoy must enter the key of your account: ");
                    key = scan.nextInt();
                    account = bank.searchAccount(key);
                    if(account != null){
                        System.out.println("Your current balance is equal to: U$D "+account.getBalance());
                        System.out.println("Now, please enter the amount of money you want to withdrawal from your bank account: ");
                        float withdrawal = scan.nextFloat();
                        if(account.withdrawal(withdrawal)){
                             System.out.println("The withdrawal of U$D "+withdrawal+" is done!");
                             System.out.println("Now, your updated balance is equal to: U$D "+account.getBalance());
                        }else {
                            System.out.println("The amount of money deposited for withdrawal exceeds the amount of money stored in the account");
                        }
                    }else {
                        System.out.println("Sorry, we could not find an account with the key entered.");
                    }
                }
                case 5 -> {
                //View current balance
                    System.out.println("To see the balance of your bank account, please enter your key: ");
                    key = scan.nextInt();
                    account = bank.searchAccount(key);
                    if(account != null){
                        System.out.println("Your current balance is equal to: U$D"+account.getBalance());
                    }else {
                        System.out.println("Sorry, we could not find an account with the key entered.");
                    }
                }
                case 6 -> {
                //Exit menu
                    System.out.println("Thanks for your time\n Goodbye!.");
                }
                default -> {
                    System.out.println("Invalid operation... try again..");
                }
            }
            System.out.println("Do you want to carry out another banking operation? (yes/no)");
            response = scan.nextLine();
            response = scan.nextLine();
            
            if(answer == 6){
                System.out.println("Thanks for your time\n Goodbye!.");
            }
        }while (response.equalsIgnoreCase("yes") && answer!=6);

    }

    public static Person createPerson (){
        System.out.println("Please insert the name of the person who owns the account to be created: ");
        String name = scan.nextLine();
         name = scan.nextLine();
        System.out.println("Now enter the "+name+"'s Last Name: ");
        String lastName = scan.nextLine();
         lastName = scan.nextLine();
        System.out.println("Enter your age, "+name);
        int age = scan.nextInt();
        System.out.println("Enter your gender: \nF for female, \nM for male, \nX for other");
        String gender = scan.nextLine();
         gender = scan.nextLine();
        char word = gender.charAt(0);
        System.out.println("Please enter your nationality: ");
        String nationality = scan.nextLine();
         nationality = scan.nextLine();
        System.out.println("Lastly, enter your address: ");
        String address = scan.nextLine();
         address = scan.nextLine();
        return new Person(name,lastName,age,word,nationality,address);
    }



}