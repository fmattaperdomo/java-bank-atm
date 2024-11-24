package org.example;
import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        double balance = 1000.0;
        ArrayList<String> transactionHistory = new ArrayList<>();

        deposit(500, balance, transactionHistory);
        withdraw(100, balance, transactionHistory);

        System.out.println("Balance final: " + balance);
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
    public static void deposit(double amount, double balance, ArrayList<String> transactionHistory) {
        balance += amount;
        transactionHistory.add("Deposited: $" + amount);
    }

    public static boolean withdraw(double amount, double balance, ArrayList<String> transactionHistory) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.add("Withdrew: $" + amount);
            return true;
        } else {
            System.out.println("Insufficient funds");
            return false;
        }
    }
}