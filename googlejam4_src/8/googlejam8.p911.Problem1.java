package googlejam8.p911;


import java.util.*;

public class Problem1 {

    private static boolean debug = false;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int _t = 1; _t <= t; _t++) {

            int n = sc.nextInt(); sc.nextLine();
            int[] p = new int[n];
            int total = 0;
            char ich = 'A';
            int max = -1;
            char[] labels = new char[n];
            for (int i=0; i < n; i++) {
                p[i] = sc.nextInt();
                total += p[i];
                labels[i] = ich;
                ich++;
                if (p[i] > max) {
                    max = p[i];
                }
            }
			StringBuilder sb = new StringBuilder();
			        Stack<Character> s = new Stack<>();
			
			        while (s.size() != total) {
			
			            for (int i=0; i<n; i++) {
			
			                if (p[i] > 0) {
			                    sb.append(labels[i]);
			                    s.push(labels[i]);
			                    p[i]--;
			                }
			            }
			        }
			
			        if (debug) {
					    System.out.println("sb: "+sb);
					}
			        if (debug) {
					    System.out.println("s: "+s);
					}
			/*
			
			        StringBuilder sb2 = new StringBuilder();
			        for (int j=0; j<sb.length(); j++) {
			            sb2.append(sb.charAt(j));
			
			            if (sb.length()%2 == 0) {
			                if (j%2==1) {
			                    sb2.append(" ");
			                }
			            } else {
			
			                if (j == sb.length()-3) {
			                    sb2.append(sb.charAt(sb.length()-1));
			                    sb2.append(" ");
			                    sb2.append(sb.charAt(sb.length()-3));
			                    sb2.append(sb.charAt(sb.length()-2));
			                    break;
			                } else {
			                    if (j%2==1) {
			                        sb2.append(" ");
			                    }
			                }
			            }
			
			        }
			*/
			
			        StringBuilder sb3 = new StringBuilder();
			        while(!s.empty()) {
			            if (s.size() == 3) {
			                char c1 = s.pop(), c2 = s.pop(), c3 = s.pop();
			                sb3.append(c3);
			                sb3.append(' ');
			                sb3.append(c2);
			                sb3.append(c1);
			                sb3.append(' ');
			            } else {
			                char c1 = s.pop(), c2 = s.pop();
			                sb3.append(c2);
			                sb3.append(c1);
			                sb3.append(' ');
			            }
			        }

            String result = sb3.toString();
            System.out.printf("Case #%d: %s%n", _t, result);
        }
    }
}