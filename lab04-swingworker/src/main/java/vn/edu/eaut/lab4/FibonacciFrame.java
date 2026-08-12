package vn.edu.eaut.lab4;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class FibonacciFrame extends JFrame {

    private JTextField txtN;
    private JButton btnTim;
    private JLabel lblKetQua;
    private JProgressBar progressBar;

    // Map dùng để lưu kết quả Fibonacci đã tính
    private Map<Integer, BigInteger> memo = new HashMap<>();

    public FibonacciFrame() {

        setTitle("Tìm số Fibonacci");

        // Tạo thành phần
        JLabel lblN = new JLabel("Nhập N:");

        txtN = new JTextField();

        btnTim = new JButton("Tìm");

        lblKetQua = new JLabel("Kết quả:");

        progressBar = new JProgressBar(0, 100);

        // Đặt vị trí
        lblN.setBounds(40, 30, 60, 30);
        txtN.setBounds(100, 30, 180, 30);

        btnTim.setBounds(100, 75, 180, 35);

        progressBar.setBounds(40, 125, 240, 30);

        lblKetQua.setBounds(40, 170, 300, 30);

        progressBar.setStringPainted(true);

        // Thêm vào cửa sổ
        add(lblN);
        add(txtN);
        add(btnTim);
        add(progressBar);
        add(lblKetQua);

        // Khi nhấn nút Tìm
        btnTim.addActionListener(e -> {

            int n;

            try {
                n = Integer.parseInt(txtN.getText());
            } catch (NumberFormatException ex) {

                lblKetQua.setText("Vui lòng nhập số nguyên!");
                return;
            }

            if (n < 0) {

                lblKetQua.setText("N phải >= 0!");
                return;
            }

            btnTim.setEnabled(false);
            progressBar.setValue(0);

            SwingWorker<BigInteger, Integer> worker =
                    new SwingWorker<BigInteger, Integer>() {

                        @Override
                        protected BigInteger doInBackground() {

                            return fibonacci(n);
                        }

                        @Override
                        protected void process(java.util.List<Integer> list) {

                            int phanTram = list.get(list.size() - 1);

                            progressBar.setValue(phanTram);
                        }

                        @Override
                        protected void done() {

                            try {

                                BigInteger ketQua = get();

                                lblKetQua.setText("Fibonacci(" + n + ") = " + ketQua);

                                progressBar.setValue(100);

                            } catch (Exception ex) {

                                lblKetQua.setText("Có lỗi xảy ra!");
                            }

                            btnTim.setEnabled(true);
                        }
                    };

            worker.execute();
        });

        // Cấu hình cửa sổ
        setSize(380, 260);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // Hàm tính Fibonacci bằng Memoization
    private BigInteger fibonacci(int n) {

        // Fibonacci(0) = 0
        if (n == 0) {
            return BigInteger.ZERO;
        }

        // Fibonacci(1) = 1
        if (n == 1) {
            return BigInteger.ONE;
        }

        // Nếu đã tính rồi thì lấy kết quả trong Map
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        BigInteger ketQua =
                fibonacci(n - 1).add(fibonacci(n - 2));

        // Lưu kết quả
        memo.put(n, ketQua);

        return ketQua;
    }

    public static void main(String[] args) {

        new FibonacciFrame();
    }
}