package googlejam1.p266;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class MushroomMonster {

	Scanner in;	public static void main(String[] args){
		MushroomMonster myClass = new MushroomMonster();
		try {			myClass.in =  new Scanner(new BufferedReader(new FileReader("A-large.in")));
				myClass.writer = new FileWriter("the-file-name.txt");
				int T = myClass.in.nextInt();
					for(int i = 1; i <= T; i++){
					int N = myClass.in.nextInt();
					
					long[] allMs = new long[N];
					long maxRate = 0;
					long diffTotal = 0;
					long diff = 0;
					allMs[0] = myClass.in.nextInt();
					for(int j = 1; j < N; j++){
						allMs[j] = myClass.in.nextInt();
						diff = allMs[j-1] - allMs[j];
		if(diff > maxRate){
			maxRate = diff;
		}
		if(diff > 0){
			diffTotal += diff;
		}
					}
					long method2 = 0;
					for(int j = 1; j<allMs.length; j++){
						diff = allMs[j-1] - allMs[j];
						if(allMs[j-1] < maxRate){
							method2 += allMs[j-1];
						}
						else{
							method2 += maxRate;
						}
					}
					
					
					StringBuilder s = new StringBuilder();
					s.append("Case #");
					s.append(i);
					s.append(": ");
		s.append(diffTotal);
		s.append(" ");
		s.append(method2);
					
					s.append("\n");
					
			myClass.writer.write(s.toString());
					
							}
				myClass.writer.close();			
				}
					catch (IOException e) {
					}
	}
	FileWriter writer;
	
	
}
