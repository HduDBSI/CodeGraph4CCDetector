package googlejam8.p948;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;

public class Problem1 {
	
	final static String PROBLEM_NAME = "problem1";
	final static String WORK_DIR = "/Users/manisharya/Desktop/jam/" + PROBLEM_NAME + "/";
	final static String INPUT_FILE_NAME = "A-small-attempt0.in";
	final static String OUTPUT_FILE_NAME = "output.txt";
	
	int[] map;
	int[] letter;
	int n = -1;
	
	
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new FileReader(WORK_DIR + INPUT_FILE_NAME));
		PrintWriter pw = new PrintWriter(new FileWriter(WORK_DIR
				+ OUTPUT_FILE_NAME));
		int caseCnt = sc.nextInt();
		for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
			pw.print("Case #" + (caseNum + 1) + ": ");
			Problem1 r = new Problem1();
			r.n = sc.nextInt();
			r.map = new int[r.n];
			r.letter = new int[r.n];
			
			for(int index = 0; index < r.n; index++) {
				r.map[index] = sc.nextInt();
				r.letter[index] = index;
			}
			
			for(int i = 0; i < r.n; i++) {
				for(int j = i+1; j < r.n ; j++) {
					if(r.map[i] < r.map[j]) {
						int temp = r.map[i];
						r.map[i] = r.map[j];
						r.map[j] = temp;
						
						temp = r.letter[i];
						r.letter[i] = r.letter[j];
						r.letter[j] = temp;
					}
				}
			}
			
			while(true) {
				
				if(r.map[0] == 0)
					break;
				
				if(r.map[0] > 1){
					if(r.map[1] > 0) {
						r.map[0] = r.map[0] - 1;
						r.map[1] = r.map[1] - 1;
						
						pw.print(Character.toChars(r.letter[0] + 65));
						pw.print(Character.toChars(r.letter[1] + 65));
			
						pw.print(" ");
						for(int i = 0; i < r.n; i++) {
							for(int j = i+1; j < r.n ; j++) {
								if(r.map[i] < r.map[j]) {
									int temp = r.map[i];
									r.map[i] = r.map[j];
									r.map[j] = temp;
									
									temp = r.letter[i];
									r.letter[i] = r.letter[j];
									r.letter[j] = temp;
								}
							}
						}
					} else {
						r.map[0] = r.map[0] - 1;
						
						pw.print(Character.toChars(r.letter[0] + 65));
			
						pw.print(" ");
						break;
					} 
				} else {
					if(r.map[1] > 0) {
						if((r.n % 2) != 0 && r.map[2] > 0) {
							r.map[0] = r.map[0] - 1;
							
							pw.print(Character.toChars(r.letter[0] + 65));
			
							pw.print(" ");
							for(int i = 0; i < r.n; i++) {
								for(int j = i+1; j < r.n ; j++) {
									if(r.map[i] < r.map[j]) {
										int temp = r.map[i];
										r.map[i] = r.map[j];
										r.map[j] = temp;
										
										temp = r.letter[i];
										r.letter[i] = r.letter[j];
										r.letter[j] = temp;
									}
								}
							}
						} else {
							r.map[0] = r.map[0] - 1;
							r.map[1] = r.map[1] - 1;
							
							pw.print(Character.toChars(r.letter[0] + 65));
							pw.print(Character.toChars(r.letter[1] + 65));
							pw.print(" ");
							for(int i = 0; i < r.n; i++) {
								for(int j = i+1; j < r.n ; j++) {
									if(r.map[i] < r.map[j]) {
										int temp = r.map[i];
										r.map[i] = r.map[j];
										r.map[j] = temp;
										
										temp = r.letter[i];
										r.letter[i] = r.letter[j];
										r.letter[j] = temp;
									}
								}
							}
						}
					} else {
						r.map[0] = r.map[0] - 1;
						
						pw.print(Character.toChars(r.letter[0] + 65));
						pw.print(" ");
						break;
					}
				}
			}
			
			pw.println();
		}
		pw.flush();
		pw.close();
		sc.close();
	}



}
