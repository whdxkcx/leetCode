package AndCheck;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NumberOfIslands {


    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();
        in.nextLine();
        char[][] grid=new char[n][m];
        for(int i=0;i<n;i++){
            char[] ca=in.nextLine().toCharArray();
            grid[i]=ca;
        }
        NumberOfIslands ni=new NumberOfIslands();
        System.out.println(ni.numIslands(grid));
    }
    public int numIslands(char[][] grid) {
         int count=0;
         int n=grid.length;
         if(n==0||grid[0].length==0) return 0;
         int m=grid[0].length;
         int b[][]=new int[n][m];
         for(int i=0;i<n;i++)
             for(int j=0;j<m;j++){
                 if(grid[i][j]=='0'||b[i][j]==1)
                     continue;
                 dfs(grid,b,i,j);
                 count++;
             }
         return count;
    }

    public void dfs(char[][] grid,int b[][],int i,int j){
       if(i<0||i>=grid.length||j<0||j>=grid[0].length) return;
        if(grid[i][j]=='0'||b[i][j]==1) return;
        b[i][j]=1;
        dfs(grid,b,i-1,j);
        dfs(grid,b,i+1,j);
        dfs(grid,b,i,j-1);
        dfs(grid,b,i,j+1);
    }

}
