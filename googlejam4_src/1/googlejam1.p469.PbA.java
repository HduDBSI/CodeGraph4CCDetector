package googlejam1.p469;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class PbA {

	public static void main(String[] args) {
		try {
			String input = "pbA-small";
			BufferedReader inputStream = new BufferedReader(new FileReader(input+".in"));
			FileWriter f = new FileWriter(input+".out");
			String l = inputStream.readLine();
			int nbCases = Integer.parseInt(l);
			for (int caseNb = 1; caseNb<=nbCases; caseNb++){
				System.out.println("case "+caseNb);
				l = inputStream.readLine();
				int N = Integer.parseInt(l);
				l = inputStream.readLine();
				String[] pos = l.split(" ");
				int[] m=new int[N];
				int pb1=0;
				m[0]=Integer.parseInt(pos[0]);
				int speed=0;
				int pb2=0;
				for(int i=1;i<N;++i){
					m[i]=Integer.parseInt(pos[i]);
					if(m[i]<m[i-1]){
						pb1+=m[i-1]-m[i];
					}
					if((m[i-1]-m[i])>speed){
						speed=m[i-1]-m[i];
					}
				}
//				System.out.println(speed);
				for(int i=0;i<N-1;++i){
					if(m[i]>speed){
						pb2+=speed;
					}else{
						pb2+=m[i];
					}
				}
				
				
				f.write("Case #"+caseNb+": " + pb1 + " " + pb2 + "\n");	
//				System.out.println("Case #"+caseNb+": " + pb1 + " " + pb2 + "\n");
			}
			f.close();
		}catch (Exception e){e.printStackTrace();}
	}

}
