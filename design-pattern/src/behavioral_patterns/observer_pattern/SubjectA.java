package behavioral_patterns.observer_pattern;

import java.util.LinkedList;
import java.util.List;

/**
 * 主题A
 */
public class SubjectA implements Subject {
    private List<Observer> observers = new LinkedList<Observer>();
    private String state;

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void setState(String state) {
        this.state = state;
        notifyObservers();
    }

    @Override
    public String getState() {
        return state;
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
