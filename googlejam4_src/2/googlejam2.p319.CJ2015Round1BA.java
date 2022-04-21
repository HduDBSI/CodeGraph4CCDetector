package googlejam2.p319;
import java.io.*;
import java.util.*;


public class CJ2015Round1BA {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("A-small-attempt1.in"));
		//BufferedReader in = new BufferedReader(new FileReader("temp.txt"));
		PrintWriter out  = new PrintWriter(new File("2015Round1BAout.txt"));
		int T = Integer.parseInt(in.readLine());
		Integer[] Ns = new Integer[T];
		for(int a = 0; a < T; a++){
			Ns[a] = Integer.parseInt(in.readLine());
		}
		List<Integer> okay = Arrays.asList(Ns);
		int N = Collections.max(okay);
		int[] nums = new int[N];
		for(int i = 0; i < N; i++){
			if (i==0){
				nums[i]=1;
			} else {
				int num = i+1;
				int reverse=0;
				while( num != 0 )
			    {
			        reverse = reverse * 10;
			        reverse = reverse + num%10;
			        num = num/10;
			    }
				if (reverse<i+1&&reverse>1&&String.valueOf(reverse).length()==String.valueOf(i+1).length()){
					nums[i]=Math.min(nums[i-1]+1,nums[reverse-1]+1);
				} else {
					nums[i]=nums[i-1]+1;
				}
			}
		}
		for(int i = 0; i < T; i++){
			out.println("Case #"+(i+1)+": "+nums[Ns[i]-1]);
		}
		in.close();
		out.close();
	}
}
