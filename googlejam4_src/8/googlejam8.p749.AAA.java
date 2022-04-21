package googlejam8.p749;
//trashcansaretasty



//EXTRA
//==============================================================================





/*
//exo2
    //static void solve() throws IOException {
    	
    	
    	//ArrayList <String> possible_res_str0 = new ArrayList <String> ();
    	ArrayList <String> possible_res_str1 = new ArrayList <String> ();
    	
    	
    	
    	String [] str = in.readLine().split(" ");
    	String str0 = str[0];
    	String str1 = str[1];
    	
    	String res_str0 = "";
    	String res_str1 = "";
    	
    	String compare = "equal";
    	
    	for (int i = 0 ; i < str0.length() ; i++){    		
    		if (str0.charAt(i) != '?' && str1.charAt(i) != '?')
    			if (str0.charAt(i) < str1.charAt(i)){
    				compare = "str1bigger";
        			res_str0 += str0.charAt(i);
        			res_str1 +=  str1.charAt(i);
    			}
    			else if (str0.charAt(i) > str1.charAt(i)){
    				compare = "str0bigger";
        			res_str0 += str0.charAt(i);
        			res_str1 +=  str1.charAt(i);
    			}
    			else{
    				compare = "equal";
        			res_str0 += str0.charAt(i);
        			res_str1 +=  str1.charAt(i);
    			}
    			
    		
    		if (str0.charAt(i) == '?' && str1.charAt(i) == '?' && compare == "equal")
    		{
    			res_str0 += "" + "0";
    			res_str1 += "" + "0";
    		}
    		
    		if (str0.charAt(i) == '?' && str1.charAt(i) == '?' && compare == "str0bigger")
    		{
    			res_str0 += "" + "0";
    			res_str1 += "" + "9";
    		}
    		
    		if (str0.charAt(i) == '?' && str1.charAt(i) == '?' && compare == "str1bigger")
    		{
    			res_str0 += "" + "9";
    			res_str1 += "" + "0";
    		}
    		
    		if (str0.charAt(i) == '?' && str1.charAt(i) != '?' && compare == "equal")
    		{
    			possible_res_str1.add(res_str0 + str1.charAt(i));
    			possible_res_str1.add(res_str0+1 + str1.charAt(i));
    			
    			possible_res_str0.add(res_str1 + str1.charAt(i));
    			
    			
    			res_str0 += "" + str1.charAt(i);
    			//res_str0 += "" + str1.charAt(i);
    			
    			res_str1 += "" + str1.charAt(i);
    		}
    		
    		if (str0.charAt(i) != '?' && str1.charAt(i) == '?' && compare == "equal")
    		{
    			//if (i != str0.length()-1 && (str0.charAt(i+1) - str1.charAt(i+1) > 5)) {	
    			res_str0 += "" + str0.charAt(i);
    			res_str1 += "" + str0.charAt(i);
    		}
    		
    		
    		
    		if (str0.charAt(i) == '?' && str1.charAt(i) != '?' && compare == "str0bigger")
    		{
    			res_str0 += "" + 0;
    			res_str1 += "" + str1.charAt(i);
    		}
    		
    		if (str0.charAt(i) != '?' && str1.charAt(i) == '?' && compare == "str0bigger")
    		{
    			res_str0 += "" + str0.charAt(i);
    			res_str1 += "" + 9;
    		}
    		
    		if (str0.charAt(i) == '?' && str1.charAt(i) != '?' && compare == "str1bigger")
    		{
    			res_str0 += "" + 9;
    			res_str1 += "" + str1.charAt(i);
    		}
    		
    		if (str0.charAt(i) != '?' && str1.charAt(i) == '?' && compare == "str1bigger")
    		{
    			res_str0 += "" + str0.charAt(i);
    			res_str1 += "" + 0;
    		}
    
    	}
    	

    	out.print(res_str0);
    	out.print(" ");
    	out.print(res_str1);
    	out.println();

        
    }
}*/

//exo3
/*
import java.io.*;
import java.math.*;
import java.util.*;


public class AAA {
	static final String FILENAME = "C-small-attempt2.in";
	//static final String FILENAME = "@Given-input.in.txt";

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
    	in = new BufferedReader(new FileReader(FILENAME));
    	
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
    	//System.out.println();
    	long n = nextInt();
    	HashMap<String, String> mapone = new  HashMap<String, String>();
    	HashMap<String, String> maptwo = new  HashMap<String, String>();
    	
    	long result = 0;
    	
    	for (int i = 0 ; i < n ; i++){
        	String [] str = in.readLine().split(" ");
        	String str0 = str[0];
        	String str1 = str[1];
        	
        	if (mapone.containsKey(str0) && maptwo.containsKey(str1)){
        		result++;
        	}
        	
        	mapone.put(str0, "");
        	maptwo.put(str1, "");
        	
        	//System.out.println(str0);
        	//System.out.println(str1);
        	
    	}
    	result = n - Math.max(mapone.size(), maptwo.size());
    	out.println(result);
    }
}
*/

//exo1
/*
import java.io.*;
import java.math.*;
import java.util.*;

import org.omg.CORBA.Current;


public class AAA {
	static final String FILENAME = "A-large.in";
	//static final String FILENAME = "@Given-input.in.txt";
	
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
  	in = new BufferedReader(new FileReader(FILENAME));
  	out = new PrintWriter(new BufferedWriter(new FileWriter("@generic.out.txt")));	
  	//out = new PrintWriter(new BufferedWriter(new FileWriter(FILENAME+".out.txt")));
		//out = new PrintWriter(System.out, true);
		
		int TC = nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			out.print("Case #"+tc+": ");
			solve();
			out.println();
		}
		in.close();
		out.close();
  }
  static void solve() throws IOException {
  	//long n = nextInt();
  	String str = in.readLine();
  	
  	ArrayList <Character> list1 = new ArrayList<Character>();

  	for (int i=0 ; i < str.length() ; i++ ){
  		list1.add(str.charAt(i));
  	}
  	
  	
  	int [] numbers = new int[10];
  	String result ="";
  	int counter = 0;
  	
  	//ZERO
  	while (list1.indexOf('Z') >= 0 ){
  		numbers[0] ++;
  		list1.remove(list1.indexOf('Z'));
  		list1.remove(list1.indexOf('E'));
  		list1.remove(list1.indexOf('R'));
  		list1.remove(list1.indexOf('O'));	
  	}
  	
  	//TWO
  	while (list1.indexOf('W') >= 0 ){
  		numbers[2] ++;
  		list1.remove(list1.indexOf('T'));
  		list1.remove(list1.indexOf('W'));
  		list1.remove(list1.indexOf('O'));	
  	}
  	
  	//FOUR
  	while (list1.indexOf('U') >= 0 ){
  		numbers[4] ++;
  		list1.remove(list1.indexOf('F'));
  		list1.remove(list1.indexOf('O'));
  		list1.remove(list1.indexOf('U'));
  		list1.remove(list1.indexOf('R'));
  		
  	}
  	
  	//SIX
  	while (list1.indexOf('X') >= 0 ){
  		numbers[6] ++;
  		list1.remove(list1.indexOf('S'));
  		list1.remove(list1.indexOf('I'));
  		list1.remove(list1.indexOf('X'));	
  	}
  	
  	//FIVE
  	while (list1.indexOf('F') >= 0 ){
  		numbers[5] ++;
  		list1.remove(list1.indexOf('F'));
  		list1.remove(list1.indexOf('I'));
  		list1.remove(list1.indexOf('V'));	
  		list1.remove(list1.indexOf('E'));	
  		
  	}
  	
  	//3
  	while (list1.indexOf('R') >= 0 ){
  		numbers[3] ++;
  		list1.remove(list1.indexOf('T'));
  		list1.remove(list1.indexOf('H'));
  		list1.remove(list1.indexOf('R'));	
  		list1.remove(list1.indexOf('E'));
  		list1.remove(list1.indexOf('E'));
  	}
  	
  	//7
  	while (list1.indexOf('S') >= 0 ){
  		numbers[7] ++;
  		list1.remove(list1.indexOf('S'));
  		list1.remove(list1.indexOf('E'));
  		list1.remove(list1.indexOf('V'));	
  		list1.remove(list1.indexOf('E'));
  		list1.remove(list1.indexOf('N'));
  		
  	}
  	
  	//8
  	while (list1.indexOf('T') >= 0 ){
  		numbers[8] ++;
  		list1.remove(list1.indexOf('E'));
  		list1.remove(list1.indexOf('I'));
  		list1.remove(list1.indexOf('G'));	
  		list1.remove(list1.indexOf('H'));
  		list1.remove(list1.indexOf('T'));
  		
  	}
  	
  	//1
  	while (list1.indexOf('O') >= 0 ){
  		numbers[1] ++;
  		list1.remove(list1.indexOf('O'));
  		list1.remove(list1.indexOf('N'));	
  		list1.remove(list1.indexOf('E'));
  	}
  	
  	//9
  	while (list1.indexOf('I') >= 0 ){
  		numbers[9] ++;
  		list1.remove(list1.indexOf('N'));
  		list1.remove(list1.indexOf('I'));
  		list1.remove(list1.indexOf('N'));
  		list1.remove(list1.indexOf('E'));		
  	}
  	
  	
  	int current = 0;
  	for (int number: numbers){
  		for (int n = 0 ; n < number ; n++){
  			result += ""+ current; 
  		}
  		current++;
  		
  	}
  	out.print(result);
  	
  			
  	//out.println(lastWord);
  }
}
*/




/* GOOD TIPS :
    String str = in.readLine();    	
    String lastWord = ""+ str.charAt(0);
    	

  	for (int i=1 ; i<str.length() ; i++ ){
    	if (lastWord.charAt(0) <= str.charAt(i)){
    		lastWord = str.charAt(i) + lastWord ;
    	}
   	}
    int N = nextInt(); 
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

        HashMap <String, String> men = new HashMap<String, String>();

        //I put all the data in a hashmap
    	String[] str = in.readLine().split(" ");  //lit la ligne
    	for (int c = 1; c<= N ;c++ ){
    		men.put(Integer.toString(c),str[c-1]);
    	}
    	
    	//I check one by one.
    	String cur = "";
    	int maximum = 0 ;
    	ArrayList<String> first = new ArrayList<String>();
    	for (int current = 1 ; current <=N ; current++){
    		System.out.print(current + ": ");

    		int tmp_maximum = 0;
    		cur = Integer.toString(current); // just to convert;
    		HashMap <String, String> tmp = new HashMap<String, String>(men);
    		HashSet <String> already = new HashSet <String>();
    		
    		boolean end = false;
    		
    		while (tmp.containsKey(cur)  || end == false ){ //&& tmp.containsKey(tmp.get(cur))){
    			String old_cur = cur;
    			cur = tmp.get(cur);
    			tmp.remove(old_cur);

    			//if (already.contains(cur) == false){
    				tmp_maximum ++;
        			already.add(cur);
        			first.add(cur);
    			//}
    			System.out.print(" " + cur+" ");
    			
    			
    			//end
    			if (tmp.containsKey(cur) == false){
    				//  
    				//System.out.println("TTTTT");

    				Set set = tmp.entrySet();
    		        Iterator i = set.iterator();
    		        end = true;
    		        while(i.hasNext()) {
    		            Map.Entry me = (Map.Entry)i.next();
		            	//System.out.println("TTTTT");
    		            //System.out.println(me.getValue());
    		            //System.out.println(old_cur);
    		            
    		            if (  ((String)me.getValue()).equals(old_cur)){
    		            	//System.out.println("TTTTT");
    		            	//System.out.print(me.getKey() + ": ");
    		            	//System.out.println(me.getValue());
    		            	cur = (String) me.getValue();
    		            	end = false;
    		            }
    		        }
    		        if (end == false)
    		        	tmp_maximum ++;

    			}
    			
    		}
    		System.out.println();
    		if (first.get(0) == first.get(first.size()-1) )
    		{
    			tmp_maximum --;
    		}
    		
    		
    		maximum = Math.max(maximum,tmp_maximum );

    		
    	}
		out.println(maximum);
          String newString = endingString.substring(0, i) + endingString.substring(i + 1);

 */

 /* TIPS
    	long n = nextInt();
    	String str = in.readLine();
    	ArrayList <String> list = new ArrayList <String> ();

        String [] str = in.readLine().split(" ");
    	String str0 = str[0];
    	String cmp = "equal";
    	for (int i = 0 ; i < str0.length() ; i++){    		
    		if (str0.charAt(i) != '?' && str1.charAt(i) != '?')
    			if (str0.charAt(i) < str1.charAt(i)){

    	HashMap<String, String> map = new  HashMap<String, String>();

    	if (map.containsKey(str0) && map.containsKey(str1)){
    		result++;
    	}
    	map.put(str0, "");
    	result = n - Math.max(mapone.size(), maptwo.size());

    	ArrayList <Character> list1 = new ArrayList<Character>();
    	for (int i=0 ; i < str.length() ; i++ ){
    		list1.add(str.charAt(i));

     	list1.remove(list1.indexOf('S'));


     
     */



import java.io.*;
import java.math.*;
import java.util.*;

public class AAA {

	static BufferedReader in; static StringTokenizer st; static PrintWriter out;
	public static void main(String[] args) throws IOException {
    	String FILENAME_IN = "@Generic.in";
    	FILENAME_IN = "A-large.in.txt";  //Enlever ce comentaire quand submit
    	//FILENAME_IN = "B-small-attempt0.in";  //Enlever ce comentaire quand submit
    	//FILENAME_IN = "C-small-attempt0.in";  //Enlever ce comentaire quand submit
    	
    	in = new BufferedReader(new FileReader(FILENAME_IN));
    	
    	out = new PrintWriter(new BufferedWriter(new FileWriter("@Generic.out")));	
		//out = new PrintWriter(System.out, true); //Utiliser pour le System.out.println
		
		int TC = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			out.print("Case #"+tc+": ");
			//EXO1
			    	String res = "";
			     	//String [] str = in.readLine().split(" ");
			    	//String str0 = str[0];
			     
			      	long n = Integer.parseInt(in.readLine());
			      	int [] senastors =  new int [(int) n]; 
			      	
			     	String [] str = in.readLine().split(" ");
			     	
			     	for (int i = 0; i < str.length ; i++){
			     		senastors[i] = Integer.valueOf(str[i]);
			     	}
			      	
			   //  	for (int sen : senastors){
			     //		System.out.println(sen);
			     	//}
			    	
			     	//find the max
			     	int indiceMax = 0;
			     	//int max = Integer.MAX_VALUE;
			     	//int counterMax = 10;
			     	
			 		int max = indiceMax;
			 		int modulo = 0;
			 		
			 		int several_max =0;
			     	do {
				     	max = senastors[indiceMax];
			
				     	for (int j = 0; j < senastors.length; j++)
				     	{
				     		 if (senastors[j] == max)
				     	    	 several_max ++;
				     		 
				     	     if (senastors[j] > max)
				     	     {
				     	    	 max = senastors[j];
				     	    	 indiceMax = j;
				     	     }
				     	     
				     	    
				     	}
				     	
				     	//result
				     	senastors[indiceMax]--;
				     	
				     	if (max != 0)
				     		res += (char) ('A' + indiceMax);
				     		//out.print((char) ('A' + indiceMax));
				     	//System.out.println();
				     	
				     	modulo ++;
				     	//if (modulo%2 == 0)
				     	//if (several_max == 1)
				     	//	out.print(" ");
				     	//System.out.println();
				     	//counterMax -- ;
				     	//if (counterMax == 0)
				     	//	break;
				     	several_max = 0;
			     	}
			     	while (max != 0);
			     	
			     	int counterModulo = 0;
			     	if (res.length()%2 == 0)
			     	{
			     		counterModulo = 0; 
			     	}
			     	else
			     		counterModulo = 1;
			     	
			     	String finalresult = "";
			     	
			     	for (char oneres : res.toCharArray()){
			     		if (counterModulo%2 != 0)
			     			finalresult += oneres+ " ";
			     		else
			     			finalresult+= oneres;
			     		counterModulo++;
			     	}
			    	
			    	out.print(finalresult);
			    	out.println();
		}
		in.close();
		out.close();
    }    
}   
    
    

