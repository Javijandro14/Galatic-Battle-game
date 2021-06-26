
package Ventanas;

import javax.swing.JFrame;


public class Ventana_Principal extends JFrame{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Ventana_Principal(){
        super("Galactic Battle");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,700);
        this.setLocationRelativeTo(null);
        
        Menu_Principal mp = new Menu_Principal();
        this.add(mp);
        /*Niveles n = new Niveles();
        this.add(n);*/
        /*Nivel_1 n1 = new Nivel_1();
        this.add(n1);*/
        /*Nivel_5 n5 = new Nivel_5();
        this.add(n5);*/
        
        this.setResizable(false);
        this.setVisible(true);
    }
    public static float clamp(int var, int min, int max) {
		if(var >= max) return var = max;
		else if(var <= min)return var = min;
		else return var;
	}
}
