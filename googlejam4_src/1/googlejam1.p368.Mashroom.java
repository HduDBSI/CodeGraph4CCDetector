package googlejam1.p368;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;


public class Mashroom {
	public static void main(String[] args) throws IOException {
		Path fFilePath = Paths.get(args[0]);
		try (Scanner scanner = new Scanner(fFilePath,
				StandardCharsets.UTF_8.name())) {
			int count = 0;
			int platesCount;
			while (scanner.hasNextLine()) {
				if (count == 0) {
					scanner.nextLine();
				} else {
					platesCount = Integer.valueOf(scanner.nextLine());
					String plateLine = scanner.nextLine();
					int[] cakes = new int[platesCount];
					Scanner scanner1 = new Scanner(plateLine);
					scanner1.useDelimiter(" ");
					int index = 0;
					while(scanner1.hasNext()){
						String count3 = scanner1.next();
						cakes[index] = Integer.valueOf(count3);
						index++;
					}
					int[] mashrooms = cakes;
					int count1 = 0;
					for(int i = 0; i < mashrooms.length - 1; i++) {
						if(mashrooms[i] > mashrooms[i+1]) {
							count1 += mashrooms[i] - mashrooms[i+1];
						}
					}
					// TODO Auto-generated method stub
					int any = count1;
					int count2 = 0;
					//		double time = mashrooms[0] / 10;
							int max = 0;
							for(int i = 0; i < mashrooms.length - 1; i++) {
								max = Math.max(max, mashrooms[i] - mashrooms[i+1]);
							}
					//		double time = max / 10;
							for(int i = 0; i < mashrooms.length - 1; i++) {
					//			int d =
								if(max < mashrooms[i]) {
									count2 += max;
								} else {
									count2 += mashrooms[i];
								}
							}
					int constant = count2;
					System.out.println("Case #" + count + ": " + any + " " + constant);
				}
				count++;
			}
		}
	}
}
