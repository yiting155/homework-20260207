package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class LoginErrorUi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginErrorUi frame = new LoginErrorUi();
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
	public LoginErrorUi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 555);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(251, 242, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("帳號密碼錯誤");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel.setBounds(200, 202, 124, 40);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("請註冊會員");
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 20));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			AddLoginUi o=new AddLoginUi();
			o.setVisible(true);
			dispose();
			}
		});
		btnNewButton.setBounds(186, 258, 156, 40);
		contentPane.add(btnNewButton);

	}

}
