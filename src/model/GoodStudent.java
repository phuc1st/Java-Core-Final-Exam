package model;

public class GoodStudent extends Student {

    private double gpa;
    private String bestRewardName;

    public GoodStudent(String fullName, String gradeLevel, String doB, String sex,
                       String phoneNumber,
                       String universityName, double gpa, String bestRewardName) {
        super(fullName, gradeLevel, doB, sex, phoneNumber, universityName);
        this.gpa = gpa;
        this.bestRewardName = bestRewardName;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getBestRewardName() {
        return bestRewardName;
    }

    public void setBestRewardName(String bestRewardName) {
        this.bestRewardName = bestRewardName;
    }

    @Override
    public void ShowMyInfor() {
        System.out.printf(
                "Good student: %s | Grade: %s | DOB: %s | Sex: %s | Phone: %s | University: %s | GPA: %.2f | Best Reward: %s%n",
                getFullName(), getGradeLevel(), getDoB(), getSex(), getPhoneNumber(),
                getUniversityName(), gpa,
                bestRewardName
        );
    }

}
