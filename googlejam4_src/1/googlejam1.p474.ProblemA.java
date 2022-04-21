package googlejam1.p474;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class ProblemA {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO READER		
		//BufferedReader br= new BufferedReader(new FileReader("bum.in"));
		//BufferedReader br= new BufferedReader(new FileReader("A-small-attempt0.in"));
		BufferedReader br= new BufferedReader(new FileReader("A-large.in"));
		PrintWriter pw = new PrintWriter("ProblemA.txt", "UTF-8");
		int T=Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++){
			int L = Integer.parseInt(br.readLine());
			String[] tab =br.readLine().split(" ");
			int[] arr = new int[tab.length];
			for(int j=0;j<tab.length;j++){
				arr[j]=Integer.parseInt(tab[j]);
			}
			

			int x=0;
			int y=0;
			int previous = 0;
			int max=0;
			for(int m:arr){
				if(m<previous)x+=previous-m;
				if(max<previous-m)max=previous-m;
				previous=m;
			}
			System.out.println(max);
			//if(max%10!=0)max=((max/10)+1)*10;
			for(int j=0;j<arr.length-1;j++){
				int m=arr[j];
				if(max<m)y+=max;
				else y+=m;
			}
			
			
			
			
			System.out.print("Case #"+(i+1)+": "+x+" "+y+"\n");
			pw.write("Case #"+(i+1)+": "+x+" "+y+"\n");

		}
		pw.close();
	}
}
