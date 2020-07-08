package lifegame;

import java.util.Random;

public class Pattern {
    static boolean[][] state;
    static int rand;
    public Pattern(boolean[][] state)
    {
        this.state = state;
    }

    public void random()
    {
        for(int i=1;i<state.length-1;i++)
        {
            for(int j=1;j<state[i].length-1;j++)
            {
                rand = (int) (Math.random()*100);
                if (rand<50) {
                    state[i][j] = false;
                }
                else
                    state[i][j] = true;
            }
        }
    }
    public void five()
    {
        for(int i=0;i<state.length;i++)
        {
            for(int j=0;j<state[i].length;j++)
            {
                state[i][j] = false;
            }
        }
        state[9][4] = true;
        state[9][5] = true;
        state[9][6] = true;
        state[9][7] = true;
        state[9][8] = true;
        state[10][6] = true;
        state[11][6] = true;
        state[12][6] = true;
        state[12][4] = true;
        state[12][5] = true;
        state[12][7] = true;
        state[12][8] = true;
        state[13][6] = true;
        state[13][8] = true;
        state[14][6] = true;
        state[14][8] = true;
        state[15][6] = true;
        state[15][3] = true;
        state[15][4] = true;
        state[15][5] = true;
        state[15][7] = true;
        state[15][8] = true;
        state[15][9] = true;
    }
    public void life() {
    	for(int i=0;i<state.length;i++)
        {
            for(int j=0;j<state[i].length;j++)
            {
                state[i][j] = false;
            }
        }
    	state[9][4] = true;
    	state[10][4] = true;
    	state[11][4] = true;
    	state[12][4] = true;
    	state[13][4] = true;
    	state[14][4] = true;
    	state[15][4] = true;
    	state[15][5] = true;
    	state[15][6] = true;
    	state[15][7] = true;
    	
    	state[9][12] = true;
    	state[10][12] = true;
    	state[11][12] = true;
    	state[12][12] = true;
    	state[13][12] = true;
    	state[14][12] = true;
    	state[15][12] = true;
    	
    	state[9][17] = true;
    	state[9][18] = true;
    	state[9][19] = true;
    	state[10][17] = true;
    	state[11][17] = true;
    	state[11][18] = true;
    	state[11][19] = true;
    	state[12][17] = true;
    	state[13][17] = true;
    	state[14][17] = true;
    	state[15][17] = true;
    	
    	state[9][24] = true;
    	state[9][25] = true;
    	state[9][26] = true;
    	state[10][24] = true;
    	state[11][24] = true;
    	state[12][24] = true;
    	state[12][25] = true;
    	state[12][26] = true;
    	state[13][24] = true;
    	state[14][24] = true;
    	state[15][24] = true;
    	state[15][25] = true;
    	state[15][26] = true;
    }
}




