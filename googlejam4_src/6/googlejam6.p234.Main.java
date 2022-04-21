package googlejam6.p234;
/**
 * File Name: Main.java
 * Package Name: com.ncfxy.codejam
 * Description： TODO 
 *
 *   ver					date			author
 * ──────────────────────────────────
 *   1.0-SNAPSHOT			2016年4月16日			Administrator
 *
 * Copyright (c) 2016, ncfxy All Rights Reserved.
 */


import java.util.Arrays;
import java.util.Scanner;

/**
 * ClassName: Main<br/>
 * Description: TODO ADD Description
 *
 * @author Administrator
 * @version 1.0-SNAPSHOT
 * @Date 2016 2016年4月16日 上午8:45:47
 */
public class Main {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		while (cin.hasNext()) {
			int t = cin.nextInt();
			for(int caseNumber = 1;caseNumber <= t;caseNumber++){
				int pool[] = new int[3000];
				Arrays.fill(pool, 0);
				int N = cin.nextInt();
				for(int i = 1;i < 2 * N;i++){
					for(int j = 0;j < N;j++){
						int x = cin.nextInt();
						pool[x]++;
					}
				}
				String result = "";
				for(int i = 0;i < 3000;i++){
					if((pool[i] & 1) == 1){
						result = result + i + " ";
					}
				}
				String output = result.substring(0,result.length()-1);
				System.out.println("Case #"+caseNumber+": "+output);
			}
			
		}
	}

}
