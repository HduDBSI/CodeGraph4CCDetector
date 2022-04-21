package googlejam1.p027;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class A {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("A-large.in"));
		int T = sc.nextInt();
		for(int testC = 1; testC<=T; ++testC)
		{
			int N = sc.nextInt();
			int[] data = new int[N];
			for(int i=0; i<N; ++i)
				data[i]=sc.nextInt();
			int max_dif=0, total_dif=0;
			for(int i=0; i<N-1; ++i)
			{
				if(data[i]-data[i+1]>max_dif)
					max_dif=data[i]-data[i+1];
				if(data[i]-data[i+1]>0)
					total_dif+=data[i]-data[i+1];				
			}
			int total=0;
			for(int i=0; i<N-1; ++i)
			{
				if(data[i]<max_dif)
					total+=data[i];
				else
					total+=max_dif;				
			}
			System.out.printf("Case #%d: %d %d\n", testC, total_dif, total);
			
			
		}
		
	}
}
