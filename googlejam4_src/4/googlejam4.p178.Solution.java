package googlejam4.p178;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Solution r = new Solution();
		Scanner sc = new Scanner(new FileReader("input.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
		
		int caseCnt = sc.nextInt();
		
		for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
		    pw.print("Case #" + (caseNum + 1) + ": ");
		
		    int R = sc.nextInt();
		    int C = sc.nextInt();
		    int res = 0;
		    String board[] = new String[R];
		    sc.nextLine();
		    for (int i = 0; i < R; i++) {
		        board[i] = sc.nextLine();
		    }
		    int max = 101;
		    int dirX[] = {-1, 1, 0, 0};
		    int dirY[] = {0, 0, 1, -1};
		    String dir = "^v><";
		    boolean possible = true;
		    for (int i = 0; i < R && possible; i++) {
		        for (int j = 0; j < C && possible; j++) {
		            int curDir = dir.indexOf(board[i].charAt(j));
		            int curX = i;
		            int curY = j;
		            boolean reachEnd = false;
		            if (curDir >= 0) {
		                for (int k = 0; k < max; k++) {
		                    curX = curX + dirX[curDir];
		                    curY = curY + dirY[curDir];
		                    if (curX < R && curX >= 0 && curY < C && curY >= 0) {
		                        if (board[curX].charAt(curY) != '.')
		                            break;
		                    } else {
		                        reachEnd = true;
		                        break;
		                    }
		                }
		                if (reachEnd) {
		                    possible = false;
		                    for (int d = 0; d < 4 && !possible; d++) {
		                        curX = i;
		                        curY = j;
		                        for (int k = 0; k < max; k++) {
		                            curX = curX + dirX[d];
		                            curY = curY + dirY[d];
		                            if (curX < R && curX >= 0 && curY < C && curY >= 0) {
		                                if (board[curX].charAt(curY) != '.') {
		                                    possible = true;
		                                    res++;
		                                    break;
		                                }
		                            } else {
		                                break;
		                            }
		                        }
		                    }
		                }
		            }
		        }
		    }
		    if (!possible) {
		        pw.println("IMPOSSIBLE");
		    } else {
		        pw.println(res);
		    }
		}
		
		pw.flush();
		pw.close();
		sc.close();
    }
}