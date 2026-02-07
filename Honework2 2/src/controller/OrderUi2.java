package controller;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.Login;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class OrderUi2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderUi2 frame = new OrderUi2(null);
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
	public OrderUi2(Login login) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//購買者名稱
		JLabel loginname = new JLabel("");
		loginname.setBounds(57, 29, 92, 15);
		contentPane.add(loginname);
		// 這裡直接使用傳進來的 login 物件
        if (login != null) {
            loginname.setText(login.getName()); 
        }
		
		
		
		//時間
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(266, 10, 158, 34);
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
