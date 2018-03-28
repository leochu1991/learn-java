package behavioral_patterns.visitor_pattern;

import java.util.LinkedList;
import java.util.List;

/**
 * 对象结构类
 */
public class ObjectStructure {
    List<Person> people = new LinkedList<Person>();

    public void attach(Person person) {
        people.add(person);
    }

    public void detach(Person person) {
        people.remove(person);
    }

    // 遍历people得到不同人对于visitor的反应
    public void showReaction(Reaction visitor) {
        for (Person person : people) {
            person.accept(visitor);
        }
    }
}
