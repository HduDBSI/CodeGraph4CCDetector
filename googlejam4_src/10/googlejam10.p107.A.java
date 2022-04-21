package googlejam10.p107;
import java.util.*;

class A {
  static int MAX_N = 12;

  public static void main(String[] args) {
    List[] p = new ArrayList[MAX_N];
    List[] r = new ArrayList[MAX_N];
    List[] s = new ArrayList[MAX_N];
    List[] merged = new ArrayList[MAX_N];
    for (int i = 0; i < MAX_N; ++i) {
      p[i] = new ArrayList();
      r[i] = new ArrayList();
      s[i] = new ArrayList();
      if (i == 0) {
        p[0].add("PR");
        r[0].add("RS");
        s[0].add("PS");
      } else {
        for (Object ao: p[i-1]) for (Object bo: r[i-1]) {
		  String aos = ao.toString();
		  String bos = bo.toString();
		  if (aos.compareTo(bos) > 0) { aos = bo.toString(); bos = ao.toString(); }
		  p[i].add(aos + bos);
		}
        for (Object ao: r[i-1]) for (Object bo: s[i-1]) {
		  String aos = ao.toString();
		  String bos = bo.toString();
		  if (aos.compareTo(bos) > 0) { aos = bo.toString(); bos = ao.toString(); }
		  r[i].add(aos + bos);
		}
        for (Object ao: p[i-1]) for (Object bo: s[i-1]) {
		  String aos = ao.toString();
		  String bos = bo.toString();
		  if (aos.compareTo(bos) > 0) { aos = bo.toString(); bos = ao.toString(); }
		  s[i].add(aos + bos);
		}
      }
      merged[i] = new ArrayList();
      merged[i].addAll(p[i]);
      merged[i].addAll(r[i]);
      merged[i].addAll(s[i]);
      Collections.sort(merged[i]);
    }

    Scanner scan = new Scanner(System.in);
    int tcc = scan.nextInt();
    for (int tc = 1; tc <= tcc; ++tc) {
      int n = scan.nextInt();
      int rc = scan.nextInt();
      int pc = scan.nextInt();
      int sc = scan.nextInt();
      String best = null;
      for (Object o: merged[n - 1]) {
        String os = o.toString();
        if (best != null && o.toString().compareTo(best) > 0) break;
        int rrc = 0;
        int rpc = 0;
        int rsc = 0;
        for (int i = 0; i < os.length(); ++i) {
          if (os.charAt(i) == 'R') ++rrc;
          if (os.charAt(i) == 'P') ++rpc;
          if (os.charAt(i) == 'S') ++rsc;
        }
        if (rrc == rc && rpc == pc && rsc == sc) best = os;
      }
      System.out.printf("Case #%d: ", tc);
      System.out.println(best == null ? "IMPOSSIBLE" : best);
    }
  }
}
