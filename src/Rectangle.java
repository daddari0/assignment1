public class Rectangle {
    private double width;
    private double height;
    private int id;
    private static int idGen = 1;

    public Rectangle() {
        this.id = idGen++;
        this.width = 1.0;
        this.height = 1.0;
    }

    public Rectangle(double width, double height) {
        this();
        setwidth(width);
        setheight(height);
    }

    public double getwidth() {
        return width;
    }

    public double getheight() {
        return height;
    }

    public int getId() {
        return id;
    }

    public void setwidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width must be > 0");
        }
        this.width = width;
    }

    public void setheight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height must be > 0");
        }
        this.height = height;
    }

    public double area() {
        return width * height;
    }

    public double perimeter() {
        return 2 * (width + height);
    }

    public String tostring() {
        return "Rectangle{id=" + id +
                ", width=" + width +
                ", height=" + height + "}";
    }
}
