package googlejam8.p349;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main {
	
	public static void main(String[] args) throws Exception {

    /*		
		FileInputStream fin=new FileInputStream("C:/Users/4dm1n/Desktop/A-large.in");
		BufferedReader br=new BufferedReader(new InputStreamReader(fin));	
		File myfile=new File("C:/Users/4dm1n/Desktop/z_output.out");
		RandomAccessFile rand=new RandomAccessFile(myfile,"rw");
    */		
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		
		int t,n,m,j,l,i,k,p,c,r,tt,arr[];
		long ff,ll;
		String s[];
		char sf[],sl[];
		StringBuilder sb;
		t=Integer.parseInt(br.readLine());
		for(tt=1;tt<=t;tt++){
			sb=new StringBuilder("Case #"+tt+": ");
			
			n=Integer.parseInt(br.readLine());
			arr=new int[n];
			s=br.readLine().split(" ");
			for(i=0;i<n;i++){
				arr[i]=Integer.parseInt(s[i]);
			}
			c=0;
			for(i=1000;i>1;i--){
				for(j=0;j<n;j++){
					if(arr[j]==i){
						c++;
						if(c%2==1) sb.append((char)(j+65));
						else sb.append(((char)(j+65))+" ");
						arr[j]--;
					}
				}
			}
			if(c%2==1){
				sb.append(" ");
			}
			c=0;
			for(j=0;j<n;j++) if(arr[j]>0) c++;
			if(c%2==1){
				for(i=1;i<=1;i++){
					c=0;
					for(j=0;j<n;j++){
						if(arr[j]==1){
							c=1;
							sb.append((char)(j+65)+" ");
							arr[j]--;
						}
						if(c==1) break;
					}
					if(c==1) break;
				}
			}
			for(i=1;i<=1;i++){
				c=0;
				for(j=0;j<n;j++){
					if(arr[j]==i){
						c++;
						if(c%2==1) sb.append((char)(j+65));
						else sb.append(((char)(j+65))+" ");
						arr[j]--;
					}
				}
			}
			
			
			
			
			
			sb.append("\n");
//			rand.writeBytes(sb.toString());
			System.out.print(sb);
		}
	}
}