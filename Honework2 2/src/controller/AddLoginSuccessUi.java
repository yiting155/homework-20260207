package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Login;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;

public class AddLoginSuccessUi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 * 直接開啟這個畫面, 用來測試這個畫面, 正常要從LoginUi使用才對
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddLoginSuccessUi frame = new AddLoginSuccessUi(null);
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
	public AddLoginSuccessUi(Login login) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 556);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(251, 242, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("恭喜註冊完成，請進入購買頁面");
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 20));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OrderUi o=new OrderUi(login);
				o.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(98, 258, 331, 49);
		contentPane.add(btnNewButton);

	}

}
