package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Order;
import service.lmpl.OrderServicelmpl;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField updateId;
	private JTextField name;
	private JTextField updatec;
	private JTextField updated;
	private JTextField deleteId;
	private JTextField updateh;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditUI frame = new EditUI();
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
	public EditUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 534);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(251, 242, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(254, 240, 160));
		panel.setBounds(27, 25, 660, 208);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 43, 622, 93);
		panel.add(scrollPane);
		
		JTextArea output = new JTextArea();
		scrollPane.setViewportView(output);
		
		
		
		
		JLabel lblNewLabel_2 = new JLabel("筆數:");
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_2.setBounds(10, 162, 46, 23);
		panel.add(lblNewLabel_2);
		
		JLabel orderCount = new JLabel("");
		orderCount.setFont(new Font("新細明體", Font.BOLD, 16));
		orderCount.setBounds(63, 162, 76, 19);
		panel.add(orderCount);
		
		JLabel lblNewLabel_4 = new JLabel("總營業額:");
		lblNewLabel_4.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_4.setBounds(200, 162, 76, 19);
		panel.add(lblNewLabel_4);
		
		JLabel orderSum = new JLabel("");
		orderSum.setFont(new Font("新細明體", Font.BOLD, 16));
		orderSum.setBounds(297, 162, 76, 23);
		panel.add(orderSum);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(254, 240, 160));
		panel_1.setBounds(27, 243, 660, 101);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 20, 34, 20);
		panel_1.add(lblNewLabel);
		
		JLabel lblAut = new JLabel("名稱");
		lblAut.setFont(new Font("新細明體", Font.BOLD, 16));
		lblAut.setBounds(106, 20, 34, 20);
		panel_1.add(lblAut);
		
		JLabel lblu = new JLabel("Chiikawa");
		lblu.setFont(new Font("新細明體", Font.BOLD, 16));
		lblu.setBounds(22, 64, 87, 20);
		panel_1.add(lblu);
		
		JLabel lblNewLabel_3 = new JLabel("Disney");
		lblNewLabel_3.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_3.setBounds(214, 64, 75, 20);
		panel_1.add(lblNewLabel_3);
		
		updateId = new JTextField();
		updateId.setBounds(35, 20, 61, 21);
		panel_1.add(updateId);
		updateId.setColumns(10);
		
		name = new JTextField();
		name.setBounds(150, 20, 68, 21);
		panel_1.add(name);
		name.setColumns(10);
		
		updatec = new JTextField();
		updatec.setBounds(106, 64, 96, 21);
		panel_1.add(updatec);
		updatec.setColumns(10);
		
		updated = new JTextField();
		updated.setBounds(279, 64, 96, 21);
		panel_1.add(updated);
		updated.setColumns(10);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(254, 240, 160));
		panel_2.setBounds(27, 354, 660, 77);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ID");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 23, 30, 23);
		panel_2.add(lblNewLabel_1);
		
		deleteId = new JTextField();
		deleteId.setBounds(73, 24, 96, 21);
		panel_2.add(deleteId);
		deleteId.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Horse");
		lblNewLabel_3_1.setFont(new Font("新細明體", Font.BOLD, 16));
		lblNewLabel_3_1.setBounds(392, 62, 55, 20);
		panel_1.add(lblNewLabel_3_1);
		
		updateh = new JTextField();
		updateh.setColumns(10);
		updateh.setBounds(445, 62, 96, 21);
		panel_1.add(updateh);
		
		
		
		
		
		
		
		/*****************event*****************/
		JButton btnNewButton = new JButton("查詢");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OrderServicelmpl orderService = new OrderServicelmpl();
				List<Order> o = orderService.allOrder();
				//List<Order> o=OrderServicelmpl.allOrder();
				String show="";
				int count=0;
				int sum=0;
				for(Order x:o)
				{
					int amounts=(x.getChiikawa()+x.getDisney()+x.getHorse())*100;
					show+=("\nID:"+x.getId()+
							"\t訂購人:"+x.getName()+
							"\tChiikawa:"+x.getChiikawa()+
							"\tDisney:"+x.getDisney()+
							"\tHorse:"+x.getHorse()+
							"\tSum:"+(x.getChiikawa()+x.getDisney()+x.getHorse())*100);
			
					
					count++;
					sum=sum+amounts;
				}
				
				output.setText(show);
				orderCount.setText(String.valueOf(count)+"筆");
				orderSum.setText(sum+"元");
				
			}
		});
		btnNewButton.setBounds(10, 10, 87, 23);
		panel.add(btnNewButton);

		
		
		
		JButton btnNewButton_1 = new JButton("修改");		
		btnNewButton_1.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.擷取ID,Name,C,D,h-->getText()-->String , Id轉型-->int
				 * 2.id-->調閱-->資料庫-->Order(名,C,D,H)
				 * 3.判斷--輸入-->Name,C,D,H-->沒有輸入-->不做set修改
				 * 4.執行update方法
				 */
				OrderServicelmpl OrderServicelmpl = new OrderServicelmpl();
				int ID=Integer.parseInt(updateId.getText());
				String Name=name.getText();
				String Chiikawa=updatec.getText();
				String Disney=updated.getText();
				String Horse=updateh.getText();
				
				Order order=OrderServicelmpl.findById(ID);
	
				if(!Name.equals("")) {
					order.setName(Name);
				}
				if(!Chiikawa.equals("")){
					int chiikawa=Integer.parseInt(Chiikawa);
					order.setChiikawa(chiikawa);
				}
				if(!Disney.equals("")){
					int disney=Integer.parseInt(Disney);
					order.setDisney(disney);
				}
				if(!Horse.equals("")){
					int horse=Integer.parseInt(Horse);
					order.setHorse(horse);
				}

				OrderServicelmpl.updateOrder(order.getName(), order.getChiikawa(), order.getDisney(), order.getHorse(),ID);
			}
		}
		);
		btnNewButton_1.setBounds(563, 61, 87, 23);
		panel_1.add(btnNewButton_1);
		
		
		
		
		
		
		JButton btnNewButton_2 = new JButton("刪除");
		btnNewButton_2.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent e) {
				OrderServicelmpl orderService = new OrderServicelmpl();
				int ID = Integer.parseInt(deleteId.getText());
				orderService.deleteById(ID);
//				int ID=Integer.parseInt(deleteId.getText());
//				OrderServicelmpl.deleteOrderById(ID);
			}
		}
		);
		btnNewButton_2.setBounds(223, 23, 87, 23);
		panel_2.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("回登入頁面");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginUi loginu=new LoginUi();
				loginu.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_3.setBounds(27, 463, 111, 23);
		contentPane.add(btnNewButton_3);
	}
}