package com.example;

public class TicTacToe {
    private static int cx,co;
    private static int win[][]={{0, 1, 2},{3, 4, 5},{6, 7, 8},{0, 3, 6},{1, 4, 7},{2, 5, 8},{0, 4, 8},{2, 4, 6}};
    private static void Count(char[] ch){
        for (char aCh : ch) {
            if (aCh == 'x') {
                cx++;
            } else if (aCh == 'o') {
                co++;
            }
        }
    }
    private static boolean playerWin(char[] board, char c)
    {
        for (int i=0; i<8; i++)
            if (board[win[i][0]] == c && board[win[i][1]] == c && board[win[i][2]] == c )
                return true;
        return false;
    }

    public static Evaluation evaluateBoard(String boardState) {
        // implement your code here
        boardState=boardState.toLowerCase();
        char[] ch=boardState.toCharArray();
        Count(ch);
        if(ch.length!=9)
        return Evaluation.InvalidInput;
        else if(cx==co||cx==co+1)
        {
            boolean wx=playerWin(ch,'x'),wo=playerWin(ch,'o');
            if(wo) {
                if (wx)
                    return Evaluation.UnreachableState;
                else
                    return Evaluation.Owins;
            }
            if(wx && cx==co+1)
            return Evaluation.Xwins;
            else if (cx+co==9||cx<3)
            return Evaluation.NoWinner;
        }
        return Evaluation.UnreachableState;
    }
}
