package googlejam1.p413;


import java.util.ArrayList;
import java.util.Scanner;

public class Mush {

	public static void main(String...args) {
		
		
		
		Scanner reader = new Scanner(System.in);
		int caseCount = Integer.parseInt(reader.nextLine());
		
	
		//for each use case
		for(int caseId = 0; caseId < caseCount; caseId++) {
			
			int first = 0;
			int second = 0;
			
			
			int count = Integer.parseInt(reader.nextLine());
			
			ArrayList<Integer> T = new ArrayList<Integer>();
			
			int last = 0;
			int lowest = 0;
			for(int i = 0; i < count; i++) {
				
				int cur = reader.nextInt();
				int diff = cur - last;
				
				T.add(cur);
				
				if(diff < 0) {
					
					first += Math.abs(diff);
					
					if(diff < lowest) {
						lowest = diff;
					}
				}
				
				last = cur;
			}
			
			int highest = Math.abs(lowest);
			last = 0;
			for(int i = 0; i < (count - 1); i++) {
				
				int cur = T.get(i);
				second += (cur > highest) ? highest : cur;
				
				last = cur;
			}
//			
//			if(last != 0 && diff != 0) {
//				second = second - last;
//			}
			
			if(first < 0 || second < 0) {
				System.err.println("Case #"+ (caseId + 1));
			}
			
			System.out.println("Case #"+ (caseId + 1) + ": "+ first + " " + second);
			reader.nextLine();
		}
		
		
		
		
	}
	
	
}
