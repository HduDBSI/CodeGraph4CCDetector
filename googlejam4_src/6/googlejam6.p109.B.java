package googlejam6.p109;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;


public class B {
	public static void main(String[] args) {
		boolean printToFile = true;
		try {
			if(printToFile){
				System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream("out.txt")), true));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new B();
	}
	
	public B() {
		Scanner sc = new Scanner(System.in);
		int nbProblems = sc.nextInt();
		for(int caseNb = 1; caseNb <= nbProblems; caseNb++){
			int n = sc.nextInt();
			int[][] lists = new int[2*n-1][n];
			for(int i = 0; i < n; i++){
				for(int j = 0; j < n; j++){
					lists[i][j] = sc.nextInt();
				}
			}
			for(int i = n; i < 2*n-1; i++){
				for(int j = 0; j < n; j++){
					lists[i][j] = sc.nextInt();
				}
			}
			HashMap<Integer, Integer> rv = new HashMap<>();
			for(int i1 = 0; i1 < lists.length; i1++){
				for(int j = 0; j < lists[0].length; j++){
					if(!rv.containsKey(lists[i1][j])){
						rv.put(lists[i1][j], 0);
					}
					rv.put(lists[i1][j], rv.get(lists[i1][j])+1);
				}
			}
			HashMap<Integer, Integer> counts = rv;
			ArrayList<Integer> answer = new ArrayList<>();
			for(int key : counts.keySet()){
				if(counts.get(key) %2 == 1){
					answer.add(key);
				}
			}
			if(answer.size() != n){
				System.err.println("niet juist");
			}
			
			Collections.sort(answer);
			StringBuilder solution = new StringBuilder();
			for(Integer i : answer){
				solution.append(i + " ");
			}
			solution.deleteCharAt(solution.length()-1);
			System.out.println("Case #" + caseNb + ": " + solution.toString());
		}
	}
}
