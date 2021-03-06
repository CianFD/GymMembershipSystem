import java.util.ArrayList;

public class GymUtility {

    private ArrayList<Member> members;
    private ArrayList<Trainer> trainers;
    private ArrayList<Assessment> assessments;

    public ArrayList<Assessment> getAssessments() {
        return assessments;
    }

    public void addAssessment(Assessment assessment) {
        assessments.add(assessment);
    }

    public int numberOfAssessments() {
        if (assessments.size() != 0) {
            return assessments.size();
        }
        else {
            return 0;
        }
    }

    public static double calculateBMI(Member member, Assessment assessment) {
        double currentBMI;
        currentBMI = assessment.getWeight()/(member.getHeight() * member.getHeight());
        return currentBMI;
    }

    public static String determineBMICategory(double bmiValue) {
        if (bmiValue < 16) {
            return "SEVERELY UNDERWEIGHT";
        }
        if (bmiValue >= 16 && bmiValue < 18.5) {
            return "UNDERWEIGHT";
        }
        if (bmiValue >= 18.5 && bmiValue < 25.0) {
            return "NORMAL";
        }
        if (bmiValue >= 25.0 && bmiValue < 30.0) {
            return "OVERWEIGHT";
        }
        if (bmiValue >= 30.0 && bmiValue < 35.0) {
            return "MODERATELY OBESE";
        }
        if (bmiValue >= 35.0) {
            return "SEVERELY OBESE";
        }
        return null;
    }

    public static boolean isIdealBodyWeight(Member member, Assessment assessment) {
        float minHeight = 60;
        double idealWeight;
        double metersToInches = 39.3701;
        double kgPerExtraInch = 2.3;
        if (member.getGender().equals("M")) {
            idealWeight = 50;
        }
        else {
            idealWeight = 45.5;
        }
        if (metersToInches * (member.getHeight()) > minHeight) {
            idealWeight += ((metersToInches * member.getHeight()) - 60) * kgPerExtraInch;
        }
        if ((assessment.getWeight() <= (idealWeight+0.2)) && (assessment.getWeight() >= (idealWeight-0.2))) {
            return true;
        }
        return false;
    }
}
