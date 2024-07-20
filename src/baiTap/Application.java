package baiTap;

import java.util.Scanner;

/**
 * Bài tập tính tiền Grab.
 * Người dùng nhập số KM đi được và thời gian chờ
 * Y/c:
 * 	1. Tính tổng tiền đi được
 *  2. In hóa đơn chi tiết theo biểu mẫu
 */
public class Application {
	
	static final String[] SERVICES = {"GrabCar", "Grarb SUV", "GrabBlack"};
	
	static final int GRAB_CAR_SERVICE = 1;
	static final int GRAB_SUV_SERVICE = 2;
	static final int GRAB_BLACK_SERVICE = 3;
	
	static final int[] GRAB_CAR = {8000, 7500, 7000, 2000};
	static final int[] GRAB_SUV = {9000, 8500, 8000, 3000};
	static final int[] GRAB_BLACK = {10000, 9500, 9000, 3500};
		
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//B1: In ra menu
		int service = menu();

		//B2: Nhập số KM đi được và thời gian chờ
		double km; double time;
		do {
			System.out.print("Xin vui lòng nhập số KM đi được: ");
			km = scanner.nextDouble();
		} while (km < 0);		
		do {
			System.out.print("Xin vui lòng nhập thời gian chờ: ");
			time = scanner.nextDouble();
		} while (time < 0);
		
		//B3: Tính tổng tiền đi được
		long[] soTien = tongTien(service, km, time);
		
		//B4: In hóa đơn
		hoaDon(service, km, time, soTien);
	}
	
	public static int menu () {
		int n;
		
		do {
			System.out.println("Xin vui lòng chọn 1 loại dịch vụ:");
			System.out.println("1: GrabCar");
			System.out.println("2. Grab SUV");
			System.out.println("3. GrabBlack");
			
			Scanner scanner = new Scanner(System.in);
			n = scanner.nextInt();
			
			if (n != GRAB_CAR_SERVICE && n != GRAB_SUV_SERVICE && n != GRAB_BLACK_SERVICE) {
				System.out.println("Dịch vụ bạn chọn không tồn tại!");
			}
		} while (n != GRAB_CAR_SERVICE && n != GRAB_SUV_SERVICE && n != GRAB_BLACK_SERVICE);
		
		return n;
		
	}
	
	public static long[] tongTien (int service, double km, double time) {
		long tongTien = 0;
		int[] bangGia = new int[4];
		
		//B1: Dựa vào loại Grab để tìm bảng giá cước
		switch (service) {
			case GRAB_CAR_SERVICE:
				bangGia = GRAB_CAR;
				break;
			case GRAB_SUV_SERVICE:
				bangGia = GRAB_SUV;
				break;
			case GRAB_BLACK_SERVICE:
				bangGia = GRAB_BLACK;
				break;
			default:
				System.out.println("Dịch vụ này ko tồn tại!");
				break;
		}
		
		//B2: Tính tổng tiền
		//TH1: km <= 1
		//TH2: 1 < km < 19
		//TH3: km >= 19
		long tienCho = (int)(time/3) * bangGia[3]; //Tiền chờ trên 3 phút (mỗi 3 phút)
		if (km <= 1) {
			tongTien = (long) (bangGia[0] * km) + tienCho;
		} else if (km > 1 && km < 19) {
			long giaKMDau = bangGia[0];
			long giaKM2 = (long) ((km - 1) * bangGia[1]);
			tongTien = (giaKMDau + giaKM2) + tienCho;
		} else {
			long giaKMDau = bangGia[0];
			long giaKM2 = (long) ((18 - 1) * bangGia[1]);
			long giaKM3 = (long) ((km - 18) * bangGia[2]);
			tongTien = (giaKMDau + giaKM2 + giaKM3) + tienCho;
		}		
		long[] soTien = {tienCho, tongTien};
		
		return soTien;
	}
	
	public static void hoaDon (int service, double km, double time, long[] soTien) {
		System.out.println("----------------------------------------------------");
		System.out.println("Tổng Hóa đơn dịch vụ " + SERVICES[service - 1]);
		System.out.println("Số km đã đi là: " + km);
		System.out.println("Thời gian chờ là: " + time);
		System.out.println("Số tiền chờ là: " + soTien[0] + " VNĐ");
		System.out.println("Tổng tiền phải trả là: " + soTien[1] + " VNĐ");
	}
}
