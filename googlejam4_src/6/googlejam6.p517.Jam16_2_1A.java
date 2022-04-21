package googlejam6.p517;
import java.io.*;
import java.util.*;

public class Jam16_2_1A {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[]args)throws Exception{
		int t=(int)getInt();
		
		for(int c=0;c<t;c++) {
			Set<Integer> s=new TreeSet<Integer>();
			ArrayList<Integer> arr=new ArrayList<Integer>();
			System.out.print("Case #"+(c+1)+": ");
			int n=(int)getInt();
			for(int i=0;i<(2*n-1);i++) {
				String arr1[]=br.readLine().split(" ");
				int a[]=new int[arr1.length];
				for(int i1=0;i1<a.length;i1++){
					a[i1]=Integer.parseInt(arr1[i1]);
				}
				int par[]=a;
				for(int j=0;j<n;j++) {
					s.add(par[j]);
					arr.add(par[j]);
				}
			}
			for(int i:s) {
				if(Collections.frequency(arr, i)%2==1) {
					System.out.print(i+" ");
				}
			}
			System.out.println();
		}
	}
	static long getInt()throws Exception{
		int n=Integer.parseInt(br.readLine());
		return n;
	}


}
