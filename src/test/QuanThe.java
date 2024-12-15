package test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QuanThe {
	List<PhanCong> danhSachCaThe; // Danh sách các cá thể (PhanCong)

    public QuanThe(int kichThuoc, int n) {
        danhSachCaThe = new ArrayList<>();
        for (int i = 0; i < kichThuoc; i++) {
            danhSachCaThe.add(new PhanCong(n)); // Khởi tạo PhanCong
        }
    }

    public PhanCong timCaTheTotNhat(int[][] maTranChiPhi) {
        return danhSachCaThe.stream()
                .min(Comparator.comparingInt(ct -> ChiPhi.tinhChiPhi(maTranChiPhi, ct.congViec)))
                .orElse(null);
    }

    public static void suaChua(PhanCong con, PhanCong boMe, int diemCat1, int diemCat2) {
        Set<Integer> phanTu = new HashSet<>();
        for (int i = diemCat1; i < diemCat2; i++) {
            phanTu.add(con.congViec[i]);
        }

        int viTri = 0;
        for (int i = 0; i < boMe.congViec.length; i++) {
            if (!phanTu.contains(boMe.congViec[i])) {
                while (viTri >= diemCat1 && viTri < diemCat2) {
                    viTri++;
                }
                con.congViec[viTri++] = boMe.congViec[i];
            }
        }
    }
}
