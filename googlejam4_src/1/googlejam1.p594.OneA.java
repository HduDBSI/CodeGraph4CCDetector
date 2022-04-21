package googlejam1.p594;
import java.io.*;
import java.util.*;

public class OneA {
    public static void main(String[] args) throws IOException {
	BufferedReader r = new BufferedReader(new FileReader(args[0]));
	int T = Integer.parseInt(r.readLine());
	for (int i=0; i < T; i++) {
	    r.readLine();
	    String[] split = r.readLine().split(" ");
	    int[] input = new int[split.length];
	    for (int j=0; j < split.length; j++)
		input[j] = Integer.parseInt(split[j]);
		int total = 0;
		for (int i1=0; i1 < input.length-1; i1++)
		    if (input[i1+1]<input[i1])
			total += input[i1]-input[i1+1];
	    int res1 = total;
		int minRate = 0;
		for (int i2=0; i2 < input.length-1; i2++)
		    if (input[i2+1]<input[i2])
			minRate = Math.max(minRate, input[i2]-input[i2+1]);
		int minEaten = 0;
		for (int i1=0; i1 < input.length-1; i1++)
		    if (input[i1] < minRate)
			minEaten += input[i1];
		    else
			minEaten += minRate;
	    int res2 = minEaten;
	    System.out.println("Case #"+(i+1)+": "+res1 + " "+ res2);
	}
    }
}
