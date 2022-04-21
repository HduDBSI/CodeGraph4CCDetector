package googlejam1.p663;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ProblemA {
	

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		PrintWriter print;
		try {
			print = new PrintWriter("outputPrA");
			StringBuilder outputString = new StringBuilder();
			
			int testCases = Integer.parseInt(in.nextLine());
			for (int i = 0; i < testCases; i++) {
				String numberOfInputs = in.nextLine();
				String numberOfMushroomsString = in.nextLine();
				String[] mushroomInputs = numberOfMushroomsString.split("\\s");
				Integer minNoEaten = 0;
				for (int i3 = 0; i3 < Integer.parseInt(numberOfInputs)-1; i3++) {
					if(Integer.parseInt(mushroomInputs[i3+1]) < Integer.parseInt(mushroomInputs[i3])){
						minNoEaten+=(Integer.parseInt(mushroomInputs[i3])-Integer.parseInt(mushroomInputs[i3+1]));
					}
				}
				String firstMethod = ""+minNoEaten;
				Integer numberOfInputs1 = Integer.parseInt(numberOfInputs);
				int rate = 0;
				for (int i2 = 0; i2 < numberOfInputs1-1; i2++) {
					if(Integer.parseInt(mushroomInputs[i2+1]) < Integer.parseInt(mushroomInputs[i2]) && rate < (Integer.parseInt(mushroomInputs[i2])- Integer.parseInt(mushroomInputs[i2+1])) ){
						rate = (Integer.parseInt(mushroomInputs[i2])- Integer.parseInt(mushroomInputs[i2+1]));
					}
				}
				Integer numberMinEaten=0,numberOfPancakesLeft=0;
				for (int i1 = 0; i1 < numberOfInputs1-1; i1++) {
					if(Integer.parseInt(mushroomInputs[i1+1]) < Integer.parseInt(mushroomInputs[i1])){
						numberMinEaten += Math.min(Integer.parseInt(mushroomInputs[i1]), rate);
					} else {
						numberMinEaten += Math.min(Integer.parseInt(mushroomInputs[i1]), rate);
						numberOfPancakesLeft += Math.abs(Integer.parseInt(mushroomInputs[i1])-rate);
					}
				}
				String secondMethod = ""+numberMinEaten;
				String outputLine = firstMethod+" "+secondMethod;
				outputString.append("Case #"+(i+1)+": "+outputLine+"\n");
			}
			System.out.println(outputString);
			print.write(new String(outputString));
			print.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error Reading the file");
			e.printStackTrace();
		}
	}
	
	
}
