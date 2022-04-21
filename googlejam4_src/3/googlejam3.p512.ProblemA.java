package googlejam3.p512;
import java.io.*;

public class ProblemA{

	public static void main(String[] args){
		try{
			FileReader in = new FileReader("A-small-attempt0.in");
			BufferedReader reader = new BufferedReader(in);
			String line = null;
			String text = "";
			int i = 0;
			while ((line = reader.readLine()) != null) {
				text = text + line + " ";
			}
			String[] parts = text.split("\\s");
			Integer testCases = Integer.valueOf(parts[0]);
			Integer columns, rows, width, temp;
			int[] answer = new int[testCases];
			for(int i1 = 0; i1 < testCases; i1++){
				temp = 0;
				rows = Integer.valueOf(parts[(i1*3+1)]);
				columns = Integer.valueOf(parts[(i1*3+2)]);
				width = Integer.valueOf(parts[(i1*3+3)]);
				if(columns%width == 0){
					temp = (columns/width)+width-1;
				}
				else{
					temp = (columns/width)+width;
				}
				temp = temp*rows;
				answer[i1] = temp;
			}
			try{
				PrintWriter out = new PrintWriter(new FileWriter("output.txt"));
				
				for(int j = 0; j < testCases; j++){
					int place = j+1;
					
					out.println("Case #"+place+": "+answer[j]);
				}
				out.close();
			}catch(Exception e){
				e.printStackTrace();}
		}catch(Exception e){e.printStackTrace();}
	}
}