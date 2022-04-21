package googlejam8.p707;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SenateEvacuation {

  public static void main(String[] args) throws Exception {
    FileInputStream is = new FileInputStream(new File(args[0]));
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);
    String line = br.readLine();
    int testCase = 1;

    // ---each case
    while ((line = br.readLine()) != null) {

      // entradas
      int N = Integer.parseInt(line);
      line = br.readLine();
      String[] sForPartiesString = line.split(" ");
      int[] sForParties = new int[sForPartiesString.length];
      int cantidad = 0;
      for (int i = 0; i < sForParties.length; i++) {
        sForParties[i] = Integer.parseInt(sForPartiesString[i]);
        cantidad += sForParties[i];
      }
      int mitad = cantidad / 2;
      // ---

      List<String> toOut = new ArrayList<String>();
      while (cantidad > 0) {

        int mayor = Integer.MIN_VALUE;
		for (int i1 = 0; i1 < sForParties.length; i1++) {
		  if (sForParties[i1] > mayor) {
		    mayor = sForParties[i1];
		  }
		}
		int maximo = mayor;
//        System.out.println("maximo:" + maximo);
//        System.out.println("cantidad:" + cantidad);

        if (sForParties.length == 2) {          
          toOut.add("AB");
          cantidad -= 2;
          continue;
        } else {

          if (cantidad == 2) {
            String out = "";
            for (int i = 0; i < sForParties.length; i++) {
              if (sForParties[i] == maximo) {
                out += String.valueOf(Character.toChars(65 + i));
                sForParties[i] = sForParties[i] - 1;
              }
            }
            // System.out.println("agrego: " + out);
            toOut.add(out);
          } else {
            String out = "";
            for (int i = 0; i < sForParties.length; i++) {
              if (sForParties[i] == maximo) {

                out += String.valueOf(Character.toChars(65 + i));
                sForParties[i] = sForParties[i] - 1;
                break;
              }
            }

            toOut.add(out);
          }
		int cantidad1 = 0;
		for (int i = 0; i < sForParties.length; i++) {
		  cantidad1 += sForParties[i];
		}
          
          cantidad = cantidad1;
        }

      }

//      System.out.println(toOut);
      System.out.format("Case #%d:", testCase);
      for (int i = 0; i < toOut.size(); i++) {
        System.out.print(" " + toOut.get(i));
      }
      System.out.println("");
      testCase++;

    }

    br.close();
  }

}
