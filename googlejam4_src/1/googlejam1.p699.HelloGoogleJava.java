package googlejam1.p699;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
public class HelloGoogleJava {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String encoding = "UTF-8";
		BufferedReader reader = null;
		String filename= "/Users/dhsingh/Downloads/inputA.txt";
		String objectFile= "/Users/dhsingh/Downloads/output_A.txt";
		String contentss="";
		BufferedWriter bw;
		bw = new BufferedWriter(new FileWriter(objectFile));
		try {
		    reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), encoding));
		    String line = reader.readLine();
		    int T= Integer.parseInt(line);
		    String[]parsed;
		    int sum=0;
		    int first,second;
		    int diff;
		    for (int ii=1; ii<=T;ii++) {
		    	sum=0;
		    	line = reader.readLine();
		    	line = reader.readLine();
				parsed= line.split(" ");
				first=0;
				diff=Integer.parseInt(parsed[0])-Integer.parseInt(parsed[1]);
				for(int i=0;i<parsed.length-1;i++){
					first+=Integer.parseInt(parsed[i])-Integer.parseInt(parsed[i+1])>0?Integer.parseInt(parsed[i])-Integer.parseInt(parsed[i+1]):0;
				}
				for(int i=0;i<parsed.length-1;i++)
				{	
					diff=Integer.parseInt(parsed[i])-Integer.parseInt(parsed[i+1])>diff?Integer.parseInt(parsed[i])-Integer.parseInt(parsed[i+1]):diff;
				}	
				second=0;
				for(int i=0;i<parsed.length-1;i++)
				{	
					second+=Integer.parseInt(parsed[i])-Integer.parseInt(parsed[i+1])<diff?(Integer.parseInt(parsed[i])>diff?diff:Integer.parseInt(parsed[i])):diff;
				}
				contentss+="Case #"+ii+": "+first+" "+second+"\n";
		    }
		    
		    
			bw.write(contentss);
			
		}
		finally{
			reader.close();
			bw.close();
		}
//		BB();
	}


}
