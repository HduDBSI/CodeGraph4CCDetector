package googlejam1.p390;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MushroomMonster {
	public static void main(String[] args) throws IOException {
		File input = new File("A-large.in");
		Scanner sc = new Scanner(input);
		int numCases = sc.nextInt();
		for (int i = 1; i <= numCases; i++) {
			int numM = sc.nextInt();
			int localMax = 0;
			int count1 = 0;
			ArrayList<Integer> diffList = new ArrayList<Integer>();
			ArrayList<Integer> numList = new ArrayList<Integer>();
			
			
			for (int j = 1; j <= numM; j++){
				int nextNum = sc.nextInt();
				numList.add(nextNum);
				int difference = localMax-nextNum;
				diffList.add(difference);
				if (localMax >= nextNum){
					count1 += difference;
				}
				localMax = nextNum;
			}
			int maxDiff = Collections.max(diffList);
			int total = 0;
			for (int k = 0; k < numList.size()-1; k++){
				if (numList.get(k) > maxDiff)
					total += maxDiff;
				else
					total += numList.get(k);
			}
			
			System.out.println("Case #"+i + ": " + count1 + " " + total);
			
				
		}
		sc.close();
	}
}
