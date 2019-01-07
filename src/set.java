
import java.util.Scanner;

public class set {
    Scanner s = new Scanner(System.in);
    
    int N = play.bs();
    public String[][] board = new String [N][N];
    public boolean hasWon (String [] [] board)
    {
        int counter = 1;
        //horizontal 
        for(int i = 0; i<N; i++)
        {
            for(int j=0;j<N-1;j++)
            {
                if(board[i][j].equals(board[i][j+1]))
                {
                    counter = counter+1;
                }
                if(counter == N)
                {
                    return true;
                }
            }
            counter = 1;
        }
        
        counter = 1;
        //vertical
        for(int i = 0; i<N; i++)
        {
            for(int j=0;j<N-1;j++)
            {
                if(board [j][i].equals(board[j+1][i]))
                {
                    counter = counter+1;
                }
                if(counter == N)
                {
                    return true;
                }
            }
            counter = 1;
        }
        
        counter = 1;
        //diagonal from left-top to right-bottom
        for(int i=0;i<N-1;i++)
        {
            if(board[i][i].equals(board[i+1][i+1]))
            {
                counter = counter+1;
            }
            if (counter==N)
            {
                return true;
            }
            //counter = 1;
        }
        
        counter = 1;
        //diagonal from right-top to left-bottom
        for(int i=0;i<N-1;i++)
        {
            if(board[i][N-1-i].equals(board[i+1][N-1-(i+1)]))
            {
                counter = counter+1;
            }
            if (counter==N)
            {
                return true;
            }
            //counter = 1;
        }
        return false;
    }


    int x = 1;

    public void createBoard()
    {
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board.length; j++)
            {
                board[i][j] = "" + (x);
                x++;
            }
        }
    }

    public void printBoard()
    {
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board.length; j++)
            {
                //System.out.print("[ - ] ");
                System.out.print("[ " + board[i][j] + " ]" + " ");
            }
            System.out.println();
        }
    }
    
    public String[][] getBoard()
    {
        return board;
    }
    
    
    }
