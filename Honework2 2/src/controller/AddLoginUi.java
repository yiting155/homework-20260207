package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Login;
import service.Login.LoginServiceImpl;
//import service.lmpl.OrderServicelmpl;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;

public class AddLoginUi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 * 直接開啟這個畫面, 用來測試這個畫面, 正常要從LoginUi使用才對
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddLoginUi frame = new AddLoginUi();
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
	public AddLoginUi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 557);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(251, 242, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("註冊會員");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 25));
		lblNewLabel.setBounds(208, 39, 150, 60);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("姓名");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_1.setBounds(171, 127, 65, 40);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("帳號");
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_2.setBounds(171, 190, 65, 40);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("密碼");
		lblNewLabel_3.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_3.setBounds(171, 253, 65, 40);
		contentPane.add(lblNewLabel_3);

		name = new JTextField();
		name.setBounds(246, 127, 130, 40);
		contentPane.add(name);
		name.setColumns(10);

		username = new JTextField();
		username.setColumns(10);
		username.setBounds(246, 190, 130, 40);
		contentPane.add(username);

		password = new JTextField();
		password.setColumns(10);
		password.setBounds(246, 253, 130, 40);
		contentPane.add(password);

		// 重新輸入
		JButton btnNewButton_1 = new JButton("重新輸入");
		btnNewButton_1.setFont(new Font("新細明體", Font.BOLD, 20));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnNewButton_1.addActionListener(e1 -> {
					name.setText("");
					username.setText("");
					password.setText("");
				});
			}
		});

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		// 確認送出
		btnNewButton_1.setBounds(293, 350, 140, 40);
		contentPane.add(btnNewButton_1);
		JButton btnNewButton = new JButton("確認送出");
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 20));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginServiceImpl loginServiceImpl = new LoginServiceImpl();
				String Username = username.getText();
				boolean un = loginServiceImpl.find_username(Username);

				if (un) {
					AddLoginErrorUi adderror = new AddLoginErrorUi();
					adderror.setVisible(true);
					dispose();
				} else {
					String Name = name.getText();
					String Password = password.getText();
					Login login = new Login(Name, Username, Password);

					loginServiceImpl.AddLogin(login);
					AddLoginSuccessUi addsuccess = new AddLoginSuccessUi(login);
					addsuccess.setVisible(true);
					dispose();
				}
			}
		});
		btnNewButton.setBounds(97, 350, 140, 40);
		contentPane.add(btnNewButton);
	}
}
