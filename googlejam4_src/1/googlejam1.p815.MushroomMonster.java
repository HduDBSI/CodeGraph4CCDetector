package googlejam1.p815;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MushroomMonster{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int totCases = Integer.parseInt(br.readLine());
		for (int i = 0; i < totCases; i++) {
			int N = Integer.parseInt(br.readLine());
			int Y = 0; 
			int Z = 0; 
			String[] data = br.readLine().split(" ");
			int minDif = 0;
			for (int j = 1; j < N; j++) {
				int dataAnt = Integer.parseInt(data[j-1]);
				int dataAct = Integer.parseInt(data[j]);
				if (dataAct<dataAnt){
					int dif = dataAnt-dataAct;
					Y+=dif;
					if (minDif<dif){
						minDif=dif;
					}
				}
			}
			for (int j = 1; j < N; j++) {
				int dataAnt = Integer.parseInt(data[j-1]);
				int dataAct = Integer.parseInt(data[j]);
				Z+=(dataAnt-dataAct)<minDif?Math.min(dataAnt, minDif):minDif;
			}
			System.out.println("Case #"+(i+1)+": "+Y+" "+Z);
		}
	}

}
