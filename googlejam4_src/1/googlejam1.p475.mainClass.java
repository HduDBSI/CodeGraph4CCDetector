package googlejam1.p475;


import java.io.*;

/**
 * Created by The Networks on 4/11/2015.
 */
public class mainClass {

    public static void main(String[] args)
    {
        BufferedReader cin =  new BufferedReader(new InputStreamReader(System.in));

        String file = null;
        try {
            System.out.print("Filename: ");
            file = cin.readLine();

            BufferedReader reader = new BufferedReader(new InputStreamReader(mainClass.class.getResourceAsStream(file)));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output.txt")));

            String line = reader.readLine();
            int testCases = Integer.parseInt(line);

            for( int i = 0; i < testCases; i++)
            {
                //waste line
                reader.readLine();

                line = reader.readLine();

                Solution obj_Solution = new Solution();
                String result = obj_Solution.solve(line)+"";
                writer.append("Case #" + (i + 1)).append(": ").append(result);
                writer.newLine();
                System.out.println("Case #" + (i + 1)+": "+line);
                System.out.println(result);
            }

            writer.close();

        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

}
