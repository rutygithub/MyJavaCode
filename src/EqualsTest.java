public class EqualsTest {
    public static void main(String[] args) {
        String s = "abc";
        String s1 = "abc";
        System.out.println(s == s1);
        System.out.println(s.equals(s1));
        System.out.println();
        Integer a = new Integer(23);
        Integer b = new Integer(23);
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println();
        Integer c = 24;
        Integer d = 24;
        System.out.println(c == d);
        System.out.println(c.equals(d));
        System.out.println();
        String s2 = new String("gh");
        String s3 = new String("gh");
        System.out.println(s2 == s3);
        System.out.println(s2.equals(s3));
    }
}
