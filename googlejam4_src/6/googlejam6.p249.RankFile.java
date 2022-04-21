package googlejam6.p249;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.StringJoiner;

/**
 * Copyright 2016, Emory University
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author 	Henry(Yu-Hsin) Chen ({@code yu-hsin.chen@emory.edu})
 * @version	1.0
 * @since 	Apr 15, 2016
 */
public class RankFile {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		
		int i, j, k, C = in.nextInt(), N, num; StringJoiner joiner;
		Set<Integer> set = new HashSet<>(); List<Integer> list;
		for(i = 1; i <= C; i++){
			N = in.nextInt(); set.clear();
			for(j = 0; j < 2* N-1; j++){
				for(k = 0; k < N; k++){
					num = in.nextInt();
					if(set.contains(num))
						set.remove(num);
					else set.add(num);
				}
			}
			list = new ArrayList<>(set);
			Collections.sort(list);
			System.out.print("Case #" + i + ": ");
			
			joiner = new StringJoiner(" ");
			for(int nn : list) joiner.add(Integer.toString(nn));
			System.out.println(joiner.toString());
		}
		in.close();
	}
}
