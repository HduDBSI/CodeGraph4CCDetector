package googlejam1.p810;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MushroomMonster {

	static BufferedReader br;
	static BufferedWriter bw;
	static String path = "C:/Users/Alberto/Desktop/GoogleContent2015/Mushroom/A-large.in";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			bw = new BufferedWriter(
					new FileWriter(
							"C:/Users/Alberto/Desktop/GoogleContent2015/Mushroom/A-large.txt"));

			br = new BufferedReader(new FileReader(path));

			String line = br.readLine();
			int T = Integer.parseInt(line);

			for (int i = 1; i <= T; i++)
				// Leemos la linea del primer participante
				try {
					int size = Integer.parseInt(br.readLine());
					String line1 = br.readLine();
					Integer[] vect = new Integer[size];
					// ArrayList<Integer> vect = new ArrayList<Integer>();
				
					long llevo1 = 0;
					long llevo2 = 0;
					int maxDif = 0;
				
					for (int i1 = 0; i1 < size; i1++) {
						vect[i1] = Integer.parseInt(line1.split(" ")[i1]);
						// vect.add(Integer.parseInt(line.split(" ")[i]));
					}
				
					// Sacamos la diferencia maxima
					for (int i3 = 0; i3 < size - 1; i3++) {
						if (vect[i3] > vect[i3 + 1] && vect[i3] - vect[i3 + 1] > maxDif)
							maxDif = vect[i3] - vect[i3 + 1];
					}
				
					for (int i2 = 1; i2 < size; i2++) {
						// Soluci�n 1:
						if (vect[i2] < vect[i2 - 1]) {
							llevo1 += vect[i2 - 1] - vect[i2];
						}
				
						// Solucion 2:
						if (vect[i2 - 1] <= maxDif)
							llevo2 += vect[i2 - 1];
						else
							llevo2 += maxDif;
					}
				
					bw.write("Case #" + i + ": " + llevo1 + " " + llevo2
							+ System.lineSeparator());
				
				} catch (IOException ex) {
					ex.printStackTrace();
				}

			bw.close();

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
