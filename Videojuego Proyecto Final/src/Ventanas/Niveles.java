package Ventanas;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Niveles extends JPanel implements ActionListener, MouseListener, MouseMotionListener{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon Fondomenu, nivelJavier, nivelSebas, nivelCoguox, nivelMarlon, nivelOsorio, J,S,C,M,O;
    //private int sizex=1000,sizey=1000, posX=150, posY=150;
    public boolean nivel1=true, nivel2=true, nivel3=true, nivel4=true, nivel5=true;
    private boolean n1s=true,n2s=true, n3s=true,n4s=true,n5s=true;
    public static int nivel=0;
    
    public Niveles(){
        this.setSize(700, 700);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.setFocusable(true);
        this.setVisible(true);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Fondomenu= new ImageIcon(getClass().getResource("Fondo_Menu.jpg"));
        g.drawImage(Fondomenu.getImage(), 0,0,700,700,this);
        
        nivelJavier = new ImageIcon(getClass().getResource("Planeta_Diaz.png"));
        nivelSebas = new ImageIcon(getClass().getResource("Planeta_Sebas.png"));
        nivelCoguox = new ImageIcon(getClass().getResource("Planeta_Coguox.png"));
        nivelMarlon = new ImageIcon(getClass().getResource("Planeta_Marlon.png"));
        nivelOsorio = new ImageIcon(getClass().getResource("Planeta_Osorio.png"));
        
        J = new ImageIcon(getClass().getResource("Planeta_Diaz_Seleccionada.png"));
        S = new ImageIcon(getClass().getResource("Planeta_Sebas_Seleccionada.png"));
        C = new ImageIcon(getClass().getResource("Planeta_Coguox_Seleccionada.png"));
        M = new ImageIcon(getClass().getResource("Planeta_Marlon_Seleccionada.png"));
        O = new ImageIcon(getClass().getResource("Planeta_Osorio_Seleccionada.png"));
        g.setColor(Color.black);
        
        if(nivel1==true){
            if(n1s==true){
            g.drawImage(J.getImage(),60,50,150,120,this);
            repaint();
            }
            else{
            g.drawImage(nivelJavier.getImage(), 60,50,150,120,this);
            repaint();
            }
        }
        else{
            g.fillOval(60,50,150,150);//Javier
            repaint();
        }
        if(nivel2==true){
            if(n2s==true){
            g.drawImage(M.getImage(),450,50,160,120,this);
            repaint();
            }
            else{
                g.drawImage(nivelMarlon.getImage(), 450,50,160,120,this);
                repaint();
            }
        }
        else{
            g.fillOval(460,50,150,150);//Marlon
            repaint();
        }
        if(nivel3==true){
            if(n3s==true){
            g.drawImage(C.getImage(),60,300,190,150,this);
            repaint();
            }
            else{
                g.drawImage(nivelCoguox.getImage(), 60,300,190,150,this);
                repaint();
            }
        }
        else{
            g.fillOval(80,300,150,150);//Coguox
            repaint();
        }
        if(nivel4==true){
            if(n4s==true){
            g.drawImage(S.getImage(),450,320,170,130,this);
            }
            else{
                g.drawImage(nivelSebas.getImage(), 450,320,170,130,this);
                repaint();
            }
        }
        else{
            g.fillOval(450,320,150,150);//Sebas
            repaint();
        }
        if(nivel5==true){
            if(n5s==true){
            g.drawImage(O.getImage(),220,480,220,160,this);
          }
            else{
                g.drawImage(nivelOsorio.getImage(), 220,480,220,160,this);
            }
        }
        else{
           g.fillOval(240,490,150,150);//Osorio
           repaint();
        }
        this.repaint();
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
    }

    @Override
    public void mouseClicked(MouseEvent me) {
    }

    @Override
    public void mousePressed(MouseEvent me) {
        int mx = me.getX();
        int my = me.getY();
         if(mouseOver(mx,my,60,50,150,120)){//Nivel 1
           if(nivel1==true){ 
           Personajes p = new Personajes();
           this.add(p);
           nivel = 0;
           this.transferFocus();
           repaint();
           }
        }
         if(mouseOver(mx,my,460,50,140,120)){//Nivel 2
           if(nivel2==true){  
           nivel = 1;
           Personajes p = new Personajes();
           this.add(p);
           this.transferFocus();
           repaint();
           }
        }
         if(mouseOver(mx,my,80,300,140,150)){//Nivel 3
           if(nivel3==true){
           nivel = 2;
           Personajes p = new Personajes();
           this.add(p);
           this.transferFocus();
           repaint();
            }
        }
         if(mouseOver(mx,my,450,320,150,130)){//Nivel 4
           if(nivel4==true){
           nivel = 3;
           Personajes p = new Personajes();
           this.add(p);
           this.transferFocus();
           repaint();
             }
        }
        if(mouseOver(mx,my,240,490,170,140)){//Nivel 5
           if(nivel5==true){
           nivel = 4;
           Personajes p = new Personajes();
           this.add(p);
           this.transferFocus();
           repaint();
           }
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
        if(mouseOver(mx,my,60,50,150,120)){//Nivel 1
            n1s=true;
            n2s=false;
            n3s=false;
            n4s=false;
            n5s=false;
        }
        else{
             n1s=false;
        }
         if(mouseOver(mx,my,460,50,140,120)){//Nivel 2
           n2s=true;
           n1s=false;
           n3s=false;
           n4s=false;
           n5s=false;
        }
         else{
             n2s=false;
        }
         if(mouseOver(mx,my,80,300,140,150)){//Nivel 3
           n3s=true;
           n1s=false;
           n2s=false;
           n4s=false;
           n5s=false;
        }
         else{
             n3s=false;
        }
         if(mouseOver(mx,my,450,320,150,130)){//Nivel 4
           n4s=true;
           n1s=false;
           n2s=false;
           n3s=false;
           n5s=false;
        }
         else{
             n4s=false;
        }
        if(mouseOver(mx,my,240,490,170,140)){//Nivel 5
           n5s=true;
           n1s=false;
           n2s=false;
           n3s=false;
           n4s=false;
        }
        else{
             n5s=false;
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
