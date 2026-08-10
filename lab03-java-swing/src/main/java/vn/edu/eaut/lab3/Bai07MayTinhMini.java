package vn.edu.eaut.lab3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Bai07MayTinhMini {

    public static void main(String[] args) {

        // Tạo cửa sổ
        JFrame frame = new JFrame("Bài 7 - Máy tính mini");

        // Tạo nhãn
        JLabel labelSo1 = new JLabel("Số thứ nhất:");
        JLabel labelSo2 = new JLabel("Số thứ hai:");

        // Tạo ô nhập
        JTextField textSo1 = new JTextField();
        JTextField textSo2 = new JTextField();

        // Tạo các nút phép tính
        JButton buttonCong = new JButton("+");
        JButton buttonTru = new JButton("-");
        JButton buttonNhan = new JButton("*");
        JButton buttonChia = new JButton("/");

        // Nút Clear
        JButton buttonClear = new JButton("Clear");

        // Vùng lịch sử
        JTextArea textHistory = new JTextArea();

        // Không cho sửa lịch sử
        textHistory.setEditable(false);

        // Thanh cuộn
        JScrollPane scrollPane = new JScrollPane(textHistory);

        // Đặt vị trí
        labelSo1.setBounds(30, 30, 100, 30);
        textSo1.setBounds(130, 30, 180, 30);

        labelSo2.setBounds(30, 70, 100, 30);
        textSo2.setBounds(130, 70, 180, 30);

        buttonCong.setBounds(30, 120, 60, 30);
        buttonTru.setBounds(100, 120, 60, 30);
        buttonNhan.setBounds(170, 120, 60, 30);
        buttonChia.setBounds(240, 120, 60, 30);

        buttonClear.setBounds(120, 165, 100, 30);

        scrollPane.setBounds(30, 215, 270, 120);

        // Nút cộng
        buttonCong.addActionListener(e -> {

            try {

                double so1 = Double.parseDouble(textSo1.getText());
                double so2 = Double.parseDouble(textSo2.getText());

                double ketQua = so1 + so2;

                String lichSu = so1 + " + " + so2 + " = " + ketQua;

                textHistory.append(lichSu + "\n");

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Vui lòng nhập số hợp lệ!"
                );
            }
        });

        // Nút trừ
        buttonTru.addActionListener(e -> {

            try {

                double so1 = Double.parseDouble(textSo1.getText());
                double so2 = Double.parseDouble(textSo2.getText());

                double ketQua = so1 - so2;

                String lichSu = so1 + " - " + so2 + " = " + ketQua;

                textHistory.append(lichSu + "\n");

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Vui lòng nhập số hợp lệ!"
                );
            }
        });

        // Nút nhân
        buttonNhan.addActionListener(e -> {

            try {

                double so1 = Double.parseDouble(textSo1.getText());
                double so2 = Double.parseDouble(textSo2.getText());

                double ketQua = so1 * so2;

                String lichSu = so1 + " * " + so2 + " = " + ketQua;

                textHistory.append(lichSu + "\n");

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Vui lòng nhập số hợp lệ!"
                );
            }
        });

        // Nút chia
        buttonChia.addActionListener(e -> {

            try {

                double so1 = Double.parseDouble(textSo1.getText());
                double so2 = Double.parseDouble(textSo2.getText());

                // Kiểm tra chia cho 0
                if (so2 == 0) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Không thể chia cho 0!"
                    );

                } else {

                    double ketQua = so1 / so2;

                    String lichSu = so1 + " / " + so2 + " = " + ketQua;

                    textHistory.append(lichSu + "\n");
                }

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Vui lòng nhập số hợp lệ!"
                );
            }
        });

        // Nút Clear
        buttonClear.addActionListener(e -> {

            textSo1.setText("");
            textSo2.setText("");
            textHistory.setText("");
        });

        // Thêm thành phần vào cửa sổ
        frame.add(labelSo1);
        frame.add(textSo1);

        frame.add(labelSo2);
        frame.add(textSo2);

        frame.add(buttonCong);
        frame.add(buttonTru);
        frame.add(buttonNhan);
        frame.add(buttonChia);

        frame.add(buttonClear);
        frame.add(scrollPane);

        // Cấu hình cửa sổ
        frame.setSize(350, 400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}