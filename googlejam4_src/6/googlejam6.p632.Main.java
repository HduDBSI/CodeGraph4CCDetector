package googlejam6.p632;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
  static int n;
  static Map<Integer, Integer> count1 = new HashMap<>();
  static Map<Integer, Integer> count2 = new HashMap<>();


  public static void main(String[] args) throws IOException {
    File out = new File("out.out");
    out.createNewFile();
    BufferedWriter output = new BufferedWriter(new FileWriter(out));
    Scanner sc = new Scanner(new File("inLarge"));
    int numCases = Integer.valueOf(sc.nextLine());
    List<String> answers = new ArrayList<String>();

    cases:
    for (int test = 1; test <= numCases; test++) {
      Map<Integer, Integer> countTotal = new HashMap<>();
      String line = sc.nextLine();
      n = Integer.valueOf(line);
      int numPapers = n * 2 - 1;
      List<List<Integer>> papers = new ArrayList<>();
      for (int i = 0; i < numPapers; i++) {
        line = sc.nextLine();
        String[] tokens = line.split(" ");
        List<Integer> paper = new ArrayList<>();
        for (int i2 = 0; i2 < n; i2++) {
          paper.add(Integer.valueOf(tokens[i2]));
        }
        papers.add(paper);
      }

      for(int p = 0; p < numPapers; p++) {
        List<Integer> paper = papers.get(p);
        for (int i = 0; i < n; i++) {
          Integer mou = countTotal.get(paper.get(i));
          if (mou == null) {
            countTotal.put(paper.get(i), 1);
          } else {
            countTotal.put(paper.get(i), mou + 1);
          }
        }
      }
      List<Integer> pot = new ArrayList<>();
      for (Map.Entry<Integer, Integer> e : countTotal.entrySet()) {
        if (e.getValue() % 2 == 1) {
          pot.add(e.getKey());
        }
      }


      pot.sort(Integer::compare);
      answers.add(String.join(" ", pot.stream().map(Object::toString).collect(Collectors.toList())));
    }

    for (int i = 0; i < numCases; i++) {
      output.write(String.format("Case #%d: %s", i + 1, answers.get(i)));
      output.newLine();
      output.flush();
    }
  }


}
