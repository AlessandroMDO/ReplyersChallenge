package entities;

public class Replyers {

    private Company company;
    private double bonus;

    public Replyers(Company company, double bonus) {
        this.company = company;
        this.bonus = bonus;
    }

    public Replyers() {

    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }


    public String toString() {
        return "#";
    }

}
