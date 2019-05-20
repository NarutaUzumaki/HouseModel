//----------------------------------PATTERN-OBSERVER---------------------------------------
interface Observed{
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

interface Observer{
    void handleEvant (int numFlat, int payment);
}

public class ConsoleObserver implements Observer {
    public void handleEvant(int numFlat,int payment){
        System.out.println("WARNING!!! У квартиры №" + numFlat + " превышение лимита долгов на " + payment + "UAH!" );
    }
}
