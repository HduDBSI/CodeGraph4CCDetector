package googlejam6.p440;
import java.io.*;
import java.util.*;

public class Q2 {
	private static int [] inputN;
	private static String [] inputH;
	
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(new FileReader("B-large.in"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		String tStr = sc.nextLine();
		int t = 0;
		try{
			t = Integer.parseInt(tStr);
		}catch(NumberFormatException nfe){
			nfe.printStackTrace();
		}
		
		inputH = new String[t];
		inputN = new int[t];
		for(int i3 = 0; i3 < t ; i3++){
			int input = 0;
			try{
				input = Integer.parseInt(sc.nextLine());
			}catch(NumberFormatException nfe){
				nfe.printStackTrace();
			}
			inputN[i3] = input;
			inputH[i3] = "";
			for(int j = 0; j< 2*inputN[i3] -1; j++)
				inputH[i3] += " " + sc.nextLine();
		}
		
		sc.close();
		//return in;
		
		String[] res = new String[inputN.length];
		
		for(int i = 0; i < inputN.length; i++){
			String [] input = inputH[i].trim().split(" ");
			System.out.println(Arrays.toString(input));
			ArrayList<Integer> l = new ArrayList<Integer>();
			for(String is : input){
				int input1 = 0;
				try{
					input1 = Integer.parseInt(is);
				}catch(NumberFormatException nfe){
					nfe.printStackTrace();
				}
				int v = input1;
				if(l.contains(new Integer(v))){
					l.remove(new Integer(v));
				}else{
					l.add(v);
				}
			}
			
			Integer [] miss = l.toArray(new Integer[0]);
			System.out.println(Arrays.toString(miss));
			int [] misslist = new int[miss.length];
			for(int i1 = 0; i1 < miss.length; i1++){
				misslist[i1] = miss[i1];
			}
			Arrays.sort(misslist);
			String res1 = "";
			for(int i2 : misslist){
				res1 += i2 + " ";
			}
			res[i] = res1; 
			System.out.println(res[i]);
		}
		
		File out = new File("testOut.txt");
		if(!out.exists()){
			try {
				out.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(out));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < res.length ; i++){
			pw.write("Case #" + (i+1) + ": "+ res[i] + "\n");
		}
		
		pw.close();
		
	}
}
