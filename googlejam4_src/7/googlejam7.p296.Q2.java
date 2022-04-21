package googlejam7.p296;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Q2 {

    public static String solve(String C, String J) {

        int len = C.length();

        char[] cs = C.toCharArray();
        char[] js = J.toCharArray();

        List<String> cres = new ArrayList<>();
        List<String> jres = new ArrayList<>();
        cres.add("");
        jres.add("");

        for (int i = 0; i < len; i++) {
            if (cs[i] == '?' && js[i] == '?') {
                List<String> r = new ArrayList<>();
				for (String s : cres) {
				    for (char c : new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'}) {
				        r.add(s + c);
				    }
				}
				cres = r;
				List<String> r = new ArrayList<>();
				for (String s : jres) {
				    for (char c : new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'}) {
				        r.add(s + c);
				    }
				}
                jres = r;
            } else if (cs[i] == '?') {
                List<String> r = new ArrayList<>();
				for (String s : cres) {
				    for (char c : new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'}) {
				        r.add(s + c);
				    }
				}
				cres = r;
				List<String> r = new ArrayList<>();
				for (String s : jres) {
				    for (char c : new char[]{js[i]}) {
				        r.add(s + c);
				    }
				}
                jres = r;
            } else if (js[i] == '?') {
                List<String> r = new ArrayList<>();
				for (String s : cres) {
				    for (char c : new char[]{cs[i]}) {
				        r.add(s + c);
				    }
				}
				cres = r;
				List<String> r = new ArrayList<>();
				for (String s : jres) {
				    for (char c : new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'}) {
				        r.add(s + c);
				    }
				}
                jres = r;
            } else {
                List<String> r = new ArrayList<>();
				for (String s : cres) {
				    for (char c : new char[]{cs[i]}) {
				        r.add(s + c);
				    }
				}
				cres = r;
				List<String> r = new ArrayList<>();
				for (String s : jres) {
				    for (char c : new char[]{js[i]}) {
				        r.add(s + c);
				    }
				}
                jres = r;
            }
        }

        long min = Long.MAX_VALUE;
        String a = "";
        String b = "";
        for (String cre : cres) {
            for (String jre : jres) {
                long m = Long.parseLong(cre);
                long n = Long.parseLong(jre);
                long diff = Math.abs(m - n);
                if (min > diff) {
                    min = diff;
                    a = cre;
                    b = jre;
                }
            }
        }

        return String.valueOf(a) + " " + String.valueOf(b);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String c = in.next();
            String j = in.next();
            System.out.println("Case #" + i + ": " + solve(c, j));
        }
    }
}
