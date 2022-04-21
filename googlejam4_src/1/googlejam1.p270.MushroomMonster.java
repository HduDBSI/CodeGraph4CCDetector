package googlejam1.p270;
// Google Code Jam Round 1A 2015
// Problem A. Mushroom Monster

import java.util.*;
import java.io.*;

public class MushroomMonster{
	static String filename = "A-large";	// io filnename here
    static String inname = filename + ".in";    
    static String outname = filename + ".out";  
    static int n;
    public static void main(String[] args){
        try{
            Scanner in = new Scanner(new BufferedReader(new FileReader(inname)));
        	//Scanner in = new Scanner(System.in);
            BufferedWriter out = new BufferedWriter(new FileWriter(outname));
            int t = in.nextInt();
            in.nextLine();
            for (int cas = 1; cas <= t; cas++){
            	String ans = "";
            	int n = in.nextInt();
            	int[] m = new int[n];
            	for(int i = 0; i < n; i++) m[i] = in.nextInt();
            	int min1 = 0;
            	int min2 = 0;
            	for (int i = 0; i < n-1; i++)
            		if (m[i]-m[i+1] > 0) min1 += m[i]-m[i+1];
            	int minrate = m[0] - m[1];
            	for (int i = 0; i < n-1; i++)
            		if (m[i]-m[i+1] > minrate) minrate = m[i]-m[i+1];
            	for (int i = 0; i < n-1; i++)
            		min2 += Math.min(minrate, m[i]);
            	
            	ans = min1 + " " + min2;
                System.out.print("Case #" + cas + ": " + ans + "\n");
                out.write("Case #" + cas + ": " + ans + "\n");
            }
            in.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}