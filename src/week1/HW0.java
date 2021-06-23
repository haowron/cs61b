package week1;

/*
Creative Exercise 1a: Drawing a Triangle
Creative Exercise 1b: DrawTriangle
Exercise 2
Exercise 3
Optional: Exercise 4
 */


public class HW0 {
    static public void main(String[] args) {
        drawTriangle(3);
        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
        int[] numbers2 = new int[]{};
        int[] a = {1, 2, -3, 4, 5, 4};
        int n = 3;
        windowPosSum(a, n);
        System.out.println(java.util.Arrays.toString(a));
        int[] a2 = {1, -1, -1, 10, 5, -1};
        n = 2;
        windowPosSum(a2, n);
        System.out.println(java.util.Arrays.toString(a2));
        System.out.println(max_while(numbers));
        System.out.println(max_for(numbers2));
    }

    // Creative Exercise 1: Drawing a Triangle
    static public void drawTriangle(int n) {
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= i; ++j) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    // Exercise 3
    public static int max_while(int[] m) {
        int ans = 0;
        int l = 0;
        while (l < m.length) {
            ans = Math.max(ans, m[l]);
            ++l;
        }
        return ans;
    }

    // Exercise 3
    public static int max_for(int[] m) {
        int ans = 0;
        for (int value : m) {
            ans = Math.max(ans, value);
        }
        return ans;
    }

    // Exercise 4
    public static void windowPosSum(int[] a, int n) {
        for (int i = 0; i < a.length; ++i) {
            if (a[i] < 0) continue;
            for (int j = i + 1; j < Math.min(a.length, i + n + 1); ++j) {
                a[i] += a[j];
            }
        }
    }
}
