package googlejam8.p328;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(
				System.in)));
		int testcases = scanner.nextInt();
		for (int testcase = 1; testcase <= testcases; testcase++) {
			//String input = scanner.next();
			int totalSize = scanner.nextInt();
			int[] array = new int[totalSize];
			for(int i = 0; i < totalSize; i++){
				array[i] = scanner.nextInt();
			}
			
			boolean done = false;
			String answer = "";
			
			while(!done){
				int maxPeople = 0;
				int firstIndex = -1;
				int secondIndex = -1;
				int countones = 0;
				
				for(int i = 0; i < totalSize; i++){
					if(array[i] > maxPeople){
						firstIndex = i;
						secondIndex = -1;
						maxPeople = array[i];
					}else if(array[i] == maxPeople){
						secondIndex = i;
					}
					
					if(array[i] == 1){
						countones++;
					}
				}
				
				if(maxPeople == 0){
					done = true;
				}else{
					/*if(secondIndex == -1){
						if(array[firstIndex] == 1){
							answer = answer + (char)(65 + firstIndex) + " ";
							array[firstIndex] = 0;
						}else{
							answer = answer + (char)(65 + firstIndex) + (char)(65 + firstIndex) + " ";
							array[firstIndex] -= 2;
						}
					}else{
						answer = answer + (char)(65 + firstIndex) + (char)(65 + secondIndex) + " ";
						array[firstIndex] -= 1;
						array[secondIndex] -= 1;
					}*/
					
					if(maxPeople <= 2 && countones % 2 == 1){
						answer = answer + (char)(65 + firstIndex) + " ";
						array[firstIndex] -= 1;
					}else if(secondIndex == -1){
						answer = answer + (char)(65 + firstIndex) + (char)(65 + firstIndex) + " ";
						array[firstIndex] -= 2;
					}else{
						answer = answer + (char)(65 + firstIndex) + (char)(65 + secondIndex) + " ";
						array[firstIndex] -= 1;
						array[secondIndex] -= 1;
					}
				}
			}
			
			answer = answer.substring(0, answer.length() - 1);
			System.out.println("Case #" + testcase + ": " + answer);
		}
		scanner.close();
	}
}
