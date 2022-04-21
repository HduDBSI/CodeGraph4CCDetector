package googlejam1.p273;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class ProblemA {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		for(int c=1; c<=cases; c++){
			int tam = Integer.parseInt(br.readLine());
			String line = br.readLine();
			int intervals[] = new int [tam];
			StringTokenizer st = new StringTokenizer(line);
			for(int i=0; i<tam; i++){
				intervals[i] = Integer.parseInt(st.nextToken());
			}
			int any, ratio;
			int maxDif;
			any = 0;
			maxDif = 0;
			ratio = 0;
			for(int i=1; i<tam; i++){
				if (intervals[i] < intervals[i-1]){
					int diff = intervals[i-1] -intervals[i];
					any += diff;
					if(diff > maxDif)maxDif = diff;
				}
			}
			for(int i=0; i<tam-1; i++){
				ratio += intervals[i] < maxDif ? intervals[i] : maxDif;
			}
			System.out.println("Case #"+c+": " + any + " " + ratio);
		}
	}

}
