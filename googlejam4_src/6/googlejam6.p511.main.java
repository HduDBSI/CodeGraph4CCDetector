package googlejam6.p511;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class main {
	
	public static int[] numbers;
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("in.txt"));
			BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt", true));
			PrintWriter out = new PrintWriter(bw);
		    int cases = Integer.parseInt(br.readLine());
		    int caseNo = 1;
		    for(int i = 0; i < cases; i++) {
		    	int N = Integer.parseInt(br.readLine());
		    	numbers = new int[2501];
		    	for(int j = 0; j < (2*N)-1; j++) {
		    		String line = br.readLine();
		    		//System.out.println(line);
					for(String number: line.split(" ")) {
						int numberInt = Integer.parseInt(number);
						numbers[numberInt] = numbers[numberInt] + 1;
					}
					//System.out.println(Arrays.toString(numbers));
		    	}
		    	String answer = "";
		    	for(int k = 0; k < numbers.length; k++) {
		    		if(numbers[k] % 2 > 0) {
		    			answer = answer + k + " ";
		    		}
		    	}
		    	out.println("Case #" + caseNo + ": " + answer);
		    	caseNo++;
		    }
		    out.close();
		} catch(IOException e) {
			System.out.println("nooo");
		}
	}

}
