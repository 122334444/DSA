package Strings.Easy;

public class rotatedStr {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        if (n != goal.length())
            return false;

        if ((s + s).contains(goal)) {
            return true;
        }
        return false;
    }
}
