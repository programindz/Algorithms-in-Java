import java.util.*;

public class NQueens{

	static void printSol(int[][] board, int n){
		for(int i = 0;i<n;i++){
			for(int j= 0; j<n;j++){
				if(board[i][j] == 1)
					System.out.print("Q ");
				else
					System.out.print("- ");
			}
			System.out.println();
		}
		System.out.println();
	}
	static boolean isSafe(int[][] board, int row, int col, int n){
		int i, j;
		for(i =0; i<row; i++){
			if(board[i][col] == 1)
				return false;
		}

		for(i = row, j = col; i>=0 && j>=0; i--,j--){
			if(board[i][j] == 1)
				return false;
		}
		for(i= row, j= col; i>=0 && j < n; i--,j++){
			if(board[i][j] == 1)
				return false;
		}

		return true;
	}

	static void solve(int[][] board, int idx, int n){
		if(idx>=n){
			printSol(board, n);
			return;
		}

		for(int i = 0; i<n; i++){
			if (isSafe(board, idx, i, n)){
				board[idx][i] = 1;
				solve(board, idx+1, n);
				board[idx][i] = 0;
			}
		}
	}

	static void nQueens(int n){
		int board[][] = new int[n][n];
		for(int i = 0;i<n;i++){
			for(int j= 0; j<n;j++){
					board[i][j] = 0;
			}
		}

		solve(board, 0, n);
	}

	public static void main(String[] args){
		int n = 5;

		nQueens(n);
	}
}