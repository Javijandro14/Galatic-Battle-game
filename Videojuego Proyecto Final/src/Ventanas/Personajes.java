
package Ventanas;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;


public class Personajes extends JPanel implements MouseListener, MouseMotionListener{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon Marlon, Javier, Osorio, Sebas, Coguox;
    private ImageIcon NaveM, NaveJ, NaveO, NaveS, NaveC;
    private ImageIcon Fondomenu;
    private Boolean m=false,j=false,o=false,s=false,c=false;
    public static int i;
    public int niveljuego = Niveles.nivel;
    Menu_Principal menu;
    
    public Personajes(){
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
        
        Marlon = new ImageIcon(getClass().getResource("Persona.png"));
        Javier = new ImageIcon(getClass().getResource("Persona2.png"));
        Osorio = new ImageIcon(getClass().getResource("Persona3.png"));
        Sebas = new ImageIcon(getClass().getResource("Persona4.png"));
        Coguox = new ImageIcon(getClass().getResource("Persona5.png"));
        //Personajes
        NaveM = new ImageIcon(getClass().getResource("Nave_Marlon.png"));
        NaveJ = new ImageIcon(getClass().getResource("Nave_Diaz.png"));
        NaveO = new ImageIcon(getClass().getResource("Nave_Osorio.png"));
        NaveS = new ImageIcon(getClass().getResource("Nave_Sebas.png"));
        NaveC = new ImageIcon(getClass().getResource("Nave_Coguox.png"));
        //Naves de los personajes
        
        g.drawRect(70, 80, 250, 150);
        g.drawRect(70, 280, 250, 150);
        g.drawRect(360, 80, 250, 150);
        g.drawRect(360, 280, 250, 150);
        g.drawRect(210, 480, 250, 150);
        g.setColor(Color.RED);
        
        if(m){
        g.fillRect(70, 80, 250, 150);
        repaint();
        }
        if(j){
        g.fillRect(70, 280, 250, 150);
        repaint();
        }
        if(o){
        g.fillRect(360, 80, 250, 150);
        repaint();
        }
        if(s){
        g.fillRect(360, 280, 250, 150);
        repaint();
        }
        if(c){
        g.fillRect(210, 480, 250, 150);
        repaint();
        }
        
        g.drawImage(Marlon.getImage(), 80, 100, 100, 100,this);
        g.drawImage(Javier.getImage(), 80, 300, 100, 100,this);
        g.drawImage(Osorio.getImage(), 380, 100, 100, 100,this);
        g.drawImage(Sebas.getImage(), 380, 300, 100, 100,this);
        g.drawImage(Coguox.getImage(),225, 500, 100, 100,this);
        //Dibuja los personajes
        g.drawImage(NaveM.getImage(), 200, 100, 100, 100,this);
        g.drawImage(NaveJ.getImage(), 200, 300, 100, 100,this);
        g.drawImage(NaveO.getImage(), 500, 100, 100, 100,this);
        g.drawImage(NaveS.getImage(), 500, 300, 100, 100,this);
        g.drawImage(NaveC.getImage(), 350, 500, 100, 100,this);
        //Dibuja las naves
        repaint();
    }
    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me){
        int mx = me.getX();
        int my = me.getY();
        
        if(mouseOver(mx,my,70, 80, 250, 150)){//Marlon
            i=0;
            if(niveljuego==0){
            Nivel_1 n1 = new Nivel_1();
            this.add(n1);
            this.transferFocus();
            this.removeMouseListener(this);
            this.repaint();
            }
            if(niveljuego==1){
            Nivel_2 n2 = new Nivel_2();
            this.add(n2);
            this.transferFocus();
            this.removeMouseListener(this);
            this.repaint();
            }
            if(niveljuego==2){
            Nivel_3 n3 = new Nivel_3();
            this.add(n3);
            this.transferFocus();
            this.removeMouseListener(this);
            this.repaint();
            }
            if(niveljuego==3){
            Nivel_4 n4 = new Nivel_4();
            this.add(n4);
            this.transferFocus();
            this.removeMouseListener(this);
            this.repaint();
            }
            if(niveljuego==4){
            Nivel_5 n5 = new Nivel_5();
            this.add(n5);
            this.transferFocus();
            this.removeMouseListener(this);
            this.repaint();
            
            }
        }
        if(mouseOver(mx,my,70, 280, 250, 150)){//Javier
            i=1;
            if(niveljuego==0){
            Nivel_1 n1 = new Nivel_1();
            this.add(n1);
            this.transferFocus();
            this.removeMouseListener(this);
            this.repaint();
            }
            if(niveljuego==1){
            Nivel_2 n2 = new Nivel_2();
            this.add(n2);
            this.transferFocus();
            this.removeMouseListener(this);
            this.repaint();
            }
            if(niveljuego==2){  
            Nivel_3 n3 = new Nivel_3();
            this.add(n3);
            this.transferFocus();
            this.removeMouseListener(this);
            this.repaint();
            }
            if(niveljuego==3){
            Nivel_4 n4 = new Nivel_4();
            this.add(n4);
            this.transferFocus();
            this.removeMouseListener(this);
            this.repaint();
            }
            if(niveljuego==4){
            Nivel_5 n5 = new Nivel_5();
            this.add(n5);
            this.transferFocus();
            this.removeMouseListener(this);
            this.repaint();
            }
        }
        
        if(mouseOver(mx,my,360, 80, 250, 150)){//Osorio
            i=2;
            if(niveljuego==0){
            Nivel_1 n1 = new Nivel_1();
            this.add(n1);
            this.transferFocus();
            this.removeMouseListener(this);
            this.repaint();
            }
            if(niveljuego==1){
            Nivel_2 n2 = new Nivel_2();
            this.add(n2);
            this.transferFocus();
            this.removeMouseListener(this);
            this.repaint();
            }
            if(niveljuego==2){
            Nivel_3 n3 = new Nivel_3();
            this.add(n3);
            this.transferFocus();
            this.removeMouseListener(this);
            this.repaint();
            }
            if(niveljuego==3){
            Nivel_4 n4 = new Nivel_4();
            this.add(n4);
            this.transferFocus();
            this.removeMouseListener(this);
            this.repaint();
            }
            if(niveljuego==4){
            Nivel_5 n5 = new Nivel_5();
            this.add(n5);
            this.transferFocus();
            this.removeMouseListener(this);
            this.repaint();
            }
        }
        
        if(mouseOver(mx,my,360, 280, 250, 150)){//Sebas
            i=3;
            if(niveljuego==0){
            Nivel_1 n1 = new Nivel_1();
            this.add(n1);
            this.transferFocus();
            this.removeMouseListener(this);
            this.repaint();
            }
            if(niveljuego==1){
            Nivel_2 n2 = new Nivel_2();
            this.add(n2);
            this.transferFocus();
            this.removeMouseListener(this);
            this.repaint();
            }
            if(niveljuego==2){
            Nivel_3 n3 = new Nivel_3();
            this.add(n3);
            this.transferFocus();
            this.removeMouseListener(this);
            this.repaint();
            }
            if(niveljuego==3){
            Nivel_4 n4 = new Nivel_4();
            this.add(n4);
            this.transferFocus();
            this.removeMouseListener(this);
            this.repaint();
            }
            if(niveljuego==4){
            Nivel_5 n5 = new Nivel_5();
            this.add(n5);
            this.transferFocus();
            this.removeMouseListener(this);
            this.repaint();
            }
        }
        if(mouseOver(mx,my,210, 480, 250, 150)){//Coguox
            i=4;
            if(niveljuego==0){
            Nivel_1 n1 = new Nivel_1();
            this.add(n1);
            this.transferFocus();
            this.removeMouseListener(this);
            this.repaint();
            }
            if(niveljuego==1){
            Nivel_2 n2 = new Nivel_2();
            this.add(n2);
            this.transferFocus();
            this.removeMouseListener(this);
            this.repaint();
            }
            if(niveljuego==2){
            Nivel_3 n3 = new Nivel_3();
            this.add(n3);
            this.transferFocus();
            this.removeMouseListener(this);
            this.repaint();
            }
            if(niveljuego==3){
            Nivel_4 n4 = new Nivel_4();
            this.add(n4);
            this.transferFocus();
            this.removeMouseListener(this);
            this.repaint();
            }
            if(niveljuego==4){
            Nivel_5 n5 = new Nivel_5();
            this.add(n5);
            this.transferFocus();
            this.removeMouseListener(this);
            this.repaint();
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
        int mx=me.getX();
        int my=me.getY();
        if(mouseOver(mx,my,70, 80, 250, 150)){
            m=true;
            j=false;
            o=false;
            s=false;
            c=false;
        }
        else{
            m=false;
        }
        if(mouseOver(mx,my,70, 280, 250, 150)){
            m=false;
            j=true;
            o=false;
            s=false;
            c=false;
        }
        else{
            j=false;
        }
        if(mouseOver(mx,my,360, 80, 250, 150)){
            m=false;
            j=false;
            o=true;
            s=false;
            c=false;
        }
        else{
            o=false;
        }
        if(mouseOver(mx,my,360, 280, 250, 150)){
            m=false;
            j=false;
            o=false;
            s=true;
            c=false;
        }
        else{
            s=false;
        }
        if(mouseOver(mx,my,210, 480, 250, 150)){
            m=false;
            j=false;
            o=false;
            s=false;
            c=true;
        }
        else{
            c=false;
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
