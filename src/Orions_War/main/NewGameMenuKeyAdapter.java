package Orions_War.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;

public class NewGameMenuKeyAdapter extends KeyAdapter
{
	private NewGameMenu newGameMenu;
	
	public NewGameMenuKeyAdapter(NewGameMenu newGameMenu)
	{
		this.newGameMenu = newGameMenu;
	}
	
	public void keyPressed(KeyEvent e)
	{
		int keycode = e.getKeyCode();
		
		System.out.println("key pressed: ");
		
		switch(keycode)
		{
		case KeyEvent.VK_UP:
			System.out.println("up");
			NewGameMenu.selector.moveUp();
			newGameMenu.repaint();
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("down");
			NewGameMenu.selector.moveDown();
			newGameMenu.repaint();
			break;
		case KeyEvent.VK_ENTER:
			System.out.println("enter");
			System.out.println(newGameMenu.getSelection());
			try {
				NewGameMenuEventHandler.handleEvent(newGameMenu.getSelection());
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			break;
		}
	}
	
	
}