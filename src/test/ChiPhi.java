package test;

public class ChiPhi {
	    public static int tinhChiPhi(int[][] maTranChiPhi, int[] congViec) {
	        int tongChiPhi = 0;
	        for (int i = 0; i < congViec.length; i++) {
	            tongChiPhi += maTranChiPhi[i][congViec[i]];
	        }
	        return tongChiPhi;
	    }
}
