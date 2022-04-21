package googlejam1.p827;
import java.util.Scanner;
import java.util.Arrays;
class mush
{
    public static void main(String[] args)
    {
	Scanner in=new Scanner(System.in);
	int ncase=in.nextInt();
	for(int icase=0;icase<ncase;icase++){
	    int icase1=icase+1;
	    int N=in.nextInt();
	    int[] mush=new int[N];
	    for(int i=0;i<N;i++)
		mush[i]=in.nextInt();

	    int imeth1=0;
	    int imeth2=0;	    
	    for(int i=0;i<N-1;i++){
		if(mush[i]>mush[i+1]){
		    int dif=mush[i]-mush[i+1];
		    imeth1+=dif;
		}
		imeth2+=mush[i];
	    }
	    if(imeth2>=mush[N-1]){
		imeth2=imeth2-mush[N-1];
	    }

	    int rate=0;

	    for(int i=1;i<N;i++){
		if(mush[i-1]>mush[i]){
		    int eaten=mush[i-1]-mush[i];
		    int r=eaten;
		    if(r>rate)
			rate=r;
		}

	    }
	    
	    imeth2=0;

	    if(rate!=0){
		for(int i=0;i<N-1;i++){
		    if(mush[i]>=rate){
			imeth2+=rate;
		    }else{
			imeth2+=mush[i];
		    }
		}
	    }
	    

	    System.out.println("Case #"+icase1+":"+" "+imeth1+" "+imeth2);
	}
    }
}
