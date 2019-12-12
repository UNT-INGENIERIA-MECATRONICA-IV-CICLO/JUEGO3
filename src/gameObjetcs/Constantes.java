
package gameObjetcs;

import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Intel
 */
public class Constantes {
    //Ventana 
    public static final int ancho=1000;
    public static final int altura=600;
    //Propiedades del jugador
    public static final int velDispara=300;
    public static final double rota=0.1;
    public static final double ACC=0.2;
    public static final double playermaxVel=7.0;
    public static final long parpadearTime=200;
    public static final long spawnTime=3000;
    public static final long GAME_OVER_TIME=3000;
    //Propiedades de laser
    public static final double velLaser=15.0;
    //Meteoro
    public static final double MeteorVeloc=2;
    public static final int MetScore=20;
    //Enemigo
    public static final int Nodo=160;
    public static final double Masa=60;
    public static final int VelocEnemigo=3;
    
    public static long enemfireRate=1000;
    public static double EnemAnguloRango = Math.PI / 2;
     
    public static final int enemScore=40;
    public static final long UFO_SPAWN_RATE=10000;
    
    public static final String PLAY = "PLAY";
	
    public static final String EXIT = "EXIT";
    
    public static final int LOADING_BAR_WIDTH=500;
    public static final int LOADING_BAR_HEIGHT=50;

    public static final String RETURN = "RETURN";
    public static final String HIGH_SCORES = "HIGHEST SCORES";
	
    public static final String SCORE = "SCORE";
    public static final String DATE = "DATE";
    
    
    public static final String SCORE_PATH=FileSystemView.getFileSystemView().getDefaultDirectory().getPath() +
			"\\Battlefleet\\data.json"; 

}
