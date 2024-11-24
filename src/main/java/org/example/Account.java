package org.example;


public abstract class Account implements Authenticatable {
    private String accountNumber;
    private double balance;
    private String pin;

    public Account(String accountNumber, double initialBalance, String pin) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.pin = pin;
    }
    /*public void deposit(double amount) {
        this.balance += amount;
    }*/

    /*public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > this.balance) {
            throw new InsufficientFundsException();
        }
        this.balance -= amount;
    }*/
    public double getBalance() {
        return balance;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public abstract void withdraw(double amount) throws InsufficientFundsException;
    public abstract void deposit(double amount);

    @Override
    public boolean authenticate(String pin) {
        return this.pin.equals(pin);
    }
    public void transferFunds(String targetAccountNumber, double amount)
            throws InsufficientFundsException, InvalidAccountException {
        if (balance < amount) {
            throw new InsufficientFundsException("Fondos insuficientes");
        }
        if (!Bank.isValidAccount(targetAccountNumber)) {
            throw new InvalidAccountException("Cuenta destino no válida");
        }
        balance -= amount;
        Bank.getAccount(targetAccountNumber).deposit(amount);
    }
}
