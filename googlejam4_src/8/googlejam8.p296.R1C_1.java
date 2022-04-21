package googlejam8.p296;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class R1C_1 {
	
	public static void main(String args[]){
		try {
			//System.setIn(new FileInputStream("C:\\Users\\ericc\\Desktop\\Question\\R1C\\Q1\\Q1.in"));
			//System.setIn(new FileInputStream("C:\\Users\\ericc\\Desktop\\Question\\R1C\\Q1\\Q1-small.in"));
			System.setIn(new FileInputStream("C:\\Users\\ericc\\Desktop\\Question\\R1C\\Q1\\Q1-large.in"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		int caseCount = 0;
		while(sc.hasNext()){
			int numParty = Integer.parseInt(sc.nextLine());
			int se[] = new int[26];
			int total = 0;
			for(int i = 0 ; i < numParty ; i++){
				se[i] = sc.nextInt();
				total += se[i];
			}
			if(sc.hasNext())
				sc.nextLine();
			
			String result = "";
			
			while(total != 0){
				if(total != 3){
					for(int i = 0 ; i < 2 ; i++){
						int maxIdx = 0;
						for(int j = 0 ; j < numParty ; j++){
							if(se[j] > se[maxIdx]){
								maxIdx = j;
							}
						}
						total--;
						se[maxIdx]--;
						result += (char)('A' + maxIdx);
					}
				}
				else{
					int maxIdx = 0;
					for(int j = 0 ; j < numParty ; j++){
						if(se[j] > se[maxIdx]){
							maxIdx = j;
						}
					}
					total--;
					se[maxIdx]--;
					result += (char)('A' + maxIdx);
				}
				result += " ";
				
			}
			
			caseCount++;
			System.out.println("Case #" + caseCount + ": " + result);
		}
		
	}
	
}
