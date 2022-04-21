package googlejam8.p462;
import java.util.Scanner;

public class round3a {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int T = input.nextInt();
		for (int n = 0; n < T; n++)
		{
			int N = input.nextInt();
			char[] chars={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
			int[] strength=new int[N];
			int total=0;
			for(int i=0;i<N;i++)
			{
				strength[i]=input.nextInt();
				total+=strength[i];
			}
			String str="";
			int count=0;
			while(total>0)
			{
				double[] per=new double[N];
				for(int i=0;i<N;i++)
				{
					per[i]=((double)strength[i])/total;
				}
				//remove first
				int maxpos=0;
				for(int i=0;i<N;i++)
				{
					if(strength[i]>strength[maxpos])
					{
						maxpos=i;
					}
				}
			if(count==0)
				{str=str+chars[maxpos];
				strength[maxpos]--;
				total--;}
			if(count==1)
			{
				strength[maxpos]--;
				total--;
				double[] newper=new double[N];
				for(int i=0;i<N;i++)
				{
					newper[i]=((double)strength[i])/total;
				}
				boolean b=false;
				for(int i=0;i<N;i++)
				{
					if(newper[i]>.5)
					{
						b=true;
					}
				}
				if(b)
				{
					strength[maxpos]++;
					total++;
				}
				else	
				{
					str=str+chars[maxpos];
				}
				
					str=str+" ";
					count=-1;
				}
				count++;
			}
			System.out.println("Case #"+(n+1)+": "+str);
		}
	}
}
