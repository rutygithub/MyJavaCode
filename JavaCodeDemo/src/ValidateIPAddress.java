
public class ValidateIPAddress {
    public static void main(String[] args) {
        //https://leetcode.com/problems/validate-ip-address/discuss/95484/PythonJava-Easy-Understand-Solution
        //这道题目用python写比较好，记住个大概就可以了
        String IP = "172.16.254.1";
    }

    public static String validIPAddress(String IP) {
        //https://leetcode.com/problems/validate-ip-address/discuss/95484/PythonJava-Easy-Understand-Solution
        //这道题目用python写比较好，记住个大概就可以了
        String[] ipv4 = IP.split("\\.", -1);
        String[] ipv6 = IP.split("\\:", -1);
        if (IP.chars().filter(ch -> ch == '.').count() == 3) {
            //find the number of . is 3
            //python has another elegant writing          IP.count(".") == 3
            for (String s : ipv4) {
                if (!isIPv4(s))
                    return "Neither";
            }
            return "IPv4";
        }
        if (IP.chars().filter(ch -> ch == ':').count() == 7) {
            for (String s : ipv6) {
                if (!isIPv6(s))
                    return "Neither";
            }
            return "IPv6";
        }
        return "Neither";
    }

    public static boolean isIPv4(String s) {
        try {
            return String.valueOf(Integer.valueOf(s)).equals(s) && Integer.parseInt(s) >= 0 && Integer.parseInt(s) <= 255;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isIPv6(String s) {
        if (s.length() > 4) return false;
        try {
            return Integer.parseInt(s, 16) >= 0 && s.charAt(0) != '-';
            //int(s, 16) read string s to base-16b integer, it should be positive and not equal to -0
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
