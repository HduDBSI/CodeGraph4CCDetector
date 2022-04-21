package googlejam6.p393;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Validgrid {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("B-large1.in"));
		//int [] tall = new int [100];
		int total = scanner.nextInt();
		
		System.out.println(total);
		
		FileWriter fw = new FileWriter("out.txt");
		for(int i=0;i<total;i++){
		   int n=scanner.nextInt();
		   int[][] grid=new int[2*n-1][n];
		   for(int k=0;k<2*n-1;k++)
			{
				for(int j=0;j<n;j++)
				{
					grid[k][j]=scanner.nextInt();
				}
			}
		int[] count= new int[2500];
		 ArrayList<Integer> obj1 = new ArrayList<Integer>();
		for(int i3=0;i3<2500;i3++)
			count[i3]=0;
		for(int i1=0;i1<2*n-1;i1++)
		{
			for(int j=0;j<n;j++)
			{
				count[grid[i1][j]-1]++;
			}
		}
		
		int k1=0;
		for(int i2=0;i2<2500;i2++)
		{
			if(count[i2]%2!=0)
				obj1.add(i2+1);
		}
		Collections.sort(obj1);
		   ArrayList<Integer> obj=obj1;
		   fw.write("Case #"+(i+1)+": ");
		   for(int k=0;k<n;k++)
		   {
			   
			   fw.write(obj.get(k)+" ");
		   }
		   fw.write("\n");     
			   
		  
		}
        fw.close();
		
	}
}
