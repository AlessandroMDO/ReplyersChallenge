package entities;

import enums.Skills;

import java.util.*;
import java.util.stream.Collectors;

public class Developer extends Replyers {

    private String[] skills;
    private int nSkills;

    public Developer(Company company, int bonus, int nSkills, String[] skills) {
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


    public static int compareCommon(Developer dev1, Developer dev2) {
        int countCommon = 0;
        if (dev1.skills.length > 0 && dev2.skills.length > 0) {
            Set<String> firstSet = new HashSet<>();
            for (int i = 0; i < dev1.skills.length; i++) {
                firstSet.add(dev1.skills[i]);
            }
            /**
             * Checa se os elementos de dev2 estão contidos no Set criado
             * a partir das skills do dev1. Se sim, soma-se +1 no counter.
             */
            for (int i = 0; i < dev2.skills.length; i++) {
                if (firstSet.contains(dev2.skills[i])) {
                    countCommon++;
                }
            }
        }
        return countCommon;
    };

    public static int distinctSkills(Developer dev1, Developer dev2) {
        List<String> distinctList1 = Arrays.stream(dev1.skills).collect(Collectors.toList());
        List<String> distinctList2 = Arrays.stream(dev2.skills).collect(Collectors.toList());
        //int countDistinct = 0;
//        if (dev1.skills.length > 0 && dev2.skills.length > 0) {
//            Set<String> firstSet = new HashSet<>();
//            for (int i = 0; i < dev1.skills.length; i++) {
//                firstSet.add(dev1.skills[i]);
//            }
//            /**
//             * Checa se os elementos de dev2 não estão contidos no Set criado
//             * a partir das skills do dev1. Se sim, soma-se +1 no counter.
//             */
//            for (int i = 0; i < dev2.skills.length; i++) {
//                if (!firstSet.contains(dev2.skills[i])) {
//                    countDistinct++;
//                }
//            }
//        }

        distinctList2.removeAll(distinctList1);

        return distinctList1.size();
    };

    public static int workPotential(Developer dev1, Developer dev2){
        int common = compareCommon(dev1, dev2);
        int distinct = distinctSkills(dev1, dev2);
        return common * distinct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Developer)) return false;
        Developer developer = (Developer) o;
        return Arrays.equals(getSkills(), developer.getSkills());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(getSkills());
    }
}
