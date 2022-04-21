package googlejam6.p684;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class R1A_2_1 {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(new File("D:/ForPrograms/java/TESTS/B-large.in"));
		FileWriter writer = new FileWriter("D:/ForPrograms/java/TESTS/B-large.out", false);
		
		int cases = scanner.nextInt();
		
		
	
		
		for(int i=0;i<cases;i++){
			
			
			
			int cell = scanner.nextInt();
			
			int[][] arr = new int[cell*2-1][cell];
			int[][] arrD = new int[cell*2-1][cell];
			
			int[] par = new int[cell];
			int parC = 0;
			
			int wrongC = 0;
			
			for(int v=0;v<cell;v++){
				par[v] = 0;
			}
			
			int[][] cols = new int[cell][cell];
			int[][] rows = new int[cell][cell];
			
			int[] allNums = new int[2600];
			
			for(int g=0;g<cell*cell;g++){
				allNums[g] = 0;
			}
			
			for(int g=0;g<cell*2-1;g++){
				
				for(int j=0;j<cell;j++){
					arr[g][j] = scanner.nextInt();
					arrD[g][j] = 1;
					
					allNums[arr[g][j]]++;
					//scanner.next();
				}
				
			}
			
			
			
			
			/*
			for(int g=0;g<cell*2-1;g++){
				
				for(int j=0;j<cell*2-1;j++){
					
					if(arr[g][0] < arr[j][0]){
						int[] temp = new int[cell];
						temp = arr[g];
						arr[g] = arr[j];
						arr[j] = temp;
					}
					//scanner.next();
				}
				
			}
			*/
			
			int[] needed  = new int[cell];
			int nC = 0;
			
			for(int v=0;v<allNums.length;v++){
				if(allNums[v] != 0 && allNums[v] % 2 == 1){
					needed[nC] = v;
					nC++;
				}
			}
			
			Arrays.sort(needed);
			
			
			
			
			System.out.println(Arrays.toString(needed));
			
			
			writer.write("Case #"+(i+1)+": ");
			
			for(int v=0;v<cell;v++){
				writer.write(needed[v]+" ");
			}
			
			
			
			writer.append('\r');
			writer.append('\n');
			
		} 
		
		
		scanner.close();
		writer.close();
	}
}
