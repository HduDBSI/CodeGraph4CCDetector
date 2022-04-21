package googlejam3.p295;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class first {

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new FileReader("A-large.in")))
		{
			PrintWriter writer = new PrintWriter("solution-A-large.output", "UTF-8");
			
			int T = 0; //number of tests
			
			String sCurrentLine = br.readLine();
			T = Integer.parseInt(sCurrentLine);
			String stringBuffer[] = null;
			int[] answers = new int[T];
			for(int testIntance = 1 ; testIntance <= T; ++testIntance){
				System.out.println("inst: " + testIntance);
				sCurrentLine = br.readLine();
				stringBuffer = sCurrentLine.split(" ");
				int R = Integer.parseInt(stringBuffer[0]);
				int C = Integer.parseInt(stringBuffer[1]);
				int W = Integer.parseInt(stringBuffer[2]);
				answers[testIntance-1] = (int) (Math.floor(C/W)*R + W);
				if(C%W == 0){
					answers[testIntance-1]--;
				}
				System.out.println("Case #" + testIntance + ": " + answers[testIntance-1]);
			    writer.println("Case #" + testIntance + ": " + answers[testIntance-1]);
		
			}
		
			writer.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		} 
		
	}

}
