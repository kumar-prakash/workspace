package array;

public class StringCompression {
    public static String compress(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        } 
        int maxCount = 1;
        int count = 1;
        char lastChar = str.charAt(0);
        char currentChar;
        String out = "";
        for (int i = 1; i < str.length(); i++) {
            currentChar = str.charAt(i);
            if (currentChar == lastChar) {
                count++;
                if (maxCount < count) {
                    maxCount = count;
                }
            } else {
                out += Character.toString(lastChar) + count;
                count = 1;
            }
            lastChar = currentChar;
        }

        out += Character.toString(lastChar) + count;
        if (count > maxCount) {
            maxCount = count;
        }

        if (maxCount > 1) {
            return out;
        }
        return str;
    }

    public static void test1() {
        System.out.println(compress("aabbcccccaaa"));
        System.out.println(compress("a"));
        System.out.println(compress(null));
        System.out.println(compress("aaa"));
        System.out.println(compress("abcd"));
    }

    public static void main(String... s) {
        test1();
    }
}