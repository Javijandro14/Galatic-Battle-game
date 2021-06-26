
package Ventanas;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;


public class Menu_Principal extends JPanel implements ActionListener, MouseListener, MouseMotionListener{
    /**
	 *  
	 */
	private static final long serialVersionUID = 1L;
	Random r = new Random();
    private ImageIcon JugarIm, InstruccionesIm, SalirIm, Fondomenu, LogoJuego;
    private boolean jugarseleccionada=false,instrseleccionada=false,salirseleccionada=false;
    public Menu_Principal(){
    
    this.setSize(700, 700);
    this.setLayout(null);
    this.addMouseListener(this);
    this.addMouseMotionListener(this);
    this.setFocusable(true);
    /*cm = java.applet.Applet.newAudioClip(getClass().getResource("toby fox - UNDERTALE Soundtrack - 77 ASGORE.wav"));
    cm.play();*/
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        
        Fondomenu= new ImageIcon(getClass().getResource("Fondo_Menu.jpg"));
        g.drawImage(Fondomenu.getImage(),-100,-100,900,900,this);
        LogoJuego = new ImageIcon(getClass().getResource("Logo_Videojuego.png"));
        g.drawImage(LogoJuego.getImage(), 120, 80, 500, 300,this);
        
        
        if(jugarseleccionada){
            JugarIm = new ImageIcon(getClass().getResource("JugarSeleccionada.png"));
            g.drawImage(JugarIm.getImage(), 225,350,250,150,this);
            this.repaint();
        }
        else{
            JugarIm = new ImageIcon(getClass().getResource("JugarOpcion.png"));
            g.drawImage(JugarIm.getImage(), 225,350,250,150,this);
            this.repaint();
        }
        if(instrseleccionada){
            InstruccionesIm = new ImageIcon(getClass().getResource("InstruccionesSeleccionada.png"));
            g.drawImage(InstruccionesIm.getImage(), 225,425,250,150,this);
            this.repaint();
        }
        else{
            InstruccionesIm= new ImageIcon(getClass().getResource("InstruccionesOpcion.png"));
            g.drawImage(InstruccionesIm.getImage(), 225,425,250,150,this);
            this.repaint();
        }
        if(salirseleccionada){
            SalirIm= new ImageIcon(getClass().getResource("SalirSeleccionada.png"));
            g.drawImage(SalirIm.getImage(), 225,500,250,150,this);
            this.repaint();
        }
        else{
            SalirIm = new ImageIcon(getClass().getResource("SalirOpcion.png"));
            g.drawImage(SalirIm.getImage(), 225,500,250,150,this);
            this.repaint();
        }
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
    }
    
    @Override
    public void mousePressed(MouseEvent me) {
        int mx = me.getX();
        int my = me.getY();
        if(mouseOver(mx,my,239,400,225,50)){
           Niveles n = new Niveles();
           this.removeMouseListener(this);
           this.add(n);
           repaint();
        }
        if(mouseOver(mx,my,239,471,225,50)){
            Instrucciones_videojuego iv = new Instrucciones_videojuego();
            this.removeMouseListener(this);
            this.add(iv);
            this.transferFocus();
            repaint();
        }
        if(mouseOver(mx,my,225,545,250,60)){
           System.exit(0);
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

    @Override
    public void mouseDragged(MouseEvent me) {
        
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        int mx = me.getX();
        int my = me.getY();
        if(mouseOver(mx,my,239,400,225,50)){
            jugarseleccionada=true;
            salirseleccionada=false;
            instrseleccionada=false;
        }
        else{
            jugarseleccionada=false;
        }
        if(mouseOver(mx,my,239,471,225,50)){
            instrseleccionada=true;
            jugarseleccionada=false;
            salirseleccionada=false;
        }
        else{
            instrseleccionada=false;
        }
        if(mouseOver(mx,my,239,545,225,50)){
            salirseleccionada=true;
            jugarseleccionada=false;
            instrseleccionada=false;
        }
        else{
            salirseleccionada=false;
        }
    }
    
}























