package test;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            int[][] maTranChiPhi = docFile("src/test/input4.txt"); // Đọc ma trận từ file
         GeneticAlgorithm thuatToan = new GeneticAlgorithm(maTranChiPhi, 10, 100, 0.8, 0.1);
         PhanCong ketQua = thuatToan.giaiQuyet();
//
            System.out.println("Phan cong toi uu: " + Arrays.toString(ketQua.congViec));
            System.out.println("Chi phi toi uu: " + ketQua.doThichNghi);
//            PhanCong ketQua1 = thuatToan1.giaiQuyet();
//            int chiPhiChinhXac = 12; // Giả sử chi phí tối ưu chính xác là 12
//            System.out.println("Chi phí tối ưu của thuật toán di truyền: " + ketQua1.doThichNghi);
//            System.out.println("Chi phí tối ưu chính xác: " + chiPhiChinhXac);
//
//            // Tính sai lệch giữa chi phí tối ưu của thuật toán di truyền và chính xác
//            double saiLech = Math.abs(ketQua1.doThichNghi - chiPhiChinhXac);
//            System.out.println("Sai lệch giữa chi phí tối ưu thuật toán di truyền và chính xác: " + saiLech);
        } catch (IOException e) {
            System.out.println("Loi khi doc file: " + e.getMessage());
        }
    }

    private static int[][] docFile(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        int n = Integer.parseInt(br.readLine().trim()); // Đọc số hàng/cột của ma trận
        int[][] maTranChiPhi = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().trim().split("\\s+"); // Tách các số trên một dòng
            for (int j = 0; j < n; j++) {
                maTranChiPhi[i][j] = Integer.parseInt(line[j]);
            }
        }

        br.close();
        return maTranChiPhi;
    }
}
