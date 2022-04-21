package googlejam1.p685;
import java.io.*;
import java.util.Scanner;


public class problemA {

    public static void main(String[] args) {
        String results = "";

        Scanner input = null;
        try {
            input = new Scanner(new File("/home/lasantha/Downloads/A-large.in"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        int T = 0, N = 0;

        int y = 0;
        int z = 0;
        int rate = 0;

        int temprate = 0;

        T = input.nextInt();

        for (int i = 0; i < T; i++) {

            N = input.nextInt();

            int[] data = new int[N];

            for (int j = 0; j < N; j++) {
                data[j] = input.nextInt();
            }

            y = 0;
            z = 0;
            rate = 0;
            temprate = 0;

            for (int j = 0; j < N - 1; j++) {
                if (data[j] > data[j + 1]) {
                    y += data[j] - data[j + 1];

                    temprate = (data[j] - data[j + 1]);

                    if (temprate > rate) {
                        rate = temprate;
                    }

                }

            }

            for (int j = 0; j < N - 1; j++) {
                if (data[j]-rate  <0) {
                    z += data[j];
                } else {
                    z += rate;
                }
            }



            results += "Case #" + (i + 1) + ": " + y + " " + z + "\n";

        }

        System.out.println(results);
        BufferedWriter writer = null;
		try {
		    writer = new BufferedWriter(new FileWriter("output.txt"));
		    writer.write(results);
		    writer.close();
		    System.out.println("Done");
		} catch (IOException e) {
		}

    }


}