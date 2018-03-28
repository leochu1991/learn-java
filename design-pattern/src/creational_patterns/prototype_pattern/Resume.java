package creational_patterns.prototype_pattern;

/**
 * 简历接口
 */
public interface Resume {
    void setName(String name);
    void setAge(Integer age);
    void setWorkExperience(String workExperience);
    Resume cloneResume() throws CloneNotSupportedException;
}
