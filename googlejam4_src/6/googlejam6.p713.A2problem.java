package googlejam6.p713;
import java.lang.*;
import java.util.*;
import java.text.*;
import java.io.*;

public class A2problem {

	public static void main(String[] args) throws IOException {
		String filename = args.length > 0 ? args[0] : "A2\\B-large.in";
		File fout = new File("A2\\resultL.txt");
		PrintStream out = new PrintStream(fout);

		Scanner in = new Scanner(new File(filename));
		String text = in.next();
		int N = Integer.parseInt(text);

		try{
		for (int i = 0; i < N; i++) {

			String ma = in.next();
			int nn = Integer.parseInt(ma);

			int nums[] = new int[(2 * nn - 1)*nn];
			int k=0;
			
			for (int j = 0; j < nums.length; j++) {
				ma = in.next();
				nums[k++] = Integer.parseInt(ma);
			}
			Arrays.sort(nums);
			int max = nums[nums.length-1];
			int count[] = new int[max];
			int count1[] = new int[max];
			
			for(int i3=0;i3<nums.length; i3++){
				count[nums[i3]-1]++;
			}
			
			for(int i1=0;i1<count.length; i1++){
				if(count[i1] % 2 == 1 ){ count1[i1] = 1; }
			}
			
			String s = "";
			for(int i2=0;i2<count1.length; i2++){
				if(count1[i2] == 1 ){ s += i2+1 + " "; }
			}

			String outRes = s;
			out.println("Case #" + (i + 1) + ": " + outRes);
			System.out.println("Case #" + (i + 1) + ": " + outRes);
		}
		}catch(Exception ex){
			System.out.println(ex);
		}
	}
}
