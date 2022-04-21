package googlejam6.p745;
import java.util.*;
import java.io.*;
public class Main {
  public static void main(String[] args) throws FileNotFoundException {
	  //new FileInputStream (new File("A-large.in") ) 
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader( new FileInputStream (new File("B-small-attempt0.in") )   ) ));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    
    for (int i = 1; i <= t; ++i) {
    	int n = in.nextInt();
    	HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
    	for( int j =1; j<=n*(2*n-1);j++){
    		int num = in.nextInt();
    		int value = 1;
    		if( map.containsKey(num) ){
    			value += map.get(num);
    		}
    		map.put(num, value);
    	}
    	int[] result = new int[n];
    	int k =0;
    	for( int key: map.keySet() ){
    		int count = map.get(key);
    		if( count%2 != 0){
    			result[k] = key;
    			k++;
    		}
    	}
    	Arrays.sort(result);
    	try
		  {
		  String path="1.txt";
		  File file=new File(path);
		  if(!file.exists())
		      file.createNewFile();
		  FileOutputStream out=new FileOutputStream(file,true);        
		  out.write(("Case #"+i+":").getBytes("utf-8"));
		  out.close();
		  }
		  catch(IOException e)
		  {
		      e.printStackTrace();
		  }
    	for( int r:result){
    		try
			  {
			  String path="1.txt";
			  File file=new File(path);
			  if(!file.exists())
			      file.createNewFile();
			  FileOutputStream out=new FileOutputStream(file,true);        
			  out.write((" "+ r).getBytes("utf-8"));
			  out.close();
			  }
			  catch(IOException e)
			  {
			      e.printStackTrace();
			  }
    	}
    	try
		  {
		  String path="1.txt";
		  File file=new File(path);
		  if(!file.exists())
		      file.createNewFile();
		  FileOutputStream out=new FileOutputStream(file,true);        
		  out.write("\n".getBytes("utf-8"));
		  out.close();
		  }
		  catch(IOException e)
		  {
		      e.printStackTrace();
		  }
    }
  } 
}