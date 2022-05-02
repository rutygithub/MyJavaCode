public class InstanceofTest {
    public static void main(String[] args) {
        String s = "abc";
        int[] a = {4, 5, 6};
        if (s instanceof String)
            System.out.println("s is string.");
        if (a instanceof int[])
            System.out.println("a is int array.");
    }
}