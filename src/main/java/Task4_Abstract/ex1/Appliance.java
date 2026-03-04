package Task4_Abstract.ex1;

public abstract class Appliance {
    // Абстрактний метод
    public abstract void turnOn();


   static class WashingMachine extends Appliance {
        @Override
        public void turnOn() {
            System.out.println("Пральна машина ввімкнена");
        }
    }

    static class Microwave extends Appliance {
        @Override
        public void turnOn() {
            System.out.println("Мікрохвильова піч ввімкнена ");
        }
    }

    public static void main(String[] args) {
        Appliance wm = new WashingMachine();
        Appliance mw = new Microwave();
        wm.turnOn();
        mw.turnOn();
    }
}

