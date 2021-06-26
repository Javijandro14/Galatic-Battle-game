
package Ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Instrucciones_videojuego extends JPanel implements KeyListener, MouseListener, MouseMotionListener{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon nv, fondo_ins, tecla_a, tecla_d, tecla_w, tecla_s,tecla_space, regresa;
    private int ox = 300, oy = 450, velX, velY,vx;
    public boolean up = false,left = false,down = false,right = false,space = false, boton_return = false, ba = false, bd = false, bs = false, bw = false, bspace=false;
    public boolean regreso;
    Rectangle bala;
    
    public Instrucciones_videojuego()
    {
    this.setSize(700, 700);
    this.addKeyListener(this);
    this.addMouseListener(this);
    this.addMouseMotionListener(this);
    this.setFocusable(true);
    
    this.setVisible(true);
    
    }
    
    @Override
    public void paintComponent (Graphics g)
    {
        super.paintComponents(g);
        
        fondo_ins = new ImageIcon(getClass().getResource("fondo_instrucciones_sinbotones.jpg"));
         g.drawImage(fondo_ins.getImage(), 0, 0, 700, 700,  this);
         nv = new ImageIcon(getClass().getResource("Nave_Diaz.png"));
         g.drawImage(nv.getImage(), ox, oy, 75, 75,  this);
         
         
         g.setColor(Color.WHITE);
         g.drawRect(1, 370, 690, 245);
         g.setColor(Color.WHITE);
         g.drawRect(2, 369, 690, 245);
         
         
         if(up == true){
           if(oy<375){
               velY=0;
           } 
           else{
               velY=5;
           }
           oy-=velY;
           this.repaint();
        }
        if(down == true){
           if(oy>538){
               velY=0;
           }
           else{
               velY=5;
           }
            oy+=velY;   
           this.repaint();
        }
        if(left == true){
            if(ox<0){
                velX=0;
            }
            else{
            velX=5;
            }
           ox-=velX;
           this.repaint();
        }
        if(right == true){
            if(ox>613){
                velX=0;
            }
            else{
            velX=5;
            }
           ox+=velX;
           this.repaint();
        }
        this.repaint();
        
       if(ba){
            tecla_a = new ImageIcon(getClass().getResource("boton_a_efecto.png"));
            g.drawImage(tecla_a.getImage(), 0,0,650,650,this);
            this.repaint();
        }
        else{
            tecla_a = new ImageIcon(getClass().getResource("boton_a.png"));
            g.drawImage(tecla_a.getImage(), 0,0,650,650,this);
            this.repaint();
        }
       if(bw){
            tecla_w = new ImageIcon(getClass().getResource("boton_w_efecto.png"));
            g.drawImage(tecla_w.getImage(), 0,0,650,650,this);
            this.repaint();
        }
        else{
            tecla_w = new ImageIcon(getClass().getResource("boton_w.png"));
            g.drawImage(tecla_w.getImage(), 0,0,650,650,this);
            this.repaint();
        }
      if(bd){
            tecla_d = new ImageIcon(getClass().getResource("boton_d_efecto.png"));
            g.drawImage(tecla_d.getImage(), 0,0,650,650,this);
            this.repaint();
        }
        else{
            tecla_d = new ImageIcon(getClass().getResource("boton_d.png"));
            g.drawImage(tecla_d.getImage(), 0,0,650,650,this);
            this.repaint();
       }
       if(bs){
            tecla_s = new ImageIcon(getClass().getResource("boton_s_efecto.png"));
            g.drawImage(tecla_s.getImage(), 0,0,650,650,this);
            this.repaint();
        }
        else{
            tecla_s = new ImageIcon(getClass().getResource("boton_s.png"));
            g.drawImage(tecla_s.getImage(), 0,0,650,650,this);
            this.repaint(); }
        
  
       if(bspace){
            tecla_space = new ImageIcon(getClass().getResource("boton_spacebar_efecto.png"));
            
            this.repaint();
        }
        else{
            tecla_space = new ImageIcon(getClass().getResource("boton_spacebar.png"));
            g.drawImage(tecla_space.getImage(), 0,0,650,650,this);
            this.repaint(); 
       }
       if(space){
           g.drawImage(tecla_space.getImage(), 0,0,650,650,this);
            g.fillRect(bala.x, bala.y, 10, 5);
            bala.x+=3;
            repaint();
       }
       if(regreso){
            regresa = new ImageIcon(getClass().getResource("return_efecto.png"));
         g.drawImage(regresa.getImage(),0, 0, 150,150, this);
         repaint();
        }
        else{
            regresa = new ImageIcon(getClass().getResource("return.png"));
         g.drawImage(regresa.getImage(),0, 0, 150, 150, this);
         this.repaint();
        }
       //g.fillRect(10,55,130,40);
    }
       public void bullet(){
        int bx = ox + 75;
        int by = oy + 35;
        bala = new Rectangle(bx, by, 10,5);
        vx=3;
        bx+=vx;
        repaint();
    }



    @Override
    public void keyTyped(KeyEvent ke) {
        
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if(ke.getKeyCode() == KeyEvent.VK_D){//Right
           
           right = true;
           bd = true;
        }
        if(ke.getKeyCode() == KeyEvent.VK_A){//Left    
           
           left = true;
           ba = true;
        }
        if(ke.getKeyCode() == KeyEvent.VK_W){//Up
            
            up = true;
            bw = true;
        }
        if(ke.getKeyCode() == KeyEvent.VK_S){//down
          down = true;
          bs = true;
        }
        if(ke.getKeyCode() == KeyEvent.VK_SPACE)
        {
            space = true;
            bspace = true;
            bullet();
    }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if(ke.getKeyCode() == KeyEvent.VK_A){//Left
              left = false;
              ba = false;
          }
          if(ke.getKeyCode() == KeyEvent.VK_D){//Right
              right = false;
              bd = false;
          }
          if(ke.getKeyCode() == KeyEvent.VK_W){//Up
              up = false;
              bw = false;
          }
          if(ke.getKeyCode() == KeyEvent.VK_S){//Down
              down = false;
              bs = false;
          }
          if(ke.getKeyCode() == KeyEvent.VK_SPACE)
          {
              bspace = false;
          }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        int mx = me.getX();
        int my = me.getY();
        if(mouseOver(mx,my,10,55,130,40)){
            Menu_Principal mp = new Menu_Principal();
            this.add(mp);
            repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseDragged(MouseEvent me) {
    
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        int mx = me.getX();
        int my = me.getY();
        if(mouseOver(mx,my,0, 0, 150, 150)){
            regreso=true;
        }
        else{
            regreso=false;
        }
    }
    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        if (mx > x && mx < x + width) {
            if (my > y && my < y + height) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
} 
