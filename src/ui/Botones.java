
package ui;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import graphics.Assets;
import graphics.Texto;
import input.Mouse;
import math.Vector2D;

public class Botones {
	
	private BufferedImage mouseOutImg;
	private BufferedImage mouseInImg;
	private boolean mouseIn;
	private Rectangle boundingBox;  //Para la caja de colision del rectangulo
	private Accion action;
	private String text;
	
	public Botones(
			BufferedImage mouseOutImg,
			BufferedImage mouseInImg,
			int x, int y,
			String text,
			Accion action
			) {
            this.mouseInImg = mouseInImg;
            this.mouseOutImg = mouseOutImg;
            this.text = text;
            boundingBox = new Rectangle(x, y, mouseInImg.getWidth(), mouseInImg.getHeight());
            this.action = action;
	}
	
	public void actualizar() 
        {
            if(boundingBox.contains(Mouse.X, Mouse.Y)) 
            {
                    mouseIn = true;
            }else {
                    mouseIn = false;
            }

            if(mouseIn && Mouse.MLB) {
                    action.doAccion();
            }
	}
	
	public void dibujar(Graphics g) 
        {
            if(mouseIn) {
                g.drawImage(mouseInImg, boundingBox.x, boundingBox.y, null);
            }else {
                g.drawImage(mouseOutImg, boundingBox.x, boundingBox.y, null);
            }

            Texto.dibujarTexto(
                        g,
                        text,
                        new Vector2D(
                                        boundingBox.getX() + boundingBox.getWidth() / 2,
                                        boundingBox.getY() + boundingBox.getHeight()),
                        true,
                        Color.BLACK,
                        Assets.fontMed);
	}
}
