package googlejam1.p229;
import static java.util.stream.Collectors.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Mushroom {
  public static void main(String[] args) throws IOException {
    try (Stream<String> lines = Files.lines(Paths.get("CodeJam/in/AA.in"))) {
      List<String> inputs = lines.collect(toList());
      int count = Integer.parseInt(inputs.get(0));
      for (int i = 0; i < count; i++) {
        String[] repeat = inputs.get(i * 2 + 2).split("\\s");
        int[] nums = Arrays.stream(repeat).mapToInt(Integer::parseInt).toArray();
		int prev = 0;
		int s1 = 0;
		for (int i1 = 0; i1 < nums.length; i1++) {
		  if (prev > nums[i1]) {
		    s1 += prev - nums[i1];
		  }
		  prev = nums[i1];
		}
		int max = 0;
		for (int i3 = 0; i3 < nums.length - 1; i3++) {
		  int diff = nums[i3] - nums[i3 + 1];
		  if (diff > 0 && max < diff) {
		    max = diff;
		  }
		}
		int s2 = 0;
		for (int i2 = 0; i2 < nums.length - 1; i2++) {
		  s2 += Math.min(max, nums[i2]);
		}

        String result = s1 + " " + s2;
        System.out.println("Case #" + (i + 1) + ": " + result);
      }
    }
  }
}
