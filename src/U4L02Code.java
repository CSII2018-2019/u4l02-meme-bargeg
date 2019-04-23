import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class U4L02Code extends JFrame {
	
	public static final String FILE_NAME = "/dogs.jpg";
	
	public U4L02Code(){
		initGUI();
		//setTitle("Meme");
		setResizable(true);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	} 
	
	public void initGUI(){
		//title Panel
		ImagePanel rgbImg = new ImagePanel(FILE_NAME);
		ImagePanel imgPanel = new ImagePanel(FILE_NAME);
		add(imgPanel, BorderLayout.LINE_START);
		add(rgbImg, BorderLayout.LINE_END);
		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(Color.BLACK);
		JLabel titleLabel = new JLabel("Walking into a test you didn't study for like");
		titleLabel.setForeground(Color.WHITE);
		titlePanel.add(titleLabel);
		add(titlePanel, BorderLayout.PAGE_START);
		JPanel downButtonPanel = new JPanel();
		downButtonPanel.setBackground(Color.LIGHT_GRAY);
		add(downButtonPanel, BorderLayout.PAGE_END);
		JButton conspiracyButton = new JButton ("conspiracy filter");
		JButton grayscale = new JButton ("grayscale");
		JButton rgbRed = new JButton ("rgb red filter");
		JButton sepia = new JButton ("sepia filter");
		conspiracyButton.setBackground(Color.WHITE);
		grayscale.setBackground(Color.WHITE);
		rgbRed.setBackground(Color.WHITE);
		sepia.setBackground(Color.WHITE);
		conspiracyButton.setForeground(Color.BLACK);
		grayscale.setForeground(Color.DARK_GRAY);
		rgbRed.setForeground(Color.RED);
		sepia.setForeground(Color.YELLOW);
		Font font = new Font ("PAPYRUS" , Font.BOLD + Font.ITALIC,  32);
		conspiracyButton.setFont(font);
		grayscale.setFont(font);
		rgbRed.setFont(font);
		sepia.setFont(font);
		conspiracyButton.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				rgbImg.conspiracyFilter();
			}
		});
		grayscale.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				rgbImg.convertToGrayscale();
			}
		});
		rgbRed.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				rgbImg.rgbRedEffect();
			}
		});
		sepia.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				rgbImg.convertToSepia();
			}
		}); 
 

		downButtonPanel.add(conspiracyButton);
		downButtonPanel.add(grayscale);
		downButtonPanel.add(rgbRed);
		downButtonPanel.add(sepia);
	}
	
		
		//image panel
		
		//grayscale image panel

	

	
	public static void main(String[] args) {
		try {
			String className = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(className);
		} catch (Exception e){}
		
		SwingUtilities.invokeLater(new Runnable (){
            @Override
            public void run() {
                new U4L02Code();
            }   
        });
	}
}
