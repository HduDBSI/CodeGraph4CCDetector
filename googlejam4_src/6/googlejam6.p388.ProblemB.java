package googlejam6.p388;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class ProblemB {
	static BufferedReader buffReader = null;
	static BufferedWriter buffWriter = null;
	static FileReader fileReader = null;
	static FileWriter fileWriter = null;
	static String input_test = "D:/Programming/workspace/test/test.in";
	static String input_small =  "D:/Programming/workspace/test/B-small-attempt0.in";
	static String input_large = "D:/Programming/workspace/test/B-large.in";

	public static final void main(String[] args){
		try {
//			fileReader = new FileReader(input_test);
//			fileReader = new FileReader(input_small);
			fileReader = new FileReader(input_large);
			buffReader = new BufferedReader(fileReader);
			fileWriter = new FileWriter("D:/Programming/workspace/test/problem_B.out");
			buffWriter = new BufferedWriter(fileWriter);

			int total_size = Integer.parseInt(buffReader.readLine());
			//iterate through every input line
			for(int i=1; i<=total_size; i++){
				int N = Integer.parseInt(buffReader.readLine());
				int size = N * (2 * N - 1);
				int index = 0;
				int[] arr = new int[size];
				for(int j=0; j<2*N-1; j++){
					String[] line = buffReader.readLine().split(" ");
					for(int k=0; k<N; k++){
						arr[index] = Integer.parseInt(line[k]);
//						System.out.println(arr[index]);
						index++;
					}
				}
				
				Arrays.sort(arr);
				int count = 1;
				int pre = arr[0];
				int cur = -2;
				String result = "";
				for(int x=1; x<size; x++){
					
					cur = arr[x];
//					System.out.println("cur = " + cur + " pre = " + pre);
					
					
					if(cur == pre){
						count++ ;
					}else{
						if ((count & 1) != 0) {
							result = result + " "+ pre;
						}
						pre = cur;
						count = 1;
					}
					
					if((x == size -1) && (count == 1)) {
						result = result + " "+ pre;
					}
					
	
				}
				

				System.out.println("Case #" +i+":"+ result);
				buffWriter.write("Case #" +i+":" + result);
				buffWriter.newLine();
				buffWriter.flush();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				buffWriter.flush();		
				buffWriter.close();
				buffReader.close();
				fileReader.close();
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
