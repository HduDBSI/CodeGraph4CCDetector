package googlejam3.p304;
import java.util.*;
import java.io.*;

public class Main{
	public static void main(String [] args)throws IOException{
	BufferedReader readTxt=new BufferedReader(new FileReader(new File("A-large.in")));
    String textLine="";
    String str="";
     while(( textLine=readTxt.readLine())!=null){
            str+=textLine+" ";
      }
    String[] strArray=str.split(" ");
    int [] numberArray=new int[strArray.length];
	for(int i=0;i<strArray.length;i++){
		numberArray[i]=Integer.valueOf(strArray[i]);
	}
	int num= numberArray[0];
	int [] sum=new int[num+1];
	for(int i=1;i<=num;i++){
		int r=numberArray[(i-1)*3+1];
		int c=numberArray[(i-1)*3+2];
		int w=numberArray[(i-1)*3+3];
		if(c%w!=0){
			sum[i]=r*(c/w)+w;
		}
		else sum[i]=r*(c/w)+w-1;
	}
    FileWriter fw = new FileWriter("output.txt");  
    BufferedWriter bufw = new BufferedWriter(fw);  
       // String line = null;  
        for(int i=1;i<=num;i++){  
            bufw.write("Case #"+i+": "+sum[i]);  
            bufw.newLine();  
            bufw.flush();  
        }  
    bufw.close();   

}  	
}