package test;
import java.util.*;

public class GeneticAlgorithm {
	 int[][] maTranChiPhi;
	    int kichThuocQuanThe;
	    int soTheHeToiDa;
	    double xacSuatLaiGhep;
	    double xacSuatDotBien;

	    public GeneticAlgorithm(int[][] maTranChiPhi, int kichThuocQuanThe, int soTheHeToiDa, double xacSuatLaiGhep, double xacSuatDotBien) {
	        this.maTranChiPhi = maTranChiPhi;
	        this.kichThuocQuanThe = kichThuocQuanThe;
	        this.soTheHeToiDa = soTheHeToiDa;
	        this.xacSuatLaiGhep = xacSuatLaiGhep;
	        this.xacSuatDotBien = xacSuatDotBien;
	    }

	    public PhanCong giaiQuyet() {
	        int n = maTranChiPhi.length;
	        QuanThe quanThe = new QuanThe(kichThuocQuanThe, n);

	        for (PhanCong caThe : quanThe.danhSachCaThe) {
	            caThe.doThichNghi = ChiPhi.tinhChiPhi(maTranChiPhi, caThe.congViec);
	        }

	        for (int theHe = 0; theHe < soTheHeToiDa; theHe++) {
	            List<PhanCong> quanTheMoi = new ArrayList<>();

	            while (quanTheMoi.size() < kichThuocQuanThe) {
	                PhanCong boMe1 = chonCaThe(quanThe);
	                PhanCong boMe2 = chonCaThe(quanThe);

	                PhanCong[] conCai;
	                if (Math.random() < xacSuatLaiGhep) {
	                    conCai = laiGhep(boMe1, boMe2);
	                } else {
	                    conCai = new PhanCong[]{new PhanCong(n)};
	                }

	                for (PhanCong con : conCai) {
	                    if (Math.random() < xacSuatDotBien) {
	                        dotBien(con);
	                    }
	                    con.doThichNghi = ChiPhi.tinhChiPhi(maTranChiPhi, con.congViec);
	                    quanTheMoi.add(con);
	                }
	            }
	            quanThe.danhSachCaThe = quanTheMoi;
	        }

	        return quanThe.timCaTheTotNhat(maTranChiPhi);
	    }

	    private PhanCong chonCaThe(QuanThe quanThe) {
	        int tongDoThichNghi = quanThe.danhSachCaThe.stream()
	                            .mapToInt(ct -> ct.doThichNghi == 0 ? Integer.MAX_VALUE : 1 / ct.doThichNghi)
	                            .sum();

	        if (tongDoThichNghi <= 0) { // Trường hợp không có giá trị hợp lệ
	            // Trả về một cá thể ngẫu nhiên nếu tất cả đều có fitness bằng 0
	            return quanThe.danhSachCaThe.get(new Random().nextInt(quanThe.danhSachCaThe.size()));
	        }

	        int mucChon = new Random().nextInt(tongDoThichNghi);
	        int tong = 0;

	        for (PhanCong ct : quanThe.danhSachCaThe) {
	            tong += ct.doThichNghi == 0 ? Integer.MAX_VALUE : 1 / ct.doThichNghi;
	            if (tong >= mucChon) {
	                return ct;
	            }
	        }

	        // Trường hợp không tìm được, trả về cá thể đầu tiên (bất thường)
	        return quanThe.danhSachCaThe.get(0);
	    }


	    private PhanCong[] laiGhep(PhanCong boMe1, PhanCong boMe2) {
	        int n = boMe1.congViec.length;
	        PhanCong con1 = new PhanCong(n);
	        PhanCong con2 = new PhanCong(n);

	        int diemCat1 = new Random().nextInt(n);
	        int diemCat2 = diemCat1 + new Random().nextInt(n - diemCat1);

	        System.arraycopy(boMe1.congViec, diemCat1, con1.congViec, diemCat1, diemCat2 - diemCat1);
	        System.arraycopy(boMe2.congViec, diemCat1, con2.congViec, diemCat1, diemCat2 - diemCat1);

	        QuanThe.suaChua(con1, boMe2, diemCat1, diemCat2);
	        QuanThe.suaChua(con2, boMe1, diemCat1, diemCat2);

	        return new PhanCong[]{con1, con2};
	    }

	    private void dotBien(PhanCong caThe) {
	        int viTri1 = new Random().nextInt(caThe.congViec.length);
	        int viTri2 = new Random().nextInt(caThe.congViec.length);
	        int temp = caThe.congViec[viTri1];
	        caThe.congViec[viTri1] = caThe.congViec[viTri2];
	        caThe.congViec[viTri2] = temp;
	    }
}
