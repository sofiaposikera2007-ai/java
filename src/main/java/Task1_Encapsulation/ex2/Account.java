package Task1_Encapsulation.ex2;

public class Account {
    // Приватні поля
    private double balance;
    private String accountNumber;

    // Геттер для balance
    public double getBalance() { return balance;}

    // Метод поповнення рахунку
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Рахунок поповнено на " + amount);
        } else {
            System.out.println("Сума поповнення має бути більшою за 0.");
        }
    }

    // Метод зняття коштів
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("З рахунку знято " + amount);
        } else {
            System.out.println("Недостатньо коштів або некоректна сума.");
        }
    }

    // Метод перевірки балансу
    public void checkBalance() {
        System.out.println("Поточний баланс: " + balance);
    }

    public static void main(String[] args) {
        Account account = new Account();
        account.deposit(200);
        account.withdraw(100);
        account.checkBalance();
    }
}
