package hw2.Entityes;

/**
 * Created by Користувач on 01.07.2017.
 */
public class Skills {

    private int skillsId;
    private String skillsName;

    public Skills() {
    }

    public Skills(int skillsId, String skillsName) {
        this.skillsId = skillsId;
        this.skillsName = skillsName;
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

    @Override
    public String toString() {
        return "Skills{" +
                "skillsId=" + skillsId +
                ", skillsName='" + skillsName + '\'' +
                '}';
    }
}
