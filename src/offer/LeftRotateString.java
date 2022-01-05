package offer;

public class LeftRotateString {

    public String reverseLeftWords(String s, int n) {
        if (n == 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = n; i < s.length(); i++) {
            sb.append(s.charAt(i));
        }

        for (int i = 0; i < n; i++) {
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        String param1 = "abcdefg";
        String param2 = "lrloseumgh";

        System.out.println(new LeftRotateString().reverseLeftWords(param1, 2));
        System.out.println(new LeftRotateString().reverseLeftWords(param2, 6));
    }

}
