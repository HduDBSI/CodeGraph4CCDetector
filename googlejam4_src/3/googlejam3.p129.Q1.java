package googlejam3.p129;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Scanner;

public class Q1 {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new FileInputStream(new File("A-large.in")));
			BufferedWriter bos = new BufferedWriter(new FileWriter(new File("A-large.out")));
			int cNum = Integer.parseInt(sc.nextLine());
			for (int i = 0; i < cNum; i++) {
				String[] nums = sc.nextLine().split(" ");
				int R = Integer.parseInt(nums[0]);
				int C = Integer.parseInt(nums[1]);
				int W = Integer.parseInt(nums[2]);
				int optimal =  (C/W) * R +W -1; 
				optimal += C%W == 0 ? 0 : 1;
				bos.write(String.format("Case #%d: %d\n", i + 1, optimal));
				bos.flush();
			}
			sc.close();
			bos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
