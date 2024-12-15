package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class PhanCong extends CaThe {
	 public PhanCong(int n) {
	        super(n); // Gọi constructor của lớp cha (CaThe)
	        sinhNgauNhien(n);
	    }

	    // Phương thức sinh ngẫu nhiên hoán vị công việc
	    public void sinhNgauNhien(int n) {
	        List<Integer> congViecList = new ArrayList<>();
	        for (int i = 0; i < n; i++) {
	            congViecList.add(i);
	        }
	        Collections.shuffle(congViecList);
	        for (int i = 0; i < n; i++) {
	            congViec[i] = congViecList.get(i);
	        }
	    }
}
