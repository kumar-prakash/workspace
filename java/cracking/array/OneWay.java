package array;

public class OneWay {

    public static boolean isOneEditAway(String str1, String str2) {
        if(str1 == null || str2 == null) {
            return false;
        }
        if (Math.abs(str1.length() - str2.length()) > 1) {
            return false;
        }

        boolean isEdited = false;
        int i = 0, j = 0;
        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            } else if (isEdited) {
                return false;
            } else {
                isEdited = true;
                if (str1.length() > str2.length()) {
                    i++;
                } else if (str2.length() > str1.length()) {
                    j++;
                } else {
                    i++;
                    j++;
                }
            }
        }
        return true;
    }


    public static void test1 () {
        System.out.println(isOneEditAway("pale", "ple"));
        System.out.println(isOneEditAway("pales", "pale"));
        System.out.println(isOneEditAway("pale", "bale"));
        System.out.println(isOneEditAway("pale", "bake"));
    }

    public static void main(String... s) {
        test1();
    }
}