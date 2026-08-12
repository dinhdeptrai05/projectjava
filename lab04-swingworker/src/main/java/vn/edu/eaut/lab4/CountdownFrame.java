package vn.edu.eaut.lab4;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

public class CountdownFrame extends JFrame {

    private JTextField txtSeconds;
    private JButton btnStart;
    private JLabel lblTime;

    public CountdownFrame() {

        // Tiêu đề cửa sổ
        setTitle("Đồng hồ đếm ngược");

        // Tạo các thành phần
        txtSeconds = new JTextField();
        btnStart = new JButton("Bắt đầu");
        lblTime = new JLabel("Thời gian còn lại: 0 giây");

        // Đặt vị trí và kích thước
        txtSeconds.setBounds(50, 30, 200, 30);
        btnStart.setBounds(50, 80, 200, 30);
        lblTime.setBounds(50, 130, 250, 30);

        // Thêm vào cửa sổ
        add(txtSeconds);
        add(btnStart);
        add(lblTime);

        // Xử lý khi nhấn nút Bắt đầu
        btnStart.addActionListener(e -> {

            int soGiay;

            try {
                soGiay = Integer.parseInt(txtSeconds.getText());
            } catch (NumberFormatException ex) {
                lblTime.setText("Vui lòng nhập số!");
                return;
            }

            if (soGiay <= 0) {
                lblTime.setText("Số giây phải lớn hơn 0!");
                return;
            }

            // Tạo SwingWorker để đếm ngược
            SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {

                @Override
                protected Void doInBackground() throws Exception {

                    for (int i = soGiay; i >= 0; i--) {

                        publish(i);

                        Thread.sleep(1000);
                    }

                    return null;
                }

                @Override
                protected void process(java.util.List<Integer> list) {

                    int thoiGian = list.get(list.size() - 1);

                    lblTime.setText("Thời gian còn lại: " + thoiGian + " giây");
                }

                @Override
                protected void done() {

                    lblTime.setText("Đã hết giờ!");
                }
            };

            worker.execute();
        });

        // Cấu hình cửa sổ
        setSize(350, 230);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}