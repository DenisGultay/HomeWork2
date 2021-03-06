package hw2.entityes;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Користувач on 01.07.2017.
 */
public class Skills {

    public static final String TABLE_NAME = "skills";
    public static final String ID = "skills_id";
    public static final String NAME = "skills_name";

    private int skillsId;
    private String skillsName;
    private List<Integer> personsIDList;

    public Skills(String skillsName) {
        this.skillsName = skillsName;
    }

    public Skills() {
    }

    public int getSkillsId() {
        return skillsId;
    }

    public void setSkillsId(int skillsId) {
        this.skillsId = skillsId;
    }

    public String getSkillsName() {
        return skillsName;
    }

    public void setSkillsName(String skillsName) {
        this.skillsName = skillsName;
    }

    public List<Integer> getPersonsIDList() {
        return personsIDList;
    }

    public void setPersonsIDList(List<Integer> personsIDList) {
        this.personsIDList = personsIDList;
    }

    @Override
    public String toString() {
        return "Skills[id=" + this.skillsId + ", name=" + this.skillsName + "]";
    }


}
