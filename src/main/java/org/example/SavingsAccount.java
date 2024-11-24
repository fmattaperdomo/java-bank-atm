package org.example;

public class SavingsAccount extends Account {
    //private double interestRate;

    public SavingsAccount(String accountNumber, double balance, String pin /*, double interestRate*/) {
        super(accountNumber, balance, pin);
        //this.interestRate = interestRate;
    }

    /*public void applyInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest);
    }*/
    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > getBalance()) {
            throw new InsufficientFundsException();
        }
        // Lógica específica de retiro...
    }

    @Override
    public void deposit(double amount) {
        // Implementación de depósito...
    }

}
