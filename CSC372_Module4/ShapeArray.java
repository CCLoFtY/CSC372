public class ShapeArray {

    public static void main(String[] args) {

        // Instantiate one of each shape
        Sphere sphere = new Sphere(3.0);
        Cylinder cylinder = new Cylinder(2.0, 5.0);
        Cone cone = new Cone(2.5, 4.0);

        // Store them in an array of Shape
        Shape[] shapeArray = new Shape[3];
        shapeArray[0] = sphere;
        shapeArray[1] = cylinder;
        shapeArray[2] = cone;

        // Loop through and print each shape's data via toString()
        for (Shape shape : shapeArray) {
            System.out.println(shape.toString());
            System.out.println("-------------------------");
        }
    }
}
