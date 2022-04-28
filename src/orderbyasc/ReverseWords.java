package orderbyasc;

public class ReverseWords {
    public String reverseWords(String s) {
        s = s.trim();

        String[] arr = s.split(" ");
        String res = "";
        for (int i = arr.length - 1; i >= 0; i--) {
            if ("".equals(arr[i])) {
                res += arr[i];
            } else {
                res += arr[i] + " ";
            }
        }
        return res.trim();
    }

    public static void main(String[] args) {
        new ReverseWords().reverseWords("a good   example");
    }
}
