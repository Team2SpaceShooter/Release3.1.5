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
				add(new NPC_Ships(0, -5, 200, 6, -1, 5));
				add(new NPC_Ships(0, -30, 250, 6, -1, 5));
				add(new NPC_Ships(0, 15, 300, 6, -1, 5));
		
				
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				Thread.sleep(500);
				for(int j =0; j < 10; j++)
					enemies.get(j).update_velocities(-6 , 3 );
				Thread.sleep(3000);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int i=0; i < 10; i++)
			{
				add(new NPC_Ships(0, 980, 250, -5, -1, 5));
				add(new NPC_Ships(0, 1005, 300, -5, -1, 5));
				add(new NPC_Ships(0, 1030, 350, -5, -1, 5));
				try {
					Thread.sleep(500);
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
	
	public static void spawnenemies2()
	{
		Runnable r2 = new Runnable()
		{
			public void run(){
			for(int i=0; i < 10; i++)
			{
				add(new NPC_Ships(0, -5, 100, 5, 0, 5));
				try {
					Thread.sleep(500);
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
	
	public static void spawnenemies3()
	{
		Runnable r2 = new Runnable()
		{
			public void run(){
			for(int i=0; i < 10; i++)
			{
				add(new NPC_Ships(0, -5, 400, 5, -1, 5));
				try {
					Thread.sleep(500);
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
			if(enemies.get(i).xPosition > 1050 || enemies.get(i).xPosition < -50)
			enemies.remove(i);
		}
	}
}
