package Task1_Encapsulation.ex1;

public class Book {
    // Приватні поля
    private String title;
    private String author;
    private int year;
    // Геттер
    public String getTitle() { return title; }
    public String getAuthor() { return author;}
    public int getYear() { return year;}
    // Сеттер
    public void setTitle(String title) {this.title = title;}
    public void setAuthor(String author) { this.author = author;}
    public void setYear(int year) { this.year = year;}
    // Виведення інформації про книгу
    public void displayInfo(){
        System.out.println("Книга: " + title);
        System.out.println("Автор: " + author);
        System.out.println("Рік: " + year);
    }

    public static void main(String[] args) {
        Book book = new Book();
        book.setTitle("Гаррі Поттер");
        book.setAuthor("Дж. К. Роулінг");
        book.setYear(1997);
        book.displayInfo();
    }
}

