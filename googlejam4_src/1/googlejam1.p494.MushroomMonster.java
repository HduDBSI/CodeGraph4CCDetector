package googlejam1.p494;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class MushroomMonster {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub


		ArrayList<Integer> arraylist = new ArrayList<Integer>();
		int[] array;


		Scanner sc = new Scanner(new File("MushroomMonster.in"));
		//PrintWriter pw = new PrintWriter("StandingOvation.out");
		PrintWriter pw = new PrintWriter(new File("MushroomMonster.out"));
		//PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("StandingOvation.out")));

		int trials = sc.nextInt();

		for(int i = 0; i<trials;i++){
			int size = sc.nextInt();
			array = new int[size];

			for(int j=0; j<size; j++){
				array[j] = sc.nextInt();
				//System.out.println("" + array[j]);

			}
			int answer1 = 0;
			int difference = 0;
			int answer2 = 0;

			for(int k=0; k<size-1; k++){
				if(array[k] > array[k+1]) {
					answer1 += array[k] - array[k+1]; 
					if(array[k] - array[k+1] > difference) difference = array[k] - array[k+1];
				}
				//if(array[k] < array[k+1]) ;

			}
			
			for(int x=0; x<size-1; x++){
				if(array[x] >= difference) answer2 += difference;
				else answer2 += array[x];
				
				
			}
			


			System.out.println("Case #" + (i+1) + ": " + answer1 + " " + answer2);
			pw.println("Case #" + (i+1) + ": " + answer1 + " " + answer2);
			
			
		}
		
		pw.close();
		sc.close();
	}



}
