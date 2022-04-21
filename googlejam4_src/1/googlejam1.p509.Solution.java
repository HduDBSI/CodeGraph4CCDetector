package googlejam1.p509;
import java.io.*;
import java.util.*;
import java.lang.*;

public class Solution {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int cases = Integer.parseInt(br.readLine().trim());
			int inputs;
			String[] data;
			int[] mushrooms;
			int max1,max2,previous,current,tempdiff;
			int rate;
			for (int i = 1; i <= cases; i++) {
				inputs = Integer.parseInt(br.readLine().trim());
				data = br.readLine().trim().split(" ");
				max1=0;
				max2=0;
				previous=Integer.parseInt(data[0]);
				current=-1;
				mushrooms = new int[inputs];
				for (int j = 1; j<inputs; j++) {
					current=Integer.parseInt(data[j]);
					tempdiff=0;
					if (current < previous) {
						tempdiff = previous - current;
					}
					max1 += tempdiff;
					if (tempdiff > max2) {
						max2 = tempdiff;
					}
					mushrooms[j-1]=previous;
					previous = current;
				}
				mushrooms[inputs-1] = previous;

				rate = max2;
				max2=0;

				for (int j = 0; j < inputs-1; j++) {
					if (mushrooms[j] < rate) {
						max2+=mushrooms[j];
					}
					else {
						max2+=rate;
					}
				}

				System.out.println("Case #"+i+": "+max1+" "+max2);
			}
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}