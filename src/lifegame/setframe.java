package lifegame;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;

public class setframe {
    JFrame frame;
    static int speed = 1000;
    static int life = 0;
    static int steps = 0;
    myThread thread = null;
    static Window window;
    static JPanel[][] jPanel;
    static int pattern = 1;
    static JPanel Panel;
    static JLabel number;
    static JLabel step;
    static boolean end = true;
    public setframe (int row ,int col) {
        frame = new JFrame("the game of life");
        jPanel = new JPanel[row][col];
        frame.getContentPane().setLayout(new BorderLayout(0, 0));
        
        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        
        number = new JLabel("Number of remaining lives: "+life+"               ");
        panel.add(number);
        
        step = new JLabel("step: "+steps);
        panel.add(step);

        panel.setBackground(Color.white);
        Panel = new JPanel();
        frame.getContentPane().add(Panel, BorderLayout.CENTER);
        Panel.setLayout(new GridLayout(30, 30, 2, 2));

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                jPanel[i][j] = new JPanel();
                jPanel[i][j].setBackground(Color.white);
                Panel.add(jPanel[i][j]);
            }
        }
        
        frame.setLocation(450, 180);
        frame.setSize(500, 500);        
        
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        
        JMenu choice = new JMenu("choice");
        menuBar.add(choice);
        
        JMenuItem start = new JMenuItem("start");
        choice.add(start);
        start.addActionListener(new start());
        
        JMenuItem Continue = new JMenuItem("continue");
        choice.add(Continue);
        Continue.addActionListener(new Continue());
        
        
        JMenuItem stop = new JMenuItem("stop");
        choice.add(stop);
        stop.addActionListener(new stop());
        
        JMenuItem clear = new JMenuItem("clear");
        choice.add(clear);
        clear.addActionListener(new clear());
        
        JMenu pattern = new JMenu("pattern");
        menuBar.add(pattern);
        
        JMenuItem five = new JMenuItem("five");
        pattern.add(five);
        five.addActionListener(new five());
        
        JMenuItem life = new JMenuItem("life");
        pattern.add(life);
        life.addActionListener(new life());
        
        JMenuItem random = new JMenuItem("random");
        pattern.add(random);
        random.addActionListener(new random());
        
        JMenu speed = new JMenu("speed");
        menuBar.add(speed);
        
        JMenuItem speed1 = new JMenuItem("500");
        speed.add(speed1);
        speed1.addActionListener(new fast());
        
        JMenuItem speed2 = new JMenuItem("1000");
        speed.add(speed2);
        speed2.addActionListener(new mid());
        
        JMenuItem speed3 = new JMenuItem("2000");
        speed.add(speed3);
        speed3.addActionListener(new slow());
        
        
        frame.setVisible(true);
        
    }
    
    class myThread extends Thread{
        public myThread()    {
        	
        }
        public void run(){
            while(end){
                life = 0;
                window.judge.judge();
                try {
                    sleep(speed);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int m = 1; m < window.state.length - 1; m++)
                {
                    for (int n = 1; n < window.state[m].length - 1; n++) 
                    {
                        if (window.state[m][n]==true) {
                            life ++;
                        }
                    }
                }
                steps++;
                number.setText("Number of remaining lives: "+life+"               ");
                step.setText("step: "+steps);
                
                window.setcolor.paint();
                
                if (life==0) {
                    end = false;
                    JOptionPane.showMessageDialog(null, "生命演化结束：\n"
                            + "        所用步数为"+steps);
                }
                
            }
        }
    }

     class start implements ActionListener
     {
    	public void actionPerformed(ActionEvent e) {
            if (pattern==1) {
        	    window.pattern.random();
            }else if(pattern==2){
                window.pattern.five();
            }else {
            	window.pattern.life();
            }
            window.setcolor.paint();
            life = 0;
            steps = 0;
            end = true;
            if (thread != null) {
        	    thread.stop(); 
        	} 
            thread = new myThread();  
            thread.start();  
            
         }
   	 }
     class Continue implements ActionListener
     {
            public void actionPerformed(ActionEvent e) {
                if(thread!=null)
                    thread.stop();
                thread = new myThread();
                thread.start();
            }
            
     }
     
     class stop implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                if (thread != null)  
                    thread.stop();  
                thread = null;
            }
            
     }
     
     class clear implements ActionListener {
         public void actionPerformed(ActionEvent e) {
             if (thread != null)  
                 thread.stop();  
             thread = null;  
             for(int i=1;i<window.state.length;i++)
             {
                 for(int j=1;j<window.state[i].length-1;j++)
                 {
                     window.state[i][j] = false;
                 }
             }
             steps=0;
             life=0;
             number.setText("Number of remaining lives: "+life+"               ");
             step.setText("step: "+steps);
             
             window.setcolor.paint();
             
         }
         
     }
        
     class five implements ActionListener{
            public void actionPerformed(ActionEvent e) {
                pattern = 2;
            }
            
     }
        
     class random implements ActionListener{
            public void actionPerformed(ActionEvent e) {
                pattern = 1;
            }
            
     }
     
     class life implements ActionListener{
         public void actionPerformed(ActionEvent e) {
             pattern = 3;
         }
         
    }
     class fast implements ActionListener{
         public void actionPerformed(ActionEvent e) {
             speed=500;
         }
         
     }
     class mid implements ActionListener{
         public void actionPerformed(ActionEvent e) {
             speed=1000;
         }
         
     }
     class slow implements ActionListener{
         public void actionPerformed(ActionEvent e) {
             speed=2000;
         }
         
     }      
}