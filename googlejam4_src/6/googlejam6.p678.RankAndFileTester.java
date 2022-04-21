package googlejam6.p678;
import java.io.File;
import java.io.FileNotFoundException;

//***********************************
//
// Bill Toth's RankAndFile
// for Google Code Jam 2016
// problem 1B
//
//***********************************

public class RankAndFileTester {

	public static void main(String[] args) throws FileNotFoundException {
		File inputFile = new File(args[0]);//take in file
		RankAndFile t = new RankAndFile(inputFile);//parse it
		for (int i=0; i < t.caseArray.length; i++){
			System.out.println("Case #" + (i+1) + ": " + 
					t.caseArray[i].evaluateCase());
		}//evaluate it
	}

}
