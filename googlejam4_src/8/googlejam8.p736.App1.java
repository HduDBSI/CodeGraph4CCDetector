package googlejam8.p736;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

public class App1 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
//        System.out.println("t: " + t);

        for (int i = 1; i <= t; ++i) {
            int parties = in.nextInt();
//            System.out.println("parties: " + parties);
            String s = in.nextLine();
            s = in.nextLine();
//            System.out.println("line: " + s);
            String values[] = s.trim().split(" ");
//            System.out.println(Arrays.toString(values));

            List<Integer> p = new ArrayList<Integer>(parties);

            for (int z = 0; z < parties; ++z) {
                p.add(z, Integer.parseInt(values[z]));

            }

            StringBuffer sb = new StringBuffer("");

            int max1 = 0;
            int max2 = 0;
            do {
                sb.append(" ");

                max1 = Collections.max(p);
                if(max1>0) {
                    int index1 = p.indexOf(max1);
                    p.set(index1, max1 - 1);
                    sb.append((char) ('A' + index1));
                }

                if (max1 == 1) { //last step, count number of 1s
                    int numOfones = 0;
                    for (int z = 0; z < p.size(); ++z) {
                        if (p.get(z) == 1) {
                            ++numOfones;
                        }
                    }
                    if (numOfones > 1 && numOfones % 2 != 1) {
//                        int sum = 0;
//                        for (int h = 0 ; h < p.size(); ++h ) {
//                            sum += p.get(h);
//                        }
//                        if (sum > 0) {
//
//                            for (int h = 0 ; h < p.size(); ++h ) {
//                                if(p.get(h)/sum > 0.5) {
//                                    System.out.println("WARNING");
//                                }
//                                System.out.println("r:" + (p.get(h)/sum));
//                                System.out.println("" + p.toString());
//                            }
//                        }
                        continue;
                    }
                }

                max2 = Collections.max(p);
                if (max2 > 0) {
                    int index2 = p.indexOf(max2);
                    p.set(index2, max2 - 1);
                    sb.append((char) ('A' + index2));
                }

//                int sum = 0;
//                for (int h = 0 ; h < p.size(); ++h ) {
//                    sum += p.get(h);
//                }
//                if (sum > 0) {
//
//                    for (int h = 0 ; h < p.size(); ++h ) {
//                        if(p.get(h)/sum > 0.5) {
//                            System.out.println("WARNING");
//                        }
//                        System.out.println("r:" + (p.get(h)/sum));
//                        System.out.println("" + p.toString());
//                    }
//                }

//                System.out.println("max1" + max1 + " max2 " + max2);
            } while(max1 != 0 || max2 != 0);

//            System.out.println("line" + n);

            System.out.println("Case #" + i + ":" + sb.toString());
        }

    }
}
