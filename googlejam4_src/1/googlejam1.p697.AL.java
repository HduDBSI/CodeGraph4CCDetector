package googlejam1.p697;
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
					
					    int n = sc.nextInt();
					    
					    int[] mush = new int[n];
					    for (int i1 = 0; i1 < n; i1++) {
					    	mush[i1] = sc.nextInt();
					    }
					    
					    int first = 0;
					    int second = 0;
					    
					    for (int i4 = 0; i4 < n - 1; i4++) {
					    	int diff = mush[i4] - mush[i4 + 1];
					    	if (diff > 0) {
					    		first += diff;
					    	}
					    }
					    
					    int[] diff = new int[n - 1];
					    for (int i3 = 0; i3 < n - 1; i3++) {
					    	diff[i3] = mush[i3] - mush[i3 + 1];
					    }
					    int max = 0;
					    for (int i5 = 0; i5 < n - 1; i5++) {
					    	max = Math.max(max, diff[i5]);
					    }
					
					    for (int i2 = 0; i2 < n - 1; i2++) {
					    	second += Math.min(max, mush[i2]);
					    }
					    
					    System.out.printf("%d %d", first, second);
					    System.err.printf("%d %d", first, second);
					    
					    System.out.println();
					    System.err.println();
					    
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
					
					    int n = sc.nextInt();
					    
					    int[] mush = new int[n];
					    for (int i1 = 0; i1 < n; i1++) {
					    	mush[i1] = sc.nextInt();
					    }
					    
					    int first = 0;
					    int second = 0;
					    
					    for (int i4 = 0; i4 < n - 1; i4++) {
					    	int diff = mush[i4] - mush[i4 + 1];
					    	if (diff > 0) {
					    		first += diff;
					    	}
					    }
					    
					    int[] diff = new int[n - 1];
					    for (int i3 = 0; i3 < n - 1; i3++) {
					    	diff[i3] = mush[i3] - mush[i3 + 1];
					    }
					    int max = 0;
					    for (int i5 = 0; i5 < n - 1; i5++) {
					    	max = Math.max(max, diff[i5]);
					    }
					
					    for (int i2 = 0; i2 < n - 1; i2++) {
					    	second += Math.min(max, mush[i2]);
					    }
					    
					    System.out.printf("%d %d", first, second);
					    System.err.printf("%d %d", first, second);
					    
					    System.out.println();
					    System.err.println();
					    
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
				
				    int n = sc.nextInt();
				    
				    int[] mush = new int[n];
				    for (int i = 0; i < n; i++) {
				    	mush[i] = sc.nextInt();
				    }
				    
				    int first = 0;
				    int second = 0;
				    
				    for (int i = 0; i < n - 1; i++) {
				    	int diff = mush[i] - mush[i + 1];
				    	if (diff > 0) {
				    		first += diff;
				    	}
				    }
				    
				    int[] diff = new int[n - 1];
				    for (int i = 0; i < n - 1; i++) {
				    	diff[i] = mush[i] - mush[i + 1];
				    }
				    int max = 0;
				    for (int i = 0; i < n - 1; i++) {
				    	max = Math.max(max, diff[i]);
				    }
				
				    for (int i = 0; i < n - 1; i++) {
				    	second += Math.min(max, mush[i]);
				    }
				    
				    System.out.printf("%d %d", first, second);
				    System.err.printf("%d %d", first, second);
				    
				    System.out.println();
				    System.err.println();
				    
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
			
			    int n = sc.nextInt();
			    
			    int[] mush = new int[n];
			    for (int i = 0; i < n; i++) {
			    	mush[i] = sc.nextInt();
			    }
			    
			    int first = 0;
			    int second = 0;
			    
			    for (int i = 0; i < n - 1; i++) {
			    	int diff = mush[i] - mush[i + 1];
			    	if (diff > 0) {
			    		first += diff;
			    	}
			    }
			    
			    int[] diff = new int[n - 1];
			    for (int i = 0; i < n - 1; i++) {
			    	diff[i] = mush[i] - mush[i + 1];
			    }
			    int max = 0;
			    for (int i = 0; i < n - 1; i++) {
			    	max = Math.max(max, diff[i]);
			    }
			
			    for (int i = 0; i < n - 1; i++) {
			    	second += Math.min(max, mush[i]);
			    }
			    
			    System.out.printf("%d %d", first, second);
			    System.err.printf("%d %d", first, second);
			    
			    System.out.println();
			    System.err.println();
			    
			}
			sc.close();
		}
    }
}
