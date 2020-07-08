package lifegame;

import static org.junit.Assert.*;

import java.awt.Color;

import javax.swing.JPanel;

import org.junit.Before;
import org.junit.Test;

public class colorTest {
	static boolean [][] state=new boolean[30][30];
    static JPanel[][] jPanel = new JPanel[30][30];
    static color setcolor=new color(state, jPanel);
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPaint() {
        for(int i=0;i<30;i++)
        {
            for(int j=0;j<30;j++)
            {
                state[i][j] = false;
            }
        }
        for(int i=0;i<30;i++)
        {
            for(int j=0;j<30;j++)
            {
                jPanel[i][j] = new JPanel();
                jPanel[i][j].setBackground(Color.white);
            }
        }
        setcolor.paint();
        for(int i=1;i<29;i++)
        {
            for(int j=1;j<29;j++)
            {
            	assertEquals(Color.white,jPanel[i][j].getBackground());
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
        setcolor.paint();
        assertEquals(Color.white,jPanel[1][1].getBackground());
        assertEquals(Color.yellow,jPanel[15][9].getBackground());
        assertEquals(Color.yellow,jPanel[12][7].getBackground());
        for(int i=0;i<30;i++)
        {
            for(int j=0;j<30;j++)
            {
                state[i][j] = true;
            }
        }
        setcolor.paint();
        for(int i=1;i<29;i++)
        {
            for(int j=1;j<29;j++)
            {
            	assertEquals(Color.yellow,jPanel[i][j].getBackground());
            }
        }
	}

}
