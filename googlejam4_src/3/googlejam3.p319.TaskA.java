package googlejam3.p319;
import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

public class TaskA {
	public int caseNumber;
	Formatter output;
	Scanner input;
	final String file = "A-large.in";
	
	public TaskA(){
		caseNumber = 1;
		try{
			output = new Formatter("result.out");
			input = new Scanner(new File(file));
		}
		catch(Exception ex){
			System.out.print(ex.getMessage() + "/n");
		}
	}
	
	public static void main(String[] args){
		TaskA app = new TaskA ();
		int T = app.input.nextInt();
		int R, C, W, result;
		
		for (int i = 0; i < T; i++){
			R = app.input.nextInt();
			C = app.input.nextInt();
			W = app.input.nextInt();
			
			result = R*(C/W) + W;
			
			if(C % W == 0)
				result--;
			String msg = result + "";
			
			app.output.format("Case #%d: %s\n", app.caseNumber, msg);
			System.out.printf("Case #%d: %s\n", app.caseNumber, msg);
			app.caseNumber++;
		}
		
		try{
			app.output.close();
			System.out.print("Output is closed\n");
		}
		catch(Exception ex1){
			System.out.print(ex1.getMessage() + "\n");
		}
		try{
			app.input.close();
			System.out.print("Input is closed\n");
		}
		catch(Exception ex){
			System.out.print(ex.getMessage() + "\n");
		}
		System.out.print("Done");
	}
}