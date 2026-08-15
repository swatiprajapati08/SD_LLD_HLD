package LLD.Problems;


import java.util.ArrayList;
import java.util.List;

class Board{
   /* int size;
    Character[][] board;

    Board(int size){
        this.size = size;
        board = new Character[size][size];
    }

    boolean play(Symbol symbol,int r, int c){
        // add at position
        if(board[r][c] != null) {
            board[r][c] = symbol.name().charAt(0);
            // check if wins
            isWin(symbol, r, c);
        }
    }

    boolean isWin(Symbol symbol, int r,int c){
        boolean horizontal = true,vertical = true, diagonal = true, antiDiagonal =true;

        for(int i=0;i<board.length;i++){
            if(board[r][i] == null || board[r][i] !=symbol.name().charAt(0)){
                horizontal = false;
                break;
            }
        }


        for(int i=0;i<board[0].length;i++){
            if(board[i][c] == null || board[i][c] !=symbol.name().charAt(0)){
                vertical = false;
                break;
            }
        }


        for(int i=0,j=0;i<board[0].length;i++,j++){
            if(board[i][j] == null || board[i][j] !=symbol.name().charAt(0)){
                diagonal = false;
                break;
            }
        }

        for (int i = 0, j = board.length - 1; i < board.length; i++, j--) {
            if(board[i][j] == null || board[i][j] !=symbol.name().charAt(0)){
                antiDiagonal = false;
                break;
            }
        }

        return horizontal || vertical || diagonal || antiDiagonal;
    }
}


class Player{
    String name;
    Symbol symbol;
}

enum Symbol{
    X,O,$
}



public class TicTacToe {
    Board board;
    List<Player> playerList;


    TicTacToe(int size){
        board = new Board(size);
        playerList = new ArrayList<>();
    }


    void addPlayer(Player player){
        playerList.add(player);
    }


    void play(Player p,int x,int y){
        board.play(p.symbol,x,y);
    }
*/
}
