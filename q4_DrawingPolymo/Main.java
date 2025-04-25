package q4_DrawingPolymo;

public class Main {
    public static void main(String[] args) {
        // Create an array of Shape objects
        Shape[] shapes = new Shape[3];

        // Store different shape objects in the array
        shapes[0] = new Circle();
        shapes[1] = new Square();
        shapes[2] = new Triangle();

        // Loop through the array and call the draw method for each shape
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}

