package googlejam8.p128;
import java.awt.font.NumericShaper;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.print.attribute.standard.Finishings;

public class ProblemA {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(new File("A-small-attempt0.in"));
//		Scanner sc = new Scanner(new File("A.in"));
		Scanner sc = new Scanner(new File("A-large.in"));

		int t = sc.nextInt();
		int count = 1;

		while (t-- > 0) {
			int numParties = sc.nextInt();
			int[] partieMembers = new int[numParties];
			int numSenators = 0;
			
			for(int i = 0; i < numParties; i++) {
				partieMembers[i] = sc.nextInt();
				numSenators += partieMembers[i];
			}
			

			System.out.print("Case #" + count + ": ");
			
			// Keep parties even sized
			if(numParties == 2) {
				if(partieMembers[0] == partieMembers[1] + 2) {
					System.out.print("AA ");
					numSenators -= 2;
				} else if(partieMembers[0] + 2 == partieMembers[1]) {
					System.out.print("BB ");
					numSenators -= 2;
				} else if(partieMembers[0] == partieMembers[1] + 1) {
					System.out.print("A ");
					numSenators--;
				} else if(partieMembers[0] + 1 == partieMembers[1]) {
					System.out.print("B ");
					numSenators--;
				} else if(partieMembers[0] == partieMembers[1]) {
				}
				
				for(int i = 0; i < numSenators/2; i++) {
					System.out.print("AB ");
				}
			} else {
				for(int i = 0; i < numSenators - 2; i++) {
					int biggestPartie1 = 0;
					int members = 0;
					
					for(int i1 = 0; i1 < partieMembers.length; i1++) {
						if(members < partieMembers[i1]) {
							members = partieMembers[i1];
							biggestPartie1 = i1;
						}
					}
					int biggestPartie = biggestPartie1;
					partieMembers[biggestPartie]--;
					char evac = (char) (65 + biggestPartie);
				
					System.out.print(evac + " ");	
				}

				String evac = "";
				for(int i = 0; i < numParties; i++) {
					if(partieMembers[i] > 0) {
						evac += (char) (65 + i);
					}
				}
				
				System.out.print(evac);
			}
			
			System.out.println("");
			count++;
		}

		sc.close();
	}
}
