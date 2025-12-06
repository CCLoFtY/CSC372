public class Sphere extends Shape {

    private double radius;

    // Parameterized constructor
    public Sphere(double radius) {
        this.radius = radius;
    }

    @Override
    public double surface_area() {
        // Surface area of sphere: 4 * π * r^2
        return 4 * Math.PI * radius * radius;
    }

    @Override
    public double volume() {
        // Volume of sphere: (4/3) * π * r^3
        return (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }

    @Override
    public String toString() {
        return String.format(
            "Sphere (radius=%.2f)\nSurface Area: %.4f\nVolume: %.4f",
            radius, surface_area(), volume()
        );
    }
}