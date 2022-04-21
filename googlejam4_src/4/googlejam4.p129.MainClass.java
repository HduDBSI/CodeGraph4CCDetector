package googlejam4.p129;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class MainClass {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader fr = new BufferedReader(new FileReader(new File("input.txt")));
		FileWriter fw = new FileWriter(new File("result.txt"));
		String firstLine = fr.readLine();
		int nbCases = Integer.parseInt(firstLine);
		for (int numCase =0; numCase<nbCases; numCase++){

			String line = fr.readLine();
			int R = Integer.parseInt(line.split(" ")[0]);
			int C = Integer.parseInt(line.split(" ")[1]);
			char[][] fleches = new char[R][C];
			
			for (int i =0; i<R; i++){
				line = fr.readLine();
				for (int j =0; j<C; j++){
					fleches[i][j]=line.charAt(j);
				}
			}
			

			int result = 0;
			
			for (int i =0; i<R; i++){
				for (int j =0; j<C; j++){
					if (fleches[i][j]=='.'){
						continue;
					}
					boolean needsToChange = true;
					if (fleches[i][j]=='<'){
						for (int k = j-1; k>=0; k--){
							if (fleches[i][k]!='.'){
								needsToChange=false;
								break;
							}
						}
					}
					if (fleches[i][j]=='>'){
						for (int k = j+1; k<C; k++){
							if (fleches[i][k]!='.'){
								needsToChange=false;
								break;
							}
						}
					}
					
					if (fleches[i][j]=='^'){
						for (int k = i-1; k>=0; k--){
							if (fleches[k][j]!='.'){
								needsToChange=false;
								break;
							}
						}
					}
					if (fleches[i][j]=='v'){
						for (int k = i+1; k<R; k++){
							if (fleches[k][j]!='.'){
								needsToChange=false;
								break;
							}
						}
					}
					if (needsToChange){

						boolean changeable = false;
						for (int k = i+1; k<R; k++){
							if (fleches[k][j]!='.'){
								changeable=true;
								break;
							}
						}
						for (int k = i-1; k>=0; k--){
							if (fleches[k][j]!='.'){
								changeable=true;
								break;
							}
						}
						for (int k = j+1; k<C; k++){
							if (fleches[i][k]!='.'){
								changeable=true;
								break;
							}
						}
						for (int k = j-1; k>=0; k--){
							if (fleches[i][k]!='.'){
								changeable=true;
								break;
							}
						}
						if (changeable){
							result++;
						}
						else{
							result=Integer.MIN_VALUE;
							break;
						}
					}
				}
			}
			if (result<0){

				fw.write("Case #"+(numCase+1)+": IMPOSSIBLE\n");
			}
			else{
			
			fw.write("Case #"+(numCase+1)+": "+result+"\n");
			}
			
		}
		fw.close();
		System.out.println("finished");
	}

}
