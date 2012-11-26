package Orions_War.main;

import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Enemy_Shot extends Space_Objects
{
	final static double Enemy_ShotRadius = 3;
	private int age;
	

	
	public Enemy_Shot(double xPos, double yPos, double xVel, double yVel) 
	{
	
			super(xPos, yPos, xVel, yVel, Enemy_ShotRadius);
			age = 0;

		}

	public void move()
	{
		super.move();
		age++;
	}
	
	public int getAge()
	{
		return age;
	}
	
	

}
