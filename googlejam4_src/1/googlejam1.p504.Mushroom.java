package googlejam1.p504;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;


public class Mushroom {

	public Mushroom() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException{
		BufferedReader input = new BufferedReader(new FileReader(new File("input.in")));
		BufferedWriter output = new BufferedWriter(new FileWriter(new File("output.txt")));
		
		String line = null;
		
		line = input.readLine();
		int num_of_cases = Integer.parseInt(line);
		
		
		for(int i=0;i<num_of_cases;i++) {
			line = input.readLine();
			int plate_num = Integer.parseInt(line);
			int[] plates = new int[plate_num];
			
			line = input.readLine();
			String[] splited = line.split("\\s+");
			for(int j=0;j<plate_num;j++) {
				plates[j] = Integer.parseInt(splited[j]);
			}

			//1st situation
			int total_1 = 0;
			for(int j=0;j<plate_num-1;j++) {
				if(plates[j]>plates[j+1]) {
					total_1+=plates[j]-plates[j+1];
				}
			}
			
			//2nd situation
			int total_2 = 0;
			int[] diff = new int[plate_num-1];
			int max_diff=0;
			for(int j=0;j<plate_num-1;j++) {
				if(plates[j]>plates[j+1]) {
					diff[j] = plates[j]-plates[j+1];
					if(max_diff<diff[j]) {
						max_diff=diff[j];
					}
				}
			}
			
			for(int j=0;j<plate_num-1;j++) {
				if(plates[j]<max_diff) {
					total_2+=plates[j];
				}else {
					total_2+=max_diff;
				}
			}

			
			output.write("Case #"+(i+1)+": "+total_1+" "+total_2+"\n");
		}
		input.close();
		output.close();
	}
	
}
