package entities;

public class Replyers {

    private Company company;
    private int bonus;

    public Replyers(Company company, int bonus) {
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

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }


    public String toString() {
        return "#";
    }

    public static int bonusPotential(Replyers rep1, Replyers rep2) {
        int bp = 0;
        if (rep1.getCompany().equals(rep2.getCompany())) {
            bp = rep1.bonus * rep2.bonus;
        }
        return bp;
    }

    public static int totalPotential(Replyers rep1, Replyers rep2) {

        int tp = 0;

        if (rep1 instanceof ProjectManager || rep2 instanceof ProjectManager){
            tp = bonusPotential(rep1, rep2);
        }
        else{
            Developer _rep1 = (Developer) rep1;
            Developer _rep2 = (Developer) rep2;
            tp = bonusPotential(rep1,rep2) + Developer.workPotential(_rep1,_rep2);
        }
        return tp;
    }


}
