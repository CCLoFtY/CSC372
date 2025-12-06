public class Cone extends Shape {

    private double radius;
    private double height;

    // Parameterized constructor
    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double surface_area() {
        // Surface area of cone: πr(r + √(r^2 + h^2))
        double slantHeight = Math.sqrt(radius * radius + height * height);
        return Math.PI * radius * (radius + slantHeight);
    }

    @Override
    public double volume() {
        // Volume of cone: (1/3)πr^2h
        return (1.0 / 3.0) * Math.PI * radius * radius * height;
    }

    @Override
    public String toString() {
        return String.format(
            "Cone (radius=%.2f, height=%.2f)\nSurface Area: %.4f\nVolume: %.4f",
            radius, height, surface_area(), volume()
        );
    }
}