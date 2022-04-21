package googlejam1.p790;
import java.io.*;
public class first1{
    static String infile = "in.txt";
    static String outfile = "out.txt";
    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new FileReader(infile));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(outfile,false)));
		int line = Integer.parseInt(in.readLine());
		for(int i=1;i<=line;i++){
		    String nums = in.readLine();
		    String[] parts = in.readLine().split(" ");
		    int d = Integer.parseInt(nums);
		    int n1=0,n2=0,max1=0;
		    int[] number = new int[parts.length];
		    for(int j=0;j<parts.length;j++){
		        number[j]=Integer.parseInt(parts[j]); 
		    }
		    if(number[0]>number[1]){
		        max1 = number[0]-number[1];
		    }
		    for(int k=1;k<number.length;k++){
		        if((number[k-1]-number[k])>max1){
		            max1=number[k-1]-number[k];
		        }
		        if(number[k]<number[k-1]){
		           n1=n1+number[k-1]-number[k]; 
		        }
		    }
		    for(int k=0;k<number.length-1;k++){
		        if(number[k]<max1){
		            n2+=number[k];
		        }else{
		            n2+=max1;
		        }
		    }
		    /*out.print("Case # "+i+" : ");
		    for(String str:parts){
		        out.print(str+" ");
		    }
		    out.println();*/
		    out.printf("Case #%d: %d %d",i,n1,n2);
		    out.println();
		    out.flush();
		}
		in.close();
		out.close();
    }
}
            
        
