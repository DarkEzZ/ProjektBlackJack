import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Pocetak_igrice extends Karte_ikone{

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void pokret() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pocetak_igrice window = new Pocetak_igrice();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Pocetak_igrice() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 676, 538);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblpozadina = new JLabel("START");
		lblpozadina.setBackground(Color.BLACK);
		lblpozadina.setFont(new Font("Sylfaen", Font.BOLD, 25));
		lblpozadina.setBounds(0, 0, 660, 499);
		ImageIcon img =new ImageIcon(getClass().getClassLoader().getResource("uvodna.jpg"));
		img=Omjer_img.oblikovanje_imgIcon(lblpozadina.getWidth(), lblpozadina.getHeight(), Image.SCALE_SMOOTH, img);
		lblpozadina.setIcon(img);
		
		frame.getContentPane().add(lblpozadina);
		
	
		
		JButton btnNewButton_2 = new JButton("START");
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setFocusTraversalPolicyProvider(true);
		btnNewButton_2.setFocusTraversalKeysEnabled(false);
		btnNewButton_2.setFocusCycleRoot(true);
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Sylfaen", Font.BOLD, 30));
		btnNewButton_2.setBorderPainted(false);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Igrica_Display.pocetak();
			}
		});
	
		btnNewButton_2.setBounds(231, 364, 173, 91);
		
		frame.getContentPane().add(btnNewButton_2);
	}
}
