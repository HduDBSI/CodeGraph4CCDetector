package googlejam6.p453;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_B {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    String s;
	    try {
	    	s = in.readLine();
	    	int case_num = Integer.parseInt(s);
	    	for (int kk = 0; kk < case_num; kk++) {
	    		s = in.readLine();
	    		int num = Integer.parseInt(s);
	    		
	    		int[] count = new int [2500];
//	    		System.out.println(count[2500]);
	    		for (int row = 0; row < (2*num-1); row++) {
	    			s = in.readLine();
	    			String[] height = s.split(" ");
	    			
	    			for (int i = 0; i < height.length; i++) {
//	    				System.out.print(height[i]);
						count[Integer.parseInt(height[i])-1]++;
					}
//	    			System.out.println();
	    		}
	    		
	    		String ans = "";
	    		
	    		for (int i = 0; i < count.length; i++) {
//	    			System.out.println((i+1)+" "+count[i]);
					if (count[i]%2!=0) {
						ans = ans + " " + (i+1);
					}
				}
	    		
	    		System.out.println("Case #"+(kk+1)+":"+ans);
	    	}
			
	    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
