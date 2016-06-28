import java.util.*;

public class Main {

	public int[][] groupPaysEval(int [][] matrix){
		//Check if matrix is null or empty
		if(matrix == null || matrix.length == 0){
			return new int[][]{};
		}

		//Declarations
		int numRows = matrix.length;
		int numCols = matrix[0].length;
		int [][] groupSizes = null;
		boolean [][] set = new boolean[numRows][numCols];
		List<int []> groups = new ArrayList<int []>();


		//Initializing the boolean array with true
		for(boolean[] row: set){
			Arrays.fill(row, true);
		}

		for(int i=0; i<numRows; i++){
			for(int j=0; j<numCols; j++){
				if(set[i][j]){
					int count = 0;
					int finalCount = createGroups(matrix, set, i, j, count, numRows, numCols);

					//System.out.println(matrix[i][j] + " " + finalCount);
					//Insert into list
					groups.add(new int[]{matrix[i][j], finalCount});
				}
			}
		}
		groupSizes = groups.toArray(new int[groups.size()][]);
		return groupSizes;
	}

	public int getValue(int [][] matrix, int row, int column, int numRows, int numCols){

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

			int value = getValue(matrix, newi, newj, numRows, numCols);

			if(value == matrix[row][column] && set[newi][newj]){
				count = createGroups(matrix, set, newi, newj,count, numRows, numCols);
			}
		}
		return count;
	}

	public static void main(String[] args) {

		Main obj = new Main();

		int [][] matrix = new int[][]{
				{0,1,1,3},
				{1,0,1,2},
				{1,0,0,2},
				{1,1,1,1}
		};

		int [][] groupSizes = obj.groupPaysEval(matrix);

		//Display results
		for(int i=0; i<groupSizes.length; i++){
			for(int j=0; j<groupSizes[0].length; j++){
				System.out.print(groupSizes[i][j] + " ");
			}
			System.out.println();
		}
	}
}
