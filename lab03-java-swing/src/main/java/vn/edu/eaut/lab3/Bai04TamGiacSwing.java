package vn.edu.eaut.lab3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Bai04TamGiacSwing {

    public static void main(String[] args) {

        // Tạo cửa sổ
        JFrame frame = new JFrame("Bài 4 - Kiểm tra tam giác");

        // Tạo các thành phần
        JLabel labelA = new JLabel("Cạnh a:");
        JLabel labelB = new JLabel("Cạnh b:");
        JLabel labelC = new JLabel("Cạnh c:");

        JTextField textFieldA = new JTextField();
        JTextField textFieldB = new JTextField();
        JTextField textFieldC = new JTextField();

        JButton button = new JButton("Kiểm tra");

        // Đặt vị trí
        labelA.setBounds(30, 30, 70, 30);
        textFieldA.setBounds(100, 30, 150, 30);

        labelB.setBounds(30, 70, 70, 30);
        textFieldB.setBounds(100, 70, 150, 30);

        labelC.setBounds(30, 110, 70, 30);
        textFieldC.setBounds(100, 110, 150, 30);

        button.setBounds(100, 155, 120, 30);

        // Xử lý khi bấm nút
        button.addActionListener(e -> {

            try {
                double a = Double.parseDouble(textFieldA.getText());
                double b = Double.parseDouble(textFieldB.getText());
                double c = Double.parseDouble(textFieldC.getText());

                // Kiểm tra cạnh phải lớn hơn 0
                if (a <= 0 || b <= 0 || c <= 0) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Các cạnh phải lớn hơn 0!"
                    );

                    // Kiểm tra điều kiện tạo thành tam giác
                } else if (a + b <= c || a + c <= b || b + c <= a) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Ba cạnh không tạo thành tam giác!"
                    );

                } else {

                    String loaiTamGiac;

                    // Tam giác đều
                    if (a == b && b == c) {

                        loaiTamGiac = "Tam giác đều";

                        // Tam giác vuông
                    } else if (a * a + b * b == c * c
                            || a * a + c * c == b * b
                            || b * b + c * c == a * a) {

                        loaiTamGiac = "Tam giác vuông";

                        // Tam giác cân
                    } else if (a == b || a == c || b == c) {

                        loaiTamGiac = "Tam giác cân";

                        // Tam giác thường
                    } else {

                        loaiTamGiac = "Tam giác thường";
                    }

                    JOptionPane.showMessageDialog(
                            frame,
                            "Đây là " + loaiTamGiac
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
        frame.add(labelC);
        frame.add(textFieldC);
        frame.add(button);

        // Cấu hình cửa sổ
        frame.setSize(300, 250);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}