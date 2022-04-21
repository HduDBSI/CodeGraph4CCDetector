package googlejam4.p053;
import java.util.*;
import java.io.*;

public class ProblemA {
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		FileWriter writer = new FileWriter("C:/Users/Max/Documents/Java Workspaces/Google Code Jam/Round 2 2015/src/output.txt");		
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:/Users/Max/Documents/Java Workspaces/Google Code Jam/Round 2 2015/src/input.txt"));
			int numCases = Integer.parseInt(br.readLine());
			for (int caseNum = 1; caseNum <= numCases; caseNum++) {
				String line = br.readLine();
				Scanner sc = new Scanner(line);
				int r = sc.nextInt();
				int c = sc.nextInt();
				char[][] grid = new char[r][c];
				for(int i = 0; i < r; i++){
					line = br.readLine();
					for(int j = 0; j < c; j++){
						grid[i][j] = line.charAt(j);
					}
				}
				int needsChanging = 0;
				boolean[][] needChangeRow = new boolean[r][c];
				boolean[][] needChangeCol = new boolean[r][c];
				boolean[][] impossibleRow = new boolean[r][c];
				boolean[][] impossibleCol = new boolean[r][c];
				for(int i = 0; i < r; i++){
					int firstCol = 0;
					while(firstCol < c && grid[i][firstCol] == '.'){
						firstCol++;
					}
					if(firstCol < c && grid[i][firstCol] != '>'){
						needChangeRow[i][firstCol] = true;
					}
					int lastCol = c - 1;
					while(lastCol >= 0 && grid[i][lastCol] == '.'){
						lastCol--;
					}
					if(lastCol >= 0 && grid[i][lastCol] != '<'){
						needChangeRow[i][lastCol] = true;
					}
					if(firstCol == lastCol){
						impossibleRow[i][firstCol] = true;
					}
					for(int j = firstCol + 1; j < lastCol; j++){
						if(grid[i][j] == 'v' || grid[i][j] == '^'){
							needChangeRow[i][j] = true;
						}
					}
				}
				for(int j = 0; j < c; j++){
					int firstRow = 0;
					while(firstRow < r && grid[firstRow][j] == '.'){
						firstRow++;
					}
					if(firstRow < r && grid[firstRow][j] != 'v'){
						needChangeCol[firstRow][j] = true;
					}
					int lastRow = r - 1;
					while(lastRow >= 0 && grid[lastRow][j] == '.'){
						lastRow--;
					}
					if(lastRow >= 0 && grid[lastRow][j] != '^'){
						needChangeCol[lastRow][j] = true;
					}
					if(firstRow == lastRow){
						impossibleCol[firstRow][j] = true;
					}
					for(int i = firstRow + 1; i < lastRow; i++){
						if(grid[i][j] == '<' || grid[i][j] == '>'){
							needChangeCol[i][j] = true;
						}
					}
				}
				boolean impossible = false;
				for(int i = 0; i < r; i++){
					for(int j = 0; j < c; j++){
						if(needChangeCol[i][j] && needChangeRow[i][j]){
							needsChanging++;
						}
						if(impossibleRow[i][j] && impossibleCol[i][j]){
							impossible = true;
						}
					}
				}
				if(impossible){
					writer.write("Case #" + caseNum + ": " + "IMPOSSIBLE" + "\n");
				} else {
					writer.write("Case #" + caseNum + ": " + "" + needsChanging + "\n");
				}
				
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		writer.close();
	}
}
