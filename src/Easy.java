public class Easy extends player
{
    public Easy()
    {
    }
    
     public void takeTurn(String[][] board, Human human) 
     {
        set Setup = new set();
        int bs = play.bs();
        int rand1 = 0;
        int rand2 = 0;
        boolean mademove = false;
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
