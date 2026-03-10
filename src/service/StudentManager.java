package service;

import util.DataValidator;
import CustomException.InvalidDOBException;
import CustomException.InvalidFullNameException;
import CustomException.InvalidPhoneNumberException;
import model.GoodStudent;
import model.NormalStudent;
import model.Student;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentManager {
    private final List<GoodStudent> listGood = new ArrayList<>();
    private final List<NormalStudent> listNormal = new ArrayList<>();

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/StudentDB", "root", "root");
    }

    public void readData(String fileName, String type) {
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    String[] data = line.split(";");
                    String fullName = data[0];
                    String doB = data[1];
                    String sex = data[2];
                    String phone = data[3];
                    String uni = data[4];
                    String grade = data[5];
                    DataValidator.validateFullName(fullName);
                    DataValidator.validateDOB(doB);
                    DataValidator.validatePhone(phone);
                    if (type.equals("Good")) {
                        GoodStudent gs = new GoodStudent(fullName, doB, sex, phone, uni, grade,
                                Double.parseDouble(data[6]), data[7]);
                        listGood.add(gs);
                        saveToDB(gs);
                    } else {
                        NormalStudent ns = new NormalStudent(fullName, doB, sex, phone, uni, grade,
                                Integer.parseInt(data[6]), Double.parseDouble(data[7]));
                        listNormal.add(ns);
                        saveToDB(ns);
                    }
                } catch (Exception e) {
                    if (e instanceof InvalidFullNameException || e instanceof InvalidDOBException || e instanceof InvalidPhoneNumberException) {
                        System.err.println("Dòng lỗi: " + e.getMessage());
                    } else {
                        System.err.println("Input files have unknow errors !!!");
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Không tìm thấy file " + fileName);
        } catch (IOException e) {
            System.err.println("Lỗi đọc file: " + fileName);
        }
    }

    private void saveToDB(Student s) {
        String sqlGood = "INSERT INTO good_student (full_name, dob, sex, phone_number, university_name, grade_level, gpa, best_reward_name) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        String sqlNormal = "INSERT INTO normal_student (full_name, dob, sex, phone_number, university_name, grade_level, english_score, entry_test_score) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = getConnection()) {
            if (s instanceof GoodStudent) {
                GoodStudent gs = (GoodStudent) s;
                try (PreparedStatement pstmt = connection.prepareStatement(sqlGood)) {
                    pstmt.setString(1, gs.getFullName());
                    pstmt.setString(2, gs.getDoB());
                    pstmt.setString(3, gs.getSex());
                    pstmt.setString(4, gs.getPhoneNumber());
                    pstmt.setString(5, gs.getUniversityName());
                    pstmt.setString(6, gs.getGradeLevel());
                    pstmt.setDouble(7, gs.getGpa());
                    pstmt.setString(8, gs.getBestRewardName());
                    pstmt.executeUpdate();
                }
            } else if (s instanceof NormalStudent) {
                NormalStudent ns = (NormalStudent) s;
                try (PreparedStatement pstmt = connection.prepareStatement(sqlNormal)) {
                    pstmt.setString(1, ns.getFullName());
                    pstmt.setString(2, ns.getDoB());
                    pstmt.setString(3, ns.getSex());
                    pstmt.setString(4, ns.getPhoneNumber());
                    pstmt.setString(5, ns.getUniversityName());
                    pstmt.setString(6, ns.getGradeLevel());
                    pstmt.setInt(7, ns.getEnglishScore());
                    pstmt.setDouble(8, ns.getEntryTestScore());
                    pstmt.executeUpdate();
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void recruit(int n) {
        List<Student> recruited = new ArrayList<>();
        listGood.sort(Comparator.comparingDouble(GoodStudent::getGpa).reversed().thenComparing(
                Student::getFullName));
        if (listGood.size() >= n) {
            recruited.addAll(listGood.subList(0, n));
        } else {
            listNormal.sort(
                    Comparator.comparingInt(NormalStudent::getEnglishScore).reversed().thenComparing(
                            NormalStudent::getFullName));
            recruited.addAll(listGood);
            int stillNeed = n - listGood.size();
            int toTake = Math.min(stillNeed, listGood.size());
            recruited.addAll(listNormal.subList(0, toTake));
        }

        System.out.println("--- DANH SÁCH TRÚNG TUYỂN (Số lượng: " + n + ") ---");
        recruited.forEach(Student::ShowMyInfor);
    }

    public void displayAllSorted() {
        List<Student> all = new ArrayList<>();
        all.addAll(listGood);
        all.addAll(listNormal);
        all.sort(Comparator.comparing(Student::getFullName).reversed().thenComparing(
                Student::getPhoneNumber));
    }
}
