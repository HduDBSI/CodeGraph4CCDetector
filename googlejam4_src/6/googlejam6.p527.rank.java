package googlejam6.p527;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class rank {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader f = new BufferedReader(new FileReader("C:/Users/John/Documents/Java/2016/der.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("C:/Users/John/Documents/Java/2016/outlarge.out")));
		int cases = Integer.parseInt(f.readLine());
		
		for(int q = 0; q< cases; q++){
		int n = Integer.parseInt(f.readLine());
		List<Integer> master =new ArrayList<Integer>();
		List<Integer> solution =new ArrayList<Integer>();
		
		for(int w = 0; w < (n+n-1); w++){
			String in = f.readLine();
			String[] parts = in.split(" ");
			for(int i= 0; i<parts.length; i++){
				master.add(Integer.parseInt(parts[i]));
			}
		}
		
		System.out.println(master);
		do{
			if(master.size()==1){
				solution.add(master.get(0));
				System.out.println("IN HERE" + master);
				break;
			}
			int j = master.get(0);
			master.remove(0);
			if(master.contains(j)){
				for(int p = 0; p <master.size();p++){
					if(master.get(p).equals(j)){
						master.remove(p);
						break;
					}
				}
			}else{
				solution.add(j);
			}
		}while(master.size()!=0);
		Collections.sort(solution);
		System.out.println(solution);
		String output1 = "";
		for(int y = 0; y< solution.size();y++){
			if((y+1)==solution.size()){
				output1 = output1 + solution.get(y);
				break;
			}
			output1 = output1 + solution.get(y) + " ";
		}
		out.write("Case #" + (q+1) + ": " + output1);
		if((q+1)!=cases){
			out.write("\n");
		}
		}
		out.close();
		f.close();
	}

}
