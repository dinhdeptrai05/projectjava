package vn.edu.eaut.lab3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Bai03PhuongTrinhBacNhat {

    public static void main(String[] args) {

        // Tạo cửa sổ
        JFrame frame = new JFrame("Bài 3 - Phương trình bậc nhất");

        // Tạo các thành phần
        JLabel labelA = new JLabel("Nhập a:");
        JLabel labelB = new JLabel("Nhập b:");

        JTextField textFieldA = new JTextField();
        JTextField textFieldB = new JTextField();

        JButton button = new JButton("Giải");

        // Đặt vị trí
        labelA.setBounds(30, 30, 80, 30);
        textFieldA.setBounds(100, 30, 150, 30);

        labelB.setBounds(30, 70, 80, 30);
        textFieldB.setBounds(100, 70, 150, 30);

        button.setBounds(100, 120, 100, 30);

        // Xử lý khi bấm nút
        button.addActionListener(e -> {

            try {
                double a = Double.parseDouble(textFieldA.getText());
                double b = Double.parseDouble(textFieldB.getText());

                if (a == 0 && b == 0) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Phương trình có vô số nghiệm"
                    );

                } else if (a == 0 && b != 0) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Phương trình vô nghiệm"
                    );

                } else {

                    double x = -b / a;

                    JOptionPane.showMessageDialog(
                            frame,
                            "Nghiệm x = " + x
                    );
                }

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Vui lòng nhập số hợp lệ!"
                );
            }
        });

        // Thêm thành phần vào cửa sổ
        frame.add(labelA);
        frame.add(textFieldA);
        frame.add(labelB);
        frame.add(textFieldB);
        frame.add(button);

        // Cấu hình cửa sổ
        frame.setSize(300, 210);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}