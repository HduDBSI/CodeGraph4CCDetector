package googlejam1.p745;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class F {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(new InputStreamReader(System.in));
		int T=s.nextInt();
		s.nextLine();
		
		for(int i=0;i<T;i++)
		{
			int m=s.nextInt();
			s.nextLine();
			int[] ints=new int[m];
			int max=0;
			int smax=0;
			for(int j=0;j<m;j++)
			{
				ints[j]=s.nextInt();
			}

			int rate=0;
			
			
			for(int k=0;k<m-1;k++)
			{
				if(ints[k+1]<ints[k])
				{
					max=ints[k];
					smax=ints[k+1];
					if(rate<(max-smax))
					{
						rate=max-smax;
					}
				}
			}
			if(rate<0)
				rate=0;
		
			int count2=0;
			//System.out.println("rate"+rate);
			for(int k=0;k<m-1;k++)
			{
				//int gap=ints[k]-ints[k+1];
				//if(gap>0)
				//{
				
					int b=0;
					if(ints[k]>=0)
						{
						if(ints[k]>rate)
							b+=rate;
						else
							b+=ints[k];
						}
					count2+=b;
					//System.out.println("b>"+b);
				//}
				
			}

			
			s.nextLine();
			
			//1
			int count=0;
			for(int k=m-1;k>0;k--)
			{
				int a=0;
				if((ints[k-1]-ints[k])>0)
					a=(ints[k-1]-ints[k]);
				count+=a;
				//System.out.println(a);
			}
			
		
//		System.out.println(smax+","+max);
		
		System.out.println("Case #"+(i+1)+": "+count+" "+count2);
		}
		}

}
