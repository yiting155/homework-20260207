package controller;
import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.Order;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import java.awt.Color;
import java.awt.Font;
public class OrderdetailUi extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderdetailUi frame = new OrderdetailUi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public OrderdetailUi() throws IOException, ClassNotFoundException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 557);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(251, 242, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("本次明細");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel.setBounds(71, 36, 101, 40);
		contentPane.add(lblNewLabel);
		
		JTextArea show = new JTextArea();
		show.setFont(new Font("Monospaced", Font.BOLD, 20));
		show.setBounds(71, 91, 386, 232);
		contentPane.add(show);
		
		FileInputStream fis=new FileInputStream("Order.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		
		Object o1=ois.readObject();
		Order o2=(Order)o1;
		int sum = (o2.getChiikawa()+o2.getDisney()+o2.getHorse()) * 100;
		
		show.setText("訂購人:"+o2.getName()+
				"\nChiikawa:"+o2.getChiikawa()+
				"\nDisney:"+o2.getDisney()+
				"\nHorse:"+o2.getHorse()+
				"\nSum:"+sum);
		
		JButton btnNewButton = new JButton("離開");
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 20));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(340, 452, 117, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("列印");
		btnNewButton_1.setFont(new Font("新細明體", Font.BOLD, 20));
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnNewButton_1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						try {
							show.print();
						} catch (PrinterException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});

			}
		});
		btnNewButton_1.setBounds(71, 452, 117, 40);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("修改訂單");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EditUI editUI=new EditUI();
				editUI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setFont(new Font("新細明體", Font.BOLD, 20));
		btnNewButton_2.setBounds(365, 30, 117, 40);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Chiikawa");
		btnNewButton_3.setFont(new Font("新細明體", Font.BOLD, 20));
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Picture p = new Picture();
                p.setVisible(true);
                dispose();
			}
		});
		btnNewButton_3.setBounds(71, 400, 117, 40);
		contentPane.add(btnNewButton_3);
		
		JButton chillkawa = new JButton("Disney");
		chillkawa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Picture2 p = new Picture2();
                p.setVisible(true);
                dispose();			}
		});
		chillkawa.setFont(new Font("Dialog", Font.BOLD, 20));
		chillkawa.setBounds(200, 400, 117, 40);
		contentPane.add(chillkawa);
		
		JButton horse = new JButton("Horse");
		horse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Picture3 p = new Picture3();
                p.setVisible(true);
                dispose();
			}
		});
		horse.setFont(new Font("Dialog", Font.BOLD, 20));
		horse.setBounds(340, 400, 117, 40);
		contentPane.add(horse);
		
//		String text = ois.readUTF();
//		show.setText(text);
	}
}
