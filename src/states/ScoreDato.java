/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import gameObjetcs.Constantes;
import graphics.Assets;
import graphics.Texto;
import io.JSONParser;
import io.ScoreData;
import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import math.Vector2D;
import ui.Accion;
import ui.Botones;

/**
 *
 * @author Intel
 */
public class ScoreDato extends State{
    private Botones returnBotones;
    private PriorityQueue<ScoreData> highScores;
    private Comparator<ScoreData> scoreComparator;
    private ScoreData[]auxArray;
    
    public ScoreDato(){
       returnBotones = new Botones(
				Assets.greyBtn,
				Assets.blueBtn,
				Assets.greyBtn.getHeight(),
				Constantes.altura - Assets.greyBtn.getHeight() * 2,
				Constantes.RETURN,
				new Accion() {
					@Override
					public void doAccion() {
						State.cambiarEstado(new MenuState());
					}
		
                                }
			);
       scoreComparator =new Comparator<ScoreData>(){
           @Override
           public int compare(ScoreData e1,ScoreData e2){
               return e1.getScore()<e2.getScore()? -1:e1.getScore()>e2.getScore()?1:0;
           }
       };
       highScores=new PriorityQueue<ScoreData>(10, scoreComparator);
       
        try {
            ArrayList<ScoreData> dataList= JSONParser.readFile();
            for(ScoreData d:dataList){
                highScores.add(d);
            }
            while(highScores.size()>10){
                highScores.poll();
            }
            
        
        } catch (FileNotFoundException e) {
           e.printStackTrace();
        }
    
    }
    @Override
    public void actualizar() {
        returnBotones.actualizar();
    }

    @Override
    public void dibujar(Graphics g) {
      returnBotones.dibujar(g);
		
		auxArray = highScores.toArray(new ScoreData[highScores.size()]);
		
		Arrays.sort(auxArray, scoreComparator);
		
		
		Vector2D scorePos = new Vector2D(
				Constantes.ancho / 2 - 200,
				100
				);
		Vector2D datePos = new Vector2D(
				Constantes.ancho / 2 + 200,
				100
				);
		
		Texto.dibujarTexto(g, Constantes.SCORE, scorePos, true, Color.BLUE, Assets.fontBig);
		Texto.dibujarTexto(g, Constantes.DATE, datePos, true, Color.BLUE, Assets.fontBig);
		
		scorePos.setY(scorePos.getY() + 40);
		datePos.setY(datePos.getY() + 40);
		
		for(int i = auxArray.length - 1; i > -1; i--) {
			
			ScoreData d = auxArray[i];
			
			Texto.dibujarTexto(g, Integer.toString(d.getScore()), scorePos, true, Color.WHITE, Assets.fontMed);
			Texto.dibujarTexto(g, d.getDate(), datePos, true, Color.WHITE, Assets.fontMed);
			
			scorePos.setY(scorePos.getY() + 40);
			datePos.setY(datePos.getY() + 40);
			
		}
		
    }
    
}
