package googlejam10.p106;
import java.io.*;
import java.util.*;
import java.math.*;

public class ProblemA {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int numCases = Integer.parseInt(in.nextLine());
		for (int caseNum = 1; caseNum <= numCases; caseNum++) {
			String line = in.nextLine();
			Scanner sc = new Scanner(line);
			int n = Integer.parseInt(sc.next());
			int r = Integer.parseInt(sc.next());
			int p = Integer.parseInt(sc.next());
			int s = Integer.parseInt(sc.next());
			int[] test = new int[3];
			test[0] = 1;
			test[1] = 1;
			for(int i = 1; i < n; i++){
				int[] nextStep = new int[3];
				nextStep[0] = test[0] + test[2];
				nextStep[1] = test[1] + test[0];
				nextStep[2] = test[1] + test[2];
				test[0] = nextStep[0];
				test[1] = nextStep[1];
				test[2] = nextStep[2];
			}
			ArrayList<String> round = new ArrayList<String>();
				
			if(test[0] == p && test[1] == r && test[2] == s){
				round.add("PR");
			} else if(test[0] == r && test[1] == s && test[2] == p){
				round.add("RS");
			} else if(test[0] == s && test[1] == p && test[2] == r){
				round.add("PS");
			} else {
				System.out.println("Case #" + caseNum + ": " + "IMPOSSIBLE");
				continue;
			}
			for(int i = 1; i < n; i++){
				ArrayList<String> nextRound = new ArrayList<String>();
				for(int j = 0; j < round.size(); j++){
					if(round.get(j).equals("PR")){
						nextRound.add("PR");
						nextRound.add("RS");
					} else if(round.get(j).equals("PS")){
						nextRound.add("PR");
						nextRound.add("PS");
					} else if(round.get(j).equals("RS")){
						nextRound.add("RS");
						nextRound.add("PS");
					}
				}
				round = nextRound;
			}
			for(int i = 1; i < n; i++){
				ArrayList<String> lastRound = new ArrayList<String>();
				for(int j = 0; j < round.size()/2; j++){
					String s1 = round.get(2*j);
					String s2 = round.get(2*j + 1);
					if(s1.compareTo(s2) < 0){
						lastRound.add(s1 + s2);
					} else {
						lastRound.add(s2 + s1);
					}
				}
				round = lastRound;
			}
			if(round.size() != 1){
				System.out.println("FAIL");
			}
			System.out.println("Case #" + caseNum + ": " + round.get(0));
		}
	}
}
