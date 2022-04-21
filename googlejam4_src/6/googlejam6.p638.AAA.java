package googlejam6.p638;
//trashcansaretasty
/* 
import java.io.*;
import java.util.*;


public class AAA {
	static final String FILENAME = "A-small-attempt0";
	static BufferedReader in; static StringTokenizer st; static PrintWriter out;
	static void newST() throws IOException {st = new StringTokenizer(in.readLine());}
	static int stInt() {return Integer.parseInt(st.nextToken());}
	static int readInt() throws IOException {return Integer.parseInt(in.readLine());}
	static void println(Object o) {System.out.println(o);} static void println() {System.out.println();} static void print(Object o) {System.out.print(o);}
    public static void main(String[] args) throws IOException {
    	in = new BufferedReader(new FileReader(FILENAME+".in.txt"));
		//out = new PrintWriter(new BufferedWriter(new FileWriter(FILENAME+".out.txt")));
    	out = new PrintWriter(new BufferedWriter(new FileWriter("@generic.out.txt")));	
		//out = new PrintWriter(System.out, true);
		
		int TC = readInt();
		for (int tc = 1; tc <= TC; tc++) {
			out.print("Case #"+tc+": ");
			solve();
		}
		in.close();
		out.close();
    }
    static void solve() throws IOException {
    	long n = readInt();

    	out.println(n);
    }
}
*/

/*
import java.io.*;
import java.math.*;
import java.util.*;


public class AAA {
	static final String FILENAME = "A-small-attempt0";
	static BufferedReader in; static StringTokenizer st; static PrintWriter out;
	static void newST() throws IOException {st = new StringTokenizer(in.readLine());}
	//String str = in.readLine();
	//int n = str.length();
	static int stInt() {return Integer.parseInt(st.nextToken());}
	//newST();
	//int K = stInt(), C = stInt(), S = stInt();
	static int nextInt() throws IOException {return Integer.parseInt(in.readLine());}
	static long nextLong() throws IOException {return Long.parseLong(in.readLine());}
	static double nextDouble() throws IOException {return Double.parseDouble(in.readLine());}
	static BigInteger BigInt(int n) throws IOException {return new BigInteger(Integer.toString(n));}
	//ans = ans.multiply(bigInt(K)).add(bigInt(i%K));
	//ans = BigInteger.ZERO;
	//ans = ans.add(BigInteger.ONE);
	
	static void println(Object o) {System.out.println(o);} static void println() {System.out.println();} static void print(Object o) {System.out.print(o);}
    public static void main(String[] args) throws IOException {
    	in = new BufferedReader(new FileReader(FILENAME+".in.txt"));
    	out = new PrintWriter(new BufferedWriter(new FileWriter("@generic.out.txt")));	
    	//out = new PrintWriter(new BufferedWriter(new FileWriter(FILENAME+".out.txt")));
		//out = new PrintWriter(System.out, true);
		
		int TC = nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			out.print("Case #"+tc+": ");
			solve();
		}
		in.close();
		out.close();
    }
    static void solve() throws IOException {
    	//long n = nextInt();
    	String str = in.readLine();

    	
    	out.println(str);
    }
}*/

/*
//exo1
import java.io.*;
import java.math.*;
import java.util.*;


public class AAA {
	static final String FILENAME = "A-large";
	static BufferedReader in; static StringTokenizer st; static PrintWriter out;
	static void newST() throws IOException {st = new StringTokenizer(in.readLine());}
	//String str = in.readLine();
	//int n = str.length();
	static int stInt() {return Integer.parseInt(st.nextToken());}
	//newST();
	//int K = stInt(), C = stInt(), S = stInt();
	static int nextInt() throws IOException {return Integer.parseInt(in.readLine());}
	static long nextLong() throws IOException {return Long.parseLong(in.readLine());}
	static double nextDouble() throws IOException {return Double.parseDouble(in.readLine());}
	static BigInteger BigInt(int n) throws IOException {return new BigInteger(Integer.toString(n));}
	//ans = ans.multiply(bigInt(K)).add(bigInt(i%K));
	//ans = BigInteger.ZERO;
	//ans = ans.add(BigInteger.ONE);
	
	static void println(Object o) {System.out.println(o);} static void println() {System.out.println();} static void print(Object o) {System.out.print(o);}
    public static void main(String[] args) throws IOException {
    	in = new BufferedReader(new FileReader(FILENAME+".in.txt"));
    	out = new PrintWriter(new BufferedWriter(new FileWriter("@generic.out.txt")));	
    	//out = new PrintWriter(new BufferedWriter(new FileWriter(FILENAME+".out.txt")));
		//out = new PrintWriter(System.out, true);
		
		int TC = nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			out.print("Case #"+tc+": ");
			solve();
		}
		in.close();
		out.close();
    }
    static void solve() throws IOException {
    	//long n = nextInt();
    	String str = in.readLine();
    	
    	String lastWord = ""+ str.charAt(0);
    	
    	
    	for (int i=1 ; i<str.length() ; i++ ){
    		if (lastWord.charAt(0) <= str.charAt(i)){
    			lastWord = str.charAt(i) + lastWord ;
    		}
    		else{
    			lastWord = lastWord + str.charAt(i)  ;

    		}
    	}
    	
    	
    			
    	out.println(lastWord);
    }
}

*/
//exo2
import java.io.*;
import java.math.*;
import java.util.*;


public class AAA {
	static final String FILENAME = "B-large";
	static BufferedReader in; static StringTokenizer st; static PrintWriter out;
	public static void main(String[] args) throws IOException {
    	in = new BufferedReader(new FileReader(FILENAME+".in.txt"));
    	out = new PrintWriter(new BufferedWriter(new FileWriter("@generic.out.txt")));	
    	//out = new PrintWriter(new BufferedWriter(new FileWriter(FILENAME+".out.txt")));
		//out = new PrintWriter(System.out, true);
		
		int TC = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			out.print("Case #"+tc+": ");
			//long n = nextInt();
			//String str = in.readLine();
			int N = Integer.parseInt(in.readLine()); 
			
			HashMap <String, Integer> men = new HashMap();
			
			for (int i = 0 ; i < 2*N-1; i++)
			{
				String[] str = in.readLine().split(" ");  //lit la ligne
				
				for (int c = 0; c< str.length ;c++ ){
					if (men.containsKey(str[c])){
						men.put(str[c],men.get(str[c]) + 1);
					}
					else
					{
						men.put(str[c],1);
					}
				}
			}
			
			
			//print the content of hashmap
			ArrayList<Integer> result = new  ArrayList<Integer>();
			Set set = men.entrySet();
			Iterator i = set.iterator();
			while(i.hasNext()) {
			    Map.Entry me = (Map.Entry)i.next();
			    if ( (int) me.getValue() % 2 ==1){
			    	//System.out.print(me.getKey() + ": ");
			    	//System.out.println(me.getValue());
			    	result.add(Integer.parseInt((String) me.getKey()));
			    }
			}
			//System.out.println();
			
			Collections.sort(result);
			
			for(int res : result){
				System.out.println(res);
				out.print(res +" ");
			
			}
			out.println();
		}
		in.close();
		out.close();
    }
}

//exo3




/*import java.io.*;
import java.math.*;
import java.util.*;

import org.omg.CORBA.Current;


public class AAA {
	static final String FILENAME = "A-small-attempt0";
	static BufferedReader in; static StringTokenizer st; static PrintWriter out;
	static void newST() throws IOException {st = new StringTokenizer(in.readLine());}
	//String str = in.readLine();
	//int n = str.length();
	static int stInt() {return Integer.parseInt(st.nextToken());}
	//newST();
	//int K = stInt(), C = stInt(), S = stInt();
	static int nextInt() throws IOException {return Integer.parseInt(in.readLine());}
	static long nextLong() throws IOException {return Long.parseLong(in.readLine());}
	static double nextDouble() throws IOException {return Double.parseDouble(in.readLine());}
	static BigInteger BigInt(int n) throws IOException {return new BigInteger(Integer.toString(n));}
	//ans = ans.multiply(bigInt(K)).add(bigInt(i%K));
	//ans = BigInteger.ZERO;
	//ans = ans.add(BigInteger.ONE);
	
	static void println(Object o) {System.out.println(o);} static void println() {System.out.println();} static void print(Object o) {System.out.print(o);}
    public static void main(String[] args) throws IOException {
    	in = new BufferedReader(new FileReader(FILENAME+".in.txt"));
    	out = new PrintWriter(new BufferedWriter(new FileWriter("@generic.out.txt")));	
    	//out = new PrintWriter(new BufferedWriter(new FileWriter(FILENAME+".out.txt")));
		//out = new PrintWriter(System.out, true);
		
		int TC = nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			out.print("Case #"+tc+": ");
			solve();
		}
		in.close();
		out.close();
    }
    static void solve() throws IOException {
    	System.out.println();
    	//long n = nextInt();
    	//String str = in.readLine();
    	int N = nextInt(); 
    	
        HashMap <String, String> men = new HashMap<String, String>();

        //I put all the data in a hashmap
    	String[] str = in.readLine().split(" ");  //lit la ligne
    	for (int c = 1; c<= N ;c++ ){
    		men.put(Integer.toString(c),str[c-1]);
    	}
    	
    	//I check one by one.
    	String cur = "";
    	int maximum = 0 ;
    	for (int current = 1 ; current <=N ; current++){
    		System.out.print(current + ": ");

    		int tmp_maximum = 0;
    		cur = Integer.toString(current); // just to convert;
    		HashMap <String, String> tmp = new HashMap<String, String>(men);
    		HashSet <String> already = new HashSet <String>();
    		while (tmp.containsKey(cur)){
    			String old_cur = cur;
    			cur = tmp.get(cur);
    			tmp.remove(old_cur);

    			//if (already.contains(cur) == false){
    				tmp_maximum ++;
    			//}
    			System.out.print(" " + cur+" ");
    			already.add(cur);
    		}
    		System.out.println();
    		maximum = Math.max(maximum,tmp_maximum );

    	}
		out.println(maximum);
    	
 
        
    }
}

*/