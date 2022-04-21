package googlejam2.p368;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by robrob on May 02, 2015.
 */
public class Round1BA {
    public static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> queue = new LinkedList<Integer>();
        int tt = Integer.parseInt(br.readLine().trim());
        for (int i = 1; i <= tt; i++) {
            int question = Integer.parseInt(br.readLine().trim());
            visited = new int[question + 1];
            visited[1] = 1;
            queue.addLast(1);
            if (question == 1) {
                System.out.println("Case #" + i + ": 1");
                continue;
            }
            while (!queue.isEmpty()) {
                Integer j = queue.pollFirst();
                if (visited[j+1] == 0) {
                    visited[j+1] = visited[j] + 1;
                    queue.addLast(j+1);
                }
				String s = String.valueOf(j);
				int index = s.length() - 1;
				while (s.charAt(index) == '0') index--;
                int flipped = Integer.parseInt(new StringBuilder(s.substring(0, index+1)).reverse().toString());
                if (flipped <= question && visited[flipped] == 0) {
                    visited[flipped] = visited[j] + 1;
                    queue.addLast(flipped);
                }
                if (j+1 == question || flipped == question) break;
            }
            queue.clear();
            System.out.println("Case #" + i + ": " + visited[question]);
        }
        br.close();
    }

}
