package googlejam6.p284;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Solution2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		
		for(int i=0;i<t;i++)
		{
			int n = in.nextInt();
			int [][] arr = new int [2*n-1][n];
			for(int x=0;x<2*n-1;x++)
				for(int y=0;y<n;y++)
					arr[x][y]=in.nextInt();
			HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
			ArrayList<Integer> a = new ArrayList<Integer>();
			for(int i3=0;i3<2*n-1;i3++)
				for(int j=0;j<n;j++)
				{
					if(h.containsKey(arr[i3][j]))
						h.put(arr[i3][j],h.get(arr[i3][j])+1);
					else
						h.put(arr[i3][j],1);
				}
			Set<Integer> keyset = h.keySet();
			ArrayList<Integer> array = new ArrayList<Integer>(keyset);
			for(int i2=0;i2<array.size();i2++){
				if(h.get(array.get(i2))%2==1){
					a.add(array.get(i2));
				}
				
			}
			int[] newarr= new int[a.size()];
			for(int i4=0;i4<n;i4++)
				newarr[i4] = a.get(i4);
			Arrays.sort(newarr);
			System.out.print("Case #"+(i+1)+":");
			for(int i1=0;i1<newarr.length;i1++)
				System.out.print(" "+newarr[i1]);
			System.out.println();
		}
	}

}
