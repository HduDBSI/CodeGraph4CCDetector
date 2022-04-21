package googlejam1.p731;
import java.util.*;
import java.io.*;


public class Mushrooms {
  public static void main(String[]args) throws Exception {
    Scanner scanz = new Scanner(new FileReader("A-large.in"));
    PrintWriter printz = new PrintWriter(new FileWriter("out.txt"));
    int total = scanz.nextInt();
    int[]shrooms;
    int first;
    int second;
    for (int x = 0; x < total; x++) {
      shrooms = new int [scanz.nextInt()];
      for (int z = 0; z < shrooms.length; z++) {
        shrooms[z] = scanz.nextInt();
      }
	int eaten = 0;
	for (int z = 1; z < shrooms.length; z++) {
	  if (shrooms[z] < shrooms[z-1]) 
	    eaten += shrooms[z-1] - shrooms[z];
	}
      first = eaten;
	int eaten1 = 0;
	int rate = 0;
	for (int z = 1; z < shrooms.length; z++) {
	  if ((shrooms[z-1] - shrooms[z]) > rate) 
	    rate = (shrooms[z-1] - shrooms[z]);
	}
	//System.out.println(rate);
	for (int z = 0; z < shrooms.length-1; z++) {
	  if (rate >= shrooms[z])
	    eaten1 += shrooms[z];
	  else
	    eaten1 += rate;
	}
      second = eaten1;
      printz.println("Case #" + (x+1) + ": " + first + " " + second);
      
    }
    printz.close();
  }
}