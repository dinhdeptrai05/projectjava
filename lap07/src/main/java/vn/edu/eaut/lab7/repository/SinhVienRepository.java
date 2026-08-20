package vn.edu.eaut.lab7.repository;

import vn.edu.eaut.lab7.model.SinhVien;
import java.util.*;
import java.util.stream.Collectors;

public class SinhVienRepository {
    private static final List<SinhVien> list = new ArrayList<>();
    private static int autoIncrementId = 1;

    // Khởi tạo dữ liệu mẫu ban đầu trong bộ nhớ
    static {
        list.add(new SinhVien(autoIncrementId++, "SV001", "Nguyễn Văn A", "ana@gmail.com", "CNTT01"));
        list.add(new SinhVien(autoIncrementId++, "SV002", "Trần Thị B", "bnb@gmail.com", "CNTT02"));
        list.add(new SinhVien(autoIncrementId++, "SV003", "Lê Văn C", "cnc@gmail.com", "CNTT01"));
    }

    // Lấy toàn bộ danh sách sinh viên
    public List<SinhVien> findAll() {
        return list;
    }

    // Tìm kiếm sinh viên theo ID
    public SinhVien findById(int id) {
        return list.stream()
                .filter(sv -> sv.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Thêm mới hoặc cập nhật sinh viên
    public void save(SinhVien sv) {
        if (sv.getId() == 0) {
            sv.setId(autoIncrementId++);
            list.add(sv);
        } else {
            update(sv);
        }
    }

    // Cập nhật thông tin sinh viên
    public void update(SinhVien sv) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == sv.getId()) {
                list.set(i, sv);
                return;
            }
        }
    }

    // Xóa sinh viên theo ID
    public void deleteById(int id) {
        list.removeIf(sv -> sv.getId() == id);
    }

    // Tìm kiếm sinh viên theo từ khóa (mã, tên, lớp)
    public List<SinhVien> search(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return findAll();
        }
        String kw = keyword.toLowerCase();
        return list.stream()
                .filter(sv -> sv.getHoTen().toLowerCase().contains(kw) ||
                        sv.getMaSinhVien().toLowerCase().contains(kw) ||
                        sv.getLop().toLowerCase().contains(kw))
                .collect(Collectors.toList());
    }
}