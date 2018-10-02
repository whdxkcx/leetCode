package Devide;

public class Searcha2DMatrixII240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows=matrix.length;
        if(rows==0)  return false;
        int lines=matrix[0].length;
        int i=0,j=lines-1;
        while(j>=0&&i<rows){
            if(matrix[i][j]==target)  return true;
            else if(matrix[i][j]>target) j--;
            else i++;
        }
        return false;
    }
}
