import java.util.*;

public class Main {

	public void grouping(int [][] matrix){
		int [][] groupSizes = null;
		boolean [][] set = new boolean[matrix.length][matrix[0].length];

		for(boolean[] row: set){
			Arrays.fill(row, true);
		}

		List<int []> groups = new ArrayList<int []>();

		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[0].length; j++){
				if(set[i][j]){
					int count = createGroups(matrix, set, i, j);

					//Insert into list
					System.out.println(matrix[i][j] + " " + count);

				}
			}
		}


		//return groupSizes;

	}

	public int createGroups(int [][] matrix, boolean [][] set, int row, int column){

		int count = 0;	
		int numRows = matrix.length;
		int numCols = matrix[0].length;
		int self = matrix[row][column];
		int side = -1; 
		int below = -1;

		//Normal case
		if(row < numRows - 1 && column < numCols - 1){
			side = matrix[row][column+1];
			below = matrix[row+1][column];
		}

		//Edge case for last row
		else if(row == numRows - 1 && column != numCols - 1){
			side = matrix[row][column+1];
		}

		//Edge case for last column
		else if(column == numCols - 1 && row != numRows - 1){
			below = matrix[row+1][column];
		}

		//Base case + edge case
		if((self != side && self != below) || (row == numRows-1 && column == numCols-1)){
			return count+1;
		}

		else if(column < numCols-1 && self == side && self != below){
			set[row][column+1] = false;
			return createGroups(matrix, set, row, column+1)+1;
		}

		else if(row < numRows-1 && self == below && self != side){
			set[row+1][column] = false;
			return createGroups(matrix, set, row+1, column)+1;
		}

		else if(self == side && self == below){
			set[row][column+1] = false;
			set[row+1][column] = false;
			return createGroups(matrix, set, row, column+1) + createGroups(matrix, set, row+1, column) + 2;
		}

		return 0;

	}

	public static void main(String[] args) {

		Main obj = new Main();

		int [][] matrix = new int[][]{
				{0,1,1,3},
				{1,0,1,2},
				{1,0,0,2},
				{1,1,1,1}
		};
		
		obj.grouping(matrix);
	}

}
