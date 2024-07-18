package baiTap;

import java.util.Scanner;

/**
 * Câu 1: Tìm số lớn nhất trong 3 số a, b, c người dùng nhập vào
 */
public class Application {
	
	static final int GRAB_CAR_SERVICE = 1;
	static final int GRAB_SUV_SERVICE = 1;
	static final int GRAB_BLACK_SERVICE = 1;
	static final int[] GRAB_CAR = {8000, 7500, 7000, 2000};
	static final int[] GRAB_SUV = {9000, 8500, 8000, 3000};
	static final int[] GRAB_BLACK = {10000, 9500, 9000, 3500};
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//B1: In ra menu
		int service = menu();

		//Nhập số KM đi được và thời gian chờ
		double km; double time;
		do {
			System.out.print("Xin vui lòng nhập số KM đi được: ");
			km = scanner.nextDouble();
		} while (km < 0);		
		do {
			System.out.print("Xin vui lòng nhập thời gian chờ: ");
			time = scanner.nextDouble();
		} while (time < 0);
		
		//1. Tính tổng tiền đi được
		long tongTien = tongTien(service, km, time);
		
		//2. In hóa đơn
		hoaDon(service, km, time, tongTien);
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
	
	public static long tongTien (int service, double km, double time) {
		return 0;
		
	}
	
	public static void hoaDon (int service, double km, double time, long tongTien) {
		
	}
}
