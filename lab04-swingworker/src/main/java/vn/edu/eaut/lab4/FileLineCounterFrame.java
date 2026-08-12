package vn.edu.eaut.lab4;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileLineCounterFrame extends JFrame {

    private JButton btnChonFile;
    private JButton btnDemDong;

    private JLabel lblFile;
    private JLabel lblKetQua;

    private JProgressBar progressBar;

    private File fileDaChon;

    public FileLineCounterFrame() {

        setTitle("Đếm số dòng trong file");

        // Tạo các thành phần
        btnChonFile = new JButton("Chọn file");

        btnDemDong = new JButton("Đếm dòng");

        lblFile = new JLabel("Chưa chọn file");

        lblKetQua = new JLabel("Số dòng: ");

        progressBar = new JProgressBar(0, 100);

        // Đặt vị trí
        btnChonFile.setBounds(40, 30, 130, 35);

        btnDemDong.setBounds(190, 30, 130, 35);

        lblFile.setBounds(40, 80, 350, 30);

        progressBar.setBounds(40, 120, 280, 30);

        lblKetQua.setBounds(40, 165, 350, 30);

        progressBar.setStringPainted(true);

        // Ban đầu chưa có file nên không cho đếm
        btnDemDong.setEnabled(false);

        // Thêm vào cửa sổ
        add(btnChonFile);
        add(btnDemDong);
        add(lblFile);
        add(progressBar);
        add(lblKetQua);

        // Xử lý nút Chọn file
        btnChonFile.addActionListener(e -> {

            JFileChooser fileChooser = new JFileChooser();

            int ketQua = fileChooser.showOpenDialog(this);

            if (ketQua == JFileChooser.APPROVE_OPTION) {

                fileDaChon = fileChooser.getSelectedFile();

                lblFile.setText("File: " + fileDaChon.getName());

                btnDemDong.setEnabled(true);

                lblKetQua.setText("Số dòng: ");

                progressBar.setValue(0);
            }
        });

        // Xử lý nút Đếm dòng
        btnDemDong.addActionListener(e -> {

            if (fileDaChon == null) {
                return;
            }

            btnDemDong.setEnabled(false);

            btnChonFile.setEnabled(false);

            progressBar.setValue(0);

            SwingWorker<Integer, Integer> worker =
                    new SwingWorker<Integer, Integer>() {

                        @Override
                        protected Integer doInBackground() {

                            int soDong = 0;

                            try {

                                BufferedReader reader =
                                        new BufferedReader(
                                                new FileReader(fileDaChon)
                                        );

                                String dong;

                                while ((dong = reader.readLine()) != null) {

                                    soDong++;
                                }

                                reader.close();

                            } catch (Exception ex) {

                                return -1;
                            }

                            return soDong;
                        }

                        @Override
                        protected void process(
                                java.util.List<Integer> list) {

                            int phanTram =
                                    list.get(list.size() - 1);

                            progressBar.setValue(phanTram);
                        }

                        @Override
                        protected void done() {

                            try {

                                int soDong = get();

                                if (soDong == -1) {

                                    lblKetQua.setText(
                                            "Không thể đọc file!"
                                    );

                                } else {

                                    lblKetQua.setText(
                                            "Số dòng: " + soDong
                                    );

                                    progressBar.setValue(100);
                                }

                            } catch (Exception ex) {

                                lblKetQua.setText(
                                        "Có lỗi xảy ra!"
                                );
                            }

                            btnDemDong.setEnabled(true);

                            btnChonFile.setEnabled(true);
                        }
                    };

            worker.execute();
        });

        // Cấu hình cửa sổ
        setSize(420, 250);

        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);

        setVisible(true);
    }

    public static void main(String[] args) {

        new FileLineCounterFrame();
    }
}