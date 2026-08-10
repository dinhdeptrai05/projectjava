package vn.edu.eaut.lab3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Bai06LoginForm {

    public static void main(String[] args) {

        // Tạo cửa sổ
        JFrame frame = new JFrame("Bài 6 - Đăng nhập");

        // Tạo các thành phần
        JLabel labelUsername = new JLabel("Tên đăng nhập:");
        JLabel labelPassword = new JLabel("Mật khẩu:");

        JTextField textUsername = new JTextField();
        JPasswordField textPassword = new JPasswordField();

        JButton buttonLogin = new JButton("Đăng nhập");

        // Đặt vị trí
        labelUsername.setBounds(30, 30, 110, 30);
        textUsername.setBounds(140, 30, 180, 30);

        labelPassword.setBounds(30, 75, 110, 30);
        textPassword.setBounds(140, 75, 180, 30);

        buttonLogin.setBounds(130, 125, 120, 30);

        // Xử lý khi bấm nút Đăng nhập
        buttonLogin.addActionListener(e -> {

            String username = textUsername.getText();

            String password = new String(textPassword.getPassword());

            // Tài khoản mẫu
            String usernameDung = "admin";
            String passwordDung = "123456";

            // Kiểm tra tài khoản
            if (username.equals(usernameDung)
                    && password.equals(passwordDung)) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Đăng nhập thành công!"
                );

            } else {

                JOptionPane.showMessageDialog(
                        frame,
                        "Tên đăng nhập hoặc mật khẩu không đúng!"
                );
            }
        });

        // Thêm thành phần vào cửa sổ
        frame.add(labelUsername);
        frame.add(textUsername);

        frame.add(labelPassword);
        frame.add(textPassword);

        frame.add(buttonLogin);

        // Cấu hình cửa sổ
        frame.setSize(360, 220);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}