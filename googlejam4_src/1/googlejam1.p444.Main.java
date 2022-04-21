package googlejam1.p444;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static PrintWriter out = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr = null;
		try {
			fr = new FileReader("test");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(fr);
		Scanner in = new Scanner(br);

		try {
			out = new PrintWriter("output.txt", "UTF-8");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int t = Integer.parseInt(in.nextLine());
		
		
		for (int i = 0; i < t; i++) {
			//String[] dataR = in.nextLine().split(" ");
			//TODO: Edit data for each case
			//===============================
			int intervals= Integer.parseInt(in.nextLine());
			String[] dataR = in.nextLine().split(" ");
			int[] data= new int[dataR.length];
			for(int j=0;j<dataR.length;j++){
				data[j]=Integer.parseInt(dataR[j]);
			}
			
			//===============================
			out.print("Case #" + (i + 1) + ": ");
			// TODO Auto-generated method stub
			int count1 =0;
			for(int i3=1;i3<data.length;i3++){
				if(data[i3-1]>data[i3]){
					count1+=data[i3-1]-data[i3];
				}
			}
			out.print(count1+" ");
			int max=0;
			int count=0;
			for(int i1=1;i1<data.length;i1++){
				if(data[i1-1]-data[i1]>max){
					max=data[i1-1]-data[i1];
				}
			}
			count=max*(data.length-1);
			for(int i2=0;i2<data.length-1;i2++){
				if(data[i2]<max){
					count-=max-data[i2];
				}
			}
			out.println(count);
		}

		out.close();
	}




}
