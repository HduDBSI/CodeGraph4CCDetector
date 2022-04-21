package googlejam1.p558;
import java.util.*;
import java.io.*;
public class Gcj {
  private int T;
  private BufferedReader buff;
  private int[] mashrooms;
  final static private boolean IS_DEBUG=false;

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
	  r.mashrooms=new int[Integer.parseInt(r.buff.readLine())];
	  String[] line=r.buff.readLine().split(" ");
	  for(int i1=0; i1<r.mashrooms.length; i1++) r.mashrooms[i1]=Integer.parseInt(line[i1]);
	  if(Gcj.IS_DEBUG){
	  System.err.println("\n"+"debug: "+"show args");
	  System.err.format("       "+"mashrooms=%s\n", Arrays.toString(r.mashrooms));
	}
	}
	catch(Exception e){
	  System.err.println(e);
	}
	  int res=0;
	for(int i2=0; i2<r.mashrooms.length-1; i2++)
	  if(r.mashrooms[i2]>r.mashrooms[i2+1]) res+=r.mashrooms[i2]-r.mashrooms[i2+1];
	System.out.print(res+" ");
	int res1=0;
	int rate=0;
	for(int i1=0; i1<r.mashrooms.length-1; i1++){
	  int diff=r.mashrooms[i1]-r.mashrooms[i1+1];
	  if(diff>rate) rate=diff;
	}
	// System.out.println("rate="+rate);
	for(int i3=0; i3<r.mashrooms.length-1; i3++){
	  res1+=(r.mashrooms[i3]>rate)?rate:r.mashrooms[i3];
	}
	System.out.println(res1);
	}
    return;
  }
}
