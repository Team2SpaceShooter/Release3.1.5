package Orions_War.main;

import java.awt.Graphics;
import java.util.ArrayList;

public class enemies 
{	
	public static ArrayList<NPC_Ships> enemies;
	
	
	public enemies()
	{
		enemies = new ArrayList<NPC_Ships>();	
	}
	
	public static void add(NPC_Ships NPC)
	{
		enemies.add(NPC);
	}
	
	public static void moveAll()
	{
		for(int i=0; i < enemies.size(); i++)
			enemies.get(i).move();
	}
	
	public static void spawnenemies1()
	{
		
		Runnable r2 = new Runnable()
		{
			public void run(){
			for(int i=0; i < 10; i++)
			{
				add(new NPC_Ships(0, -5, 100, 2, 0, 5));
				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}
		};
		
		Thread r = new Thread(r2);
		r.run();
		
	}
	
	public void spawnenemies2()
	{
		
	}
	
	public void spawnenemies3()
	{
		
	}
	
	public static void drawAll(Graphics g)
	{
		for(int i=0; i < enemies.size(); i++)
		{
			g.drawImage(enemies.get(i).enemy_ship,(int) enemies.get(i).xPosition, (int) enemies.get(i).yPosition, (Main.Player1.ship.getWidth())/2,(Main.Player1.ship.getHeight())/2,Main.Game_Screen);
		}
	}
	
	public static void handleOffScreen()
	{
		for(int i=0; i < enemies.size(); i++)
		{
			if(enemies.get(i).xPosition > 810 || enemies.get(i).xPosition < -10)
			enemies.remove(i);
		}
	}
}
