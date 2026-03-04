package Task3_Polymorphism.ex2;

public class Notification {
    public void send() {
        System.out.println("Надсилання повідомлення");
    }


    public static class EmailNotification extends Notification {

        @Override
        public void send() {
            System.out.println("Надсилання Email повідомлення ");
        }
    }

    public static class SMSNotification extends Notification {

        @Override
        public void send() {
            System.out.println("Надсилання SMS повідомлення ");
        }
    }


    public static void main(String[] args) {
        Notification email = new EmailNotification();
        Notification sms = new SMSNotification();
        email.send();
        sms.send();

    }

}