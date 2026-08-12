package vn.edu.eaut.lab4;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

public class ProgressDemoFrame extends JFrame {

    private JButton btnStart;
    private JProgressBar progressBar;
    private JLabel lblStatus;

    public ProgressDemoFrame() {

        // Tiêu đề cửa sổ
        setTitle("Mô phỏng tải dữ liệu");

        // Tạo các thành phần
        btnStart = new JButton("Tải dữ liệu");
        progressBar = new JProgressBar(0, 100);
        lblStatus = new JLabel("Chưa tải dữ liệu");

        // Đặt vị trí
        btnStart.setBounds(80, 30, 180, 35);
        progressBar.setBounds(50, 80, 240, 30);
        lblStatus.setBounds(50, 125, 250, 30);

        // Hiển thị phần trăm trên ProgressBar
        progressBar.setStringPainted(true);

        // Thêm vào cửa sổ
        add(btnStart);
        add(progressBar);
        add(lblStatus);

        // Xử lý khi nhấn nút
        btnStart.addActionListener(e -> {

            // Không cho bấm lại khi đang tải
            btnStart.setEnabled(false);

            // Đưa ProgressBar về 0
            progressBar.setValue(0);

            // Tạo SwingWorker
            SwingWorker<Void, Integer> worker = new SwingWorker<Void, Integer>() {

                @Override
                protected Void doInBackground() throws Exception {

                    // Tăng từ 0 đến 100
                    for (int i = 0; i <= 100; i++) {

                        publish(i);

                        // Mỗi bước nghỉ 100ms
                        Thread.sleep(100);
                    }

                    return null;
                }

                @Override
                protected void process(java.util.List<Integer> list) {

                    int phanTram = list.get(list.size() - 1);

                    progressBar.setValue(phanTram);

                    lblStatus.setText("Đang tải: " + phanTram + "%");
                }

                @Override
                protected void done() {

                    lblStatus.setText("Tải dữ liệu hoàn tất!");

                    btnStart.setEnabled(true);
                }
            };

            // Bắt đầu chạy
            worker.execute();
        });

        // Cấu hình cửa sổ
        setSize(350, 220);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {

        new ProgressDemoFrame();
    }
}