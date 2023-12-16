import java.util.HashMap;

public class Bank {
    public String name;
    public String address;

    //Collection of accounts at the Bank
    HashMap<Integer, BankAccount> accounts = new HashMap<>();


    //Constructor:
    public Bank(String name, String address) {
        this.name = name;
        this.address = address;
    }


    //Getters:
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }


    private boolean existsKey (int key){
        return accounts.containsKey(key);
    }

    private static int numberDigits (int number){
        int digits = 0;
        while (number!= 0){
            number = number/10;
            digits++;
        }
        return digits;
    }

    private boolean validateKeySize (int key){
        int digits = numberDigits(key);
        return digits >= 4 && digits <= 8;
    }

    public boolean validateKey (int key){
        return !existsKey(key) && validateKeySize(key);
    }

    public void addNewAccount (BankAccount newAccount, int key){
        accounts.put(key, newAccount);
    }

    public BankAccount searchAccount (int key){
        return accounts.get(key);
    }
}
