package AndCheck;

public class SurroundedRegions {
    public  static  void main(String[] args){
           char borad[][]={{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
           SurroundedRegions sr=new SurroundedRegions();
           sr.solve(borad);

        }

    public void solve(char[][] board) {
        int n=board.length;
        if(n==0||board[0].length==0) return;
        int m=board[0].length;
        int b[][]=new int[n][m];

        for(int i=0;i<m;i++){
            if(board[0][i]=='O')
                dfs(board,0,i,b);
            if(board[n-1][i]=='O')
                dfs(board,n-1,i,b);
        }
        for(int i=0;i<n;i++){
            if(board[i][0]=='O')
                dfs(board,i,0,b);
            if(board[i][m-1]=='O')
                dfs(board,i,m-1,b);
        }


        for(int i=0;i<n;i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && b[i][j] == 0)
                    board[i][j] = 'X';
            }
        }
    }


    public void dfs(char[][] board,int i,int j,int b[][]){
        if(i<0||i>=board.length||j<0||j>=board[0].length)  return;
        if(board[i][j]=='X'||b[i][j]==1) return;
        b[i][j]=1;
        dfs(board,i-1,j,b);
        dfs(board,i+1,j,b);
        dfs(board,i,j-1,b);
        dfs(board,i,j+1,b);
    }
}
