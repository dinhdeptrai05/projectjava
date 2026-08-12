package vn.edu.eaut.lab4;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

public class PrimeSumFrame extends JFrame {

    private JTextField txtN;
    private JButton btnTinh;
    private JLabel lblKetQua;
    private JProgressBar progressBar;

    public PrimeSumFrame() {

        // Tiêu đề cửa sổ
        setTitle("Tính tổng số nguyên tố");

        // Tạo các thành phần
        JLabel lblN = new JLabel("Nhập N:");

        txtN = new JTextField();

        btnTinh = new JButton("Tính");

        lblKetQua = new JLabel("Kết quả: ");

        progressBar = new JProgressBar(0, 100);

        // Đặt vị trí
        lblN.setBounds(40, 30, 80, 30);
        txtN.setBounds(100, 30, 150, 30);

        btnTinh.setBounds(100, 75, 150, 35);

        progressBar.setBounds(40, 125, 250, 30);

        lblKetQua.setBounds(40, 170, 280, 30);

        // Hiển thị phần trăm
        progressBar.setStringPainted(true);

        // Thêm thành phần vào cửa sổ
        add(lblN);
        add(txtN);
        add(btnTinh);
        add(progressBar);
        add(lblKetQua);

        // Xử lý khi nhấn nút Tính
        btnTinh.addActionListener(e -> {

            int n;

            // Kiểm tra dữ liệu nhập
            try {
                n = Integer.parseInt(txtN.getText());
            } catch (NumberFormatException ex) {

                lblKetQua.setText("Vui lòng nhập số nguyên!");
                return;
            }

            // Kiểm tra N
            if (n <= 1) {

                lblKetQua.setText("N phải lớn hơn 1!");
                return;
            }

            // Không cho bấm nút khi đang tính
            btnTinh.setEnabled(false);

            progressBar.setValue(0);

            // Tạo SwingWorker
            SwingWorker<Integer, Integer> worker =
                    new SwingWorker<Integer, Integer>() {

                        @Override
                        protected Integer doInBackground() {

                            int tong = 0;

                            // Duyệt các số từ 2 đến N - 1
                            for (int i = 2; i < n; i++) {

                                // Nếu i là số nguyên tố
                                if (isPrime(i)) {

                                    tong = tong + i;
                                }

                                // Tính phần trăm tiến trình
                                int phanTram = (i * 100) / (n - 1);

                                publish(phanTram);
                            }

                            return tong;
                        }

                        @Override
                        protected void process(java.util.List<Integer> list) {

                            int phanTram = list.get(list.size() - 1);

                            progressBar.setValue(phanTram);
                        }

                        @Override
                        protected void done() {

                            try {

                                int tong = get();

                                lblKetQua.setText("Tổng các số nguyên tố = " + tong);

                            } catch (Exception ex) {

                                lblKetQua.setText("Có lỗi xảy ra!");
                            }

                            btnTinh.setEnabled(true);
                        }
                    };

            // Bắt đầu tính
            worker.execute();
        });

        // Cấu hình cửa sổ
        setSize(350, 260);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Hàm kiểm tra số nguyên tố
    private boolean isPrime(int n) {

        if (n < 2) {
            return false;
        }

        if (n == 2) {
            return true;
        }

        if (n % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(n); i += 2) {

            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        new PrimeSumFrame();
    }
}