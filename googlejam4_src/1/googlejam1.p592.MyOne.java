package googlejam1.p592;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class MyOne {
		public static String INPUT_FILE_NAME="/Users/utsavpatel/Documents/workspace/algo/CodeJam2015/src/input.txt";
		public static String OUTPUT_FILE_NAME="/Users/utsavpatel/Documents/workspace/algo/CodeJam2015/src/output.txt";
	
		public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader reader = new BufferedReader(new FileReader(new File(INPUT_FILE_NAME)));
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File(OUTPUT_FILE_NAME)));
		int testCases = Integer.parseInt(reader.readLine());
		for(int index=1;index<=testCases;index++){
			String result="";
			reader.readLine();
			String str[] = reader.readLine().split(" ");
			
			int max = Integer.MIN_VALUE;
			int result1 = 0;
			int result2 = 0;
			for(int i = 0; i<str.length-1;i++){
				int i2=Integer.parseInt(str[i+1]);
				int i1 = Integer.parseInt(str[i]);
				if((i2-i1)<0) result1+=-(i2-i1);
				if(-(i2-i1)>max) max = -(i2-i1);
			}
			for(int i = 0; i<str.length-1;i++){
				int i1 = Integer.parseInt(str[i]);
				if(i1>=max) result2 = result2+max;
				else if(i1<max) result2 = result2+i1;
			}
			writer.write("Case #"+index+": "+result1+" "+result2+"\n");
		}
		reader.close();
		writer.close();

	}

}
