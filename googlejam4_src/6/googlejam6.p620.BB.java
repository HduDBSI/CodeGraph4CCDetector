package googlejam6.p620;
import java.io.*;
import java.util.*;

public class BB {
    
//    private static PrintWriter out;
    
    public static void main(String[] args) throws IOException{
	String filename = "B-large";
//	String filename = "1A/A-small";
//	out = new PrintWriter(new BufferedWriter(new FileWriter(filename + ".out")));
	System.setIn(new FileInputStream(filename + ".in"));
	Scanner in = new Scanner(System.in);
	int T = in.nextInt();		
	String line = in.nextLine();
	for(int z = 1; z <= T; z++){
	    System.out.print("Case #"+z+": ");
	    int N = in.nextInt();
	    line = in.nextLine();
	    HashSet nums = new HashSet(); 
	    for (int i = 0; i < (2 * N) - 1; i++) {
		for (int j = 0; j < N; j++) {
		    int num = in.nextInt();		    
		    if(nums.contains(num))
			nums.remove(num);
		    else
			nums.add(num);
		    
		    
		}		
	    }
	    TreeSet myTreeSet = new TreeSet();
	    myTreeSet.addAll(nums);
	    for (Object n : myTreeSet) {
		System.out.print(n);
		System.out.print(" ");
	    }
	    System.out.println("");
	}
	
//	out.close();
	System.exit(0);
    }
    
//    public static void print(String str){
//	System.out.print(str);
//	out.print(str);
//    }
//    public static void println(String str){
//	System.out.println(str);
//	out.println(str);
//    }
}
