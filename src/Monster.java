import java.util.ArrayList;
import java.util.List;

class Monster {
    private final List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void notifyPlayer(String msg) {
        for (Observer o: observers){
            o.update(msg);
        }
    }
}

