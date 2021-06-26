
package Ventanas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.AudioClip;
//Estas son librerias. Sirven para importar funciones especiales para una funcion especifica

public class Nivel_1 extends JPanel implements ActionListener,KeyListener{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ox=200, oy=390, velX, velY, posX=0, Health=100, vx=0, score=0;//Jugador
    private final int ix=10000,iy=700 /*iy=700*/;//Nivel Fondo
    private int pro, damage;
    private int enemigo1H=50, enemigo2H=50, enemigo3H=50, enemigo4H=50, enemigo5H=50, e1x=1000,e1y=100,e2x=1200,e2y=200,e3x=1225,e3y=300, e4x=1000, e4y=400, e5x=1200,e5y=500;//Enemigos, nivel de vida, posiciones
    public int v, jefex=1000,jefey=250, jefeH=400;//Jefe Posicion y vida
    private boolean up= false, down=false, left=false, right=false, bulletshot = false;//Estos muestran el movimiento del jugador y si dispara sus proyectiles.
    private boolean jefearriba=true,jefeabajo=false, ataque=false;//Movimiento del jefe y su comportamiento hacia el jugador
    private boolean enemigo1_arriba=true,enemigo1_abajo=false,enemigo2_arriba=false,enemigo2_abajo=true,enemigo3_arriba=true,enemigo3_abajo=false, enemigo4_arriba=false, enemigo4_abajo=true, enemigo5_arriba=true,enemigo5_abajo=false;//Enemigo Movimiento arriba y abajo
    private ImageIcon personaje, fondo, enemigo1, enemigo2, enemigo3, enemigo4, enemigo5, jefe, victory, defeat;//Imagenes de todo el ambiente del juego
    Rectangle enemigo1c; Rectangle enemigo2c; Rectangle enemigo3c; Rectangle enemigo4c; Rectangle enemigo5c; Rectangle Jefec; Rectangle Playerc;//Estos representan las collisiones de cada nave
    Rectangle Bullet; Rectangle BulletBoss;//Estas son balas para el jugador y el jefe final
    public int persona = Personajes.i;// Esta variable muestra que personaje seleccionó el jugador para este nivel
    Niveles niveles;
    private final AudioClip Cancionfondo;
    
    public Nivel_1(){
    
    this.setSize(700, 700);
    this.addKeyListener(this);
    this.setFocusable(true);
    Cancionfondo = java.applet.Applet.newAudioClip(getClass().getResource("115 8-Bit Version.wav"));
    Cancionfondo.play();
    }
    @Override
    public void paintComponent(Graphics g){
        String personajes[] = new String[5];
        personajes[0] = "Nave_Marlon.png";
        personajes[1] = "Nave_Diaz.png";
        personajes[2] = "Nave_Osorio.png";
        personajes[3] = "Nave_Sebas.png";
        personajes[4] = "Nave_Coguox.png";
        //Estos son imagenes. Cada numero en [] contiene una imagen y al dibujarlo dependerá del personaje que escogió
        super.paintComponent(g);
        if(pro<=ix){
        pro = -(posX*100/(ix-700));
        //Barra de Progression. Esto demuestra que tan lejos a llegado el jugador en el nivel.
        }
        fondo = new ImageIcon(getClass().getResource("Nivel_Javier.jpg"));//Nombre del Fondo del nivel
        personaje = new ImageIcon(getClass().getResource(personajes[persona]));//Nave del Personaje seleccionada
        enemigo1 = new ImageIcon(getClass().getResource("Enemigo 1.png"));
        enemigo2 = new ImageIcon(getClass().getResource("Enemigo 2.png"));
        enemigo3 = new ImageIcon(getClass().getResource("Enemigo 3.png"));
        enemigo4 = new ImageIcon(getClass().getResource("Enemigo 4.png"));
        enemigo5 = new ImageIcon(getClass().getResource("Enemigo 5.png"));
        jefe = new ImageIcon(getClass().getResource("Jefe_1.png"));
        victory = new ImageIcon(getClass().getResource("victory.png"));
        defeat = new ImageIcon(getClass().getResource("game_over.png"));
        //Estos variables contienen imagenes para dibujarlos.
        
        g.drawImage(fondo.getImage(), posX,0,ix,iy,this);//Dibuja el fondo del nivel
        
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
           if(oy>600){
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
            if(ox>620){
                velX=0;
            }
            else{
            velX=3;
            }
           ox+=velX;
           //this.repaint();
        }
        //Movimiento del jugador, este metodo es mas conveniente ya que hace que los movimientos sean mas fluidos
        
        
        if(enemigo1H>0){
            int h = enemigo1H;
            enemigo1c = new Rectangle(e1x,e1y,20,50);
            g.drawImage(enemigo1.getImage(), e1x, e1y, 50,50,this);
            g.setColor(Color.green);
            g.fillRect(e1x, e1y+50, enemigo1H, 5);
            g.setColor(Color.WHITE);   
            g.drawRect(e1x, e1y+50, 50, 5);
            g.drawString(""+ h, e1x, e1y+65);
            this.repaint();
            //Dibuja la imagen de la nave con su barra de vida
        }
        else if(enemigo1H==0){
            e1x=1000;
            enemigo1c = new Rectangle(e1x,e1y,20,50);
            g.drawImage(enemigo1.getImage(), e1x, e1y, 50,50,this);
            g.setColor(Color.green);
            g.fillRect(e1x, e1y+50, enemigo1H, 5);
            g.setColor(Color.WHITE);   
            g.drawRect(e1x, e1y+50, 50, 5);
            enemigo1H=50;
            this.repaint();
            //Si el enemigo1H es igual a 0, se mueve la imagen y restaura su nivel de vida
        }
        if(enemigo2H>0){
            int h = enemigo2H;
            enemigo2c = new Rectangle(e2x,e2y,20,50);
            g.drawImage(enemigo2.getImage(), e2x, e2y, 50,50,this);
            g.setColor(Color.green);
            g.fillRect(e2x, e2y+50, enemigo2H, 5);
            g.setColor(Color.WHITE);   
            g.drawRect(e2x, e2y+50, 50, 5);
            g.drawString(""+ h, e2x, e2y+65);
            this.repaint();
            //Hace lo mismo que el primer enemigo
        }
        else if(enemigo2H==0){
            e2x=1000;
            enemigo2c = new Rectangle(e2x,e2y,20,50);
            g.drawImage(enemigo2.getImage(), e2x, e2y, 50,50,this);
            g.setColor(Color.green);
            g.fillRect(e2x, e2y+50, enemigo2H, 5);
            g.setColor(Color.WHITE);   
            g.drawRect(e2x, e2y+50, 50, 5);
            enemigo2H=50;
            this.repaint();
            //Hace lo mismo que el primer enemigo
        }
        if(enemigo3H>0){
            int h = enemigo3H;
            enemigo3c = new Rectangle(e3x,e3y,20,50);
            g.drawImage(enemigo3.getImage(), e3x, e3y, 50,50,this);
            g.setColor(Color.green);
            g.fillRect(e3x, e3y+50, enemigo3H, 5);
            g.setColor(Color.WHITE);   
            g.drawRect(e3x, e3y+50, 50, 5);
            g.drawString(""+ h, e3x, e3y+65);
            this.repaint();
            //Hace lo mismo que el primer enemigo
        }
        else if(enemigo3H==0){
            e3x=1000;
            enemigo3c = new Rectangle(e3x,e3y,20,50);
            g.drawImage(enemigo3.getImage(), e3x, e3y, 50,50,this);
            g.setColor(Color.green);
            g.fillRect(e3x, e3y+50, enemigo3H, 5);
            g.setColor(Color.WHITE);   
            g.drawRect(e3x, e3y+50, 50, 5);
            enemigo3H=50;
            this.repaint();
            //Hace lo mismo que el primer enemigo
        }
        if(enemigo4H>0){
            int h = enemigo4H;
            enemigo4c = new Rectangle(e4x,e4y,20,50);
            g.drawImage(enemigo4.getImage(), e4x, e4y, 50,50,this);
            g.setColor(Color.green);
            g.fillRect(e4x, e4y+50, enemigo4H, 5);
            g.setColor(Color.WHITE);   
            g.drawRect(e4x, e4y+50, 50, 5);
            g.drawString(""+ h, e4x, e4y+65);
            this.repaint();
            //Hace lo mismo que el primer enemigo
        }
        else if(enemigo4H==0){
            e4x=1000;
            enemigo4c = new Rectangle(e4x,e4y,20,50);
            g.drawImage(enemigo4.getImage(), e4x, e4y, 50,50,this);
            g.setColor(Color.green);
            g.fillRect(e4x, e4y+50, enemigo4H, 5);
            g.setColor(Color.WHITE);   
            g.drawRect(e4x, e4y+50, 50, 5);
            enemigo4H=50;
            this.repaint();
            //Hace lo mismo que el primer enemigo
        }
        if(enemigo5H>0){
            int h = enemigo5H;
            enemigo5c = new Rectangle(e5x,e5y,20,50);
            g.drawImage(enemigo5.getImage(), e5x, e5y, 50,50,this);
            g.setColor(Color.green);
            g.fillRect(e5x, e5y+50, enemigo5H, 5);
            g.setColor(Color.WHITE);   
            g.drawRect(e5x, e5y+50, 50, 5);
            g.drawString(""+ h, e5x, e5y+65);
            this.repaint();
            //Hace lo mismo que el primer enemigo
        }
        else if(enemigo5H==0){
            e5x=1000;
            enemigo5c = new Rectangle(e5x,e5y,20,50);
            g.drawImage(enemigo5.getImage(), e5x, e5y, 50,50,this);
            g.setColor(Color.green);
            g.fillRect(e5x, e5y+50, enemigo5H, 5);
            g.setColor(Color.WHITE);   
            g.drawRect(e5x, e5y+50, 50, 5);
            enemigo5H=50;
            this.repaint();
            //Hace lo mismo que el primer enemigo
        }
        
        if(jefeH<=0){
            Jefec = new Rectangle(0,0,0,0);
            //Si jefeH es igual a 0, el jefe se elimina y el rectángulo desaparece.
        }
        else{
            g.drawImage(jefe.getImage(), jefex, jefey, 200, 200, this);
            Jefec = new Rectangle(jefex,jefey+20,100,160);
            //BulletBoss = new Rectangle(jefex,jefey,10,5);
            //dibuja la imagen del jefe, su colision, y sus balas.
        }
        if(Health>0){
            Playerc = new Rectangle(ox,oy,75,75);
            int h = Health;
            g.setColor(Color.green);
            g.fillRect(15, 15, (int)(Health*4), 32);
            g.setColor(Color.WHITE);
            g.drawRect(15, 15, 400, 32);
            g.drawString("Health: "+ h, 20, 60);
            g.drawString("Score: "+ score, 20, 80);
            g.drawImage(personaje.getImage(), ox, oy, 75, 75, this);
            //Si Health es mayor que 0, entonces el jugador SI esta vivo
        }
        else{
            //Esto sirve para que cuando el jugador muera, ya no podrá disparar, ademas este metodo hace que su personaje no aparezca.
            
            bulletshot=false;
            g.setColor(Color.red.darker().darker());
            g.fillRect(180, 90, 340, 90);
            g.drawImage(defeat.getImage(), 0,-100,700,500,this);
            g.drawString("Your score is: "+ score +" points!", 300, 200);
            Playerc = new Rectangle(0,0,0,0);
            
        }
        if(jefeH>0){
        if(Playerc.intersects(enemigo1c)){
                score+=10;
                enemigo1H=0;
                Health-=5;
                this.repaint();
                //Si el enemigo toca al jugador, el enemigo muere, pero el jugador recibe daño
        }
        if(Playerc.intersects(enemigo2c)){
                score+=10;
                enemigo2H=0;
                Health-=5;
                this.repaint();
                //Si el enemigo toca al jugador, el enemigo muere, pero el jugador recibe daño
        }
        if(Playerc.intersects(enemigo3c)){
            score+=10;
            enemigo3H=0;   
            Health-=5;
            this.repaint();
            //Si el enemigo toca al jugador, el enemigo muere, pero el jugador recibe daño
        }
        if(Playerc.intersects(enemigo4c)){
            score+=10;
            enemigo4H=0;   
            Health-=5;
            this.repaint();
            //Si el enemigo toca al jugador, el enemigo muere, pero el jugador recibe daño
        }
        if(Playerc.intersects(enemigo5c)){
            score+=10;
            enemigo5H=0;   
            Health-=5;
            this.repaint();
            //Si el enemigo toca al jugador, el enemigo muere, pero el jugador recibe daño
        }
    }
        //g.drawRect(Playerc.x, Playerc.y, Playerc.width, Playerc.height);
        if(pro<100){
        g.drawRect(150, 620, 400, 30);
        g.setColor(Color.yellow);
        g.fillRect(150, 620, pro*4, 30);
        g.drawString(pro+"%", 400, 600);
        //Si la barra de progresion no esta llena, se sigue dibujando
        }
        else{
            //Esta vacio porque cuando se llena, desaparece la barra y viene el jefe
        }
                
        for(int timer=0; timer<=60000; timer++){		
        
        if(timer == 60000){
        int mov;
        v=1;
        e1x-=v;
        e2x-=v;
        e3x-=v;
        e4x-=v;
        e5x-=v;
        
        //Mueve los enemigos hacia la izquierda
        //g.drawString(""+ t/100, 400, 400);
        if(posX<-(ix-700)){
        mov=0;
        if(jefex>500){
        jefex-=1;
        }
        else if(jefex==500)
        {
            ataque=true;
        }
        }
        else{
        mov=1;
        
        }
        posX-=mov;
        if(enemigo1_arriba){
            if(e1y>10){
                e1y-=1;
            }
            else{
                enemigo1_abajo=true;
                enemigo1_arriba=false;
            }
            this.repaint();
        }
        if(enemigo1_abajo){
             if(e1y<600){
                    e1y+=1;
                }
                else{
                    enemigo1_arriba=true;
                    enemigo1_abajo=false;
                }
            this.repaint();
        }
        if(enemigo2_arriba){
            if(e2y>10){
                e2y-=1;
            }
            else{
                enemigo2_abajo=true;
                enemigo2_arriba=false;
            }
            this.repaint();
        }
        if(enemigo2_abajo){
            if(e2y<600){
                    e2y+=1;
                }
                else{
                    enemigo2_arriba=true;
                    enemigo2_abajo=false;
                }
            this.repaint();
        }
        if(enemigo3_arriba){
            if(e3y>10){
                e3y-=1;
            }
            else{
                enemigo3_abajo=true;
                enemigo3_arriba=false;
            }
            this.repaint();
        }
        if(enemigo3_abajo){
            if(e3y<600){
                    e3y+=1;
                }
                else{
                    enemigo3_arriba=true;
                    enemigo3_abajo=false;
                }
        }
        if(enemigo4_arriba){
            if(e4y>10){
                e4y-=1;
            }
            else{
                enemigo4_abajo=true;
                enemigo4_arriba=false;
            }
            this.repaint();
        }
        if(enemigo4_abajo){
            if(e4y<600){
                    e4y+=1;
                }
                else{
                    enemigo4_arriba=true;
                    enemigo4_abajo=false;
                }
        }
        if(enemigo5_arriba){
            if(e5y>10){
                e5y-=1;
            }
            else{
                enemigo5_abajo=true;
                enemigo5_arriba=false;
            }
            this.repaint();
        }
        if(enemigo5_abajo){
            if(e5y<600){
                    e5y+=1;
                }
                else{
                    enemigo5_arriba=true;
                    enemigo5_abajo=false;
                }
        }
            if(e1x<0){
            enemigo1H=0;
            this.repaint();
        }
            if(e2x<0){
            enemigo2H=0;
            this.repaint();
        }
            if(e3x<0){
            enemigo3H=0;
            this.repaint();
        }
            if(e4x<0){
            enemigo4H=0;
            this.repaint();
        }
            if(e5x<0){
            enemigo5H=0;
            this.repaint();
        }
            this.repaint();
        
        }
        repaint();
        }
        
        if(ataque){
            int x=jefeH/4;
            g.setColor(Color.black);
            g.drawString("Boss Health: " + x, 150, 600);
            g.setColor(Color.green);
            g.fillRect(150, 620, jefeH, 30);
            g.setColor(Color.WHITE);
            g.drawRect(150, 620, 400, 30);
           if(jefearriba){
            if(jefey>0){
                jefey-=2;
            }
            else{
                jefeabajo=true;
                jefearriba=false;
            }
            
           }
            if(jefeabajo){
                if(jefey<500){
                    jefey+=2;
                }
                
                else{
                    jefearriba=true;
                    jefeabajo=false;
                }
            }
            
            if(Playerc.intersects(Jefec)){
                Health-=1;
                //Si el jugador toca al jefe, el jugador recibe mucho daño
            }
            
            this.repaint();
        }
        
        if(bulletshot){
            g.fillRect(Bullet.x, Bullet.y,Bullet.width, Bullet.height);
            
            if(Bullet.intersects(enemigo1c)){
                score+=25;
                damage=25;
                enemigo1H-=damage;
                Bullet.setRect(0, 0, 0, 0);
            }
            else{
                damage=0;
            }
            if(Bullet.intersects(enemigo2c)){
                score+=25;
                damage=25;
                enemigo2H-=damage;
                Bullet.setRect(0, 0, 0, 0);
            }
            else{
                damage=0;
            }
            if(Bullet.intersects(enemigo3c)){
                score+=25;
                damage=25;
                enemigo3H-=damage;
                Bullet.setRect(0, 0, 0, 0);
            }
            else{
                damage=0;
            }
            if(Bullet.intersects(enemigo4c)){
                score+=25;
                damage=25;
                enemigo4H-=damage;
                
                Bullet.setRect(0, 0, 0, 0);
            }
            else{
                damage=0;
            }
            if(Bullet.intersects(enemigo5c)){
                score+=25;
                damage=25;
                enemigo5H-=damage;
                Bullet.setRect(0, 0, 0, 0);
            }
            else{
                damage=0;
            }
            if(Bullet.intersects(Jefec)){
                score+=20;
                damage=10;
                jefeH-=damage;
                Bullet.setRect(0, 0, 0, 0);
                repaint();
            }
           Bullet.x+=vx;
           this.repaint();
          
        }
        repaint();
        if(jefeH<=0){
            v=0;
            g.setColor(Color.green.darker().darker());
            g.fillRect(190, 100, 340, 90);
            g.drawImage(victory.getImage(), 0,-100,700,500,this);
            g.drawString("Your score is: "+ score +" points!", 300, 200);
            g.drawString("Press Enter to Continue", 300, 400);
            repaint();
        }
    }
    public void bullet(){
        int bx = ox + 75; 
        int by = oy + 35;
        Bullet = new Rectangle(bx, by, 10,5);
        vx=3;
        bx+=vx;
        repaint();
    }
    @Override
    public void actionPerformed(ActionEvent ae) {   
        
    }
    
    @Override
    public void keyTyped(KeyEvent ke) {
    }
    
    
     @Override
    public void keyPressed(KeyEvent ke){
       if(jefeH>0){
       if(ke.getKeyCode() == KeyEvent.VK_D){ //Right
           right =true;
          
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
       
        if(ke.getKeyCode() == KeyEvent.VK_SPACE){
            bulletshot = true;
             bullet();
        }
       }
       else{
           bulletshot=false;
            right = false;
            left=false;
            up=false;
            down=false;
       }
            if(ke.getKeyCode() == KeyEvent.VK_ENTER){
                
                if(jefeH<=0){
                
                Cancionfondo.stop();
                Niveles n = new Niveles();
                this.add(n);
                n.nivel1=true;
                n.nivel2=true;
                Personajes.i=0;
                this.transferFocus();
            }
            if(Health<=0){
                
                Cancionfondo.play();
                Nivel_1 n1 = new Nivel_1();
                this.add(n1);
                this.transferFocus();
            }
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
          if(ke.getKeyCode() == KeyEvent.VK_SPACE){
          }
    }
}