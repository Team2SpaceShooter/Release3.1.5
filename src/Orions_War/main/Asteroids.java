package Orions_War.main;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class Asteroids extends Enemy_Space_Objects
{

	public BufferedImage sprite = null;
	
	Asteroids(int type,double xPos, double yPos, double xVel, double yVel, double radius) 
	{
		super(xPos, yPos, xVel, yVel, radius);
		createAsteroid(type);
	}
	
	
	public void createAsteroid(int type)
	{
		BufferedImageLoader loader = new BufferedImageLoader();
		
		if(type == 0)
		{
			try 
			{
				sprite = loader.loadImage("images/asteroidSmall01.png");
			} catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			radius = 10;
		}
		else if(type == 1)
		{
			
			try 
			{
				sprite = loader.loadImage("images/asteroid01.png");
			} catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			radius = 25;
			
		}
		else if(type == 2)
		{
			
			try 
			{
				sprite = loader.loadImage("images/asteroidBig01.png");
			} catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			radius = 50;
			
		}
		
		
	}
}
