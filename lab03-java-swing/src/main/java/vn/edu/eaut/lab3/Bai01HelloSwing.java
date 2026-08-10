package vn.edu.eaut.lab3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
public class Bai01HelloSwing {

    public static void main(String[] args) {

        // Tạo cửa sổ
        JFrame frame = new JFrame("Bài 1 - Chào người dùng");

        // Tạo nhãn
        JLabel label = new JLabel("Nhập tên:");

        // Ô nhập tên
        JTextField textField = new JTextField();

        // Nút bấm
        JButton button = new JButton("Chào");

        // Đặt vị trí và kích thước
        label.setBounds(30, 30, 80, 30);
        textField.setBounds(100, 30, 200, 30);
        button.setBounds(100, 80, 100, 30);

        // Khi bấm nút
        button.addActionListener(e -> {

            String ten = textField.getText();

            JOptionPane.showMessageDialog(
                    frame,
                    "Xin chào " + ten
            );
        });

        // Thêm các thành phần vào cửa sổ
        frame.add(label);
        frame.add(textField);
        frame.add(button);

        // Cấu hình cửa sổ
        frame.setSize(350, 170);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}