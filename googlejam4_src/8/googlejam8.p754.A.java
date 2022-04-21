package googlejam8.p754;
import java.io.*;
import java.util.*;
class A
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for(int i=0;i<T;i++){
			System.out.print("Case #"+(i+1)+": ");
			int part=Integer.parseInt(in.readLine());
			String[] mem=in.readLine().split(" ");
			int totalmembers=0;
			for(int j=0;j<part;j++){
				totalmembers+=Integer.parseInt(mem[j]);
					}
			while(totalmembers!=0){
				int max=0;
				int num1=0;
				String ans="";
				for(int j=0;j<part;j++){
						if(max<Integer.parseInt(mem[j])){
							max=Integer.parseInt(mem[j]);
							num1=j;
							}
					}
				ans=""+(char)(65+num1);
				mem[num1]=Integer.toString(Integer.parseInt(mem[num1])-1);
				totalmembers-=1;
				for(int j=0;j<part;j++){
					double p=totalmembers;
					if(Double.parseDouble(mem[j])/p>0.5){
						ans+=(char)(65+j);
						mem[j]=Integer.toString(Integer.parseInt(mem[j])-1);
						totalmembers-=1;
						break;
					}
				}
			System.out.print(ans+" ");
		}
		System.out.println();	
		}
	}
}