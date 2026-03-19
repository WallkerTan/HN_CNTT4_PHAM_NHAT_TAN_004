package SRC.ra.course;

import java.util.Scanner;

public class Course {
    private String courseID;
    private String courseName;
    private int credit;
    private double tuitionfee;
    private String instructor;
    private boolean status;

    private static int CreateID = 1;

    public Course() {
        Scanner sc = new Scanner(System.in);
        String namez;
        int creditz;
        double tuitionfeez;
        String instructorz;
        boolean temp = true;
        while (temp) {
            try {
                temp = false;
                System.out.println("nhap ten khoa hoc.");
                namez = sc.nextLine();
                this.courseName = namez;
            } catch (Exception e) {
                temp = true;
                System.out.println("nhap sai !!!");
            }

            try {
                temp = false;
                System.out.println("nhap so tin chi");
                creditz = sc.nextInt();
                sc.nextLine();
                this.credit = creditz;
            } catch (Exception e) {
                temp = true;
                System.out.println("nhap sai !!!");
            }

            try {
                temp = false;
                System.out.println("nhap so hoc phi");
                tuitionfeez = sc.nextDouble();
                sc.nextLine();
                this.tuitionfee = tuitionfeez;
            } catch (Exception e) {
                temp = true;
                System.out.println("nhap sai !!!");
            }

            try {
                temp = false;
                System.out.println("nhap ten giao vien");
                instructorz = sc.nextLine();
                this.instructor = instructorz;
            } catch (Exception e) {
                temp = true;
                System.out.println("nhap sai !!!");
            }
        }
        this.courseID = "CS-" + CreateID;
        this.status = true;
    }

    public Course(String name, int credit, double tuitionfee, String instructor) {
        try {
            this.courseName = name;
            this.credit = credit;
            this.instructor = instructor;
            this.tuitionfee = tuitionfee;
            this.courseID = "CS-" + CreateID;
            this.status = true;
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public String getName() {
        return this.courseName;
    }

    public String getID() {
        return this.courseID;
    }

    public int getCredit() {
        return this.credit;
    }

    public double getTuitionfee() {
        return this.tuitionfee;
    }

    public String getInstructor() {
        return this.instructor;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setName(String name) {
        this.courseName = name;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setTuitionfee(double tuitionfee) {
        this.tuitionfee = tuitionfee;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void displayData() {
        System.out.println("-> id: " + courseID + " name: " + courseName + " instructor: " + instructor + " credit: "
                + credit + " tuitionfee: " + tuitionfee);
    }

}
