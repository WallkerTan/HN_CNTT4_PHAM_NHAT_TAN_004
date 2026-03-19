package SRC.ra.management;

import java.util.Scanner;

import SRC.ra.busines.CourseBusines;
import SRC.ra.course.Course;
public class Management {

    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourseBusines busines = new CourseBusines();

        while (true) {
            try {
                System.out.println("--------------------MENU-------------------");
                System.out.println("1: hien thi toan bo khoa hoc");
                System.out.println("2: them moi khoa hoc");
                System.out.println("3: cap nhat thong tin khoa hoc");
                System.out.println("4: xoa khoa hoc theo id dang (vs: CS-1)");
                System.out.println("5: tim khoa hoc theo ten giang vien");
                System.out.println("6: loc khoa hoc theo trang thai");
                System.out.println("7: sap sep khoa hoc theo hoc phi giam dan");
                System.out.println("8: thoat");
                System.out.println("--------------------------------------------");
                System.out.printf("    -> ");


                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        busines.displayAll();
                        break;
                    case 2:
                        busines.addCourse(new Course());
                        break;
                    case 3:
                        try {
                            System.out.println("nhap ma  khoa hoc");
                            String id = sc.nextLine();
                            busines.updateCourse(id, sc);
                        } catch (Exception e) {
                            System.out.println(" loi case 3");
                        }
                        break;
                    case 4:
                        try {
                            System.out.println("nhap ma khoa hoc");
                            String id = sc.nextLine();
                            busines.deleteCourse(id);
                        } catch (Exception e) {
                            System.out.println(" loi case 3");
                        }
                        break;
                    case 5:
                        try {
                            System.out.println("nhap ten giang vien");
                            String id = sc.nextLine();
                            busines.searchByIns(id);
                        } catch (Exception e) {
                            System.out.println(" loi case 5");
                        }
                        break;
                    case 6:
                        busines.filterActiveCourse(true);
                        break;
                    case 7:
                        busines.sortByfeeDesc();
                        break;
                    case 8:
                        System.out.println("thoat chuong trinh");
                        return;
                    default:
                        break;
                }
            } catch (Exception e) {
                System.out.println("loi nhap");
            }
        }
    }
}
