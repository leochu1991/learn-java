package creational_patterns.prototype_pattern;

/**
 * 简历二,new深拷贝,WorkExperience需实现Cloneable接口
 */
public class TwoResume implements Resume, Cloneable {
    private String name;
    private int age;
    private WorkExperience workExperience;

    // public TwoResume(WorkExperience workExperience) throws CloneNotSupportedException {
    //     this.workExperience = (WorkExperience) workExperience.clone();
    // }

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
        this.workExperience = new WorkExperience(workExperience);
    }

    @Override
    public Resume cloneResume() throws CloneNotSupportedException {
        Resume resume = new TwoResume();
        resume.setName(this.name);
        resume.setAge(this.age);
        // 调用workExperience重写的clone()方法，不是Object的clone()方法(protected方法不同包can't access)
        WorkExperience clonedWorkExperience = (WorkExperience) this.workExperience.clone();
        resume.setWorkExperience(clonedWorkExperience.getWorkExperience());

        return resume;
    }
}
