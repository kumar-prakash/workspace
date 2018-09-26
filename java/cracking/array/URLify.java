package array;

public class URLify {
    public static int countSpaces(char [] arr, int length) {
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i] == ' ') {
                count++;
            }
        }
        return count;
    }

    public static void removeSpace(char [] arr, int length) {
        int count = countSpaces(arr, length);
        int lastChar = 0;
        for (int i = length - 1; i >= 0; i--) {
            if (arr[i] != ' ') {
                lastChar = (count * 2) + i;
                arr[lastChar] = arr[i];
            } else {
                arr[--lastChar] = '0';
                arr[--lastChar] = '2';
                arr[--lastChar] = '%';
                count--;
            }
        }
    }

    public static void test() {
        char [] arr = " mr john  smith        ".toCharArray();
        removeSpace(arr, 15);
        printArr(arr, 23);
    }

    public static void printArr(char [] arr, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(((char)arr[i]));
        }
        System.out.print("\n");
    }

    public static void main(String... s) {
        test();
    }
}