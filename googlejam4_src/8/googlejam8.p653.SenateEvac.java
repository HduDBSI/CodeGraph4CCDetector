package googlejam8.p653;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;


public class SenateEvac {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		File testFile = new File("e:\\Users\\Ricardo\\Documents\\CodeJam\\SenateEvac\\A-large.in");
		
		Scanner in=null;
		try {
			in = new Scanner(testFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (in==null){
			return;
		}
		Integer testCases = in.nextInt();
		in.nextLine();

		for (Integer currentCase = 0; currentCase < testCases; currentCase++) {
			Integer partyNumber = in.nextInt();
			Integer totalSenators = 0;
			in.nextLine();
			int[] partyMembers = new int[partyNumber];
			System.out.print(String.format("Case #%d: ",currentCase+1));
			for(Character nextCharacter='A';nextCharacter<'A'+partyNumber;nextCharacter++){
				Integer senatorsInParty = in.nextInt();
				partyMembers[nextCharacter - 'A'] = senatorsInParty;
				totalSenators+=senatorsInParty;
			}
			while(totalSenators>0){
				ArrayList<Integer>evacuees =new ArrayList<Integer>();
				int lastCandidate = -1;
				for (int i=0;i<partyNumber;i++){
					if (partyMembers[i]>0){
						//MUST evacuate
						if (partyMembers[i]>(totalSenators-1)/2){
							evacuees.add(i);
							if (evacuees.size()==2){
								break;
							}
						}			
						else{
							if (evacuees.size()==0){
								lastCandidate = i;
							}							
						}
					}
				}
				if (evacuees.size()==0){
					evacuees.add(lastCandidate);
				}
				for (Integer nextEvacuee:evacuees){
					partyMembers[nextEvacuee]-=1;  
					System.out.print((char)( nextEvacuee+'A'));
					totalSenators--;
				}
				if (totalSenators>0) System.out.print(" ");
			}
			System.out.println();
			if (currentCase+1<testCases){
				in.nextLine();
			}
		
		}

		in.close();

	}

}
