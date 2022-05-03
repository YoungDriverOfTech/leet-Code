package string;

public class AddBinary {

    public String addBinary(String a, String b) {
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int add = 0;

        StringBuilder sb = new StringBuilder();
        int sum = 0;
        while (indexA >= 0 || indexB >= 0 || add != 0) {
            int number1 = indexA >= 0 ? a.charAt(indexA) - '0': 0;
            int number2 = indexB >= 0 ? b.charAt(indexB) - '0' : 0;

            sum = number1 + number2 + add;

            sb.append(sum % 2);
            add = sum / 2;

            indexA--;
            indexB--;
        }

        return sb.reverse().toString();
    }

    public String addBinary_1(String a, String b) {
        if ("0".equals(a) && "0".equals(b)) {
            return "0";
        }

        int aLength = a.length();
        int bLength = b.length();

        // padding 0 if length is different
        if (aLength - bLength > 0) {
            b = getBlank(aLength - bLength) + b;
        } else if (aLength - bLength < 0) {
            a = getBlank(bLength - aLength) + a;
        }

        char temp = '0';
        StringBuilder sb = new StringBuilder();
        for (int i = a.length() - 1; i >= 0 ; i--) {
            char aChar = a.charAt(i);
            char bChar = b.charAt(i);

            // 没有进位的情况下
            if (temp == '0') {
                if (aChar == '1' && bChar == '1') {
                    sb.append("0");
                    temp = '1';
                } else if (aChar == '0' && bChar == '0') {
                    sb.append("0");
                } else {
                    sb.append("1");
                }
            } else {
                // 有进位的情况下
                if (aChar == '1' && bChar == '1') {
                    sb.append("1");
                    temp = '1';
                } else if (aChar == '0' && bChar == '0') {
                    sb.append("1");
                    temp = '0';
                } else {
                    sb.append("0");
                    temp = '1';
                }
            }
        }

        // no need append temp if it's 0
        if (temp != '0') {
            sb.append(temp);
        }
        return sb.reverse().toString();
    }

    private String getBlank(int length) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append("0");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("11", "1"));
    }
}
