package googlejam1.p332;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;


public class Mushroom {

	private String folderName="C:/Data/workspaces/workspaces2015/cj/codejam/files" ; 
	
	private String fileName="A-large" ;
	
	private String inputFileName=fileName+".in" ; 
	
	private String outputFileName=fileName+".out" ; 
	
	private BufferedReader reader ;
	
	private BufferedWriter writer ;
	
	private Integer nCases ;
	
	private Integer caseNumber ;
	
	private Integer n ;
	
	private int[] q ;
	
	public static void main(String[] args) {
		try {
			Mushroom sc=new Mushroom() ;
			sc.reader=new BufferedReader(new FileReader(new File(sc.folderName,sc.inputFileName))) ;
			sc.nCases=new Integer(sc.reader.readLine()) ;
			System.out.println("nCases="+sc.nCases);
			sc.writer=new BufferedWriter(new FileWriter(new File(sc.folderName,sc.outputFileName))) ;
			for (int i=1 ; i<=sc.nCases ; i++) {
				sc.caseNumber=i ;
				sc.n=new Integer(sc.reader.readLine()) ;
				sc.q=new int[sc.n] ;
				StringTokenizer st=new StringTokenizer(sc.reader.readLine()," ",false) ;
				for (int i1=0 ; i1<sc.n ; i1++) {
					sc.q[i1]=new Integer(st.nextToken()) ;
				}
				int ans=0 ;
				for (int i1=1 ; i1<sc.n ; i1++) {
					int diff=sc.q[i1-1]-sc.q[i1] ;
					if (diff>0) ans+=diff ;
				}
				int method1=ans ;
				int ans1=0 ;
				int max=0 ;
				for (int i1=1 ; i1<sc.q.length ; i1++) {
					int diff=sc.q[i1-1]-sc.q[i1] ;
					if (diff>max) max=diff ;
				}
				for (int i2=0 ; i2<(sc.q.length-1) ; i2++) {
					if (sc.q[i2]>max) {
						ans1+=max ;
					} else {
						ans1+=sc.q[i2] ;
					}
				}
				int method2=ans1 ;
				String output="Case #"+sc.caseNumber+": "+method1+" "+method2 ;
				sc.writer.write(output+"\n") ;
			}
			sc.reader.close() ;
			sc.writer.flush() ;
			sc.writer.close() ;
		} catch (Exception exp) {
			exp.printStackTrace() ;
		}
	}

}
