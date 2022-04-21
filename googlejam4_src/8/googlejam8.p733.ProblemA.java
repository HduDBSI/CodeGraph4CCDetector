package googlejam8.p733;
import java.io.File;
import java.io.PrintWriter;
import java.util.*;

public class ProblemA {

    public static String PROBLEM_LETTER = "A";

    public static String IN_DIR = "inputs/" + PROBLEM_LETTER + "/";
    public static String OUT_DIR = "outputs/" + PROBLEM_LETTER + "/";

    //public static String IN_FILE = IN_DIR + "sample.in";
    //public static String IN_FILE = IN_DIR + "A-small-attempt0.in";
    public static String IN_FILE = IN_DIR + "A-large.in";

    //public static String OUT_FILE = OUT_DIR + "sample.out";
    //public static String OUT_FILE = OUT_DIR + "small.out";
    public static String OUT_FILE = OUT_DIR + "large.out";

    public static int[] idxToCnt = new int[26];
    public static char[] idxToCh = new char[26];

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File(IN_FILE));
            PrintWriter wr = new PrintWriter(OUT_FILE);

            int T = sc.nextInt();
            for (int ti = 0; ti < T; ti++) {
                int N = sc.nextInt();
                for(int i = 0; i < 26; i++) {
                    idxToCnt[i] = 0;
                    idxToCh[i] = (char) ('A' + i);
                }
                for(int i = 0; i < N; i++) {
                    idxToCnt[i] = sc.nextInt();
                }
                wr.print("Case #" + (ti+1) + ": ");
				
				int rem = 0;
				for (int i = 0; i < N; i++) {
				    rem += idxToCnt[i];
				}
				
				for (int tsi = 0; tsi < N-1; tsi++) {
				    int end = N-1;
					int res1 = tsi;
					
					if (true) {
					    for (int i = tsi + 1; i <= end; i++) {
					        if (idxToCnt[i] > idxToCnt[res1]) {
					            res1 = i;
					        }
					    }
					} else {
					    for (int i = tsi + 1; i <= end; i++) {
					        if (idxToCnt[i] >= idxToCnt[res1]) {
					            res1 = i;
					        }
					    }
					}
					int nextMax = res1;
				    if (nextMax == tsi) {
				        continue;
				    } else {
				        int tmpCnt = idxToCnt[tsi];
						char tmpChar = idxToCh[tsi];
						
						idxToCnt[tsi] = idxToCnt[nextMax];
						idxToCh[tsi] = idxToCh[nextMax];
						
						idxToCnt[nextMax] = tmpCnt;
						idxToCh[nextMax] = tmpChar;
				    }
				}
				
				String res = "";
				while(true) {
				    if (res.length() != 0) {
				        res += " ";
				    }
				    String door = "";
				
				    door += idxToCh[0];
				    idxToCnt[0]--;
				    rem--;
				
				    if(rem == 0) {
				        res += door;
				        break;
				    }
					int end = N-1;
					int res1 = 0;
					
					if (false) {
					    for (int i = 0 + 1; i <= end; i++) {
					        if (idxToCnt[i] > idxToCnt[res1]) {
					            res1 = i;
					        }
					    }
					} else {
					    for (int i = 0 + 1; i <= end; i++) {
					        if (idxToCnt[i] >= idxToCnt[res1]) {
					            res1 = i;
					        }
					    }
					}
				
				    int nextMax = res1;
				    if (nextMax != 0) {
				        int tmpCnt = idxToCnt[0];
						char tmpChar = idxToCh[0];
						
						idxToCnt[0] = idxToCnt[nextMax];
						idxToCh[0] = idxToCh[nextMax];
						
						idxToCnt[nextMax] = tmpCnt;
						idxToCh[nextMax] = tmpChar;
				    }
				
				    if (idxToCnt[0] > rem - idxToCnt[0]) {
				        door += idxToCh[0];
				        idxToCnt[0]--;
				        rem--;
				
				        res += door;
				
				        if(rem == 0) {
				            break;
				        }
						int end1 = N-1;
						int res2 = 0;
						
						if (false) {
						    for (int i = 0 + 1; i <= end1; i++) {
						        if (idxToCnt[i] > idxToCnt[res2]) {
						            res2 = i;
						        }
						    }
						} else {
						    for (int i = 0 + 1; i <= end1; i++) {
						        if (idxToCnt[i] >= idxToCnt[res2]) {
						            res2 = i;
						        }
						    }
						}
				
				        int nextMax2 = res2;
				        if (nextMax2 != 0) {
				            int tmpCnt = idxToCnt[0];
							char tmpChar = idxToCh[0];
							
							idxToCnt[0] = idxToCnt[nextMax2];
							idxToCh[0] = idxToCh[nextMax2];
							
							idxToCnt[nextMax2] = tmpCnt;
							idxToCh[nextMax2] = tmpChar;
				        }
				    } else {
				        res += door;
				    }
				}
				
				wr.println(res);
            }

            wr.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
