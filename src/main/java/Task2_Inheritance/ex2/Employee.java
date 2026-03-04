package Task2_Inheritance.ex2;

public class Employee {
    protected String name;
    protected String position;

    // Конструктор
    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    // Вивід інформації
    public void displayInfo() {
        System.out.println("Ім'я: " + name);
        System.out.println("Посада: " + position);
    }
}
class Manager extends Employee {
    private int teamSize;

    public Manager(String name, String position, int teamSize) {
        super(name, position); // виклик конструктора батьківського класу
        this.teamSize = teamSize;
    }

    @Override
    public void displayInfo() {
        super.displayInfo(); // викликаємо метод з Employee
        System.out.println("Розмір команди: " + teamSize);
    }

    public static void main(String[] args) {
        Employee emp = new Manager("Аліса", "Лідер команди", 5);
        emp.displayInfo();
    }
}