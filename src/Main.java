import java.util.*;

public class Main {

	public int [][] grouping(int [][] matrix){
		int [][] groupSizes = null;
		List<int []> groups = new ArrayList<int []>();
		
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[0].length; j++){
				//int count = function name(matrix, i, j);
				
				//Insert into list
			}
		}
		
		
		return groupSizes;
		
	}

	/*function name(matrix, int row, int column){
	 int count = 1;
	 int self = matrix[row][column];
	 int side = matrix[row][column+1];
	 int below = matrix[row+1][column];
	 
	 if(self != side && self != below){
	 	return count;
	 }
	 
	 if(self == side && self != below){
	   count++;
	   return count + function name(matrix, row, column);
	 }
	 
	 if(self == below && self != side){
	 	count++;
	 	return count + function name(matrix, row, column);
	 }
	 
	 if(self == side && self == below){
	 	count += 2;
	 	return count + function(matrix, row, column) + function(matrix, row, column);
	 }
	 
}
*/
	public static void main(String[] args) {
	
	}

}
