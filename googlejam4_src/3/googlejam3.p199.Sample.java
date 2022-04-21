package googlejam3.p199;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class Sample {	
	
	public static final String INPUT_FILE = "A-large.in";
	public static final String OUTPUT_FILE = "output_A-large.txt";
	
	public static final String CASE_STRING_BEFORE = "Case #";
	public static final String CASE_STRING_AFTER = ": ";
	
	Scanner scanner = null;
	File outputFile;
	PrintStream pout = null;
	int totalTests;
	int testNo;
	//DecimalFormat formatter = new DecimalFormat("#0.0000000");
	
	//ArrayList<Integer> plates = null;
	int row;
	int col;
	int width;
	int turn;
	
	public static void main(String argv[]){
		
		Sample cards = new Sample();
		try {
			cards.scanner = new Scanner(new File(Sample.INPUT_FILE));
			cards.outputFile = new File(Sample.OUTPUT_FILE);
			
			if(cards.outputFile.exists()){
				cards.outputFile.delete();
			}
			
			cards.outputFile.createNewFile();
			
			cards.pout = new PrintStream(cards.outputFile);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cards.totalTests = cards.scanner.nextInt();
		
		for(int i=1;i<=cards.totalTests;i++){
			cards.testNo = i;
			//plates = new ArrayList<Integer>();
			cards.row = 0;
			cards.col = 0;
			cards.width = 0;
			cards.turn = 0;
			cards.row = cards.scanner.nextInt();
			cards.col = cards.scanner.nextInt();
			cards.width = cards.scanner.nextInt();
			cards.turn = cards.col/cards.width;
			cards.turn += (cards.width-1);
			
			if(cards.col%cards.width == 0){
				// no action required
			}else{
				cards.turn++;
			}
			if(cards.row>1){
				cards.row--;
				int misses = cards.col/cards.width;
				int missTurns = misses * cards.row;
				cards.turn += missTurns;
			}
			
			
			
			cards.pout.print(Sample.CASE_STRING_BEFORE + cards.testNo + Sample.CASE_STRING_AFTER);
			
			cards.pout.println(""+cards.turn);
		}
		
		cards.scanner.close();
		cards.pout.flush();
		cards.pout.close();
		
	}
	
	
	
//	public class IntegerComparator implements Comparator<Integer> {
//
//	    @Override
//	    public int compare(Integer o1, Integer o2) {
//	        return o2.compareTo(o1);
//	    }
//	}

}
