package view.windows;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.KeyboardFocusManager;

import javax.swing.JFrame;
import javax.swing.JPanel;

import listeners.systemFunctions.SystemSaveListener;
import view.panels.curSelectedPanel.B_CurSelectedPanel;
import view.panels.inputPanel.C_InputPanel;
import view.panels.outputPanel.C_OutputPanel;

public class B_MainWindow {
	private JFrame window;
	
	private JPanel mainPanel;
	private C_OutputPanel outputPanel;
	private B_CurSelectedPanel curSelectedPanel;
	private C_InputPanel inputPanel;
	
	private GridBagConstraints c;
	
	public B_MainWindow() {
		initializeComponents();
		layoutComponents();
		display();
	}
	
	private void initializeComponents() {
		this.window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.mainPanel = new JPanel(new GridBagLayout());
		this.outputPanel = new C_OutputPanel();
		this.curSelectedPanel = new B_CurSelectedPanel();
		this.inputPanel = new C_InputPanel();
		
		this.c = new GridBagConstraints();
	}
	
	private void layoutComponents() {
		KeyboardFocusManager keyManager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		keyManager.addKeyEventDispatcher(new SystemSaveListener());
		
		c.ipadx = 30;
		c.ipady = 30;
		
		c.gridx = 0;
		c.gridy = 0;		
		mainPanel.add(outputPanel.getOutputPanel(), c);
		
		c.gridx = 1;
		c.gridy = 0;
		mainPanel.add(curSelectedPanel.getCurSelectedPanel(), c);
		
		c.gridx = 2;
		c.gridy = 0;
		mainPanel.add(inputPanel.getUserInputPanel(), c);
		
		window.add(mainPanel);
	}
	
	public void display() {
		window.pack();
		//window.addKeyListener(new SystemSaveListener());
		window.setVisible(true);
	}
	
	public void refreshCurSelectedPanel() {		
		this.curSelectedPanel.refresh();
		
		c.gridx = 1;
		c.gridy = 0;
		mainPanel.add(curSelectedPanel.getCurSelectedPanel(), c);
		
		window.setVisible(true);
	//	layoutComponents();
//		display();
	}	
}
