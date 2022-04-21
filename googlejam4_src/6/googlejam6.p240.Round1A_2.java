package googlejam6.p240;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;


public class Round1A_2 {
	public static void main(String args[]) throws FileNotFoundException, UnsupportedEncodingException{
		Scanner scan = new Scanner(System.in);
		PrintWriter out = new PrintWriter("output.txt", "UTF-8");
		
		System.out.println("Input Filename: ");
		String filename = scan.nextLine();
		try {scan = new Scanner(new File(filename));}
		catch(Exception e){
			System.out.println("Invalid File Input");
			return;
		}
		
		int sets = scan.nextInt();
		for(int k = 1; k <= sets; ++k){
			int n = scan.nextInt(); scan.nextLine();
			int files = (2*n) - 1;
			HashMap<Integer, Integer> soldiers = new HashMap<Integer, Integer>();
			for(int j = 0; j < files; ++j){
				for(int l = 0; l < n; ++l){
					int i = scan.nextInt();
					if(soldiers.containsKey(i)){
						soldiers.put(i, soldiers.get(i)+1);
					}
					else {
						soldiers.put(i, 1);
					}
				}
			}
			
			int[] missing = new int[n];
			int index = 0;
			Iterator entries = soldiers.entrySet().iterator();
			while(entries.hasNext()){
				Entry e = (Entry) entries.next();
				if((Integer)e.getValue() % 2 == 1){
					missing[index] = (Integer)e.getKey();
					index++;
				}
			
			}
			
			Arrays.sort(missing);
			out.print("Case #" +k +": ");
			for(int i = 0; i < n; ++i){
				out.print(missing[i]);
				if(i < n-1) out.print(" ");
			}
			out.println();
			
		}
		out.close();
	}
}
