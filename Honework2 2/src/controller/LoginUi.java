package controller;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import model.Login;
import service.Login.LoginServiceImpl;
import java.awt.Font;

public class LoginUi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JTextField password;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUi frame = new LoginUi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginUi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 555);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(251, 242, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("帳號");
		lblNewLabel.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel.setBounds(159, 117, 55, 40);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("密碼");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 20));
		lblNewLabel_1.setBounds(159, 183, 55, 40);
		contentPane.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setFont(new Font("宋体", Font.BOLD, 16));
		username.setBounds(232, 112, 130, 40);
		contentPane.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setFont(new Font("宋体", Font.BOLD, 16));
		password.setBounds(232, 183, 130, 40);
		contentPane.add(password);
		password.setColumns(10);
		
		LoginServiceImpl loginServiceImpl = new LoginServiceImpl();
		
		JButton loginBtn = new JButton("登入");
		loginBtn.setFont(new Font("宋体", Font.BOLD, 20));
		loginBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String userStr = username.getText();
				String passStr = password.getText();
				Login loginUser = loginServiceImpl.find_login_by_username_and_password(userStr, passStr);

				if(loginUser != null) {
					LoginSuccessUi loginSuccess = new LoginSuccessUi(loginUser);
				    loginSuccess.setVisible(true);
				    dispose();
				} else {
					LoginErrorUi loginerror = new LoginErrorUi();
					loginerror.setVisible(true);
					dispose();
				}	
			}
		});
		loginBtn.setBounds(129, 274, 120, 40);
		contentPane.add(loginBtn);
		
		JButton register = new JButton("註冊");
		register.setFont(new Font("宋体", Font.BOLD, 20));
		register.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddLoginUi o = new AddLoginUi();
				o.setVisible(true);
				dispose();
			}
		});
		register.setBounds(304, 274, 120, 40);
		contentPane.add(register);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("宋体", Font.BOLD, 14));
		lblNewLabel_2.setBounds(282, 10, 250, 60);
		contentPane.add(lblNewLabel_2);
		
		Timer timer = new Timer(1000, new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		        lblNewLabel_2.setText("目前時間：" + time);
		    }
		});
		timer.start();
	}
}