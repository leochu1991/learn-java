package creational_patterns.prototype_pattern;

/**
 * 简历一,clone()浅拷贝,实现Cloneable接口
 */
public class OneResume implements Resume, Cloneable {
    private String name;
    private int age;
    private String workExperience;

    public OneResume(String name, int age, String workExperience) {
        this.name = name;
        this.age = age;
        this.workExperience = workExperience;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    @Override
    public Resume cloneResume() throws CloneNotSupportedException {
        return (Resume) this.clone();
    }
}
