package offer;

public class ReverseWords {

    // my solution, use StringBuilder
    public String reverseWords(String s) {
        s = s.trim();
        String[] sArr = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for(int i = sArr.length -1; i >= 0; i--) {
            if (sArr[i].equals("")) {
                continue;
            }

            sb.append(sArr[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    // double pointer
    public String reverseWords_1(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        int j = s.length() - 1, i = j;

        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            sb.append(s, i + 1, j + 1).append(" ");

            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWords().reverseWords("a good   example"));
    }
}
