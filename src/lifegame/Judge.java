package lifegame;


import java.awt.Color;

import javax.swing.JPanel;

public class Judge{
    static boolean [][] state;
    JPanel[][] jPanel;

    public Judge(boolean [][] state,JPanel[][] jpanel)
    {
        this.state = state;
        this.jPanel = jpanel;
    }
    public int getnumber(boolean [][] state,int i,int j) {
    	int nCount=0;
        if (state[i - 1][j - 1]==true) {
            nCount++;
        }
        if (state[i - 1][j] == true) {
            nCount++;
        }
        if (state[i - 1][j + 1] ==true) {
            nCount++;
        }
        if (state[i][j - 1]== true) {
            nCount++;
        }
        if (state[i][j + 1]== true) {
            nCount++;
        }
        if (state[i + 1][j - 1] == true) {
            nCount++;
        }
        if (state[i + 1][j]== true) {
            nCount++;
        }
        if (state[i + 1][j + 1] ==true) {
            nCount++;
        }
    	return nCount;
    }
    public void judge() {
        int life = 0;
        for (int i = 1; i < state.length - 1; i++) {
            for (int j = 1; j < state[i].length - 1; j++) {
                int nCount = getnumber(state,i,j);
                if (nCount==3) {
                    state[i][j] = true;
                }
                else if (nCount == 2) {
                    state[i][j] = state[i][j];
                }
                else 
                    state[i][j] = false;
           }
       }
    }
}

