
package Ventanas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;


public class Panel extends JPanel implements KeyListener, ActionListener{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon fondo, naveoso, ene1, ene2, ene3;
    private int ox = 300, oy = 500, ex1 =500, ey1=100, ex2=300, ey2=50, ex3=500, ey3=150, velX, velY, Xfondo;
    public JLabel texto, tiempo, segundos, minutos;
    public boolean up= false, down=false, left=false, right=false;
    private AudioClip fondocancion; 
     
     public Panel(){
         
    this.setSize(700, 700);
    this.addKeyListener(this);
    this.setFocusable(true);
    this.setVisible(true);
    fondocancion = java.applet.Applet.newAudioClip(getClass().getResource("The Offspring - Youre Gonna Go Far Kid 8-bit.wav"));
    fondocancion.loop();
       
    }
     
     public void paintComponent(Graphics g)
     {
         super.paintComponents(g);
         
         fondo = new ImageIcon(getClass().getResource("fondofinal.png"));
         g.drawImage(fondo.getImage(), Xfondo, 0, 5000, 700,  this);
         naveoso = new ImageIcon(getClass().getResource("osorio1.png"));
         g.drawImage(naveoso.getImage(), ox, oy, 140, 140,  this);
        
         
         ene1 = new ImageIcon(getClass().getResource("enemigo1.png"));
         g.drawImage(ene1.getImage(), ex1, ey1, 110, 110,  this);
         ene2 = new ImageIcon(getClass().getResource("enemigo2.png"));
         g.drawImage(ene2.getImage(), ex2, ey2, 110, 110,  this);
         ene3 = new ImageIcon(getClass().getResource("enemigo3.png"));
         g.drawImage(ene3.getImage(), ex3, ey3, 110, 110,  this);
         
         for(int timer=0; timer<=600000; timer++)
         {
             if(timer == 600000)
             {
                 Xfondo-=2;
                 repaint();
             }
         }
         for (int tnave1=10; tnave1<=100; tnave1++)
         {
             if(tnave1 == 100)
             {
                 ex1-=1;
             }
         }
         
         if(up == true){
           if(oy<0){
               velY=0;
           } 
           else{
               velY=3;
           }
           oy-=velY;
           this.repaint();
        }
        if(down == true){
           if(oy>540){
               velY=0;
           }
           else{
               velY=3;
           }
            oy+=velY;   
           this.repaint();
        }
        if(left == true){
            if(ox<0){
                velX=0;
            }
            else{
            velX=3;
            }
           ox-=velX;
           this.repaint();
        }
        if(right == true){
            if(ox>580){
                velX=0;
            }
            else{
            velX=3;
            }
           ox+=velX;
           this.repaint();
        }
        this.repaint();
     }
     
     
    @Override
    public void keyTyped(KeyEvent ke) {
         
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getKeyCode() == KeyEvent.VK_D){//Right
           
           right = true;
        }
        if(ke.getKeyCode() == KeyEvent.VK_A){//Left    
           
           left = true;
        }
        if(ke.getKeyCode() == KeyEvent.VK_W){//Up
            
            up = true;
        }
        if(ke.getKeyCode() == KeyEvent.VK_S){//down
          down = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if(ke.getKeyCode() == KeyEvent.VK_A){//Left
              left = false;
          }
          if(ke.getKeyCode() == KeyEvent.VK_D){//Right
              right = false;
          }
          if(ke.getKeyCode() == KeyEvent.VK_W){//Up
              up = false;
          }
          if(ke.getKeyCode() == KeyEvent.VK_S){//Down
              down = false;
          }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       
    }
    
    
}
