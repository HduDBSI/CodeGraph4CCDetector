package googlejam1.p482;
import java.util.*;

class A{

public static void main(String[] args){

	Scanner sc = new Scanner(System.in);
	int kase = sc.nextInt();
	for(int k = 1; k<=kase; k++){
		int N =sc.nextInt();
		int[] mush = new int[N];
		int max = 0;
		int p1 = 0;
		for (int i = 0; i<N; i++){
			mush[i] = sc.nextInt();
			if(i>0 && max < mush[i-1]-mush[i]) max = mush[i-1]-mush[i];
			if(i>0 && (mush[i-1]-mush[i])>0) p1+= mush[i-1]-mush[i];
		}
		int p2 = 0;
		for (int i = 0; i<N-1; i++){
			if(mush[i]<max) p2+= mush[i];
			else p2+= max;
		}
		System.out.println("Case #"+k+": "+p1+" "+p2);
	}
}
}

