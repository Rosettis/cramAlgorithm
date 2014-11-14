package com.company;
import java.math.*;
import java.util.Random;
/**
 * Created by 100490515 on 12/11/2014.
 */
//RANDOMIZED BLOCK PLACEMENT FOR CRAM GAME
public class cramCalc {
    //Global Variables
    static int boardSize = 5;
    static String board[][] = new String[boardSize][boardSize];
    static int xDecision_num;
    static String xDecision_let = null;
    static int yDecision_num;
    static int x2placement_num = 0;
    static String x2placement_let = "A";
    static int y2placement_num = 0;
    //Main Function
    public static void main(String[] args)
    {
        //Local Variables
        //int turnCount;
        String playerMove;

        //Fill empty board for testing
        for(int i = 0; i < boardSize; i++)
        {
            for(int j = 0; j < boardSize; j++)
            {
                board[i][j] = "O";
            }
        }
        //Displaying board - check
        for(int i = 0; i < 25; i++) {
            if (i % 5 == 4)
                System.out.print(board[i % 5][i / 5] + "\n");
            else
                System.out.print(board[i % 5][i / 5] + " ");
        }

        //Getting Random Values for Initial block placement
        xDecision_num = valueSet();
        yDecision_num = valueSet();
        block2();
        //checking if the blocks are a legal move
        checkLoop();

        xDecision_let = convert(xDecision_num);
        x2placement_let = convert(x2placement_num);
        yDecision_num = yDecision_num + 1;
        y2placement_num = y2placement_num + 1;

        playerMove = ""+(xDecision_let)+(yDecision_num)+(x2placement_let)+(y2placement_num);
        System.out.println("This is going to the server: "+playerMove);
    }

    public static int valueSet()
    {
        //Variables
        int value;
        //Calculations
        do
            value = (int)(10*Math.random());
        while(value > (boardSize - 1));
        //Output
        return value;
    }
    public static void block2()
    {
        //Determining Second Square Position
        // 1-Left,2-Down,3-Right,4-Up
        //Checking if move is on horizontal edge
        if(yDecision_num == 0)
        {
            if(xDecision_num == 0)
            {
                do
                    x2placement_num = (int)(10*Math.random());
                while((x2placement_num != 2) && (x2placement_num != 3));
            }
            else if(xDecision_num == 4)
            {
                do
                    x2placement_num = (int)(10*Math.random());
                while((x2placement_num != 1) && (x2placement_num != 2));
            }
            else
            {
                do
                    x2placement_num = (int)(10*Math.random());
                while((x2placement_num != 1) && (x2placement_num != 2) && (x2placement_num != 3));
            }
        }
        else if(yDecision_num == 4)
        {
            if(xDecision_num == 0)
            {
                do
                    x2placement_num = (int)(10*Math.random());
                while((x2placement_num != 3) && (x2placement_num != 4));
            }
            else if(xDecision_num == 4)
            {
                do
                    x2placement_num = (int)(10*Math.random());
                while((x2placement_num != 1) && (x2placement_num != 4));
            }
            else
            {
                do
                    x2placement_num = (int)(10*Math.random());
                while((x2placement_num != 1 )&& (x2placement_num != 3) && (x2placement_num != 4));
            }
        }
        //Checking if move is on vertical edge
        if(xDecision_num == 0)
        {
            if(yDecision_num == 0)
            {
                //Covered in horizontal edge check
            }
            else if(yDecision_num == 4)
            {
                //Covered in horizontal edge check
            }
            else
            {
                do
                    x2placement_num = (int)(10*Math.random());
                while((x2placement_num != 1) && (x2placement_num != 2) && (x2placement_num != 4));
            }
        }
        else if(xDecision_num == 4)
        {
            if(yDecision_num == 0)
            {
                //Covered in horizontal edge check
            }
            else if(yDecision_num == 4)
            {
                //Covered in horizontal edge check
            }
            else
            {
                do
                    x2placement_num = (int)(10*Math.random());
                while((x2placement_num != 1) && (x2placement_num != 2) && (x2placement_num != 4));
            }
        }
        //If not on horizontal or vertical edge
        else
        {
            do
                x2placement_num = (int)(10*Math.random());
            while(x2placement_num > 4 && x2placement_num != 0);
        }
        System.out.println(x2placement_num);
        //Converting Second Block Position From Orientation
        if(x2placement_num == 1)//2nd Block Left
        {
            x2placement_num = xDecision_num - 1;
            y2placement_num = yDecision_num;
        }
        else if(x2placement_num == 2)//2nd Block Down
        {
            x2placement_num = xDecision_num;
            y2placement_num = yDecision_num + 1;

        }
        else if(x2placement_num == 3)//2nd Block Right
        {
            x2placement_num = xDecision_num + 1;
            y2placement_num = yDecision_num;
        }
        else if(x2placement_num == 4)//2nd Block Up
        {
            x2placement_num = xDecision_num;
            y2placement_num = yDecision_num - 1;
        }
    }
    public static String convert(int value)
    {
        //Converting X Numeric Value into Letter
        if (value == 0)
        {
            return  "A";
        }
        else if (value == 1)
        {
            return "B";
        }
        else if(value == 2)
        {
            return "C";
        }
        else if(value == 3)
        {
            return "D";
        }
        else if(value == 4)
        {
            return "E";
        }
        else
        {
            System.out.println("Invalid value selection");
        }
        return "0";
    }
    public static void checkLoop()
    {
        boolean check = false;
        //Checking if block positions are taken
        while(!check)
        {
            System.out.println(xDecision_num+" "+yDecision_num+" "+x2placement_num+" "+y2placement_num);
            if (!board[xDecision_num][yDecision_num].equals("O") || !board[x2placement_num][y2placement_num].equals("O"))
            {
                if(!board[xDecision_num][yDecision_num].equals("O")) {
                    xDecision_num = valueSet();
                    yDecision_num = valueSet();
                    block2();
                }
                if (!board[x2placement_num][y2placement_num].equals("O"))
                {
                    block2();
                }
                else
                {
                    check = true;
                }
            }
            else
            {
                check = true;
            }
        }
    }
}


