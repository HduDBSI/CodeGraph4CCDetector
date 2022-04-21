package googlejam9.p119;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProblemB {
	public static void main(String[] args) throws FileNotFoundException {
//		Scanner sc = new Scanner(new File("B-small-attempt3.in"));
//		Scanner sc = new Scanner(new File("B.in"));
		Scanner sc = new Scanner(new File("B-large.in"));

		int t = sc.nextInt();
		int count = 1;
		
		long[] possibleRoutes = new long[52];
		for(int i = 2; i <= 50; i++) {
			possibleRoutes[i] = 1;
			for(int j = 0; j < i; j++) {
				possibleRoutes[i] += possibleRoutes[j];
			}
			
//			System.out.println("Numbuildings: " + (i) + " Possible routes: " + possibleRoutes[i]);
		}
		possibleRoutes[1] = 1;

		while (t-- > 0) {
			int B = sc.nextInt(); // num buildings
			long M = sc.nextLong(); // num routes
			
			// To many routes needed
			if(M > possibleRoutes[B]) {
				System.out.println("Case #" + count + ": " + "IMPOSSIBLE");
			// 
			} else {
				int building = B;
				long routes = M;
				System.out.println("Case #" + count + ": " + "POSSIBLE");
//				System.out.println(building);
				boolean buildSlides = false;
				
				for(int j = 0; j < B; j++) {
					if(routes < possibleRoutes[building] && !buildSlides) {
//						System.out.println("Don't use building: " + building + " it gives: " + test[building] + " extra routes");
						// Next one also gives to much slides
						if(routes <= possibleRoutes[building-1]) {
							for(int i = 0; i < B; i++) {
								if(i == j+1) {
									System.out.print("1");
								} else {
									System.out.print("0");
								}
							}
							System.out.println("");
						} else {
							buildSlides = true;
//							routes -= possibleRoutes[building-1];
							for(int i = B; i > 0; i--) {
								if(possibleRoutes[i] <= routes) {
									routes -= possibleRoutes[i];
									System.out.print("1");
								} else {
									System.out.print("0");
								}
							}
							System.out.println("");
						}
					} else {
//						System.out.println("Use building: " + building);
						buildSlides = true;
						for(int i = 0; i < B; i++) {
							if(i > j) {
								System.out.print("1");
							} else {
								System.out.print("0");
							}
						}
						System.out.println("");
					}
					
					building--;
				}
//				System.out.println(routes);
			}

			
			count++;
		}

		sc.close();
	}
}
