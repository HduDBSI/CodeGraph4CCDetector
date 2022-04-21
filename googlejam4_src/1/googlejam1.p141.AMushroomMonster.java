package googlejam1.p141;


import java.util.Scanner;

public class AMushroomMonster {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int t = 1; t <= cases; t++) {
            int intervals = sc.nextInt();
            int minEaten = 0;
            int minConstant = 0;
            int prevAmount = 0;
            int[] measurements = new int[intervals];
            for (int x = 0; x < intervals; x++) {
                measurements[x] = sc.nextInt();
            }
            for (int amount : measurements) {
                if (amount < prevAmount) {
                    minEaten += prevAmount - amount;
                    minConstant = Math.max(minConstant, prevAmount - amount);
                }
                prevAmount = amount;
            }
            int secondEaten = 0;
            for (int x = 0; x < measurements.length - 1; x++) {
                secondEaten += Math.min(measurements[x], minConstant);
            }
            System.out.printf("Case #%d: %d %d%n", t, minEaten, secondEaten);
        }
        sc.close();
    }
}
