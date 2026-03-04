package Task3_Polymorphism.ex1;

public abstract class Shape {
    public abstract double calculateArea();

public static class Triangle extends Shape {

    private double base;
    private double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return ( base * height) / 2;
    }
}

    public static class Square extends Shape {

        private double side;

        public Square(double side) {
            this.side = side;
        }

        @Override
        public double calculateArea() {
            return side * side;
        }
    }

    public static void main(String[] args) {
        Shape tri = new Triangle(5, 10);
        Shape sq = new Square(4);
        System.out.println("Площа трикутника: " + tri.calculateArea());
        System.out.println("Площа квадрата: " + sq.calculateArea());
    }

}
