package googlejam1.p752;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Monstor {

	public static void main(String[] args) {
		Monstor r = new Monstor();
		File inputFile = new File("/Users/aganavin/Desktop/A-large.in");
				BufferedReader br = null;
				StringBuilder output = new StringBuilder();
				try {
					 // String buffer for storing the output
					br = new BufferedReader(new FileReader(inputFile));
					int numTests = Integer.parseInt(br.readLine());
					int test;
					String [] testSplit;
					int [] mush;
					
					// Loop through each test
					for (int testCounter = 0; testCounter < numTests; ++testCounter) {
						test=Integer.parseInt(br.readLine());
						
						testSplit=(br.readLine()).split(" ");
						mush= new int[test];
						for(int s=0;s<test;s++)
						{
							mush[s]=Integer.parseInt(testSplit[s]);
						}
						int out1=0,out2=0;
						int currentDiff=0,maxDiff=0;
						out1=0;
						for(int s=test-1;s>0;s--)
						{
							if(mush[s]<mush[s-1])
							{
								currentDiff=mush[s-1]-mush[s];
								out1+=currentDiff;
								maxDiff=(maxDiff<currentDiff)?currentDiff:maxDiff;
								
							}
						}
						for(int s=test-1;s>0;s--)
						{
							if(mush[s-1]<maxDiff)
							{
								out2+=mush[s-1];
								
							}
							else
							{
								out2+=maxDiff;
							}
						}
						System.out.println("Case #"+(testCounter+1)+": "+out1+" "+out2);
		//				System.out.println("Done");
						output.append("Case #").append((testCounter+1)).append(": ").append(out1+" "+out2);
						output.append("\n");
					}
				} catch (Exception e) {
		//			System.out.println(e);
				}
				File outputFile = new File("/Users/aganavin/Desktop/output1.out");
				BufferedWriter writer = null;
				try
				{
				    writer = new BufferedWriter( new FileWriter(outputFile ));
				    writer.write( output.toString());
				
				}
				catch ( IOException e)
				{
				}
				finally
				{
				    try
				    {
				        if ( writer != null)
				        writer.close( );
				    }
				    catch ( IOException e)
				    {
				    }
				}

	}
}
