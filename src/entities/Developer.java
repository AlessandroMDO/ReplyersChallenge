package entities;

import enums.Skills;

public class Developer extends Replyers {

    private String[] skills;
    private int nSkills;

    public Developer(Company company, double bonus, int nSkills, String[] skills) {
        super(company, bonus);
        this.nSkills = nSkills;
        this.skills = skills;
    }

    public Developer() {

    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    public int getnSkills() {
        return nSkills;
    }

    public void setnSkills(int nSkills) {
        this.nSkills = nSkills;
    }

    @Override
    public String toString() {
        return "_";
    }


}
