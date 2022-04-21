package googlejam2.p162;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class BigCount {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("b.in"));
		//Scanner in = new Scanner(System.in);
		int cases = in.nextInt();
		BigInteger twenty = new BigInteger("20");
		for (int caseNo = 1; caseNo <= cases; caseNo++) {
			BigInteger val = in.nextBigInteger();
			int count = 0;
			
			while (val.compareTo(twenty) > 0) {
				String sVal = val.toString();
				// char first = sVal.charAt(0);
				char last = sVal.charAt(sVal.length() - 1);
				if (last != '1') {
					val = val.subtract(BigInteger.ONE);
					count++;
				} else
				// We know the last digit is 1
				if (val.compareTo(new BigInteger("1000")) < 0 ) {

					int result = 0;
							// System.err.print("reverse of " + i + " is ");
					//		while (i > 0) {
					//			result = result * 10 + i % 10;
					//			i /= 10;
					//		}
							// System.err.println(result);
							
							String forward = val.toString();
							String bw = "";
							for (int j = 0; j < forward.length(); j++)
								bw = forward.charAt(j) + bw;
					BigInteger rev = new BigInteger(bw);
					if (rev.compareTo(val) < 0)
						val = rev;
					else
						val = val.subtract(BigInteger.ONE);
					count++;
				} else {
					char second = sVal.charAt(sVal.length() - 2);
					if (second != '0') {
						val = val.subtract(BigInteger.ONE);
						count++;
					} // The last 2 digits are 01
					
					//  DAMNATION, this is ugly!
					else if (val.compareTo(new BigInteger("100000"))  < 0) {

						int result = 0;
								// System.err.print("reverse of " + i + " is ");
						//		while (i > 0) {
						//			result = result * 10 + i % 10;
						//			i /= 10;
						//		}
								// System.err.println(result);
								
								String forward = val.toString();
								String bw = "";
								for (int j = 0; j < forward.length(); j++)
									bw = forward.charAt(j) + bw;
						BigInteger rev = new BigInteger(bw);
						if (rev.compareTo(val) < 0)
							val = rev;
						else
							val = val.subtract(BigInteger.ONE);
						count++;
					} else {
						char third = sVal.charAt(sVal.length() - 3);
						if (third != '0') {
							val = val.subtract(BigInteger.ONE);
							count++;
						} // The last 3 digits are 001
						else if (val.compareTo(new BigInteger("10000000")) < 0) {

							int result = 0;
									// System.err.print("reverse of " + i + " is ");
							//		while (i > 0) {
							//			result = result * 10 + i % 10;
							//			i /= 10;
							//		}
									// System.err.println(result);
									
									String forward = val.toString();
									String bw = "";
									for (int j = 0; j < forward.length(); j++)
										bw = forward.charAt(j) + bw;
							BigInteger rev = new BigInteger(bw);
							if (rev.compareTo(val) < 0)
								val = rev;
							else
								val = val.subtract(BigInteger.ONE);
							count++;
						}
						else {
							char fourth = sVal.charAt(sVal.length() - 4);
							if (fourth != '0') {
								val = val.subtract(BigInteger.ONE);
								count++;
							} // The last 4 digits are 0001
							else if (val.compareTo(new BigInteger("1000000000")) < 0) {

								int result = 0;
										// System.err.print("reverse of " + i + " is ");
								//		while (i > 0) {
								//			result = result * 10 + i % 10;
								//			i /= 10;
								//		}
										// System.err.println(result);
										
										String forward = val.toString();
										String bw = "";
										for (int j = 0; j < forward.length(); j++)
											bw = forward.charAt(j) + bw;
								BigInteger rev = new BigInteger(bw);
								if (rev.compareTo(val) < 0)
									val = rev;
								else
									val = val.subtract(BigInteger.ONE);
								count++;
							}
							
							//  You know, I really should refactor this to make it more general, but what the hell...I'm
							//  sorta getting in the cut and paste groove...
							else {
								char fifth = sVal.charAt(sVal.length() - 5);
								if (fifth != '0') {
									val = val.subtract(BigInteger.ONE);
									count++;
								} // The last 5 digits are 00001
								else if (val.compareTo(new BigInteger("100000000000")) < 0) {

									int result = 0;
											// System.err.print("reverse of " + i + " is ");
									//		while (i > 0) {
									//			result = result * 10 + i % 10;
									//			i /= 10;
									//		}
											// System.err.println(result);
											
											String forward = val.toString();
											String bw = "";
											for (int j = 0; j < forward.length(); j++)
												bw = forward.charAt(j) + bw;
									BigInteger rev = new BigInteger(bw);
									if (rev.compareTo(val) < 0)
										val = rev;
									else
										val = val.subtract(BigInteger.ONE);
									count++;
								}						
								else {
									char sixth = sVal.charAt(sVal.length() - 6);
									if (sixth != '0') {
										val = val.subtract(BigInteger.ONE);
										count++;
									} // The last 6 digits are 000001
									else if (val.compareTo(new BigInteger("10000000000000")) < 0) {

										int result = 0;
												// System.err.print("reverse of " + i + " is ");
										//		while (i > 0) {
										//			result = result * 10 + i % 10;
										//			i /= 10;
										//		}
												// System.err.println(result);
												
												String forward = val.toString();
												String bw = "";
												for (int j = 0; j < forward.length(); j++)
													bw = forward.charAt(j) + bw;
										BigInteger rev = new BigInteger(bw);
										if (rev.compareTo(val) < 0)
											val = rev;
										else
											val = val.subtract(BigInteger.ONE);
										count++;
									}
									else {  //  And one to grow on...
										char seventh = sVal.charAt(sVal.length() - 7);
										if (seventh != '0') {
											val = val.subtract(BigInteger.ONE);
											count++;
										} // The last 7 digits are 0000001
										else if (val.compareTo(new BigInteger("1000000000000000")) < 0) {

											int result = 0;
													// System.err.print("reverse of " + i + " is ");
											//		while (i > 0) {
											//			result = result * 10 + i % 10;
											//			i /= 10;
											//		}
													// System.err.println(result);
													
													String forward = val.toString();
													String bw = "";
													for (int j = 0; j < forward.length(); j++)
														bw = forward.charAt(j) + bw;
											BigInteger rev = new BigInteger(bw);
											if (rev.compareTo(val) < 0)
												val = rev;
											else
												val = val.subtract(BigInteger.ONE);
											count++;
										}
									}  //  7
								}//6
							}//5
						}//4



					}

				}
			}
			count += val.intValue();

			System.out.println("Case #" + caseNo + ": " + count);

		}
	}

}
