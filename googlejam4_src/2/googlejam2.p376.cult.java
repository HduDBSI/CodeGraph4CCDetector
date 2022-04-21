package googlejam2.p376;
import java.util.Scanner;
import java.util.Arrays;
class cult
{

    public static void main(String[] args)
    {
	Scanner in=new Scanner(System.in);
	int ncase=in.nextInt();
	for(int icase=0;icase<ncase;icase++){
	    int icase1=icase+1;
	    int N=in.nextInt();	    
	    int count=0;
	    int [] num=new int[N+1];
	    int iR=0;

	    if(N<=20){
		count=N;
	    }else{
		for(int i=1;i<=20;i++)
		    num[i]=i;

		for(int i=21;i<=N;i++){
		    String str=Integer.toString(i);
			iR=Integer.valueOf(new StringBuffer(str).reverse().toString());
		    int min=i;

		    if(iR<i&&i%10!=0){

			if(num[iR]+1<min)
			    min=num[iR]+1;
		    }

		    for(int j=i-1;j>=i-10;j--)
			if(num[j]+(i-j)<min){
			    min=num[j]+(i-j);
			}
		    num[i]=min;
		}
		count=num[N];
	    }


	    System.out.println("Case #"+icase1+":"+" "+count);
	}
    }
}
