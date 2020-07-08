package lifegame;

import javax.swing.JPanel;

public class Window extends Thread{
    static Window window;
    static Pattern pattern;
    static Judge judge;
    static color setcolor;
    static setframe frame;    
    static boolean[][] state;
    static JPanel[][] jPanel;
    
    public Window(int row,int col){
        state = new boolean[row][col];
        frame = new setframe(row,col);
        jPanel = frame.jPanel;
    }
    
    public static void main(String[] args){
            window = new Window(30,30);
            pattern = new Pattern(state);
            judge = new Judge(state, jPanel);
            setcolor = new color(state, jPanel);
    }
}
