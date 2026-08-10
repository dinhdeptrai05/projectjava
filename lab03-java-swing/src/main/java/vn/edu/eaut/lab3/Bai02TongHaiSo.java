package vn.edu.eaut.lab3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Bai02TongHaiSo {

    public static void main(String[] args) {

        // Tạo cửa sổ
        JFrame frame = new JFrame("Bài 2 - Tính tổng hai số");

        // Tạo các thành phần
        JLabel label1 = new JLabel("Số thứ nhất:");
        JLabel label2 = new JLabel("Số thứ hai:");

        JTextField textField1 = new JTextField();
        JTextField textField2 = new JTextField();

        JButton button = new JButton("Tính tổng");

        // Đặt vị trí
        label1.setBounds(30, 30, 100, 30);
        textField1.setBounds(130, 30, 150, 30);

        label2.setBounds(30, 70, 100, 30);
        textField2.setBounds(130, 70, 150, 30);

        button.setBounds(100, 120, 120, 30);

        // Xử lý khi bấm nút
        button.addActionListener(e -> {

            try {
                double so1 = Double.parseDouble(textField1.getText());
                double so2 = Double.parseDouble(textField2.getText());

                double tong = so1 + so2;

                JOptionPane.showMessageDialog(
                        frame,
                        "Tổng = " + tong
                );

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Vui lòng nhập số hợp lệ!"
                );
            }
        });

        // Thêm vào cửa sổ
        frame.add(label1);
        frame.add(textField1);
        frame.add(label2);
        frame.add(textField2);
        frame.add(button);

        // Cấu hình cửa sổ
        frame.setSize(330, 210);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}