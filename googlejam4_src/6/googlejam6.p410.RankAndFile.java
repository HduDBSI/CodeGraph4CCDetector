package googlejam6.p410;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.TreeSet;
import java.io.IOException;


public class RankAndFile {


	public static void main(String[] args) throws IOException {
		
		String path =  "B-large.in";
		File f = new File(path);
		PrintWriter out = null;
		
		
		try{
			File fi = new File("resultBlarge.txt");
			fi.createNewFile();
			out = new PrintWriter(fi);
			Scanner sc = new Scanner(f);
			int num = sc.nextInt();
			//sc.nextLine();
			
			for(int k=0; k<num; k++){
				
				int n = sc.nextInt();
				// sc.nextLine();
			TreeSet<Integer> lista = new TreeSet<>();	
				
				for(int i=0; i<(2*n)-1; i++){
					
					for(int j=0; j<n; j++){
						
						int z = sc.nextInt();
					//	System.out.println(z);
						
						if(lista.contains(z)){
							//System.out.println("Removing: " + lista.toString());
							//boolean flag = lista.remove(z);
							lista.remove(z);
							
						}else {
							//System.out.println("Adding: " + lista.toString());
							lista.add(z);	
						}
					}
					
				}
				
			//	Collections.sort(lista);

				out.printf("Case #%d: ", (k+1));
				for(Integer i : lista){
					
					out.print(i + " ");
					
				}
			out.println();
			}
			
			sc.close();
		} catch (FileNotFoundException e){
			System.out.println("File not found.");
			
		}finally{
			out.close();
		
		}

	}
	
	
}
