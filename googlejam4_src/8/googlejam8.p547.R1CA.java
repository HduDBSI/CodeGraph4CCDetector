package googlejam8.p547;


import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class R1CA {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(System.in);
        PrintWriter writer = new PrintWriter("out.txt");
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            Map<Integer, Integer> c = new HashMap<>();
            for (int j = 0; j < N; j++) {
                c.put(j, sc.nextInt());
            }
            StringBuilder sb = new StringBuilder();
            while (true) {
                int m1 = -1, m2 = -1;
                int m1v = 0, m2v = 0;

                for (Map.Entry<Integer, Integer> entry : c.entrySet()) {
                    if (entry.getValue() > m1v) {
                        if (c.containsKey(m2)) {
                            c.put(m2, c.get(m2) + 1);
                        }
                        m2v = m1v;
                        m2 = m1;
                        m1v = entry.getValue();
                        m1 = entry.getKey();
                        entry.setValue(entry.getValue() - 1);
                    } else if (entry.getValue() > m2v) {
                        if (c.containsKey(m2)) {
                            c.put(m2, c.get(m2) + 1);
                        }
                        m2 = entry.getKey();
                        m2v = entry.getKey();
                        entry.setValue(entry.getValue() - 1);
                    }


                }
                if (c.containsKey(m2) && c.containsKey(m1)) {
                    int c1 = c.get(m1);
                    int c2 = c.get(m2);
                    if (c1 > c2) {
                        c.put(m2, c.get(m2) + 1);
                        m2 = m1;
                        m2v = m1v;
                        c.put(m1, c.get(m1) - 1);
                    }
                }
                if (c.containsKey(m1)) {
                    sb.append((char) ('A' + m1));
                }
                if (c.containsKey(m2)) {
                    sb.append((char) ('A' + m2));
                }
                sb.append(" ");
                boolean cont = false;
                for (Map.Entry<Integer, Integer> entry : c.entrySet()) {
                    if (entry.getValue() > 0) {
                        cont = true;
                        break;
                    }
                }
                if (!cont) {
                    break;
                }


            }

            String re = sb.toString();
            String[] sp = re.split(" ");
            if (sp.length >1 && sp[sp.length - 1].length() < 2) {
                String aa = sp[sp.length - 1];
                sp[sp.length - 1] = sp[sp.length - 2];
                sp[sp.length - 2] = aa;
                sb = new StringBuilder();
                for (String s : sp) {
                    sb.append(s).append(" ");
                }

            }

            writer.println("Case #" + (i + 1) + ": " + sb.toString());
        }
        writer.flush();
        writer.close();
    }

}
