package googlejam8.p847;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Round1B01 {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(
				System.in)));
		int numOfTestCases = in.nextInt(); // Scanner has functions to read ints, longs,
								// strings, chars, etc.
		int testCaseNum = 1;
		while(numOfTestCases!= 0){
			int numOfParties = in.nextInt();
			in.nextLine();
			String partyMembersNum = in.nextLine();
			
			String[] tokens = partyMembersNum.split(" ");
			int[] eachPartyMemberCount = new int[numOfParties];
			String[] ResultOps = new String[100000];
			int ResultOpsIndex = 0;
			
			
			int i = 0;
			for (String token : tokens){
				eachPartyMemberCount[i++] = Integer.parseInt(token); 
			}
			
			int finish = 0;
			char beginChar = 'A';
			String tempStr = "";
			//System.out.print("Case #"+testCaseNum+": ");
			while(finish != 1){
				int maxLoc = 0;
				int maxVal = eachPartyMemberCount[maxLoc];
				for(int k = 1;k<eachPartyMemberCount.length;k++){
					if(eachPartyMemberCount[k] > maxVal){
						maxVal = eachPartyMemberCount[k];
						maxLoc = k;
					}
				}
				eachPartyMemberCount[maxLoc]--;
				
				//System.out.print(Character.toString((char)(beginChar+maxLoc)));
				
				int zeroCount = 0;
				
				for(int k = 0;k<eachPartyMemberCount.length;k++){
					if(eachPartyMemberCount[k] == 0){
						zeroCount++;
					}
				}
				if(zeroCount == numOfParties) {
					tempStr = Character.toString((char)(beginChar+maxLoc));
					ResultOps[ResultOpsIndex] = tempStr;
					ResultOpsIndex++;
					break;
				}
				
				int maxLoc1 = 0;
				int maxVal1 = eachPartyMemberCount[maxLoc1];
				for(int k = 1;k<eachPartyMemberCount.length;k++){
					if(eachPartyMemberCount[k] > maxVal1){
						maxVal1 = eachPartyMemberCount[k];
						maxLoc1 = k;
					}
				}
				eachPartyMemberCount[maxLoc1]--;
				//System.out.print(Character.toString((char)(beginChar+maxLoc1)));
				
				int zeroCount1 = 0;
				
				for(int k = 0;k<eachPartyMemberCount.length;k++){
					if(eachPartyMemberCount[k] == 0){
						zeroCount1++;
					}
				}
				if(zeroCount1 == numOfParties) {
					tempStr = Character.toString((char)(beginChar+maxLoc)) + Character.toString((char)(beginChar+maxLoc1));
					ResultOps[ResultOpsIndex] = tempStr;
					ResultOpsIndex++;
					break;
				}
				else{
					tempStr = Character.toString((char)(beginChar+maxLoc)) + Character.toString((char)(beginChar+maxLoc1));
					ResultOps[ResultOpsIndex] = tempStr;
					ResultOpsIndex++;
				}
				
				
			}
			// print results
			
			System.out.print("Case #"+testCaseNum+": ");
			if(ResultOps[ResultOpsIndex-1].length() == 1){
				System.out.print(ResultOps[ResultOpsIndex-1]);
				System.out.print(" ");
				for(int p = 0;p<ResultOpsIndex-1;p++){
					System.out.print(ResultOps[p]);
					System.out.print(" ");
				}
			}
			else{
				//System.out.print(ResultOps[ResultOpsIndex-1]);
				//System.out.print(" ");
				for(int p = 0;p<ResultOpsIndex;p++){
					System.out.print(ResultOps[p]);
					System.out.print(" ");
				}
			}
			
			System.out.println();
			numOfTestCases--;
			testCaseNum++;
		}

		in.close();

		// S = S.replaceFirst("O", "");
		// S = S.replaceFirst("O", "");
		// S = S.replaceFirst("O", "");

		// removeCharAt(S, 3);
		// System.out.println(S+ " "+Slength+" Index of Z is: "+S.indexOf('w'));
	}
}