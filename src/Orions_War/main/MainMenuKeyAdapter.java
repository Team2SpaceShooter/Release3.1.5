package Orions_War.main;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MainMenuKeyAdapter extends KeyAdapter
{
	private MainMenu menu;
	
	public MainMenuKeyAdapter(MainMenu mainMenu)
	{
		this.menu = mainMenu;
	}
	
	public void keyPressed(KeyEvent e)
	{
		int keycode = e.getKeyCode();
		
		System.out.println("key pressed: ");
		
		switch(keycode)
		{
		case KeyEvent.VK_UP:
			System.out.println("up");
			MainMenu.selector.moveUp();
			menu.repaint();
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("down");
			MainMenu.selector.moveDown();
			menu.repaint();
			break;
		case KeyEvent.VK_ENTER:
			System.out.println("enter");
			System.out.println(menu.getSelection());
			MenuEventHandler.handleEvent(menu.getSelection());
			break;
		}
	}
	
	
}