package googlejam2.p342;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;


public class CounterCulture {
	public static void main(String[] args){
		File a = new File("A-small-attempt2 (1).in");
		Scanner input = null;
		try {
			input = new Scanner(a);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Scanner input = new Scanner(System.in);
		
		File b = new File("A-output.txt");
		FileWriter fw = null;
		try {
			fw = new FileWriter(b);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int number = input.nextInt();
		int cases = number;
		int[] answers = new int[1000001];
		
		int index = 1;
		int count = 1;
		answers[1] = 1;
		while(index < answers.length){
			int toBeReversed = index;
			int reversedCount = 0;
			while (toBeReversed != 0) {
				reversedCount = reversedCount * 10 + toBeReversed  % 10;
				toBeReversed  = toBeReversed  / 10;   
			}
			index++;
			count++;
			if(reversedCount > index && reversedCount < answers.length){
				answers[reversedCount] = count;
			}
			if(index < answers.length){
				if (count < answers[index] || answers[index] == 0){
					answers[index] = count;
				} else {
					count = answers[index];
				}
			} 
		}
		
		while(number > 0){
			int n = input.nextInt();
			int result = answers[n];
			
			try {
				fw.write("Case #" + (cases - number + 1) + ": " + result + "\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			number--;
		}
		
		try {
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
