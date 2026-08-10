package vn.edu.eaut.lab3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Bai05FibonacciSwing {

    public static void main(String[] args) {

        // Tạo cửa sổ
        JFrame frame = new JFrame("Bài 5 - Dãy Fibonacci");

        // Tạo các thành phần
        JLabel label = new JLabel("Nhập n:");

        JTextField textField = new JTextField();

        JButton button = new JButton("Hiển thị");

        JTextArea textArea = new JTextArea();

        // Không cho người dùng sửa kết quả
        textArea.setEditable(false);

        // Tạo thanh cuộn cho JTextArea
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Đặt vị trí
        label.setBounds(30, 30, 60, 30);
        textField.setBounds(90, 30, 120, 30);
        button.setBounds(220, 30, 100, 30);

        scrollPane.setBounds(30, 80, 290, 150);

        // Xử lý khi bấm nút
        button.addActionListener(e -> {

            try {

                int n = Integer.parseInt(textField.getText());

                // Kiểm tra n
                if (n <= 0) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Vui lòng nhập n lớn hơn 0!"
                    );

                } else {

                    long so1 = 0;
                    long so2 = 1;

                    String ketQua = "";

                    for (int i = 1; i <= n; i++) {

                        ketQua = ketQua + so1 + " ";

                        long so3 = so1 + so2;

                        so1 = so2;
                        so2 = so3;
                    }

                    // Hiển thị kết quả
                    textArea.setText(ketQua);
                }

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Vui lòng nhập số nguyên!"
                );
            }
        });

        // Thêm thành phần vào cửa sổ
        frame.add(label);
        frame.add(textField);
        frame.add(button);
        frame.add(scrollPane);

        // Cấu hình cửa sổ
        frame.setSize(370, 290);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}