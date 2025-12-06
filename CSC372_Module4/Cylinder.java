public class Cylinder extends Shape {

    private double radius;
    private double height;

    // Parameterized constructor
    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double surface_area() {
        // Surface area of cylinder: 2πr^2 + 2πrh
        return 2 * Math.PI * radius * radius + 2 * Math.PI * radius * height;
    }

    @Override
    public double volume() {
        // Volume of cylinder: πr^2h
        return Math.PI * radius * radius * height;
    }

    @Override
    public String toString() {
        return String.format(
            "Cylinder (radius=%.2f, height=%.2f)\nSurface Area: %.4f\nVolume: %.4f",
            radius, height, surface_area(), volume()
        );
    }
}
