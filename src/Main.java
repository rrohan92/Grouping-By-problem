import java.util.*;

public class Main {

	public void grouping(int [][] matrix){
		int numRows = matrix.length;
		int numCols = matrix[0].length;
		int [][] groupSizes = null;
		boolean [][] set = new boolean[matrix.length][matrix[0].length];

		for(boolean[] row: set){
			Arrays.fill(row, true);
		}

		List<int []> groups = new ArrayList<int []>();

		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[0].length; j++){
				if(set[i][j]){
					int count = 0;
					int finalCount = createGroups(matrix, set, i, j, count, numRows, numCols);

					//Insert into list
					System.out.println(matrix[i][j] + " " + finalCount);
				}
			}
		}
		//return groupSizes;
	}
	
	public int getval(int [][] matrix, int row, int column, int numRows, int numCols){
	
		if(row >= 0 && row < numRows && column >= 0 && column < numCols){
			return matrix[row][column];
		}
		
		else{
			return Integer.MIN_VALUE;
		}
	}

	public int createGroups(int [][] matrix, boolean [][] set, int row, int column, int count, int numRows, int numCols){
		
		if(row >= numRows || column >= numCols){
			return Integer.MIN_VALUE;
		}
		
		count++;
		set[row][column] = false;
		int direction [][] = {{1,0}, {0,1}, {-1,0}, {0,-1}};
		
		for(int i=0; i<4; i++){
			int newi = row + direction[i][0];
			int newj = column + direction[i][1];
			
			int val = getval(matrix, newi, newj, numRows, numCols);
			
			if(val == matrix[row][column] && set[newi][newj]){
				//System.out.println(newi+" "+newj);
				count=createGroups(matrix, set, newi, newj,count, numRows, numCols);
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {

		Main obj = new Main();

		int [][] matrix = new int[][]{
				{0,0,0,0},
				{0,0,1,0},
				{0,0,0,1},
				{0,0,0,0}
		};
		
		obj.grouping(matrix);
	}

}
