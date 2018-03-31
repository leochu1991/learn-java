package behavioral_patterns.memento_pattern;

import java.util.LinkedList;
import java.util.List;

/**
 * 管理者类，管理备忘录，并恢复
 */
public class CareTaker {
    // 保存memento，并恢复
    private List<Memento> mementoList = new LinkedList<>();

    // 添加memento
    public void addMemento(Memento memento) {
        mementoList.add(memento);
    }

    // 恢复memento
    public Memento getMemento(int index) {
        return mementoList.get(index);
    }
}
