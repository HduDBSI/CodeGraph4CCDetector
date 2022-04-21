package googlejam3.p318;


import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by rkogawa on 5/10/15.
 */
public class Brattleship {


    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("resources/round1c/Brattleship/A-large.in"));
        //BufferedReader reader = new BufferedReader(new FileReader("resources/round1c/Brattleship/Teste.in"));

        int quantidadeTeste = Integer.parseInt(reader.readLine());
        int teste = 1;
        while (teste <= quantidadeTeste) {
            String[] currentLine = reader.readLine().split(" ");

            int rows = Integer.parseInt(currentLine[0]);
            int columns = Integer.parseInt(currentLine[1]);
            int shipSize = Integer.parseInt(currentLine[2]);

            int fistHit = columns / shipSize * rows;

            int miss = columns % shipSize > 0 ? 1 : 0;

            int plays = fistHit + miss + shipSize - 1;
            System.out.println("Case #" + teste + ": " + plays);

            teste++;
        }
    }

}
