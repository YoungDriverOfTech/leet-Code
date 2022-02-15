package string;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;
        int add = 0;

        StringBuilder result = new StringBuilder();
        while (index1 >= 0 || index2 >= 0 || add > 0) {
            int number1 = index1 >= 0 ? num1.charAt(index1) - '0' : 0;
            int number2 = index2 >= 0 ? num2.charAt(index2) - '0' : 0;

            int currentSum = number1 + number2 + add;
            result.append(currentSum % 10); // 这里记得对10取余数，因为我们是一位一位进行计算的，所以只用把本位加入到结果
            add = currentSum / 10;          // 进位的话留给下一次计算的时候在加进去

            index1--;
            index2--;
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
         new AddStrings().addStrings("11", "123");
    }
}
