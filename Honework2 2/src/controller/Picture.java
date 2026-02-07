package controller;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Picture extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Picture frame = new Picture();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Picture() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 557);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon(Picture.class.getResource("/images/未命名的作品 3.jpg")));
		lblNewLabel.setBounds(9,-42, 536,600);
		contentPane.add(lblNewLabel);
		/*
		ImageIcon icon = new ImageIcon(("/Users/ting/Downloads/未命名的作品.jpg")	   
		);

			// 取得 Image
			Image img = icon.getImage();

			// 縮放（寬, 高）
			Image scaledImg = img.getScaledInstance(300, 200, Image.SCALE_SMOOTH);

			// 放回 ImageIcon
			icon = new ImageIcon(scaledImg);

			// 顯示
			JLabel label = new JLabel(icon);
			getContentPane().add(label);*/

	}

}
