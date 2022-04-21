package googlejam3.p283;
	
import java.io.*;
import java.util.*;
import static java.util.Arrays.*;

public class AL {
    static final boolean _PRACTICE = !true;
    static final boolean _SAMPLE = !true;
    static final boolean _SMALL = !true;
    static final String _PROBLEM = "A";

    public static void main(String... args) throws IOException {
        if (!_SAMPLE) {
            if (_SMALL) {
                int i = 0;
                while (new File(_PROBLEM + "-small"
				+ (_PRACTICE ? i == 0 ? "-practice" : "" : "-attempt" + i) + ".in").exists())
                    i++;
                i--;
                boolean test = false;
                if (new File(_PROBLEM + "-small"
				+ (_PRACTICE ? i == 0 ? "-practice" : "" : "-attempt" + i) + ".out").exists()) {
                    System.err.println("overwrite?(y/n)");
                    char c = (char) System.in.read();
                    test = c != 'y';
                }
                if (test) {
                    System.setIn(new FileInputStream(_PROBLEM + "-small"
					+ (_PRACTICE ? i == 0 ? "-practice" : "" : "-attempt" + i) + ".in"));
                    System.setOut(new PrintStream(_PROBLEM + "-small-test.out"));
					AL r = new AL();
                    Scanner sc = new Scanner(System.in);
					int testCase = sc.nextInt();
					
					for (int k = 1; k <= testCase; k++) {
					    System.out.printf("Case #%d: ", k);
					    System.err.printf("Case #%d: ", k);
					
					    int r1 = sc.nextInt();
					    int c = sc.nextInt();
					    int w = sc.nextInt();
					    
					    int count = (c / w) * r1;
					    count += (w - 1);
					    if (c % w != 0) {
					    	count++;
					    }
					    
					    System.out.println(count);
					    System.err.println(count);
					    
					}
					sc.close();
                    FileReader f1 = new FileReader(_PROBLEM + "-small-test.out");
                    FileReader f2 = new FileReader(_PROBLEM + "-small"
					+ (_PRACTICE ? i == 0 ? "-practice" : "" : "-attempt" + i) + ".out");
                    BufferedReader br1 = new BufferedReader(f1);
                    BufferedReader br2 = new BufferedReader(f2);
                    for (int j = 1;; j++) {
                        String s1 = br1.readLine();
                        String s2 = br2.readLine();
                        if (s1 == null && s2 == null) {
                            System.err.println("OK!");
                            break;
                        }
                        if (s1 == null || s2 == null || !s1.equals(s2)) {
                            System.err.println("failed at line " + j);
                            System.err.println("expected " + s2);
                            System.err.println("but " + s1);
                            break;
                        }
                    }
                    br1.close();
                    br2.close();
                } else {
                    System.setIn(new FileInputStream(_PROBLEM + "-small"
					+ (_PRACTICE ? i == 0 ? "-practice" : "" : "-attempt" + i) + ".in"));
                    System.setOut(new PrintStream(_PROBLEM + "-small"
					+ (_PRACTICE ? i == 0 ? "-practice" : "" : "-attempt" + i) + ".out"));
					AL r = new AL();
                    Scanner sc = new Scanner(System.in);
					int testCase = sc.nextInt();
					
					for (int k = 1; k <= testCase; k++) {
					    System.out.printf("Case #%d: ", k);
					    System.err.printf("Case #%d: ", k);
					
					    int r1 = sc.nextInt();
					    int c = sc.nextInt();
					    int w = sc.nextInt();
					    
					    int count = (c / w) * r1;
					    count += (w - 1);
					    if (c % w != 0) {
					    	count++;
					    }
					    
					    System.out.println(count);
					    System.err.println(count);
					    
					}
					sc.close();
                }
            } else {
                System.setIn(new FileInputStream(_PROBLEM + "-large" + (_PRACTICE ? "-practice" : "") + ".in"));
                System.setOut(new PrintStream(_PROBLEM + "-large" + (_PRACTICE ? "-practice" : "") + ".out"));
				AL r = new AL();
                Scanner sc = new Scanner(System.in);
				int testCase = sc.nextInt();
				
				for (int k = 1; k <= testCase; k++) {
				    System.out.printf("Case #%d: ", k);
				    System.err.printf("Case #%d: ", k);
				
				    int r1 = sc.nextInt();
				    int c = sc.nextInt();
				    int w = sc.nextInt();
				    
				    int count = (c / w) * r1;
				    count += (w - 1);
				    if (c % w != 0) {
				    	count++;
				    }
				    
				    System.out.println(count);
				    System.err.println(count);
				    
				}
				sc.close();
            }
        } else {
			AL r = new AL();
			Scanner sc = new Scanner(System.in);
			int testCase = sc.nextInt();
			
			for (int k = 1; k <= testCase; k++) {
			    System.out.printf("Case #%d: ", k);
			    System.err.printf("Case #%d: ", k);
			
			    int r1 = sc.nextInt();
			    int c = sc.nextInt();
			    int w = sc.nextInt();
			    
			    int count = (c / w) * r1;
			    count += (w - 1);
			    if (c % w != 0) {
			    	count++;
			    }
			    
			    System.out.println(count);
			    System.err.println(count);
			    
			}
			sc.close();
		}
    }
}
