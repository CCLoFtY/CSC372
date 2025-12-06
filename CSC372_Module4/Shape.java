public abstract class Shape {

    // Abstract methods
    public abstract double surface_area();

    public abstract double volume();

    @Override
    public String toString() {
        // Default implementation (can be overridden)
        return "Surface Area: " + surface_area() + ", Volume: " + volume();
    }
}