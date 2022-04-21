package googlejam1.p814;
import java.io.*;
import java.util.Scanner;
class Mushrooms{
	public static void main(String[]args) throws UnsupportedEncodingException,FileNotFoundException{
		FileInputStream fis = new FileInputStream("A-large.in") ;
		Scanner sc = new Scanner(fis);
		PrintWriter writer = new PrintWriter("out1.txt", "UTF-8");
		int t,x,i,j,n,plate[],eat,eat1,f;
		t=sc.nextInt();
		for(x=1;x<=t;x++){
			n=sc.nextInt();
			f=0;
			eat=0;
			eat1=0;
			plate = new int[n];
			plate[0]=sc.nextInt();
			for(i=1;i<n;i++){
				plate[i]=sc.nextInt();
				if(plate[i]<plate[i-1])
					eat+=plate[i-1]-plate[i];
			}
			for(i=1;i<n;i++){
				int a = plate[i-1]-plate[i];
				f=f>a?f:a;
			}
			for(i=0;i<n-1;i++){
				eat1+= plate[i]-f>=0?f:plate[i];
			}
			writer.println("Case #"+x+": "+eat+" "+eat1);
			
		}
		writer.close();
	}
}