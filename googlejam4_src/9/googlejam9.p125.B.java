package googlejam9.p125;


import java.io.*;
import java.util.*;

public class B {
	static Scanner in = null;
	static PrintWriter out = null;
	static FileInputStream toclose=null;
	
	//static String file = "B-training.in";
	//static String file = "B-small-attempt1.in";
	static String file = "B-large.in";
	static String folder = "CodeJam16";
	static String contest = "1C";

	public static void main(String[] args) {
		String empInput = "C:/Users/Momo/Desktop/"+folder+"/"+file;
		String empOutput = "C:/Users/Momo/Desktop/"+folder+"/Liet-"+contest+"-"+file+".out";
		try {
			toclose = new FileInputStream(empInput);
			System.setIn(toclose);
			in = new Scanner(System.in);
			out = new PrintWriter(empOutput);
		} catch (Exception e) {
			System.out.println("Ouverture");
			e.printStackTrace();
		}

		int nbLig = in.nextInt();
		
		for(int lig=0; lig<nbLig; lig++){
			int nBuild = in.nextInt();
			long nMouv = in.nextLong();
			
			int[][] slides = new int[nBuild][nBuild];
			
			if( ((long)Math.pow(2, nBuild-2)) < nMouv ){
				out.println("Case #"+(lig+1)+": "+ "IMPOSSIBLE" );
			}else{
				out.println("Case #"+(lig+1)+": "+ "POSSIBLE" );
				
				for(int i=0; i<nBuild; i++){
					for(int j=i+1; j<nBuild; j++){
						if(j!=nBuild-1 || i==0){
							slides[i][j]=1;
						}else{ //last collumn
							slides[i][j]= (int) (((nMouv-1)>>(i-1) )%2);
						}
					}
				}
				
				
				for(int i=0; i<nBuild; i++){
					for(int j=0; j<nBuild; j++){
						out.print(slides[i][j]);
					}
					out.println();
				}
			}
			
		}
		in.close();
		out.close();
		try {
			toclose.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
