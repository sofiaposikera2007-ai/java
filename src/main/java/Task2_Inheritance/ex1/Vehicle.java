package Task2_Inheritance.ex1;

public class Vehicle {
    //Поля
    protected String make;
    protected String model;

    // Конструктор
    public Vehicle(String make, String model) {
        this.make = make;
        this.model = model;
    }

    // Вивід інформації
    public void displayInfo() {
        System.out.println("Марка: " + make);
        System.out.println("Модель: " + model);
    }
}
    // Підклас Motorcycle
    class Motorcycle extends Vehicle {
        private int engineCapacity; // обʼєм двигуна

        // Конструктор
        public Motorcycle(String make, String model, int engineCapacity) {
            super(make, model); // виклик конструктора батьківського класу
            this.engineCapacity = engineCapacity;
        }


        // Перевизначення методу
        @Override
        public void displayInfo() {
            super.displayInfo(); // виклик методу з Vehicle
            System.out.println("Обʼєм двигуна: " + engineCapacity + " см³");
        }

        public static void main(String[] args) {
            Vehicle moto = new Motorcycle("Yamaha", "R1", 1000);
            moto.displayInfo();
        }
    }







