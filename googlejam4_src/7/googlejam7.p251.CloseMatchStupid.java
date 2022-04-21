package googlejam7.p251;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Timur on 30.04.2016.
 */
public class CloseMatchStupid {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(in.readLine());
        for (int t=1;t<=test;t++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            String first = st.nextToken();
            String second = st.nextToken();

            int diff = Integer.MAX_VALUE;

            String ans1 = "";
            String ans2 = "";

            for (int i = 0; i < 1000; i++) {

                String a1 = ""+i;
                while (a1.length() < first.length()) {
                    a1 = "0" + a1;
                }

                boolean correct = a1.length() == first.length();
                if (correct)
                for (int k = 0; k < first.length();k++) {
                    if (first.charAt(k) != '?' && first.charAt(k)!=a1.charAt(k)) {
                        correct = false;
                        break;
                    }
                }
                if (correct)
                for (int j = 0; j < 1000; j ++) {

                    if (Math.abs(i - j) < diff || (Math.abs(i - j) == diff && a1.compareTo(ans1)<0)) {

                        String b1 = "" + j;
                        while (b1.length() < first.length()) {
                            b1 = "0" + b1;
                        }


                        correct = b1.length() == first.length();

                        if (correct)
                        for (int k = 0; k < first.length();k++) {
                            if (second.charAt(k) != '?' && second.charAt(k)!=b1.charAt(k)) {
                                correct = false;
                                break;
                            }
                        }
                        if (correct) {
                            diff = Math.abs(i - j);
                            ans1 = a1;
                            ans2 = b1;
                        }

                    }



                }
            }
            System.out.println("Case #"+t+": "+ans1+" "+ans2);
        }

        in.close();
    }
}
