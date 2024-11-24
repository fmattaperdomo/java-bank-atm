package org.example;
import java.util.Scanner;

public class ATM implements Authenticatable{
    private Calculator calculator = new Calculator();

    private static final String LOG_FILE = "transactions.log";
    private TransactionLogger logger = new TransactionLogger(LOG_FILE);

    public void performTransaction(String accountNumber, Transaction.TransactionType type, double amount) {
        logger.logTransaction(accountNumber + " " + type + " " + amount);
    }
    @Override
    public boolean authenticate(String pin) {
        // Lógica de autenticación...
        return true; // o false según el caso
    }
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Bienvenido a JavaBank ATM.");
            System.out.println("Seleccione una operación:");
            System.out.println("1. Realizar una transacción");
            System.out.println("2. Usar la calculadora");
            System.out.println("0. Salir");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // lógica de transacción
                    break;
                case 2:
                    calculator.start();
                    break;
                case 0:
                    exit = true;
                    break;
                default:
                    System.out.println("Selección no válida.");
            }
        }
        scanner.close();
    }


    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.start();
    }
}
