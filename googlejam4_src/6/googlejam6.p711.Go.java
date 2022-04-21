package googlejam6.p711;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class Go 
{
	static LinkedList<BigInteger> divisorList=new LinkedList<BigInteger>();
	public static void main(String args[]) throws IOException
	{
		File inputFileName = new File("D:\\Eclipse3\\CodeJam2016\\src\\Input\\B-large (1).in");
		File outputFileName = new File("D:\\Eclipse3\\CodeJam2016\\src\\Output\\B-large (1).out");

		FileReader fileReader=null;
		BufferedReader bufferedReader=null;
		
		FileWriter fileWriter=null;
		BufferedWriter bufferedWriter=null;
		
		try
		{
			
	        String line = null;
	        
	        int lineNo=0;
	        int caseNo=0,noOfCases;
	        
	        String string2Write;
	        
	        fileReader = new FileReader(inputFileName);
	        bufferedReader = new BufferedReader(fileReader);
	        
	        fileWriter = new FileWriter(outputFileName);
	        bufferedWriter = new BufferedWriter(fileWriter);

	        int argNo=0; //0 means Test cases, 1 means N, 2 means matrix
	        int matrixN=-1;
	        
	        while((line = bufferedReader.readLine()) != null) 
	        {
	        	
	        	switch(argNo)
	        	{
	        		case 0:
	        			argNo=1;
	        			break;
	        		case 1:
	        			matrixN=Integer.valueOf(line);
	        			caseNo++;
	        			argNo=2;
	        		case 2:
	        			int[][] matrix=new int[2*matrixN-1][matrixN];
	        			
	        			for(int i=0;i<(2*matrixN-1);i++)
	        			{
	        				line = bufferedReader.readLine();
	        				String[] numbersInString=line.split(" ");
	        				int col=0;
	        				
	        				for(String s:numbersInString)
	        				{
	        					matrix[i][col]=Integer.valueOf(s);
    							col++;
	        				}
	        				
	        			}
					HashMap<Integer,Integer> countHeights=new HashMap<Integer,Integer>();
					int[] missingRowOrColumn1=new int[matrixN];
					
					for(int r=0;r<matrix.length;r++)
					{
						for(int c=0;c<matrix[r].length;c++)
						{
							int currentHeight=matrix[r][c];
							if(countHeights.containsKey(currentHeight))
							{
								int existingCounts=countHeights.get(currentHeight);
								countHeights.put(currentHeight, (existingCounts+1));
							}
							else
							{
								countHeights.put(currentHeight, 1);
							}
						}
					}
					int i1=0;
					
					for(int height:countHeights.keySet())
					{
						int count=countHeights.get(height);
						
						if(count%2!=0)
						{
							missingRowOrColumn1[i1]=height;
							i1++;
						}
					}
					
					
					Arrays.sort(missingRowOrColumn1);
	        			
	        			int[] missingRowOrColumn=missingRowOrColumn1;
	        			string2Write="Case #"+String.valueOf(caseNo)+": ";
	        			
	        			for(int i=0;i<missingRowOrColumn.length;i++)
	        			{
	        				string2Write=string2Write+(String.valueOf(missingRowOrColumn[i]))+" ";
	        			}
	        			string2Write=string2Write+"\n";
	        			
	        			bufferedWriter.write(string2Write);
	        			argNo=1;
	        			break;
	        	}
	        	
	        }
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			bufferedReader.close();
			bufferedWriter.close();
		}
        
        
	}

}
