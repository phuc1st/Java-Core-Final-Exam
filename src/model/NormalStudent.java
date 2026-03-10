package model;

public class NormalStudent extends Student{

    private int englishScore;
    private double entryTestScore;

    public NormalStudent(String fullName, String gradeLevel, String doB, String sex,
                         String phoneNumber,
                         String universityName, int englishScore, double entryTestScore) {
        super(fullName, gradeLevel, doB, sex, phoneNumber, universityName);
        this.englishScore = englishScore;
        this.entryTestScore = entryTestScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }

    public double getEntryTestScore() {
        return entryTestScore;
    }

    public void setEntryTestScore(double entryTestScore) {
        this.entryTestScore = entryTestScore;
    }

    @Override
    public void ShowMyInfor() {
        System.out.printf(
                "Normal student: %s | Grade: %s | DOB: %s | Sex: %s | Phone: %s | University: %s | English Score: %d | Entry Test Score: %.2f%n",
                getFullName(), getGradeLevel(), getDoB(), getSex(), getPhoneNumber(), getUniversityName(),
                englishScore, entryTestScore
        );
    }
}
