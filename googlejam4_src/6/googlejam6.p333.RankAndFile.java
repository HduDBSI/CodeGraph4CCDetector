package googlejam6.p333;


import java.util.*;

public class RankAndFile {
	public static void main(String[] args){		
		Scanner scanner = new Scanner(System.in);
		int testcases = Integer.parseInt(scanner.nextLine());
		for(int i=1; i<=testcases; i++){
			int N = Integer.parseInt(scanner.nextLine());
			List<List<Integer>> matrix = new ArrayList<List<Integer>>();
			
			for(int j=0; j<2*N-1; j++){
				String[] arr = scanner.nextLine().split(" ");
				List<Integer> list = new ArrayList<Integer>();
				for(int k=0; k<arr.length; k++){
					list.add(Integer.parseInt(arr[k]));
				}
				matrix.add(list);
			}
			
			System.out.print(String.format("Case #%d: ", i));
			Set<Integer> set = new HashSet<Integer>();
			
			for(int i1=0; i1<matrix.size(); i1++){
				for(int j=0; j<matrix.get(i1).size(); j++){
					int num = matrix.get(i1).get(j);
					if(set.contains(num)){
						set.remove(num);
					}else{
						set.add(num);
					}
					
				}
			}
			
			int[] arr = new int[N];
			int index = 0;
			for(int num : set){
				arr[index++] = num;
			}
			
			Arrays.sort(arr);
			
			for(int i2=0; i2<arr.length; i2++){
				System.out.print(arr[i2] + " ");
			}
			System.out.println();
		}
		scanner.close();
	}
	
}
