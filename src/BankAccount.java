public class BankAccount {
    private float balance;
    private Person person;
    private int key;


    //Constructor:
    public BankAccount (Person person, int key){
        this.key = key;
        this.person = person;
        this.balance = 0;
    }
    public BankAccount(Person person, float balance, int key) {
        this.key = key;
        this.person = person;
        this.balance = balance;
    }

    //Getters:

    //Returns the current balance:
    public float getBalance() {
        return balance;
    }

    //Functions:

    //Add the amount received to the account balance:
    public void deposit (float money){
        balance += money;
    }

    //Deduct the amount received from the balance. After calling this method, the balance cannot remain negative:
    public boolean withdrawal (float money) {
        if(validateWithdrawal(money)){
            balance -= money;
            return true;
        }else {
            return false;
        }
    }

    //The following function allows you to validate a bank withdrawal
    public boolean validateWithdrawal (float money){
        return !(getBalance() < money);
    }



    @Override
    public String toString() {
        return "BankAccount data: \n" +
                "U$D"+ balance +
                ",\n Owner: " + person.getFirstName()+" "+person.getLastName();
    }





}
