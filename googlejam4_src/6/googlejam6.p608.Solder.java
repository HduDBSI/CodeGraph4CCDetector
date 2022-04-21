package googlejam6.p608;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solder {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("resources/A-large-solder.in"));
		FileWriter fw = new FileWriter("resources/A-large-solder.out");
		int C = new Integer(in.readLine());		

		for (int i = 1; i <= C; i++){
			int N = new Integer(in.readLine());
			int[][] heights = new int [2500*2500][2];			
	    	for (int j = 0; j < 2*N - 1; j++){
	    		StringTokenizer st = new StringTokenizer(in.readLine());
	    		for (int v = 0; v < N; v++){
	    			int height = new Integer(st.nextToken());
	    			boolean matched = false;
					int i1 = 0;
					for (; i1 < N * N && heights[i1][0] > 0;  i1++){
						if (height == heights[i1][0]){
							heights[i1][1]++;	
							matched = true;
						}
					}
					if (!matched) {
						heights[i1][0] = height;
						heights[i1][1]++;
					}
	    		}
	    	}	    	
	    	ArrayList result = new ArrayList();
			for(int i2 = 0; i2 < N * N && heights[i2][0] > 0; i2++){
				if (heights[i2][1] % 2 == 1)
					result.add(heights[i2][0]);
			}		
			Collections.sort(result);
			fw.write("Case #" + i + ": ");
			for (int i1 = 0; i1 < result.size(); i1++ ){
				fw.write(result.get(i1) + " ");
			}
			fw.write("\n");
		}		
		fw.flush();
		fw.close();
	}
	

}
