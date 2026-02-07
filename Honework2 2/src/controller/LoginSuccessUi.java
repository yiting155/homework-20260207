package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Login;
import util.Tool;

//import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;

public class LoginSuccessUi extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * 修改建構式：增加參數 (Login login)
     */
    public LoginSuccessUi(Login login) { 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 551, 557);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(251, 242, 204));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("恭喜您登入完成");
        lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 20));
        lblNewLabel.setBounds(177, 223, 163, 40); // 寬度稍微拉長一點
        contentPane.add(lblNewLabel);
        
        JButton btnNewButton = new JButton("進入花錢世界");
        btnNewButton.setFont(new Font("新細明體", Font.BOLD, 20));
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                OrderUi o = new OrderUi(login);
                o.setVisible(true);
                dispose();
            }
        });
        btnNewButton.setBounds(158, 297, 200, 40);
        contentPane.add(btnNewButton);
        
        // 顯示登入者的名字
        JLabel loginname = new JLabel("");
        loginname.setFont(new Font("新細明體", Font.BOLD, 20));
        loginname.setBounds(229, 116, 94, 40);
        contentPane.add(loginname);
        
        // 這裡直接使用傳進來的 login 物件
        if (login != null) {
            loginname.setText(login.getName()); 
        }
    }

    /**
     * 修改 main 方法以符合新的建構式（僅供測試用）
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // 測試時傳入 null 或 new Login()
                    LoginSuccessUi frame = new LoginSuccessUi(null); 
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
