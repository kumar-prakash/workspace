package comp;

import java.util.*;

public class ParkingAllotement {
    private class Rectangle {
        int x1;
        int y1;
        int x2;
        int y2;

        Rectangle(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }
    }

    private static Rectangle findOverlappingRegion(Rectangle rect1, Rectangle rect2) {
        if(rect1.x1 == rect2.x2) {

        } else if(rect1.x1 > rect2.x2) {
            Rectangle temp = rect1;
            rect1 = rect2;
            rect2 = rect1;

            int x1 = 0; 
            int y1 = 0;
            int x2 = 0;
            int y2 = 0;
            if(rect1.x1 < rect2.x1 && rect2.x1 < rect1.x2) {
                if(rect1.y1 > rect2.y2 || rect1.y2 < rect2.y1) {
                    return null;
                }
                if(rect1.y1 < rect2.y2) {
                    
                }
            }   
        }
        return null; 
    }

    public static int calculateTotalMoney(Rectangle [] data) {
        int total = 0;

        return total;
    }
    public static void main(String... s) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Rectangle []arr = new Rectangle[n];
        for(int i = 0; i < n; i++) {
            arr[i] = new Ractangle(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        System.out.println(calculateTotalMoney(arr));
    }
}