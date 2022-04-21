package googlejam1.p591;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class A {
	
public static void main(String[] args){
		

		try {
			Scanner in = new Scanner(new File(args[0]));
			BufferedWriter bw = new BufferedWriter(new FileWriter( new File("A-output.txt"),false));
			
			
			int T = in.nextInt();
			
			for(int i=0;i<T;i++){
				
				int totNum = in.nextInt();
				int[] musStates = new int[totNum];
				
				int methodA = 0 ;
				int methodB = 0 ;
				int maxDiff = 0 ;
				musStates[0] = in.nextInt();
				
				for(int j=1;j<totNum;j++){
					musStates[j] = in.nextInt();
					
					int di = musStates[j] - musStates[j-1] ;
					if(di<0){
						di = Math.abs(di);
						methodA += di ;
						
						if(maxDiff < di ){
							maxDiff = di ;
						}
					}
				}
				
				for(int j=0;j<totNum-1;j++){
					if(musStates[j]<maxDiff){
						methodB += musStates[j];
					}else{
						methodB += maxDiff ;
					}
				}
				
				
				System.out.println("Case #"+(i+1)+": " + methodA + " " + methodB);
				bw.write("Case #"+(i+1)+": " + methodA + " " + methodB );
				bw.newLine();
			}
			
			if(in!=null)in.close();
			if(bw!=null)bw.close();
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
			
		
	}

}
