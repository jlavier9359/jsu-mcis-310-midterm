package edu.jsu.mcis; 

public class ConnectFour {
    public enum Token { RED, BLACK, EMPTY }
    public enum Result { NONE, RED_WIN, BLACK_WIN, TIE }
    public static final int COLUMNS = 7;
    private final int ROWS = 6;
    private Token[][] board;
    private boolean redTurn;
    
    public ConnectFour() {
        board = new Token[ROWS][COLUMNS];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                board[i][j] = Token.EMPTY;
            }
        }
        redTurn = true;
    }
    
	// Is able to check if the top row has an EMPTY,RED,or BLACK
    public Token getTopOfColumn(int col) {
		if(board[5][col] == Token.RED){
			return Token.RED;
		}
		else if(board[5][col] == Token.BLACK){
			return Token.BLACK;
		}
		return Token.EMPTY;	
    }
    
    public int getHeightOfColumn(int col) {
        if(board[5][col] != Token.EMPTY){
			return 5;
		}
		else if(board[4][col] != Token.EMPTY){
			return 4;
		}
		else if(board[3][col] != Token.EMPTY){
			return 3;
		}
		else if(board[2][col] != Token.EMPTY){
			return 2;
		}
		else if(board[1][col] != Token.EMPTY){
			return 1;
		}
		else if(board[0][col] != Token.EMPTY){
			return 0;
		}
		return 0;
    }
    
	// Brute force it to drop tokens 
    public boolean dropTokenInColumn(int col) {
			if(board[5][col] == Token.EMPTY & redTurn == true){
				board[5][col] = Token.RED;
				redTurn = false;
			}
			else if(board[4][col] == Token.EMPTY & redTurn == false){
				board[4][col] = Token.BLACK;
				redTurn = true;
			}
			else if(board[3][col] == Token.EMPTY & redTurn == true){
				board[3][col] = Token.RED;
				redTurn = false;
			}
			else if(board[2][col] == Token.EMPTY & redTurn == false){
				board[2][col] = Token.BLACK;
				redTurn = true;
			}
			else if(board[1][col] == Token.EMPTY & redTurn == true){
				board[1][col] = Token.RED;
				redTurn = false;
			}
			else if(board[0][col] == Token.EMPTY & redTurn == false){
				board[0][col] = Token.BLACK;
				redTurn = true;
			}
			return true;
    }
    
    public Result getResult() {
        return Result.TIE;
    }
    
    
    // Here are a couple of private methods to give you
    // an idea of a more clever way to determine winners.
    private boolean doesRedWinVerticallyInColumn(int col) {
        String columnString = makeStringFromColumn(col);
        return (columnString.indexOf("RRRR") >= 0);
    }
    
    private String makeStringFromColumn(int col) {
        String s = "";
        for(int row = 0; row < ROWS; row++) {
            if(board[row][col] == Token.RED) s += "R";
            else if(board[row][col] == Token.BLACK) s += "B";
            else s += " "; 
        }
        return s;
    }
}












