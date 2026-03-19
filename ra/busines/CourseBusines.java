package SRC.ra.busines;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import SRC.ra.course.Course;

public class CourseBusines {
    List<Course> courses = new ArrayList<>();

    public void displayAll() {
        try {
            if (courses.isEmpty()) {
                System.out.println("danh sach rong");
                return;
            }
            courses.forEach(Course::displayData);
        } catch (Exception e) {
            System.out.println("loi in danh sach displayAll");
        }
    }

    public void addCourse(Course c) {
        try {
            boolean exit = courses.stream().anyMatch(u -> u.getID().equals(c.getID()));
            if (exit) {
                System.out.println("ma khoa hoc da ton tai");
                return;
            }
            courses.add(c);
        } catch (Exception e) {
            System.out.println("loi them nguoi dung moi addCourse");
        }
    }

    public Optional<Course> findByid(String id) {
        return courses.stream().filter(e -> e.getID().equals(id)).findFirst();
    }

    public void updateCourse(String id, Scanner sc) {
        try {
            Optional<Course> temp = findByid(id);

            if (temp.isEmpty()) {
                System.out.println("ma nguoi dung khong hop le");
                return;
            }

            Course c = temp.get();

            System.out.println("1: sua ten khoa hoc");
            System.out.println("2: sua so tin chi");
            System.out.println("3: sua hoc phi");
            System.out.println("4: sua ten giang vien");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("-> ten moi: ");
                    c.setName(sc.nextLine());
                    break;
                case 2:
                    System.out.println("nhap so tin chi");
                    int credit = Integer.parseInt(sc.nextLine());
                    if (credit < 0) {
                        System.out.println("so tin chi ko dc am");
                        return;
                    }
                    c.setCredit(credit);
                    break;
                case 3:
                    System.out.println("nhap so hoc phi");
                    double tuitionfee = Double.parseDouble(sc.nextLine());
                    if (tuitionfee < 0) {
                        System.out.println("hoc phi ko dc am");
                        return;
                    }
                    c.setTuitionfee(tuitionfee);
                    break;
                case 4:
                    System.out.println("nhap ten giang vien");
                    c.setName(sc.nextLine());
                    break;
                default:
                    System.out.println("loi nhap!!");
                    break;
            }
            System.out.println("cap nhat thanh cong");

        } catch (Exception e) {
            System.out.println("loi cap nhat");
        }
    }

    public void deleteCourse(String id) {
        try {
            Optional<Course> temp = findByid(id);

            if (temp.isEmpty()) {
                System.out.println(" khoa hoc khong ton tai");
                return;
            }
            courses.remove(temp.get());
            System.out.println("xoa thanh cong");
        } catch (Exception e) {
            System.out.println("loi xoa nguoi dung");
        }
    }

    public void searchByIns(String instructor) {
        try {
            List<Course> c = courses.stream()
                    .filter(e -> e.getName().toLowerCase().contains(instructor.toLowerCase()))
                    .toList();

            if (c.isEmpty()) {
                System.out.println("khong tim thay khoa hoc nao");
                return;
            }

            c.forEach(Course::displayData);
            System.out.println("tong so-> " + c.size());

        } catch (Exception e) {
            System.out.println("loi tim kiem ten giang vien");
        }
    }
    public void sortByfeeDesc() {
        try {
            courses.stream().sorted((c1, c2) -> Double.compare(c1.getTuitionfee(), c2.getTuitionfee()))
                    .forEach(Course::displayData);
        } catch (Exception e) {
            System.out.println("loi sap sep");
        }
    }

    public void filterActiveCourse(boolean sttus){
        try {
            List<Course> l = courses.stream().filter(c -> c.getStatus() == sttus).toList();
            if (l.isEmpty()) {
                System.out.println("khong tim thay khoa hoc nao dang mo");
                return;
            }
            l.forEach(Course::displayData);
        } catch (Exception e) {
            System.out.println("loi tim khoa hoc theo status");
        }

    }

}
