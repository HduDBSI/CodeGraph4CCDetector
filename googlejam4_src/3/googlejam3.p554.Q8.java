package googlejam3.p554;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q8 {
	public static void main(String args[]) throws IOException{
		String co;
		String str[];
		int n,ans,r,c,w;
		File f = new File("C:\\file\\code jam\\q1.txt");					
		FileInputStream fi = new FileInputStream(f) ;
		BufferedReader br= new BufferedReader(new InputStreamReader(fi));
		File fa = new File("C:\\file\\code jam\\ans1.txt");
		FileOutputStream fo = new FileOutputStream(fa) ;
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(fo));
			n=Integer.parseInt(br.readLine());	
			for(int i=1;i<=n;i++){
				str=br.readLine().split(" ");
				r=Integer.parseInt(str[0]);
				c=Integer.parseInt(str[1]);
				w=Integer.parseInt(str[2]);				
				float mid=(float)c/(float)w;
				//System.out.println(""+mid);
				mid=(float) Math.ceil(mid);
				//System.out.println(""+mid);
				if(w==c){
					ans=w;
				}
				else {
					ans=(int) (mid+w-1);
				}
				
				System.out.println("Case #"+i+": "+ans);
				bw.write("Case #"+i+": "+ans);
				bw.newLine();
			}			
			bw.close();		
		}
	}

