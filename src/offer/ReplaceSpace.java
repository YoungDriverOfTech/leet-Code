package offer;

public class ReplaceSpace {

    public String replaceSpace_1(String s) {
        String[] strArr = s.split("");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            String letter = strArr[i];
            if (letter.equals(" ")) {
                result.append("%20");
            } else {
                result.append(letter);
            }
        }
        return result.toString();
    }

    public String replaceSpace_2(String s) {
        return s.replace(" ", "%20");
    }

    public String replaceSpace_3(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (" ".equals(String.valueOf(aChar))) {
                sb.append("%20");
            } else {
                sb.append(aChar);
            }
        }
       return sb.toString();
    }


    public static void main(String[] args) {

        String param= "We are happy.";
        System.out.println(new ReplaceSpace().replaceSpace_3(param));
    }
}
