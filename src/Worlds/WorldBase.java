package Worlds;

import Game.Entities.Dynamic.Player;
import Game.Entities.Dynamic.Tail;
import Game.Entities.Static.Apple;
import Main.Handler;

import java.awt.*;
import java.util.LinkedList;


/**
 * Created by AlexVR on 7/2/2018.
 */
public abstract class WorldBase {

	//How many pixels are from left to right
	//How many pixels are from top to bottom
	//Must be equal
	public int GridWidthHeightPixelCount;

	//automatically calculated, depends on previous input.
	//The size of each box, the size of each box will be GridPixelsize x GridPixelsize.
	//changed to double
	public int GridPixelsize;

	public Player player;

	protected Handler handler;


	public Boolean appleOnBoard;
	protected Apple apple;
	public Boolean[][] appleLocation;


	public Boolean[][] playerLocation;

	public LinkedList<Tail> body = new LinkedList<>();


	public WorldBase(Handler handler){
		this.handler = handler;

		appleOnBoard = false;


	}
	public void tick(){



	}

	public void render(Graphics g){

		for (int i = 0; i <= 1200; i = i + GridPixelsize) {
//eliminates grid lines
//		g.setColor(Color.white);
//		g.drawLine(0, i, handler.getWidth() , i);
//		g.drawLine(i,0,i,handler.getHeight());
		String score = "Score:" + handler.getWorld().player.playerScore;//display playerScore
		g.setFont(new Font("Courier",Font.ITALIC, 45));	
		g.setColor(Color.CYAN);
		g.drawString(score, 20, 30);
		}



	}
	
	public Apple getApple(){ //Getter to access apple through world using handler 
		return apple;
	}

}
