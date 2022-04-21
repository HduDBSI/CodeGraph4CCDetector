package googlejam8.p831;
import java.io.*;
import java.util.*;

public class A {

    static Scanner input = null;
    static BufferedWriter writer = null;

    public static void main(String[] args) {
        try {
            input = new Scanner(new FileReader("A-large.in"));
            writer = new BufferedWriter(new FileWriter("A-large.out"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int numCases = input.nextInt();
        for (int n = 0; n < numCases; n++)
        {
            Long N = input.nextLong();
            HashMap<Character, Integer> parties = new LinkedHashMap<>();
            char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
            for (int j = 0; j < N; j++)
            {
                parties.put(Character.toUpperCase(alphabet[j]), input.nextInt());
            }

            /**
             * Amax-1 <= totalj/2
             *
             * Max+SecondMax
             */

            try {
			    writer.write("Case #" + (n + 1) + ": ");
			    writer.flush();
			} catch (IOException e1) {
			    e1.printStackTrace();
			}
            while (parties.values().stream().anyMatch(i -> i!=0)) {
                Map.Entry<Character, Integer> majorParty = Collections.max(parties.entrySet(),
                                                                      (entry1, entry2) -> entry1.getValue() >= entry2.getValue()
                                                                          ? 1 : -1);

                int total = parties.values().stream().mapToInt(Number::intValue).sum() - 1;
                parties.put(majorParty.getKey(), majorParty.getValue() - 1);
                Map.Entry<Character, Integer> secondMajor = Collections.max(parties.entrySet(),
                                                                      (entry1, entry2) -> entry1.getValue() >= entry2.getValue()
                                                                          ? 1 : -1);
                if (secondMajor.getValue() <= total/2) {
                    try {
					    writer.write(majorParty.getKey() + " ");
					    writer.flush();
					} catch (IOException e) {
					    e.printStackTrace();
					}
                } else {
                    parties.put(secondMajor.getKey(), secondMajor.getValue() - 1);
                    try {
					    writer.write(majorParty.getKey()+ "" + secondMajor.getKey()+" ");
					    writer.flush();
					} catch (IOException e) {
					    e.printStackTrace();
					}
                }
            }
            try {
			    writer.newLine();
			    writer.flush();
			} catch (IOException e) {
			    e.printStackTrace();
			}

        }
    }
}
