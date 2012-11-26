package Orions_War.main;


import java.awt.Color; 
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import java.awt.Font;
import javax.imageio.ImageIO;
import javax.swing.JLabel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@SuppressWarnings("serial")
public class Game_Screen extends JPanel implements KeyListener
{
	public static double current_yVel, current_xVel;
	private static Color backgroundColor = Color.black;
	private static Color textColor = Color.white;

	
	

	
	private static Dimension windowSize = new Dimension(1000,800);
	private static Image img1;
	
	//TODO: make the selectionOval its own class
	private static int selectionOvalWidth = 3;
	private static int selectionOvalHeight = 3;
	public static int Ship_Pos_X = 400,Ship_Pos_Y = 700;
	public static Random generator = new Random();
	volatile public static ArrayList<Shot> shots = new ArrayList <Shot>();
	public static  int xPosition = generator.nextInt(940);
	public static int count =0;
	volatile public static ArrayList <Asteroids> Enemy_Asteroids = new ArrayList <Asteroids>();
    volatile public static ArrayList <NPC_Ships> Enemy_NPC_Ships = new ArrayList <NPC_Ships>();
    
	
	
	// These are the bool fields that correspond to in game key presses
	private boolean upPress, downPress, leftPress, rightPress, spacePress, escPressed;
	
	public Game_Screen()
	{
	
		System.out.println("Game Screen created");
        ImageIcon icon = new ImageIcon("images/spacefield.png");
		
		img1 = icon.getImage();

		this.setBackground(backgroundColor);
		this.setSize(windowSize);
		this.setOpaque(true);
		
		//NOTE: for focusing, these must not be set in the constructor. Undesirable focus behavior results from doing so
		//this.setVisible(true); // needed to focus
		//this.setFocusable(true); // needed to focus
		//this.setEnabled(true); // needed to focus
		
		this.addKeyListener(this);
		//this.addMouseListener(new NewGameMenuMouseAdapter(this));
		//System.out.println("requesting focus: " + this.requestFocus());
		
		//added so that manual position of JComponents would be feasible
		this.setLayout(null);
		
		
		upPress = false;
		downPress = false;
		leftPress = false;
		rightPress = false;
		spacePress = false;
		escPressed = false;
		
		
	}
	
	 
	 
	 
//Need to figure out how to do double buffering.. 
	 
	 /*
	  * Double Buffering: We create image before displaying it
	  * 
	  * Thoughts: Need function to load next image and always display one screen previous
	  * 
	  * 
	  * 
	  * Draw ship graphics image then display graphics repeatedly (this way we can just add things to buffered graphics image and then display those)
	  * 
	  */
	public void play() throws FileNotFoundException
	{
		System.setProperty("sun.java2d.pmoffscreen", "false");
		  System.setProperty("org.apache.pivot.wtk.disablevolatilebuffer",
                  "false");
		  
		  	
		  	enemies NPC = new enemies();
		  	//enemies.spawnenemies1();
		 	//this.setVisible(true);
		 
			//this.setEnabled(true);
			//this.setFocusable(true);
		
			Graphics g = Main.Game_Screen.getGraphics();
			g.drawImage(img1, 0, 0, 1010,805, this);
			//g.drawImage()
			  g.drawImage(Main.Player1.ship,Ship_Pos_X,Ship_Pos_Y, (Main.Player1.ship.getWidth())/2,(Main.Player1.ship.getHeight())/2,this);
			  //NPC_Ships one = new NPC_Ships(1,400, 500, 0 ,0, 5);
			  
			  
		      Toolkit.getDefaultToolkit().sync();
		

		     

		      File level = null;

		      if(Main.Player1.progress == 1)
		      {  
		    	  level =  new File(System.getProperty("user.dir")+"/src/Orions_War/levels", "level1.txt"); 
		    	  System.out.println("SUCCESS");
		    	  System.out.println(level);
		      } 
		      else if(Main.Player1.progress == 2)
		      {  
		    	  level =  new File(System.getProperty("user.dir")+"/src/Orions_War/levels", "level2.txt"); 
		      }
		      else if(Main.Player1.progress == 3)
		      {  
		    	  level =  new File(System.getProperty("user.dir")+"/src/Orions_War/levels", "level3.txt"); 
		      }
		      else if(Main.Player1.progress == 4)
		      {  
		    	  level =  new File(System.getProperty("user.dir")+"/src/Orions_War/levels", "level4.txt"); 
		      } 
		      else if(Main.Player1.progress == 5)
		      {  
		    	  level =  new File(System.getProperty("user.dir")+"/src/Orions_War/levels", "level5.txt"); 
		      }

		      Scanner sc = new Scanner(level);
		      int num = 0;
		      int [] nums = new int[6];
		      int do_asteroids = 1;
		      boolean done = false;
		      while(!done)
		      {  
		    	  if(do_asteroids == 1)
		    	  { 
		    		  
		    		  for(int z =0; z < 3; z++)	
		    		  {  
		    			  num = sc.nextInt();
		    			  for(int y = 0; y < 6; y++)
	    				  {
	    					  nums[y] = sc.nextInt();
	    				  } 
		    			  for(int x = 0; x < num; x++)
		    			  {
		    				     
		    				  Enemy_Asteroids.add(new Asteroids(nums[0],nums[1] + Main.Game_Screen.xPosition,nums[2],nums[3],nums[4],nums[5]));
		    			  }
		    	  } 
		    		  do_asteroids = 0;
		    	  }
		    	  else
		    	  {
		    		  for(int z =0; z < 3; z++)
		    		  {  
		    			  num = sc.nextInt();
		    			  for(int y = 0; y < 6; y++)
	    				  {
	    					  nums[y] = sc.nextInt();
	    				  } 
		    			  for(int x = 0; x < num; x++)
		    			  {
		    				   
		    				  Enemy_NPC_Ships.add(new NPC_Ships(nums[0],nums[1]  + Main.Game_Screen.xPosition,nums[2],nums[3],nums[4],nums[5]));
		    			  }
		    		  }
		    	  }
		    	  done = true;
		      }

			//this.requestFocusInWindow();
		
		
		Runnable r1 = new Runnable()
		{ 		
			public void run()
			{Main.Game_Screen.setDoubleBuffered(true);
			
				while(!escPressed)
				{
					
					//long time = System.currentTimeMillis();
					
					
					Graphics g = Main.Game_Screen.getGraphics();
					
					//if(current_xVel != 0.0 || current_yVel !=0.0)
					g.drawImage(img1, 0, 0, 1000,800, Main.Game_Screen);
				
					//HandlekeyActions();
					//Handle_Collisions();
					//updateShip();
					g.drawImage(Main.Player1.ship,Ship_Pos_X,Ship_Pos_Y, (Main.Player1.ship.getWidth())/2,(Main.Player1.ship.getHeight())/2,Main.Game_Screen);
					//g.drawImage(one.enemy_ship, (int)one.xPosition, (int)one.yPosition,(Main.Player1.ship.getWidth())/2,(Main.Player1.ship.getHeight())/2,Main.Game_Screen);
					deal_with_shots_fired(g);
					//deal_with_NPCs(g);
					enemies.drawAll(g);
					Toolkit.getDefaultToolkit().sync();	
					
					try
					{
						//long Delay = Math.max(0, 32-System.currentTimeMillis()-time);
						//long delay = Math.max(0, 32-(System.currentTimeMillis()-time));	
						Thread.sleep(30);
						
					}
						catch(InterruptedException e)
						{
						}
					
				}
			}
			
		};
		
		Runnable r2 = new Runnable()
		{
			public void run()
			{
				while(!escPressed)
				{
				//Graphics g = Main.Game_Screen.getGraphics();
				
				//deal_with_shots_fired(g);
					HandlekeyActions2();
					
				
				try
				{
					
					Thread.sleep(125);	
				}
					catch(InterruptedException e)
					{
					}
				}
			}
		};
		
		Runnable r3 = new Runnable()
		{
			public void run()
			{
				while(!escPressed)
				{
				//Graphics g = Main.Game_Screen.getGraphics();
				
				//deal_with_shots_fired(g);
					HandlekeyActions();
					
				
				try
				{
					
					Thread.sleep(30);	
				}
					catch(InterruptedException e)
					{
					}
				}
			}
		};
		
		Runnable r4 = new Runnable()
		{
			public void run()
			{
				while(!escPressed)
				{
				//Graphics g = Main.Game_Screen.getGraphics();
				
				//deal_with_shots_fired(g);
					Handle_Collisions();
					updateShip();
					enemies.moveAll();
					enemies.handleOffScreen();
					
				
				try
				{
					
					Thread.sleep(30);	
				}
					catch(InterruptedException e)
					{
					}
				}
			}
		};
		
		
		Runnable r5 = new Runnable()
		{
			public void run()
			{
				Graphics g = Main.Game_Screen.getGraphics();
				while(!escPressed)
				{
				
	            // g.drawImage(img1, 0, 0, 1000,800, Main.Game_Screen);
				
					g.drawImage(Main.Player1.ship,Ship_Pos_X,Ship_Pos_Y, (Main.Player1.ship.getWidth())/2,(Main.Player1.ship.getHeight())/2,Main.Game_Screen);
				//deal_with_shots_fired(g);
					Toolkit.getDefaultToolkit().sync();	
				
				try
				{
					
					Thread.sleep(60);	
				}
					catch(InterruptedException e)
					{
					}
				}
			}
		};
		
		Runnable r6 = new Runnable()
		{ 		
			public void run()
			{Main.Game_Screen.setDoubleBuffered(true);
			enemies.spawnenemies1();
			//enemies.spawnenemies2();
			//enemies.spawnenemies3();
				while(!escPressed)
				{
					
					//long time = System.currentTimeMillis();
					
					
					//Graphics g = Main.Game_Screen.getGraphics();
					
					//if(current_xVel != 0.0 || current_yVel !=0.0)
					//g.drawImage(img1, 0, 0, 1000,800, Main.Game_Screen);
					//enemies.spawnenemies1();
					//HandlekeyActions();
					//Handle_Collisions();
					//updateShip();
					//g.drawImage(Main.Player1.ship,Ship_Pos_X,Ship_Pos_Y, (Main.Player1.ship.getWidth())/2,(Main.Player1.ship.getHeight())/2,Main.Game_Screen);
					//g.drawImage(one.enemy_ship, (int)one.xPosition, (int)one.yPosition,(Main.Player1.ship.getWidth())/2,(Main.Player1.ship.getHeight())/2,Main.Game_Screen);
					//deal_with_shots_fired(g);
					Toolkit.getDefaultToolkit().sync();	
					
					try
					{
						//long Delay = Math.max(0, 32-System.currentTimeMillis()-time);
						//long delay = Math.max(0, 32-(System.currentTimeMillis()-time));	
						Thread.sleep(30);
						
					}
						catch(InterruptedException e)
						{
						}
					
				}
			}
			
		};
		
		
		Thread thr1 = new Thread(r1);
		Thread thr2 = new Thread(r2);
		Thread thr3 = new Thread(r3);
		Thread thr4 = new Thread(r4);
		//Thread thr5 = new Thread(r5);
		Thread thr6 = new Thread(r6);
		thr1.start();
		thr2.start();
		thr3.start();
		thr4.start();
	   // thr5.start();
		thr6.start();
	}
		
		
	private void HandlekeyActions2()
	{
		if(spacePress) fire_shot();
	}
		
	
	
	private void HandlekeyActions()
	{
		// This method is called from this class every time a key is pressed
		if (upPress) moveShipUp();
		if (downPress) moveShipDown();
		if (leftPress) moveShipLeft();
		if (rightPress) moveShipRight();
		//if (spacePress) fire_shot();
		
		if(Ship_Pos_Y <= 0 && current_yVel <0)
		{
			Ship_Pos_Y = 0;
			current_yVel = 0;
			//repaint();
			return;
		}
		else if(Ship_Pos_Y >= 730 && current_yVel >0)
		{
			Ship_Pos_Y = 730;
			current_yVel = 0;
			//repaint();
			return;
		}
		
		if(Ship_Pos_X <= 0 && current_xVel < 0)
		{
			Ship_Pos_X = 0;
			current_xVel = 0;
			//repaint();
			return;
		}
		else if(Ship_Pos_X >= 940 && current_xVel > 0)
		{
			Ship_Pos_X = 940;
			current_xVel = 0;
			//repaint();
			return;
		}
	}
	
	
	
	public void updateShip()
	{
		Ship_Pos_X += current_xVel;
		Ship_Pos_Y += current_yVel;
	}
	
	public void moveShipUp()
	{
		if(Ship_Pos_Y <= 0)
		{
			Ship_Pos_Y = 0;
			current_yVel = 0;
			//repaint();
			return;
		}
		else 
			{
			current_yVel -= 0.5;
			
			if(current_yVel < -5)
			{
				current_yVel = -5;
			};
			System.out.println("Going up");
			
			}
		
	}
	public void moveShipDown()
	{
		if(Ship_Pos_Y >= 730)
		{
			Ship_Pos_Y = 730;
			current_yVel = 0;
			//repaint();
			return;
		}
		else 
			{
			current_yVel += 0.5;
			
			
			if(current_yVel > 5)
			{
				current_yVel = 5;
			
			}
			System.out.println("Going down");
			}
	}
	public void moveShipLeft()
	{
		if(Ship_Pos_X <= 0)
		{
			Ship_Pos_X = 0;
			current_xVel = 0;
			//repaint();
			return;
		}
		else 
			{
			current_xVel -= 0.5;
			
			if(current_xVel < -5)
			{
				current_xVel = -5;
			}
			System.out.println("Going Left");
			}
		
	}
	public void moveShipRight()
	{
		if(Ship_Pos_X >= 940)
		{
			Ship_Pos_X = 940;
			current_xVel = 0;
			//repaint();
			return;
		}
		else {
			current_xVel += 0.5;
			
			if(current_xVel > 5)
			{
				current_xVel = 5;
			}
			System.out.println("Going Right");
			}
		
	}
	
	public void keyTyped(KeyEvent e){
		// This overrides the keyTyped method which enables keyPressed() to handle 
		// all of the movement
	}
	
	public void keyPressed(KeyEvent e)
	{
		int keycode = e.getKeyCode();
		
		System.out.println("key pressed: ");
		
		switch(keycode)
		{
		case KeyEvent.VK_UP:
			System.out.println("up");
			this.upPress = true;
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("down");
			this.downPress = true;
			break;
		case KeyEvent.VK_LEFT:
			System.out.println("left");
			this.leftPress = true;
			break;
		case KeyEvent.VK_RIGHT:
			System.out.println("right");
			this.rightPress = true;
			break;
		case KeyEvent.VK_SPACE:
			System.out.println("space");
			this.spacePress = true;
			break;
		case KeyEvent.VK_ESCAPE:
			System.out.println("escape!");
			this.escPressed = true;

		}// end switch
		
		e.consume();
		//Game_Screen.keyAction();
		
		
	}
	
	public void keyReleased(KeyEvent e)
	{
		int keycode = e.getKeyCode();
		
		System.out.println("key released: ");
		
		switch(keycode)
		{
		case KeyEvent.VK_UP:
			System.out.println("up");
			this.upPress = false;
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("down");
			this.downPress = false;
			break;
		case KeyEvent.VK_LEFT:
			System.out.println("left");
			this.leftPress = false;
			break;
		case KeyEvent.VK_RIGHT:
			System.out.println("right");
			this.rightPress = false;
			break;
		case KeyEvent.VK_SPACE:
			System.out.println("space");
			this.spacePress = false;
			break;
			

		}
	}
	
	public void fire_shot()
	{
		shots.add(new Shot((double)Ship_Pos_X+26,(double)Ship_Pos_Y - 10, 0 ,-10));
		
	}
	
	public void deal_with_shots_fired(Graphics g)
	{
		//ArrayList<Shot> newshots = new ArrayList <Shot>();
		  //if(!shots.equals(null))
		  for(int i=0; i < shots.size(); ++i) 			  
		 {  
			shots.get(i).move();
			if(Main.Player1.Ship.Ship_Weapon.getCurrentWeapon() == -1)
			{	
				g.setColor(Color.GREEN);
				g.drawOval((int)shots.get(i).getXPosition(),(int)shots.get(i).getYPosition(), (int)shots.get(i).getRadius(), (int)shots.get(i).getRadius());

			}
			else	
			{
				g.drawImage(shots.get(i).weapon,(int)shots.get(i).getXPosition(),(int)shots.get(i).getYPosition(),7,21,this);	
			}
		 }
	}
	
		  
			public void deal_with_enemy_shots_fired(Graphics g)
			{
				//ArrayList<Shot> newshots = new ArrayList <Shot>();
				  //if(!shots.equals(null))
				  for(int i=0; i < Enemy_NPC_Ships.size(); ++i) 			  
				 {  
					Enemy_NPC_Ships.get(i).move();
					if(Main.Player1.Ship.Ship_Weapon.getCurrentWeapon() == -1)
					{	
						g.setColor(Color.RED);
						g.drawOval((int)Enemy_NPC_Ships.get(i).getXPosition(),(int)Enemy_NPC_Ships.get(i).getYPosition(), (int)Enemy_NPC_Ships.get(i).getRadius(), (int)Enemy_NPC_Ships.get(i).getRadius());
						
						
					}
					else	
					{
						
						g.drawImage(Enemy_NPC_Ships.get(i).weapon,(int)Enemy_NPC_Ships.get(i).getXPosition(),(int)Enemy_NPC_Ships.get(i).getYPosition(),7,21,this);	
					}
				 }
				  
			}
		  

	public void Handle_Collisions()
	{
	boolean[] shotsAlive = new boolean[shots.size()];
	boolean[] NPCsAlive = new boolean[enemies.enemies.size()];
	ArrayList<Shot> newShots = new ArrayList<Shot>();
	ArrayList<NPC_Ships> newEnemies = new ArrayList<NPC_Ships>();

	Arrays.fill(shotsAlive, true);
    Arrays.fill(NPCsAlive, true);
    // Deal with shots blowing up enemies
	for(int i = 0; i < shots.size(); i++) 
		if(shotsAlive[i])
	{
		Shot s = shots.get(i);
		for(int j = 0; j < enemies.enemies.size(); j++) 
			if(NPCsAlive[j])
		{
			NPC_Ships e = enemies.enemies.get(j);
			
			// If a shot has hit a comet, destroy both the shot and comet
			if(s.overlapping(e))
			{
				 enemies.enemies.get(j).current_health -= Main.Player1.shipDamage;
				System.out.println("ENEMY " + j + " has been hit and has " + enemies.enemies.get(j).current_health + "Left");
				shotsAlive[i] = false;
				if(enemies.enemies.get(j).current_health <= 0)
				NPCsAlive[j] = false;
				
				// New Comets spawn for the next frame
				// Keep this?					
				break;
			}
		}
	}
    
    
    //Deals with Shots not having hit anything and just existing
	for(int i = 0; i < shots.size(); i++) 
	if(shotsAlive[i]) 
	{
	  Shot s = shots.get(i);
	  if(s.getYPosition() > 0) 
	   newShots.add(s);
	}
	for(int j = 0; j < enemies.enemies.size(); ++j) 
		if(NPCsAlive[j]) 
			newEnemies.add(enemies.enemies.get(j));
 
	enemies.enemies = newEnemies;
	shots = newShots;
	}		

	
}
