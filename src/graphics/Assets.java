
package graphics;

import java.awt.Font;
import java.awt.image.BufferedImage;
import javax.sound.sampled.Clip;



public class Assets {
    
    public static boolean loaded=false;
    public static float count=0;
    public static float MAX_COUNT=100;
    
            
            
    public static BufferedImage player;
   
    public static BufferedImage speed;
    public static BufferedImage screen;
   
    public static BufferedImage azullaser,verdelaser,rojolaser;
    public static BufferedImage space;
    public static BufferedImage enemigo;
    public static BufferedImage life;
    
    public static BufferedImage []grande=new BufferedImage[1];
    public static BufferedImage []mediano=new BufferedImage[1];
    public static BufferedImage []pequeño=new BufferedImage[1];
    
    
    public static BufferedImage []explosion=new BufferedImage[1]; 
    public static BufferedImage []numeros=new BufferedImage[11]; 
    
    
    public static Font fontBig;
    public static Font fontMed;
    
    public static Clip  musica,playerlaser,explo,playerLoose,ufoShoot;
    public static BufferedImage blueBtn;
    public static BufferedImage greyBtn;
    
    
    public static void init() {
        for (int j =0; j<3; j++)
        {
       
       space=loadImage("/ships/space.png");
       player=loadImage("/ships/Dr_opt_opt.png");
       speed=loadImage("/efectos/fire04.png");
       screen=loadImage("/ships/Fondo_opt.jpg");
       
       azullaser=loadImage("/laser/laserBlue16.png");
       verdelaser=loadImage("/laser/laserGreen10.png");
       rojolaser= loadImage("/laser/laserRed16.png");   
      
       
       for(int i=0;i<grande.length;i++)
           grande[i]=loadImage("/meteoros/grande"+(i+1)+".png");
       
       for(int i=0;i<grande.length;i++)
           mediano[i]=loadImage("/meteoros/mediano"+(i+1)+".png");
       
       for(int i=0;i<grande.length;i++)
           pequeño[i]=loadImage("/meteoros/pequeño"+(i+1)+".png");
       
      
       
       for(int i=0;i<explosion.length;i++)
           explosion[i]=loadImage("/efectos/explo"+i+".png");
       
       for(int i=0;i<numeros.length;i++)
           numeros[i]=loadImage("/numeros/"+i+".png");
       
       
       enemigo= loadImage("/ships/ene_opt.png");  
       life= loadImage("/otros/life.png"); 
       
       fontBig=loadFont("/fuente/futureFont.ttf",42);
       fontMed=loadFont("/fuente/futureFont.ttf",20);
  
       musica=loadSonido("/sonidos/tullegaste.wav");
       playerlaser=loadSonido("/sonidos/Playerlaser.wav");
       explo=loadSonido("/sonidos/explosion.wav");
       playerLoose=loadSonido("/sonidos/playerLoose.wav");
       ufoShoot=loadSonido("/sonidos/ufoShoot.wav");
               
       greyBtn = loadImage("/ui/grey_button01.png");
       blueBtn = loadImage("/ui/blue_button04.png");
       
        }
       //=======================================================
       loaded=true;
    } 
    public static BufferedImage loadImage(String path){
        count ++;
        return Loader.ImageLoader(path);
    }
    public static Font loadFont(String path, int size){
        count ++;
        return Loader.loadFont(path, size);
    }
    public static Clip loadSonido(String path){
        count++;
        return Loader.loadSonido(path);
    }
}
