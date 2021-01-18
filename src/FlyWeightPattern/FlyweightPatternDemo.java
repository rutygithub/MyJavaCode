package FlyWeightPattern;
//https://www.tutorialspoint.com/design_pattern/flyweight_pattern.htm

public class FlyweightPatternDemo {
    //use hashmap store some objects already exist.
    //drawing 20 circles of different locations but we will create only 5 objects.
    private static final String colors[] = {"Red", "Green", "Blue", "White", "Black"};

    public static void main(String[] args) {

        for (int i = 0; i < 20; ++i) {
            Circle circle = (Circle) ShapeFactory.getCircle(getRandomColor());
            circle.setX(getRandomX());
            circle.setY(getRandomY());
            circle.setRadius(100);
            circle.draw();
        }

        System.out.println();
        System.out.println(ShapeFactory.size());
    }

    private static String getRandomColor() {
        return colors[(int) (Math.random() * colors.length)];
    }

    private static int getRandomX() {
        return (int) (Math.random() * 100);
    }

    private static int getRandomY() {
        return (int) (Math.random() * 100);
    }
}