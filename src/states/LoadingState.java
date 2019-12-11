/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import gameObjetcs.Constantes;
import graphics.Assets;
import graphics.Loader;
import graphics.Texto;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;

import java.awt.Graphics;
import java.awt.Graphics2D;

import math.Vector2D;

/**
 *
 * @author Intel
 */
public class LoadingState extends State {
    
    private Thread loadingThread;
    private Font font;
    public LoadingState(Thread loadingThread){
        this.loadingThread=loadingThread;
        this.loadingThread.start();
        font=Loader.loadFont("/fuente/futureFont.ttf",38);
    }
    @Override
    public void actualizar() {
      if(Assets.loaded){
          State.cambiarEstado(new MenuState());
          try{
              loadingThread.join();
          } catch(InterruptedException e){
              e.printStackTrace();
          }
      }
    }

    @Override
    public void dibujar(Graphics g) {
       GradientPaint gp= new GradientPaint(
        Constantes.ancho/2 - Constantes.LOADING_BAR_WIDTH/2,
        Constantes.altura/2 - Constantes.LOADING_BAR_HEIGHT/2,
        Color.WHITE,
        Constantes.ancho/2 + Constantes.LOADING_BAR_WIDTH/2,
        Constantes.altura/2 + Constantes.LOADING_BAR_HEIGHT/2,
        Color.BLUE);
       
       Graphics2D g2d=(Graphics2D)g;
       g2d.setPaint(gp);
       float percentage = (Assets.count / Assets.MAX_COUNT);
		
		g2d.fillRect(Constantes.ancho / 2 - Constantes.LOADING_BAR_WIDTH / 2,
				Constantes.altura / 2 - Constantes.LOADING_BAR_HEIGHT / 2,
				(int)(Constantes.LOADING_BAR_WIDTH * percentage),
				Constantes.LOADING_BAR_HEIGHT);
		
		//dibujar el marco de la barra
                g2d.drawRect(Constantes.ancho / 2 - Constantes.LOADING_BAR_WIDTH / 2,
				Constantes.altura / 2 - Constantes.LOADING_BAR_HEIGHT / 2,
				Constantes.LOADING_BAR_WIDTH,
				Constantes.LOADING_BAR_HEIGHT);
		
		Texto.dibujarTexto(g2d, "BATTLEFLEET", new Vector2D(Constantes.ancho / 2, Constantes.altura / 2 - 50),
				true, Color.WHITE, font);
		
		
		Texto.dibujarTexto(g2d, "LOADING...", new Vector2D(Constantes.ancho/ 2, Constantes.altura / 2 + 40),
				true, Color.WHITE, font);
    }
    }


