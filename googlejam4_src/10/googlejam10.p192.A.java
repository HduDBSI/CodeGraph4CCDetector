package googlejam10.p192;
import java.util.*;

public class A {

	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
		
		int num = in.nextInt();
		for(int i = 0; i < num; i++) {
			boolean ayy = false;
			System.out.print("Case #" + (i+1) + ": ");
			int n = in.nextInt();
			int nn = (int) Math.pow(2, n);
			int r = in.nextInt();
			int p = in.nextInt();
			int s = in.nextInt();
			char[] test = new char[nn];
			Arrays.fill(test, 'p');
			if(p == nn) {
				System.out.print("IMPOSSIBLE");
				ayy = true;
			} else {
				boolean solvable = true;
				boolean unsolved = true;
				while(solvable) {
					for(int ii = nn-1; ii >= 0; ii--) {
						if(test[ii] == 'p') {
							test[ii] = 'r';
							break;
						} else if (test[ii] == 'r') {
							test[ii] = 's';
							break;
						}
						if(ii == 0) {
							solvable = false;
							s = -1;
							break;
						} else {
							test[ii] = 'p';
						}
					}
					int cr = 0;
					int cp = 0;
					int cs = 0;
					/*for(int ff = 0; ff < nn; ff++) {
						System.out.print(test[ff]);
					}
					System.out.println();*/
					for(int j = 0; j < nn; j++) {
						if(test[j] == 'p') cp++;
						if(test[j] == 'r') cr++;
						if(test[j] == 's') cs++;
					}
					if(cr != r || cp != p || cs != s) {
							continue;
						}
					//System.out.println("GOOD");
					boolean decent = true;
					while(true && unsolved && decent) {
						int nnn = nn;
						char[] prev = new char[nn];
						char[] rec;
						for(int sp = 0; sp < nn; sp++) {
							prev[sp] = test[sp];
						}
						while(nnn > 1) {
							nnn /= 2;
							rec = new char[nnn];
							for(int mm = 0; mm < nnn; mm++) {
								if(prev[mm*2] == prev[mm*2+1]) {
									nnn = 0;
									decent = false;
									break;
								}
								if(prev[mm*2] != 'r' && prev[mm*2+1] != 'r') {
									rec[mm] = 's';
								} else if(prev[mm*2] != 's' && prev[mm*2+1] != 's') {
									rec[mm] = 'p';
								} else {
									rec[mm] = 'r';
								}
							}
							prev = rec;
						}
						if(decent) {
							unsolved = false;
						}
					}
					if(!unsolved) {
						for(int meh = 0; meh < nn; meh++) {
							if(test[meh] == 'r') System.out.print('R');
							else if(test[meh] == 's') System.out.print('S');
							else System.out.print('P');
						}
						ayy = true;
						break;
					}
				}
			}
			if(!ayy) System.out.print("IMPOSSIBLE");
			System.out.println();
		}
	}

}