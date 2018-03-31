package structural_patterns.proxy_pattern.reflectivedemo;

/**
 * 学生类，测试Java反射
 */
public class Student {
    // id
    private Integer id;
    // 姓名
    private String username;
    // 年龄
    private Integer age;

    public Student(Integer id, String username, Integer age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

    protected Student(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    private Student(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                '}';
    }

    // 自定义方法，展示学生信息
    public void show(String username) {
        System.out.println(String.format("调用了参数username = %s的公有的show方法，返回值为void。。。", username));
    }

    protected String show() {
        System.out.println("调用了无参的保护show方法，返回类型String");
        return "string";
    }

    private boolean isAgeOver18(int age) {
        return age > 18;
    }
}
