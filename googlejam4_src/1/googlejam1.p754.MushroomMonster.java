package googlejam1.p754;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class MushroomMonster {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner scanner = new Scanner(new FileInputStream("A-small-attempt0.in"));
//		Scanner scanner = new Scanner(new FileInputStream("MM_input.txt"));
		Scanner scanner = new Scanner(new FileInputStream(args[0]));
		scanner.nextLine();
		int c = 1;
		while (scanner.hasNext()) {//at most 100
			int answer1 = 0;
			int answer2 = 0;
			scanner.nextLine();
			StringTokenizer tokens = new StringTokenizer(scanner.nextLine());
			ArrayList<Integer> listMushroom = new ArrayList<Integer>();
			while (tokens.hasMoreElements()) { //at most 1000
				listMushroom.add(Integer.parseInt(tokens.nextToken()));
			}
			for (int i = 1; i < listMushroom.size(); i++) {
				if(listMushroom.get(i-1)>listMushroom.get(i)){
					answer1+=listMushroom.get(i-1)-listMushroom.get(i);
				}
			}
			int d = listMushroom.get(0)-listMushroom.get(1);
			int least = (d>0)?d:0;
			int most = 10000;//listMushroom.get(0);
			boolean finish = false;
			for (int e = least; e<=most&&!finish; e++){
				answer2=0;
//				System.out.println(e);
				for (int i = 1; i < listMushroom.size()&& !finish; i++) {
					int a = (e>listMushroom.get(i-1))?listMushroom.get(i-1):e;
					if(i==listMushroom.size()-1
							&&(listMushroom.get(i-1)-e)<=listMushroom.get(i)){
						finish=true;
					}
					if(listMushroom.get(i-1)-a>listMushroom.get(i)){
						break;
					}
					answer2+=a;
//					System.out.print(a+" ");
				}
//				System.out.println();
			}
			System.out.println("Case #"+c+": "+answer1+" "+answer2);
//			System.out.println(finish);
			++c;
		}
		scanner.close();
	}
}
