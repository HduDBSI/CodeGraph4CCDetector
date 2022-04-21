package googlejam8.p956;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;


public class SenateEvac {
	public static void main(String[] args){
		File a = new File("A-small-attempt2.in");
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
		input.nextLine();
		int cases = number;
		
		while(number > 0){
			int parties = input.nextInt();
			int[] partySizes = new int[parties];
			int totalMembers = 0;
			for(int i = 0; i < parties; i ++){
				partySizes[i] = input.nextInt();
				totalMembers += partySizes[i];
			}
			String result = "";
			
			while(totalMembers > 0){
				int max = -1;
				int maxIndex = -1;
				int otherIndex = -1;
				int thirdIndex = -1;
				for (int i =0; i < parties; i++){
					if (partySizes[i] > max){
						max = partySizes[i];
						maxIndex = i;
					} else if (partySizes[i] == max){
						if(otherIndex != -1 && max == 1){
							otherIndex = -1;
						} else {
							otherIndex = i;
						}
					}
				}
				if(otherIndex != -1){
					partySizes[maxIndex] -= 1;
					partySizes[otherIndex] -= 1;
					result = result + (char)(65 + maxIndex) + (char) (65 + otherIndex) + " ";
					totalMembers -= 2;
				} else {
					partySizes[maxIndex] -= 1;
					result = result + (char)(65 + maxIndex) + " ";
					totalMembers -= 1;
				}
			}
			
			char f = (char)65;
			
			
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
