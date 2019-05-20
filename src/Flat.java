import java.util.Comparator;
import java.lang.reflect.Array;
import java.util.*;
//
//паттерн наблюдатель для квратплаты
//наблюдатель это топ,в браузере есть видео для реализации,наблюдатель будет уведомлять в консоль об изменении сосояния квартплаты
//
//------------------------PATTERN----------------------------------------------------------------
//interface Observed{
//    void addObserver(Observer o);
//    void removeObserver(Observer o);
//    void notifyObservers();
//}
//
//interface Observer{
//    void handleEvant (int numFlat, int payment);
//}


//----------------------------------------------------------------------------------------------
public class Flat implements Observed {
    int squareOfFlat;
    int numberFlat;
    int payment;
    List<String> residents=new ArrayList<String>();
    int cacheOfFlat;
//    FlatComparator fcomp=new FlatComparator();
//    TreeSet<Flat> flats=new TreeSet<Flat>(fcomp);

    private List<Observer> observers=new ArrayList<>();

    public void addObserver(Observer o){
        observers.add(o);
    }

    public void removeObserver(Observer o){
        observers.remove(0);
    }

    public  void notifyObservers(){
        for(Observer o:observers){
            o.handleEvant(numberFlat, payment);
        }
    }
    public Flat(int squareOfFlat, int numberFlat, List <String> residents){
        this.squareOfFlat=squareOfFlat;
        this.numberFlat=numberFlat;
        this.residents=residents;
        payment=0;
        cacheOfFlat=100000;//пусть кеш будет для каждой квартиры

    }

    public int getNumberFlat() {
        return numberFlat;
    }
    public int getPayment(){return payment;}
    public int getCache(){return cacheOfFlat;}

//    public void Payment(){
//        System.out.println("Payment for flat №"+numberFlat+":");
//        payment=squareOfFlat*200;
//        System.out.println("Payment for square=" + payment + "\nLimit of payment= 10 000 UAH!");
//    }

    public void WriteResidentInFlat(String name,int num){
        if(numberFlat==num){
            residents.add(name);
        }
    }


    //для поиска жителей в конткретной квартире и их выписки
    public void FindTheResidentAndDel(String name){
        for (String r:residents) {
            if(r.equals(name)){
                residents.remove(r);
            }
        }
    }

    public String toString(){
        return  "\nNumber of flat " + numberFlat + "| Name of residents: " + residents.toString() +
                "\nSquare of flat: " + squareOfFlat + "| Number of flat: " + numberFlat +
                "\nPayment for flat: " + payment + "UAH " + "| Status of flat's cache: " + cacheOfFlat + "UAH";
    }
//    public int compare(Flat t, Flat c){
//        if(t.getNumberFlat()>c.getNumberFlat()){
//            return 1;
//        }
//        else if(t.getNumberFlat()<c.getNumberFlat()){
//            return -1;
//        }
//        else
//            return 0;
//    }


}


//public interface Comparator<Flat>{
//    int compare(Flat a,Flat b);
//}

//class FlatComparator implements Comparator<Flat>{
//    public int compare(Flat num1,Flat num2){
//        return num1.getNumberFlat()-num2.getNumberFlat();
//    }
//}
//class PaymentComparator implements Comparator<Flat>{
//    public int compare(Flat pay1, Flat pay2) {
//        return pay1.getPayment()-pay2.getPayment();
//    }
//}