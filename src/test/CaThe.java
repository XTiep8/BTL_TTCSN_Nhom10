package test;

public class CaThe {
	protected int[] congViec; // Hoán vị công việc 
	protected  int doThichNghi; // Giá trị fitness của cá thể 
    // Phương thức khởi tạo
    public CaThe(int n) {
        congViec = new int[n];
        doThichNghi = Integer.MAX_VALUE; // Giá trị mặc định lớn nhất
    }
}
