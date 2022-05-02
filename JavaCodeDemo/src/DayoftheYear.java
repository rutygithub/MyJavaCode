import java.time.Year;

public class DayoftheYear {
    public int dayOfYear(String S) {
        //https://leetcode.com/problems/day-of-the-year/discuss/355880/Simple-Java-Solution-easy-to-understand-GregorianCalendar
        String[] s = S.split("-");
        int year = Integer.parseInt(s[0]);
        int month = Integer.parseInt(s[1]);
        int date = Integer.parseInt(s[2]);
        boolean isLeap = checkYear(year);
        int noOfDays = 0;
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < month - 1; i++) {
            if (isLeap && i == 1) {
                //lead year and the month is Feb, it becomes 29 days in Feb in Leap Year
                noOfDays += days[i] + 1;
            } else {
                noOfDays += days[i];
            }
        }
        return noOfDays + date;
    }

    boolean checkYear(int year) {
        if (year % 400 == 0)
            return true;
        if (year % 100 == 0)
            return false;
        if (year % 4 == 0)
            return true;
        return false;
    }
}
