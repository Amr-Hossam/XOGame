import java.util.InputMismatchException;
import java.util.Scanner;

public class play
{
    public static int N;
    public static void main(String[] args)
    {
        try
        {
            System.out.println("Welcome to Tic-Tac-Toe!!!");
            System.out.println();
            

            //creat markers
            String marker1 = "x";
            String marker2 = "o";
            int playAgain;

            Scanner s = new Scanner(System.in);

            do
            {
                //Determining the size of the board
                N = getBoardSizebs();
                
                if(N<=0)
                 {
                     System.out.println("Size of the board must be greater than '0'!"
                             + "\nPlease enter a valis number for size!!");
                     System.exit(N);
                 }
                //run board setup
                set Setup = new set();
            
                Setup.createBoard();
                Setup.printBoard();
       
                System.out.println("\nChoose the level you want to play from the following options"
                        + "\n\t1. Easy\n\t2. Medium\n\t3.Hard"
                        + "\nSelect from (1,2,3) for (Easy, Medium, Hard) levels!!");
                int level = s.nextInt();
                if(level == 1)
                {
                    //create player objects
                    Human human = new Human();
                    Easy computer = new Easy();
                    System.out.println("please choose your marker");
                    System.out.println("type 1 for 'X' or 2 for 'O'");

                    int marker = s.nextInt();
                    //set markers
                    if(marker == 1)
                    {
                        // create player objects
                        System.out.println("You chose cross 'X'");
                        human.setMarker("X");
                        computer.setMarker("O");
                    } 
                    else if(marker == 2)
                    {
                        System.out.println("You chose Knought 'O'");
                        human.setMarker("O");
                        computer.setMarker("X");
                    }
                    else if((marker != 1) && (marker != 2))
                    {
                        System.out.println("Please choose either '1' or '2'!!");
                        System.exit(marker);
                    }
                    // determine who goes first
                    int first = (int) (Math.random() * 2);

                    boolean won = false;
                    int turns = 0;
                
                    if(first == 0)
                    {
                        System.out.println("You got to make the first move!");
                        if((N == 1) || (N == 2))
                        {
                            System.out.println("When the board is of size 1X1 or 2X2, "
                                    + "\n first player wins the game!! "
                                    + "\nCongratulations!!! You won the game!!");
                            System.exit(turns);
                        }
                    }
                    else
                    {
                        System.out.println("I make the first move!");
                        if((N == 1) || (N == 2))
                        {
                            System.out.println("When the board is of size 1X1 or 2X2, "
                                    + "\n first player wins the game!! "
                                    + "\nYayy!! I won the game!!");
                            System.exit(turns);
                        }
                    }
                
                    if(first == 0)
                    {
                        System.out.println();
                        while(!won)
                        {
                            human.takeTurn(Setup.getBoard());
                            turns++;
                            Setup.printBoard();
                            if(Setup.hasWon(Setup.getBoard()))
                            {
                                won = true;
                                System.out.println("Congrats, you won!");
                            }
                            if(turns == N*N)
                            {
                                won = true;
                                //System.out.println(N*N);
                                System.out.println("Its a bore draw!");
                                break;
                            }
                            if(!won)
                            {
                                computer.takeTurn(Setup.getBoard(), human);
                                turns++;
                                System.out.println();
                                Setup.printBoard();
                                System.out.println();
                                if(Setup.hasWon(Setup.getBoard()))
                                {
                                    won = true;
                                    System.out.println("You just lost a game to an A.I"
                                        + " with an incomplete rule set.\nFACEPALM. :D");
                                }
                                if(turns == N*N)
                                {
                                    won = true;
                                    System.out.println("Its a bore draw!");
                                    break;
                                }
                            }   
                        }  // close while 1
                    }
                    else 
                    {
                        System.out.println();
                        while(!won)
                        {
                            computer.takeTurn(Setup.getBoard(), human);
                            turns++;
                            Setup.printBoard();
                            if(Setup.hasWon(Setup.getBoard()))
                            {
                                won = true;
                                System.out.println("You just lost a game to an A.I "
                                        + "with an incomplete rule set.\nFACEPALM. :D");
                            }
                            
                            //checks if maximum moves are made and declares a draw
                            if(turns == N*N)
                            {
                                won = true;
                                System.out.println("Its a draw!");
                                break;
                            }
                            if(!won)
                            {
                                human.takeTurn(Setup.getBoard());
                                turns++;
                                System.out.println();
                                Setup.printBoard();
                                System.out.println();
                                if(Setup.hasWon(Setup.getBoard()))
                                {
                                    won = true;
                                    System.out.println("You won the game!");
                                }
                                if(turns == N*N)
                                {
                                    won = true;
                                    System.out.println("Its a draw!");
                                    break;
                                }
                            }
                        }  // close while 2
                    }
                }
                else if(level == 2)
                {
                    //create player objects
                    Human human = new Human();
                    Medium computer = new Medium();
                    System.out.println("please choose your marker");
                    System.out.println("type 1 for 'x' or 2 for 'o'");

                    int marker = s.nextInt();
                    //set markers
                    if(marker == 1)
                    {
                        // create player objects
                        System.out.println("You chose cross 'X'");
                        human.setMarker("X");
                        computer.setMarker("O");
                    } 
                    else if(marker == 2)
                    {
                        System.out.println("You chose Knought 'O'");
                        human.setMarker("O");
                        computer.setMarker("X");
                    }
                    else if((marker != 1) && (marker != 2))
                    {
                        System.out.println("Please choose either '1' or '2'!!");
                        System.exit(marker);
                    }
                    // determine who goes first
                    int first = (int) (Math.random() * 2);

                    boolean won = false;
                    int turns = 0;
                
                    if(first == 0)
                    {
                        System.out.println("You got to make the first move!");
                        if((N == 1) || (N == 2))
                        {
                            System.out.println("When the board is of size 1X1 or 2X2, "
                                    + "\n first player wins the game!! \nYou won the game!!");
                            System.exit(turns);
                        }
                    }
                    else
                    {
                        System.out.println("I make the first move!");
                        if((N == 1) || (N == 2))
                        {
                            System.out.println("When the board is of size 1X1 or 2X2, "
                                    + "\n first player wins the game!! \nI won the game!!");
                            System.exit(turns);
                        }
                    }
                
                    if(first == 0)
                    {
                        System.out.println();
                        while(!won)
                        {
                            human.takeTurn(Setup.getBoard());
                            turns++;
                            Setup.printBoard();
                            if(Setup.hasWon(Setup.getBoard()))
                            {
                                won = true;
                                System.out.println("Congrats you won!");
                            }
                            if(turns == N*N)
                            {
                                won = true;
                                //System.out.println(N*N);
                                System.out.println("Its a bore draw!");
                                break;
                            }
                            if(!won)
                            {
                                computer.takeTurn(Setup.getBoard(), human);
                                turns++;
                                System.out.println();
                                Setup.printBoard();
                                System.out.println();
                                if(Setup.hasWon(Setup.getBoard()))
                                {
                                    won = true;
                                    System.out.println("You just lost a game to an A.I"
                                        + " with an incomplete rule set.\nFACEPALM. :D");
                                }
                                if(turns == N*N)
                                {
                                    won = true;
                                    System.out.println("Its a bore draw!");
                                    break;
                                }
                            }   
                        }  // close while 1
                    }
                    else 
                    {
                        System.out.println();
                        while(!won)
                        {
                            computer.takeTurn(Setup.getBoard(), human);
                            turns++;
                            Setup.printBoard();
                            if(Setup.hasWon(Setup.getBoard()))
                            {
                                won = true;
                                System.out.println("You just lost a game to an"
                                        + " A.I with an incomplete rule set.\nFACEPALM. :D");
                            }
                            
                            //checks if maximum moves are made and declares a draw
                            if(turns == N*N)
                            {
                                won = true;
                                System.out.println("Its a draw!");
                                break;
                            }
                            if(!won)
                            {
                                human.takeTurn(Setup.getBoard());
                                turns++;
                                System.out.println();
                                Setup.printBoard();
                                System.out.println();
                                if(Setup.hasWon(Setup.getBoard()))
                                {
                                    won = true;
                                    System.out.println("You win!");
                                }
                                if(turns == N*N)
                                {
                                    won = true;
                                    System.out.println("Its a draw!");
                                    break;
                                }
                            }
                        }  // close while 2
                    }
                    
                }
                else if(level == 3)
                {
                    //create player objects
                    Human human = new Human();
                    Computer computer = new Computer();
                    System.out.println("please choose your marker");
                    System.out.println("type 1 for 'x' or 2 for 'o'");

                    int marker = s.nextInt();
                    //set markers
                    if(marker == 1)
                    {
                        // create player objects
                        System.out.println("You chose cross 'X'");
                        human.setMarker("X");
                        computer.setMarker("O");
                    } 
                    else if(marker == 2)
                    {
                        System.out.println("You chose Knought 'O'");
                        human.setMarker("O");
                        computer.setMarker("X");
                    }
                    else if((marker != 1) && (marker != 2))
                    {
                        System.out.println("Please choose either '1' or '2'!!");
                        System.exit(marker);
                    }
                    // determine who goes first
                    int first = (int) (Math.random() * 2);

                    boolean won = false;
                    int turns = 0;
                
                    if(first == 0)
                    {
                        System.out.println("You got to make the first move!");
                        if((N == 1) || (N == 2))
                        {
                            System.out.println("When the board is of size 1X1 or 2X2, "
                                    + "\n first player wins the game!! \nYou won the game!!");
                            System.exit(turns);
                        }
                    }
                    else
                    {
                        System.out.println("I make the first move!");
                        if((N == 1) || (N == 2))
                        {
                            System.out.println("When the board is of size 1X1 or 2X2, "
                                    + "\n first player wins the game!! \nI won the game!!");
                            System.exit(turns);
                        }
                    }
                
                    if(first == 0)
                    {
                        System.out.println();
                        while(!won)
                        {
                            human.takeTurn(Setup.getBoard());
                            turns++;
                            Setup.printBoard();
                            if(Setup.hasWon(Setup.getBoard()))
                            {
                                won = true;
                                System.out.println("Congrats you won!");
                            }
                            if(turns == N*N)
                            {
                                won = true;
                                //System.out.println(N*N);
                                System.out.println("Its a bore draw!");
                                break;
                            }
                            if(!won)
                            {
                                computer.takeTurn(Setup.getBoard(), human);
                                turns++;
                                System.out.println();
                                Setup.printBoard();
                                System.out.println();
                                if(Setup.hasWon(Setup.getBoard()))
                                {
                                    won = true;
                                    System.out.println("You just lost a game to an A.I"
                                        + " with an incomplete rule set.\nFACEPALM. :D");
                                }
                                if(turns == N*N)
                                {
                                    won = true;
                                    //System.out.println(N*N);
                                    System.out.println("Its a bore draw!");
                                    break;
                                }
                            }   
                        }  // close while 1
                    }
                    else 
                    {
                        System.out.println();
                        while(!won)
                        {
                            computer.takeTurn(Setup.getBoard(), human);
                            turns++;
                            Setup.printBoard();
                            if(Setup.hasWon(Setup.getBoard()))
                            {
                                won = true;
                                System.out.println("You just lost a game to an"
                                        + " A.I with an incomplete rule set.\nFACEPALM. :D");
                            }
                            
                            //checks if maximum moves are made and declares a draw
                            if(turns == N*N)
                            {
                                won = true;
                                System.out.println("Its a draw!");
                                break;
                            }
                            if(!won)
                            {
                                human.takeTurn(Setup.getBoard());
                                turns++;
                                System.out.println();
                                Setup.printBoard();
                                System.out.println();
                                if(Setup.hasWon(Setup.getBoard()))
                                {
                                    won = true;
                                    System.out.println("You win!");
                                }
                                if(turns == N*N)
                                {
                                    won = true;
                                    System.out.println("Its a draw!");
                                    break;
                                }
                            }
                        }  // close while 2
                    }
                }// Close of 'hard' level
                else
                {
                    System.out.println("Please enter a valid number for choosing the level!"
                            + "\nChoose 1 or 2 or 3 only.");
                    System.exit(level);
                }
                System.out.println("Would you like to play again? Type '1' for yes!!\n"
                        + "Any other input will be considered as a 'NO'!!");
                System.out.println();
                playAgain = s.nextInt();
            }while(playAgain == 1);
        }
        catch(InputMismatchException e)
        {
            System.out.println("Invalid input!! \n ");
        }
    }
     public static int getBoardSizebs()
     {
         Scanner s = new Scanner(System.in);
         System.out.println("Please choose the size of the board! \n"
                     + "Enter 3 for 3X3 board, 4 for 4X4 board, etc..");
         int _boardSize;
         _boardSize = s.nextInt();
         System.out.print("You chose a "+_boardSize+"X"+_boardSize+" board.\n");
         return _boardSize;
     }
     
     public static int bs()
     {
         return N;
     }
}
class Computer extends player 
{
    public Computer()
    {
    }

    public void takeTurn(String[][] board, Human human) 
    {
        boolean mademove = false;

        set Setup = new set();
        int bs = play.bs();
        int counter = 1;
        // check if you can take a win vertically
        for(int a = 0; a<bs; a++)
        {
            for(int j=0; j<bs-2; j++)
            {
                if((board[j][a].equals(board[j+1][a]) && board[j][a].equals(Marker))
                        || (board[j][a].equals(board[j+2][a]) && board[j][a].equals(Marker))
                        || (board[j+1][a].equals(board[j+2][a]) && board[j+1][a].equals(Marker)))
                {
                    counter = counter+1;
                }
                if(counter == bs-1)
                {
                    for(int k=0;k<bs;k++)
                    {
                        if(!board[k][a].equals(human.getMarker()) && !board[k][a].equals(Marker))
                        {
                            board[k][a] = Marker;
                            mademove = true;
                            return;
                        }
                    }
                }
            }
            counter = 1;
        }
        
        counter = 1;
        // check if you can take a win horizontally
        for(int i = 0; i<bs; i++)
        {
            for(int j=0; j<bs-2; j++)
            {
                if((board[i][j].equals(board[i][j+1]) && board[i][j].equals(Marker))
                        ||(board[i][j].equals(board[i][j+2]) && board[i][j].equals(Marker))
                        || (board[i][j+1].equals(board[i][j+2]) && board[i][j+1].equals(Marker)))
                {
                    counter = counter+1;
                }
                if(counter == bs-1)
                {
                    for(int k=0; k<bs; k++)
                    {
                        if(!board[i][k].equals(human.getMarker()) && !board[i][k].equals(Marker))
                        {
                            board[i][k] = Marker;
                            mademove = true;
                            return;
                        }
                    }
                }
                //}
            }
            counter = 1;
        }
        
        counter = 1;
        // check if you can take a win diagonally left-top to right-bottom
        for(int i=0;i<bs;i++)
        {
            for(int j=0;j<bs;j++)
            {
                if(i!=j)
                {
                    if(board[i][i].equals(board[j][j]) && board[j][j].equals(Marker))
                    {
                        counter = counter+1;
                    }
                    if(counter == bs-1)
                    {
                        for(int k=0;k<bs;k++)
                        {
                            if(!board[k][k].equals(human.getMarker()) && !board[k][k].equals(Marker))
                            {
                                board[k][k] = Marker;
                                mademove = true;
                                return;
                            }
                        }
                    }
                }
            }
        }
        counter = 1;
        // check if you can take a win diagonally right-bottom to left-top
        for(int j=bs-2;j>=0;j--)
            {
                int i=bs-1;
                if(board[i][i].equals(board[j][j]) && board[j][j].equals(Marker))
                {
                    counter = counter+1;
                }
                if(counter == bs-1)
                {
                    for(int k=0;k<bs;k++)
                    {
                        if(!board[k][k].equals(human.getMarker()) && !board[k][k].equals(Marker))
                        {
                            board[k][k] = Marker;
                            mademove = true;
                            return;
                        }
                    }
                }
            }
        
        counter = 1;
        //Check if you can win diagonally from right-top to left-bottom
        for(int i=0;i<bs-2;i++)
        {
            if(board[i][bs-1-i].equals(board[i+1][bs-1-i-1]) && board[i][bs-1-i].equals(Marker))
            {
                counter = counter+1;
            }
            if(counter == bs-1)
            {
                for(int k=0;k<bs-1;k++)
                {
                    if(!board[k][bs-1-k].equals(human.getMarker()) && !board[k][bs-1-k].equals(Marker))
                    {
                        board[k][bs-1-k] = Marker;
                        mademove = true;
                        return;
                    }
                }
            }
        }
  
        // BLOCKS!!!! //
        counter = 1;
        // check if you can block a win horizontally
        for(int a = 0; a<bs; a++)
        {
            for(int j=0; j<bs-2; j++)
            {
                if((board[a][j].equals(board[a][j+1]) && board[a][j].equals(human.getMarker()))
                        ||(board[a][j].equals(board[a][j+2]) && board[a][j].equals(human.getMarker()))
                        || (board[a][j+1].equals(board[a][j+2]) && board[a][j+1].equals(human.getMarker())))
                {
                    counter = counter+1;
                }
                if(counter == bs-1)
                {
                    for(int k=0;k<bs;k++)
                    {
                        if(!board[a][k].equals(human.getMarker()) && !board[a][k].equals(Marker))
                        {
                            System.out.println("I am placing the marker at: "+a+" "+k);
                            board[a][k] = Marker;
                            mademove = true;
                            return;
                        }
                    }
                }
            }
            counter = 1;
        }
        
        counter = 1;
        // check if you can block a win vertically
        for(int i = 0; i<bs; i++)
        {
            for(int j=0; j<bs-2; j++)
            {
                if(board[j][i].equals(board[j+1][i]) && board[j][i].equals(human.getMarker())
                        || (board[j][i].equals(board[j+2][i]) && board[j][i].equals(human.getMarker()))
                        || (board[j+1][i].equals(board[j+2][i]) && board[j+1][i].equals(human.getMarker())))
                {
                    counter = counter+1;
                }
                if(counter == bs-1)
                {
                    for(int k=0; k<bs; k++)
                    {
                        if(!board[i][k].equals(human.getMarker()) && !board[i][k].equals(Marker))
                        {
                            System.out.println("I am placing the marker at: "+k+" "+i);
                            board[k][i] = Marker;
                            mademove = true;
                            return;
                        }
                    }
                }
                //}
            }
            counter = 1;
        }
        
        
        // check if you can block a win diagonally left-top to right-bottom
        counter = 1;
        for(int j=1;j<bs;j++)
        {
            int i=0;
            if(board[i][i].equals(board[j][j]) && board[j][j].equals(human.getMarker()))
            {
                counter = counter+1;
            }
            if(counter == bs-1)
            {
                for(int k=0;k<bs;k++)
                {
                    if(!board[k][k].equals(human.getMarker()) && !board[k][k].equals(Marker))
                    {
                        System.out.println("I am placing the marker at: "+k+" "+k);
                        board[k][k] = Marker;
                        mademove = true;
                        return;
                    }
                }
            }
        }
        
        //Check if you can block a win diagonally from right-top to left-bottom
        counter = 1;
        for(int i=0;i<bs-1;i++)
        {
            if(board[i][bs-1-i].equals(board[i+1][bs-1-i-1]) && board[i][bs-1-i].equals(human.getMarker()))
            {
                counter = counter+1;
            }
            if(counter == bs-1)
            {
                for(int k=0;k<bs;k++)
                {
                    if(!board[k][bs-1-k].equals(human.getMarker()) && !board[k][bs-1-k].equals(Marker))
                    {
                        System.out.println("I am placing the marker at: "+k+" "+(bs-1-k));
                        board[k][bs-1-k] = Marker;
                        mademove = true;
                        return;
                    }
                }
            }
        }

        // make random move if above rules dont apply
        int rand1 = 0;
        int rand2 = 0;
        
        while(!mademove)
        {
            rand1 = (int) (Math.random() * bs);
            rand2 = (int) (Math.random() * bs);

            int rand11,rand22;
            if(!"X".equals(board[rand1][rand2]) && !"O".equals(board[rand1][rand2]))
            {
                rand11 = rand1+1;
                rand22 = rand2+1;
                System.out.println("\nI am placing the marker at: "+rand11+" "+rand22);
                board[rand1][rand2] = Marker;
                mademove = true;        
            }
        }
    }
}
class Human extends player 
{
    public Human()
    {

    }   

    public void takeTurn(String[][] board) 
    {

        Scanner s = new Scanner(System.in);

        boolean turn = true;

        int bs = play.bs();
        while(turn)
        {
            System.out.println("please enter row");
            int row = s.nextInt();
            System.out.println("please enter col");
            int col = s.nextInt();
            System.out.print("you entered "+row+" "+col);
            System.out.println();
            if(row<1 || row>bs || col<1 ||col>bs)
            {
                System.out.println("Enter valid numbers for placing the marker!!");
                System.exit(bs);
            }
            if(!"X".equals(board[row - 1][col - 1]) && !"O".equals(board[row - 1][col - 1]))
            {
                board[row - 1][col - 1] = Marker;
                turn = false;
            } // closes if
            else 
            {
                System.out.println("Already Marker here! please guess again!");
        }
    } // ends while
} // ends method

} // ends class
