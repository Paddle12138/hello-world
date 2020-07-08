package lifegame;

import java.awt.Color;

import javax.swing.JPanel;

public class color{
    static boolean [][] state;
    static JPanel[][] jPanel;

    public color(boolean [][] state,JPanel[][] jpanel)
    {
        this.state = state;
        this.jPanel = jpanel;
    }
    public static void paint()
    {    
        for(int i=1;i<state.length-1;i++)
        {
            for(int j=1;j<state[i].length-1;j++)
            {
                if (state[i][j]) {
                    jPanel[i][j].setBackground(Color.yellow);
                }
                else{
                    jPanel[i][j].setBackground(Color.white);
                }
            }
        }
    }
}