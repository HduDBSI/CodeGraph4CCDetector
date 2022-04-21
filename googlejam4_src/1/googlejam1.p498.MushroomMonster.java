package googlejam1.p498;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;


public class MushroomMonster {

	public static void main(String[] args)  throws IOException{
		// TODO Auto-generated method stub
//		String inputFile = "input.txt";
//		String inputFile = "A-small-attempt0 (1).in";
		String inputFile = "A-large (1).in";
//		String inputFile = "C-large.in";
		String outputFile = "output.txt";
		FileInputStream fstream = new FileInputStream(inputFile);
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		PrintWriter writer = new PrintWriter(outputFile, "UTF-8"); //result
		
		String strLine;
		strLine = br.readLine();
		int T = Integer.parseInt(strLine);
		System.out.println("T=" + T);
		for( int i = 0;i<T;i++){
			int N;
			strLine = br.readLine();
			N = Integer.parseInt(strLine);
			
			int[] c = new int[N];
			strLine = br.readLine();
			String[] strArray = strLine.split(" ");
//			System.out.println("N = " + N);
//			System.out.println(Arrays.toString(strArray));
			for(int j =0;j<N;j++){
				c[j] = Integer.parseInt(strArray[j]);
			}
			int n = c.length;
			int r = 0;
			for (int i1 =0;i1<n-1;i1++){
				r = r +  Math.max(0, c[i1] - c[i1+1]);
			}
			
//			System.out.println(Arrays.toString(c));
			int y = r;
			int n1 = c.length;
			int minCount = -1; // 最小速度
			int e = 0;
			for (int i2 =0;i2<n1-1;i2++){
				 e = Math.max(0, c[i2] - c[i2+1]);
				 if(e > minCount){
					 minCount = e;
				 }
			}
			int r1 = 0;
			for (int i1 =0;i1<n1-1;i1++){
				 if(c[i1] <= minCount){
					 r1 = r1 + c[i1];
				 }else{
					 r1 = r1 + minCount;
				 }
			}
			int z = r1;
			String result_str;
			result_str ="Case #"+(i+1)+": " + y + " " + z; 
			 
			writer.println(result_str);
			System.out.println(result_str);
		}
	
		//Close the input stream
		br.close();
		writer.close();
	}

}
