package googlejam8.p429;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class MainA {

    public static void main(String[] args) {
//        String in = "./sample.in";
//        String out = "./sample.out";
//        String in = "./A-small-attempt0.in";
//        String out = "./A-small-attempt0.out";
        String in = "./A-large.in";
        String out = "./A-large.out";

        try {
            BufferedReader br = new BufferedReader(new FileReader(in));
            FileWriter fw = new FileWriter(out);
            int T = Integer.parseInt(br.readLine());
            for (int i = 0; i < T; i++) {
                System.out.print("Case #" + (i + 1) + ": ");
                fw.write("Case #" + (i + 1) + ": ");
                int N = Integer.parseInt(br.readLine());
                String[] strP = br.readLine().split(" ");
                Map<Character, Integer> P = new HashMap<>();
                int total = 0;
                for (int j = 0; j < N; j++) {
                    P.put((char) ('A' + j), Integer.parseInt(strP[j]));
                    total += Integer.parseInt(strP[j]);
                }
                while (total > 0) {
                    for (int k = 0; k < 2; k++) {
                        for (int j = 0; j < N; j++) {
                            char p = (char) ('A' + j);
                            if (P.get(p) == 0)
                                continue;
                            double offset = ((double) (total - 1) / 2);
                            boolean valid = true;
                            if (k != total) {
                                for (int l = 0; l < N; l++) {
                                    if (l != j) {
                                        char p1 = (char) ('A' + l);
                                        if (P.get(p1) > offset && k == 1) {
                                            valid = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (valid) {
                                System.out.print(p);
                                fw.write(p);
                                total--;
                                P.put(p, P.get(p) - 1);
                                break;
                            }
                        }
                    }
                    System.out.print(' ');
                    fw.write(' ');
                }
                System.out.print("\n");
                fw.write("\n");
            }
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
