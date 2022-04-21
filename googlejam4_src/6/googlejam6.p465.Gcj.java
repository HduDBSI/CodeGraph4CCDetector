package googlejam6.p465;
import java.util.*;
import java.io.*;
public class Gcj {
  private int T;
  private BufferedReader buff;
  final static private boolean IS_DEBUG=false;
  // final static private boolean IS_DEBUG=true;
  private String[] list;
  private int N;
  private int MAX_HEIGHT=2501;
  private int[] soldiers=new int[MAX_HEIGHT];

  Gcj(){
    buff=new BufferedReader(new InputStreamReader(System.in));
    try{
      T=Integer.parseInt(buff.readLine());
    }
    catch(Exception e){
      System.err.println(e);
    }
  }

  public static final void main(final String[] args) {
    Gcj r = new Gcj();
	for(int i=0; i<r.T; i++){
	  System.out.print(String.format("Case #%d: ", i+1));
	  try{
	  // INIT VARIABLES HERE
	  r.soldiers=new int[r.MAX_HEIGHT];
	  r.N=Integer.parseInt(r.buff.readLine());
	  r.list=new String[2*r.N-1];
	  for(int i1=0; i1<2*r.N-1; i1++) r.list[i1]=r.buff.readLine();
	  if(Gcj.IS_DEBUG){
	  System.err.println("debug: "+"list="+Arrays.toString(r.list));
	  // System.out.format("       "+"variable=\n");
	}
	}
	catch(Exception e){
	  System.err.println(e);
	}
	  PriorityQueue<Integer> set=new PriorityQueue<Integer>();
	
	for(int i2=0; i2<2*r.N-1; i2++){
	  String[] line=r.list[i2].split(" ");
	  for(int j=0; j<line.length; j++)
	    r.soldiers[Integer.parseInt(line[j])]++;
	}
	// debugInfo(Arrays.toString(soldiers));
	for(int i1=0; i1<r.MAX_HEIGHT; i1++){
	  if(r.soldiers[i1]%2==1) set.add(i1);
	}
	if(Gcj.IS_DEBUG){
	  System.err.println("debug: "+"N="+r.N);
	  // System.out.format("       "+"variable=\n");
	}
	if(Gcj.IS_DEBUG){
	  System.err.println("debug: "+"set="+set);
	  // System.out.format("       "+"variable=\n");
	}
	System.out.println(set.toString().replaceAll(", ", " ").replace("[", "").replace("]", ""));
	}
    return;
  }
}
