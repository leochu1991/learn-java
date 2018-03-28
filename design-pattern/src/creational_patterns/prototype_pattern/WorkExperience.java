package creational_patterns.prototype_pattern;

/**
 * 工作经历
 */
public class WorkExperience implements Cloneable {
    private String workExperience;

    public WorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    @Override // 也可用public
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }
}
