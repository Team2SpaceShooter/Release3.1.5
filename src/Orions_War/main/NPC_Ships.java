package Orions_War.main;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class NPC_Ships extends Enemy_Space_Objects {

	final static double ShipRadius = 5;
	public static double current_yVel, current_acceleration,current_max_speed;
	public static int current_health, current_damage;
	public static int type;
	public static BufferedImage spriteSheet = null,enemy_ship = null,weapon = null;
	public static BufferedImageLoader loader = new BufferedImageLoader();
	public static Enemy_Shot shot;
	
	NPC_Ships(int type,double xPos, double yPos, double xVel, double yVel, double radius)
	{
		super(xPos, yPos, xVel, yVel, radius);
	    this.type = type;
	    current_yVel = yVel;
		set_up_ship();
		set_the_Enemy_Shots_image();
		
	    shot = new Enemy_Shot(xPos,yPos,xVel,yVel);
	}

	public void set_up_ship()
	{      BufferedImageLoader loader = new BufferedImageLoader();
	 try {
	 	  spriteSheet = loader.loadImage("images/Ship_Shop/Enemy_Ships.png");
	 	 } catch (IOException e) {
	 				// TODO Auto-generated catch block
	 				e.printStackTrace();
	 			}
	   //Level 1 type Enemy Ship
	   if(type == 0)
	   {
		   current_max_speed = 25;
		   current_health = 150;
		   current_damage = 100;
	       enemy_ship = spriteSheet.getSubimage(54, 0, 39, 38);
	   }
	   //Level 2 type of Enemy Ship
	   else if(type == 1)
	   {
		   current_max_speed = 45;
		   current_health = 200;
		   current_damage = 150;
		   enemy_ship = spriteSheet.getSubimage(5, 0, 48, 39);
	   }
	   //Level 3 type of Enemy Ship
	   else
	   {
		   current_max_speed = 65;
		   current_health = 250;
		   current_damage = 200;
		   enemy_ship = spriteSheet.getSubimage(95, 0, 62, 45);
	   }
	}
	
	public Enemy_Shot getShot()
	{
		return shot;
	}
	
	public static void accelerateY()
	{
		// Also add thruster boost to x or y velocity
		
		current_yVel += 0.1;
		
		if(current_yVel >current_max_speed)
		{
			current_yVel = current_max_speed;
		}
	}
	
	
	
	public static void deacceleateY()
	{
		current_yVel -= 0.1;
		
		if(current_yVel < -current_max_speed)
		{
			current_yVel = -current_max_speed;
		}
	}
	public void set_the_Enemy_Shots_image()
	{
		try {
			spriteSheet = loader.loadImage("images/Ship_Shop/Weapon_Sprite_Sheet.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(Main.Player1.Ship.Ship_Weapon.getCurrentWeapon() == 0)
		{
		  weapon = spriteSheet.getSubimage(44, 1, 7, 21);
		}
		else if(Main.Player1.Ship.Ship_Weapon.getCurrentWeapon() == 1)
		{
		  weapon = spriteSheet.getSubimage(58, 1, 7, 21);
		}
		else if(Main.Player1.Ship.Ship_Weapon.getCurrentWeapon() == 2)
		{
		  weapon = spriteSheet.getSubimage(69, 1, 7, 21);
		}
		
	}
	
	


}
