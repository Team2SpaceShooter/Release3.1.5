package Orions_War.main;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class AsteroidHandler 
{
	
	public static ArrayList<Asteroids> asteroids;
	
	public AsteroidHandler()
	{
		asteroids = new ArrayList<Asteroids>();
	}
	
	public static void add(Asteroids asteroid)
	{
		asteroids.add(asteroid);
	}
	
	public static void moveAll()
	{
		//System.out.println("asteroids.size: "+asteroids.size());
		for(int i=0; i < asteroids.size(); i++)
			asteroids.get(i).move();
	}
	
	public static void handleOffScreen()
	{
		for(int i=0; i < asteroids.size(); i++)
		{
			if(asteroids.get(i).xPosition > 1050 || asteroids.get(i).xPosition < -50)
			asteroids.remove(i);
		}
	}
	
	public static void drawAll(Graphics g)
	{
		for(int i=0; i < asteroids.size(); i++)
		{
			g.drawImage(asteroids.get(i).sprite,(int) asteroids.get(i).xPosition, (int) asteroids.get(i).yPosition, null);
		}
	}
	
	public static void spawnAsteroids(final int interval)
	{
		final Random generator = new Random();
		Runnable rA = new Runnable()
		{

			@Override
			public void run() 
			{
				add(new Asteroids(generator.nextInt(2), generator.nextInt(999), 0, generator.nextInt(10), generator.nextInt(10), 15));
				try 
				{
					Thread.sleep(interval);
				} catch (InterruptedException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		};
		
		Thread th = new Thread(rA);
		th.run();

	}
	
	
	
}
