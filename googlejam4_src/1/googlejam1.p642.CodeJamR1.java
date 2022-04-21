package googlejam1.p642;


import java.math.*;
import java.io.*;
import java.util.*;
import javax.swing.*;


@SuppressWarnings("unused")
public class CodeJamR1 {
	private static String in;
	private static String out;
	public static void main(String[] args) throws IOException{


		BufferedReader inputStream = new BufferedReader(new FileReader("in.txt"));
		BufferedWriter outputStream = new BufferedWriter(new FileWriter("out.txt"));
		in = inputStream.readLine();
		int testCaseNum = Integer.parseInt(in);
		for(int i = 0; i < testCaseNum; i++){
		    in = inputStream.readLine();
		    int size = Integer.parseInt(in);
		    int[] array = new int[size];
		    in = inputStream.readLine();
		    String[] split = in.split(" ");
		    int last = 0;
		    int count1 = 0;
		    double rate = 0;
		    for(int j = 0; j < (size-1); j++){
		        if( Integer.parseInt(split[j]) - Integer.parseInt(split[j+1]) > 0 ) {
		            count1 += Integer.parseInt(split[j]) - Integer.parseInt(split[j+1]);
		        }
		        if( ( Integer.parseInt(split[j]) - Integer.parseInt(split[j+1]) > rate ) ) {
		            rate = Integer.parseInt(split[j]) - Integer.parseInt(split[j+1]);
		        }
		    }
		    int count2 = 0;
		    for(int j = 0; j < (size-1); j++){
		        if( Integer.parseInt(split[j]) < rate )
		            count2 += Integer.parseInt(split[j]);
		        else
		            count2 += rate;
		    }
		   outputStream.write("Case #" + (i+1) + ": " + count1 + " " + (int)count2);
		   outputStream.newLine();
		   }
		inputStream.close();
		outputStream.close();


	}
} //END COMPETITION CLASS
