package vn.edu.eaut.lab3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Bai08QuanLySinhVien {

    public static void main(String[] args) {

        // Tạo cửa sổ
        JFrame frame = new JFrame("Bài 8 - Quản lý sinh viên");

        // Tạo các nhãn
        JLabel labelMaSV = new JLabel("Mã SV:");
        JLabel labelHoTen = new JLabel("Họ tên:");
        JLabel labelDiem = new JLabel("Điểm:");

        // Tạo các ô nhập
        JTextField textMaSV = new JTextField();
        JTextField textHoTen = new JTextField();
        JTextField textDiem = new JTextField();

        // Tạo các nút
        JButton buttonThem = new JButton("Thêm");
        JButton buttonSua = new JButton("Sửa");
        JButton buttonXoa = new JButton("Xóa");

        // Tạo bảng
        String[] tenCot = {
                "Mã SV",
                "Họ tên",
                "Điểm"
        };

        DefaultTableModel model = new DefaultTableModel(tenCot, 0);

        JTable table = new JTable(model);

        JScrollPane scrollPane = new JScrollPane(table);

        // Đặt vị trí các thành phần
        labelMaSV.setBounds(30, 30, 70, 30);
        textMaSV.setBounds(100, 30, 200, 30);

        labelHoTen.setBounds(30, 70, 70, 30);
        textHoTen.setBounds(100, 70, 200, 30);

        labelDiem.setBounds(30, 110, 70, 30);
        textDiem.setBounds(100, 110, 200, 30);

        buttonThem.setBounds(30, 155, 80, 30);
        buttonSua.setBounds(120, 155, 80, 30);
        buttonXoa.setBounds(210, 155, 80, 30);

        scrollPane.setBounds(30, 205, 400, 200);

        // =========================
        // NÚT THÊM
        // =========================

        buttonThem.addActionListener(e -> {

            try {

                String maSV = textMaSV.getText();
                String hoTen = textHoTen.getText();

                double diem = Double.parseDouble(textDiem.getText());

                // Kiểm tra mã sinh viên
                if (maSV.isEmpty()) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Vui lòng nhập mã sinh viên!"
                    );

                    return;
                }

                // Kiểm tra họ tên
                if (hoTen.isEmpty()) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Vui lòng nhập họ tên!"
                    );

                    return;
                }

                // Kiểm tra điểm
                if (diem < 0 || diem > 10) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Điểm phải từ 0 đến 10!"
                    );

                    return;
                }

                // Thêm sinh viên vào bảng
                model.addRow(new Object[]{
                        maSV,
                        hoTen,
                        diem
                });

                // Xóa ô nhập
                textMaSV.setText("");
                textHoTen.setText("");
                textDiem.setText("");

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Điểm phải là số!"
                );
            }
        });

        // =========================
        // BẤM VÀO BẢNG
        // =========================

        table.getSelectionModel().addListSelectionListener(e -> {

            int dong = table.getSelectedRow();

            if (dong >= 0) {

                textMaSV.setText(
                        model.getValueAt(dong, 0).toString()
                );

                textHoTen.setText(
                        model.getValueAt(dong, 1).toString()
                );

                textDiem.setText(
                        model.getValueAt(dong, 2).toString()
                );
            }
        });

        // =========================
        // NÚT SỬA
        // =========================

        buttonSua.addActionListener(e -> {

            int dong = table.getSelectedRow();

            if (dong == -1) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Vui lòng chọn sinh viên cần sửa!"
                );

                return;
            }

            try {

                String maSV = textMaSV.getText();
                String hoTen = textHoTen.getText();

                double diem = Double.parseDouble(
                        textDiem.getText()
                );

                if (maSV.isEmpty() || hoTen.isEmpty()) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Vui lòng nhập đầy đủ thông tin!"
                    );

                    return;
                }

                if (diem < 0 || diem > 10) {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Điểm phải từ 0 đến 10!"
                    );

                    return;
                }

                // Cập nhật dữ liệu
                model.setValueAt(maSV, dong, 0);
                model.setValueAt(hoTen, dong, 1);
                model.setValueAt(diem, dong, 2);

                JOptionPane.showMessageDialog(
                        frame,
                        "Sửa sinh viên thành công!"
                );

            } catch (NumberFormatException ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Điểm phải là số!"
                );
            }
        });

        // =========================
        // NÚT XÓA
        // =========================

        buttonXoa.addActionListener(e -> {

            int dong = table.getSelectedRow();

            if (dong == -1) {

                JOptionPane.showMessageDialog(
                        frame,
                        "Vui lòng chọn sinh viên cần xóa!"
                );

                return;
            }

            int luaChon = JOptionPane.showConfirmDialog(
                    frame,
                    "Bạn có chắc muốn xóa sinh viên này?",
                    "Xác nhận",
                    JOptionPane.YES_NO_OPTION
            );

            if (luaChon == JOptionPane.YES_OPTION) {

                model.removeRow(dong);

                // Xóa dữ liệu trong ô nhập
                textMaSV.setText("");
                textHoTen.setText("");
                textDiem.setText("");
            }
        });

        // Thêm thành phần vào cửa sổ
        frame.add(labelMaSV);
        frame.add(textMaSV);

        frame.add(labelHoTen);
        frame.add(textHoTen);

        frame.add(labelDiem);
        frame.add(textDiem);

        frame.add(buttonThem);
        frame.add(buttonSua);
        frame.add(buttonXoa);

        frame.add(scrollPane);

        // Cấu hình cửa sổ
        frame.setSize(480, 470);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}