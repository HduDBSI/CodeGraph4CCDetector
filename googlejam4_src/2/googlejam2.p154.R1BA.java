package googlejam2.p154;


import java.util.Scanner;

public class R1BA {

    static long[] tens = new long[] {
            1L,
            10L,
            100L,
            1000L,
            10000L,
            100000L,
            1000000L,
            10000000L,
            100000000L,
            1000000000L,
            10000000000L,
            100000000000L,
            1000000000000L,
            10000000000000L,
            100000000000000L,
            1000000000000000L
    };

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {

            final long N = in.nextLong();

            long x = N;
            long c = 0;
			long x1 = x;
			int bits1 = 0;
			while(x1 > 0) {
			    bits1++;
			    x1 /= 10;
			}

            int bits = bits1;

            /*
            while(bits > 1) {

                int bits2 = bits / 2;

                int lb = 0;
                long l = 0, h = 0;
                while(lb < bits2) {
                    int hb = bits - lb - 1;
                    l = get(x, lb);
                    h = get(x, hb);
                    if (l != h)
                        break;
                    if ((lb == 0 && l != 1) || (lb > 0 && l != 0))
                        break;
                    lb++;
                }

                if(lb == 0 && h == 0) {
                    throw new RuntimeException();
                }

                if(lb >= bits2) {
                    // pattern 1000001..
                    long all9 = tens[bits - 1] - 1;
                    c += (x - all9);
                    x = all9;
                    bits --;
                    continue;
                }

                if(lb == 0) {
                    if(l > 1) {
                        x -= (l - 1);
                        c += (l - 1);
                    } else if(l == 1) {
                        // l == 1, h != l (h > 1)
                        x = flip(x);
                        c++;
                    } else {
                        // l = 0
                        x--;
                        c++;
                        bits = bits(x);
                    }
                } else {
                    if(l > 0) {
                        x -= (l * tens[lb]);
                        c += (l * tens[lb]);
                    } else {
                        x = flip(x);
                        c++;
                    }
                }
            }
            */

            while(bits > 1) {
                if(x % 10 == 0) {
                    x--;
                    c++;
					long x2 = x;
					int bits2 = 0;
					while(x2 > 0) {
					    bits2++;
					    x2 /= 10;
					}
                    bits = bits2;
                    continue;
                }
                int lb = 0;
                long lo = 0, hi = 0;
                while (lb < bits / 2) {
                    int hb = bits - lb - 1;
                    long l = (x % tens[lb + 1]) / tens[lb];
                    long h = (x % tens[hb + 1]) / tens[hb];
                    lo += (l * tens[lb]);
                    hi += (h * tens[lb]);
                    lb++;
                }

                if(lo > 1) {
                    // reduce lower to 1
                    x -= (lo - 1);
                    c += (lo - 1);
                } else {
                    // already reduced
                    if(hi > 1) {
                        long x2 = x;
						long n = 0;
						while (x2 > 0) {
						    long m = x2 % 10;
						    x2 /= 10;
						    n = (n * 10) + m;
						}
						x = n;
                        c++;
                    } else {
                        // pattern 1000x0001..
                        long all9 = tens[bits - 1] - 1;
                        c += (x - all9);
                        x = all9;
                        bits --;
                    }
                }
            }

            c += x;

            System.out.format("Case #%d: %d\n", t, c);
        }

    }

}
