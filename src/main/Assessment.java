public class Assessment {
    public double weight;
    public double chest;
    public double thigh;
    public String upperArm;

    public Assessment(double weight, double chest, double thigh, String upperArm)
    {
        setWeight(weight);
        setChest(chest);
        setThigh(thigh);
        setUpperArm(upperArm);

    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getChest() {
        return chest;
    }

    public void setChest(double chest) {
        this.chest = chest;
    }

    public double getThigh() {
        return thigh;
    }

    public void setThigh(double thigh) {
        this.thigh = thigh;
    }

    public String getUpperArm() {
        return upperArm;
    }

    public void setUpperArm (String upperArm) {
        this.upperArm = upperArm;
    }
}
