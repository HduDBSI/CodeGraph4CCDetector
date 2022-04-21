package googlejam8.p659;
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
			int parties=Integer.parseInt(in.readLine());
			String[] Members=in.readLine().split(" ");
			int total=0;
			for(int j=0;j<parties;j++){
				total+=Integer.parseInt(Members[j]);
					}
			while(total!=0){
				int first=0;
				int second=-1;
				int num1=0;
				int num2=0;
				String ans="";
				for(int j=0;j<parties;j++){
						if(first<Integer.parseInt(Members[j])){
							second=first;
							first=Integer.parseInt(Members[j]);
							num2=num1;
							num1=j;
							}
						else
							{
								if(second<Integer.parseInt(Members[j])){
									second=Integer.parseInt(Members[j]);
									num2=j;
								}
							}
					}
				ans=""+(char)(65+num1);
				Members[num1]=Integer.toString(Integer.parseInt(Members[num1])-1);
				total-=1;
				String ans2="";
				for(int j=0;j<parties;j++){
					double p=total;
					if(Double.parseDouble(Members[j])/p>0.5){
						ans+=(char)(65+j);
						Members[j]=Integer.toString(Integer.parseInt(Members[j])-1);
						total-=1;
						break;
					}
				}
			System.out.print(ans+" ");
		}
		System.out.println();
				
				
			
			
		}
	}
}