public class StringCompression {
    public static void main(String[] args) {
        String s = "aaabbccccdde";
        System.out.println(compress(s));
    }

    private static String compress(String s) {
        StringBuffer sb = new StringBuffer();
        int count = 1;// 计算至少是1
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {// i跟i-1进行比较
                count++;
            } else {
                sb.append(s.charAt(i - 1));
                sb.append(count);
                count = 1;// 三步走
            }
        }
        sb.append(s.charAt(s.length() - 1));
        sb.append(count);
        // don't forget the last char and last count
        return sb.toString();
    }
}
