package lifegame;

import static org.junit.Assert.*;

import javax.swing.JPanel;

import org.junit.Before;
import org.junit.Test;

public class JudgeTest {
    static Judge judge;   
    static boolean[][] state;
    static JPanel[][] jPanel;
    
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetnumber() {
        judge = new Judge(state, jPanel);
        state=new boolean[30][30];
        for(int i=0;i<30;i++)
        {
            for(int j=0;j<30;j++)
            {
                state[i][j] = false;
            }
        }
        for(int i=1;i<29;i++)
        {
            for(int j=1;j<29;j++)
            {
            	assertEquals(0,judge.getnumber(state,i,j));
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
		assertEquals(0,judge.getnumber(state,1,1));
		assertEquals(3,judge.getnumber(state,15,8));
		assertEquals(3,judge.getnumber(state,9,5));
        for(int i=0;i<30;i++)
        {
            for(int j=0;j<30;j++)
            {
                state[i][j] = true;
            }
        }
        for(int i=1;i<29;i++)
        {
            for(int j=1;j<29;j++)
            {
            	assertEquals(8,judge.getnumber(state,i,j));
            }
        }
	}

}
