package googlejam6.p087;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Round1B {
	public static void main(String[] args) {
			
	    Scanner sc = new Scanner(System.in);
	    int T = sc.nextInt();
	    sc.nextLine();
	    Writer writer = null;
	    try {
	        writer = new BufferedWriter(new OutputStreamWriter(
	              new FileOutputStream("filename.txt"), "utf-8"));
	        for(int k = 0;k < T; k ++){
	        	System.out.println(k);
	        	int N = sc.nextInt();
	 	        StringBuilder sb = new StringBuilder();
	     		HashSet<Integer> set = new HashSet<Integer>();
	 	        for(int i = 0; i < N*(2*N-1); i++){
	 	        	int t = sc.nextInt();
	 				if(set.contains(t))
	 					set.remove(t);
	 				else 
	 					set.add(t);
	 			}
	     		ArrayList<Integer> res = new ArrayList<Integer>();
	     		res.addAll(set);
	     		Collections.sort(res);
	     		for(int i = 0;i < res.size()-1;i ++){
	     			sb.append(res.get(i));
	     			sb.append(' ');
	     		}
	     		sb.append(res.get(res.size()-1));
	     		writer.write("Case #" + (k+1) + ": " + sb.toString()+"\n");
	        }
	       
	    } catch (IOException ex) {
	    } finally {
	       try {writer.close();} 
	       catch (Exception ex) {/*ignore*/}
	    }
	}
}
