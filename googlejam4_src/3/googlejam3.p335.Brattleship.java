package googlejam3.p335;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Brattleship {
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		int cases = Integer.parseInt(br.readLine());
		for(int i=0;i<cases;i++){
			String in = br.readLine();
			String[] input = in.split(" ");
			int rows = Integer.parseInt(input[0]);
			int columns = Integer.parseInt(input[1]);
			int width = Integer.parseInt(input[2]);
			int moves = (columns/width)*rows + (width - 1);
			int nomiss = columns%width==0 ? 0 : 1;
			moves += nomiss;
			System.out.format("Case #%d: %d\n", i+1, moves);
		}
	}
}
