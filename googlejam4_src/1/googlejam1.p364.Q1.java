package googlejam1.p364;
import java.util.*;
import java.io.*;
import java.lang.Math;
import java.math.*;

public class Q1{
	public static void main(String args[]){
		File f = new File(args[0]);
		try{
			Scanner s = new Scanner(f);
			int time = Integer.parseInt(s.next());
			PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
			for(int in = 1; in <= time; in++) {
				int timeslots = Integer.parseInt(s.next());
				int[] mushrooms = new int[timeslots];
				for(int m = 0; m < timeslots; m ++){
					mushrooms[m] = Integer.parseInt(s.next());
				}
				int eat = 0;
				int prev = mushrooms[0];
				for(int i : mushrooms){
					if(i >= prev){
						prev = i;
					} else {
						eat += (prev - i);
						prev = i;
					}
				}
				int m1 = eat;
				int interval = 0;
				int eat1 = 0;
				int prev1 = mushrooms[0];
				for(int i2 = 1; i2<mushrooms.length;i2++){
					if(mushrooms[i2] < prev1){
						if(prev1 - mushrooms[i2] > interval){
							interval = prev1 - mushrooms[i2];
						}
					} 
					prev1 = mushrooms[i2];
				}
				
				for(int i1 = 0; i1 < mushrooms.length - 1; i1++){
					if(mushrooms[i1] <= interval){
						eat1 += mushrooms[i1]; // eat up;
					} else {
						eat1 += interval;
					}
				}
				int m2 = eat1;
				System.out.println("Finished: " + in);
				writer.println("Case #" + in + ": " + m1 + " " + m2);
			}
			writer.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
