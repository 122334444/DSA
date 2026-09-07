package Strings.Easy;

public class reverseWords {
    public String reverseWords(String s) {
        String arr[] = s.trim().split("\\s+");
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            String t = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = t;
        }
        String res = String.join(" ", arr);
        return res;
    }
}
