package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Login;
import model.Order;
import service.Login.LoginServiceImpl;
import service.lmpl.OrderServicelmpl;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
//import javax.swing.JTextArea;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.awt.Font;
import java.awt.Color;


public class OrderUi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField chiikawa;
	private JTextField disney;
	private JTextField horse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderUi frame = new OrderUi(null);
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
	public OrderUi(Login login) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 557);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(251, 242, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("歡迎選購");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 25));
		lblNewLabel.setBounds(210, 45, 112, 40);
		contentPane.add(lblNewLabel);
		
		JLabel name1 = new JLabel("訂購人");
		name1.setFont(new Font("宋体", Font.BOLD, 20));
		name1.setBounds(120, 115, 80, 40);
		contentPane.add(name1);
		
		
		JLabel chiikawaname = new JLabel("Chiikawa");
		chiikawaname.setFont(new Font("宋体", Font.BOLD, 20));
		chiikawaname.setBounds(119, 165, 100, 40);
		contentPane.add(chiikawaname);
		
		JLabel disneyname = new JLabel("Disney");
		disneyname.setFont(new Font("宋体", Font.BOLD, 20));
		disneyname.setBounds(120, 218, 100, 50);
		contentPane.add(disneyname);
		
		JLabel housename = new JLabel("Horse");
		housename.setFont(new Font("宋体", Font.BOLD, 20));
		housename.setBounds(119, 272, 100, 50);
		contentPane.add(housename);
		
		JLabel name = new JLabel("");
		name.setFont(new Font("宋体", Font.BOLD, 20));
		name.setBounds(264, 113, 100, 50);
		contentPane.add(name);
		name.setText(login.getName());
		
		chiikawa = new JTextField();
		chiikawa.setBounds(251, 168, 130, 40);
		contentPane.add(chiikawa);
		chiikawa.setColumns(10);
		
		disney = new JTextField();
		disney.setBounds(251, 221, 130, 40);
		contentPane.add(disney);
		disney.setColumns(10);
		
		horse = new JTextField();
		horse.setBounds(251, 282, 130, 40);
		contentPane.add(horse);
		horse.setColumns(10);
		
		JButton btnNewButton = new JButton("確認");
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 20));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 1.截取資料庫
				 2.new
				 3.連接資料庫
				 3.儲存txt
				 4.切換至OrderdetailUi
				 */
				String Name=name.getText();
				int Chiikawa=Integer.parseInt(chiikawa.getText());
				int Disney=Integer.parseInt(disney.getText());
				int Horse=Integer.parseInt(horse.getText());
				Order o=new Order(Name, Chiikawa,Disney,Horse);
				
				OrderServicelmpl orderServiceImpl = new OrderServicelmpl();
				orderServiceImpl.addOrder(o);
				
				try {
					FileOutputStream fos=new FileOutputStream("Order.txt");
					ObjectOutputStream odj=new ObjectOutputStream(fos);
					odj.writeObject(o);
					
					odj.writeUTF("訂購人："+o.getName()+
					"\n吉伊卡哇："+o.getChiikawa()+
					"\n迪士尼："+o.getDisney()+
					"\n馬："+o.getHorse()+
					"\n總金額："+o.getChiikawa()+o.getChiikawa()+o.getHorse());
					
					int sum = (o.getChiikawa()+o.getChiikawa()+o.getHorse()) * 100;
					
					String summary = "訂購人："+o.getName()+
							"\n吉伊卡哇："+o.getChiikawa()+
							"\n迪士尼："+o.getDisney()+
							"\n馬："+o.getHorse()+
							"\n總金額："+sum;
					
					Files.write(Paths.get("data.txt"), summary.getBytes(StandardCharsets.UTF_8));

//					odj.writeUTF("訂購人："+o.getName()+
//							"\n吉伊卡哇："+o.getChiikawa()+
//							"\n迪士尼："+o.getDisney()+
//							"\n馬："+o.getHorse()+
//							"\n總金額："+o.getChiikawa()+o.getChiikawa()+o.getHorse());
				
					OrderdetailUi ot=new OrderdetailUi();
					ot.setVisible(true);
					dispose();
				}catch(Exception ex) {
					ex.printStackTrace();
					/*OrderErrorUi ot=new OrderErrorUi();
					ot.setVisible(true);
					dispose();*/
				}

				
			}
		});
		btnNewButton.setBounds(286, 363, 150, 40);
		contentPane.add(btnNewButton);
		
		JButton restart = new JButton("重新下訂單");
		restart.setFont(new Font("新細明體", Font.BOLD, 20));
		restart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				restart.addActionListener(e1 -> {
				    chiikawa.setText("");
				    disney.setText("");
				    horse.setText("");
				});
			}
		});
		restart.setBounds(95, 363, 150, 40);
		contentPane.add(restart);
		
		
		
		
	}
}
