package googlejam8.p986;
import java.util.*;
public class GoogleCodeJamProblem {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[] num = new int[n];
            int total = 0;
            for (int j = 0; j < n; j++) {
                num[j] = in.nextInt();
                total += num[j];
            }
            String[] alph = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
                "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
            String evacuation = "";
            if (n == 2) {
                if (total == 2) {
                    evacuation = "AB";
                } else if (total == 4) {
                    evacuation = "AB AB";
                } else if (total == 6) {
                    evacuation = "AB AB AB";
                } else if (total == 8) {
                    evacuation = "AB AB AB AB";
                }
            } else {
                if (num[0] == 1 && num[1] == 1 && num[2] == 1) {
                    evacuation = "A BC";
                } else {
                    int a = num[0];
                    int b = num[1];
                    int c = num[2];
                    // <editor-fold>
                    if (a == 4 || b == 4 || c == 4) {
                        if (a == 4) {
                            num[0] = 3;
                            evacuation += "A";
                        }
                        if (b == 4) {
                            num[1] = 3;
                            evacuation += "B";
                        }
                        if (c == 4) {
                            num[2] = 3;
                            evacuation += "C";
                        }
                        evacuation += " ";
                    }
                    // </editor-fold>
                    a = num[0];
                    b = num[1];
                    c = num[2];
                    // <editor-fold>
                    if (a == 3 || b == 3 || c == 3) {
                        if (a == 3 && b == 3 && c == 3) {
                            evacuation = "A BC A BC A BC";
                            num[0] = 0;
                            num[1] = 0;
                            num[2] = 0;
                        } else {
                            if (a == 3) {
                                evacuation += "A";
                                num[0] = 2;
                            }
                            if (b == 3) {
                                evacuation += "B";
                                num[1] = 2;
                            }
                            if (c == 3) {
                                evacuation += "C";
                                num[2] = 2;
                            }
                            evacuation += " ";
                        }
                    }
                    // </editor-fold>
                    a = num[0];
                    b = num[1];
                    c = num[2];
                    // <editor-fold>
                    if (a == 2 || b == 2 || c == 2) {
                        if (a == 2 && b == 2 && c == 2) {
                            evacuation += "A BC A BC";
                            num[0] = 0;
                            num[1] = 0;
                            num[2] = 0;
                        } else {
                            if (a == 2) {
                                num[0] = 1;
                                evacuation += "A";
                            }
                            if (b == 2) {
                                num[1] = 1;
                                evacuation += "B";
                            }
                            if (c == 2) {
                                num[2] = 1;
                                evacuation += "C";
                            }
                            evacuation += " ";
                            evacuation += "A BC";
                        }
                    }
                    // </editor-fold>
                }
            }
            System.out.println("Case #" + (i + 1) + ": " + evacuation);
        }
    }
    
}
