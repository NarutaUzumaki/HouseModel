import java.sql.SQLOutput;
import java.util.*;

//
//отчет должен содержать:comporator сортирует, не важно какие поля, главное сортировка.
//если будет сортировка то она должна сортировать от большего к меньшему значению определенного поля
//выбирается поле и производится сортировка по нему
//
public class House {
    private int floor;
    private int flats;
    private int flatsOnFloor;
    private int squareOfFloor;
    List<Flat> FlatsList=new ArrayList<Flat>();
    //-----------------------------------------------
    private FlatComparator fcomp=new FlatComparator();
    private TreeSet<Flat> flats_=new TreeSet<Flat>(fcomp);
    private PaymentComparator pcomp=new PaymentComparator();
    private TreeSet<Flat> payments_=new TreeSet<Flat>(pcomp);
    private CacheComparator ccomp=new CacheComparator();
    private TreeSet<Flat> caches_=new TreeSet<Flat>(ccomp);

    public House(int floor, int flats,int flatsOnFloor){
        this.flats=flats;
        this.floor=floor;
        this.flatsOnFloor=flatsOnFloor;
    }

    //Создание квартиры
    public void CreateFlat(){
        squareOfFloor=0;

        for(int i=0;i<flatsOnFloor;i++){
            System.out.println("Select a square of " + (i+1) + " flat on floor:");
            Scanner in=new Scanner(System.in);
            //int square=in.nextInt();
            int square=35;
            int num = 0;

            if(FlatsList.isEmpty()) {
                System.out.println("Select a number of flat:");
                //num = in.nextInt();
                num = 1;
            } else {
                for (Flat t : FlatsList) {
                    boolean checker=true;
                    while (checker) {
                        System.out.println("Select a number of flat:");
                        //num = in.nextInt();

                        if (num==t.getNumberFlat()) {
                            System.out.println(num + "This flat already exist!!!");
                            checker = true;
                        } else {
                            checker = false;
                        }
                    }
                }
            }
            System.out.println("Select a quantity of residents in this "+(i+1)+"flat:");
            //int quant=in.nextInt();
            int quant = 1;
            List <String> names=new ArrayList<String>();
            for (int n=0;n<quant;n++){
                System.out.println("Write name №"+(n+1)+":");
                Scanner inName=new Scanner(System.in);
                //String nameIn=inName.nextLine();
                String nameIn="Kek";
                names.add(nameIn);
            }
        squareOfFloor+=square;
            System.out.println("NOMER" + num);
        FlatsList.add(new Flat(square,num,names));
        flats_.add(new Flat(square,num,names));
        }
        System.out.print("Total square of 1 floor:" + squareOfFloor);
    }

    public void Add(){
        System.out.println("Write name of new resident:");
        String name="Gector";
        System.out.println("Select a flat for resident");
        int num=12;
        for (Flat t:FlatsList) {
            t.WriteResidentInFlat(name,num);
        }
    }


    //Выписать жителя из квартиры
    public void Remove() {
        System.out.println("For removing resident write his name.");
        String revName="Vova";
        for (Flat t:FlatsList) {
            t.FindTheResidentAndDel(revName);
        }
    }

    //Начисление налога для всех существующих квартир
//    public void AddPaymentForAll(){
//        for (Flat t:FlatsList) {
//            t.payment+=t.squareOfFlat*200;
//        }
//    }

    //Начисление налога
    public int AddPaymentForFlat(int num_){
        for (Flat t:FlatsList) {
            if(t.numberFlat==num_){
                t.payment+=t.squareOfFlat*200;
                System.out.println("Payment-" +t.payment + " for flat №" +t.numberFlat+ " is added.");
                System.out.println("Total payment for flat №"+ t.numberFlat + " = " + t.payment);
            if(t.payment>7000) {
                t.notifyObservers();
            }
            }
            payments_.add(t);
            return t.payment;
        }
        return 0;
    }

    //Оплата налога
    public void PaymentKill(){

        System.out.println("Select a flat, enter the flat's number:");
        int selectFlat=12;
        for (Flat t:FlatsList) {
            if(t.numberFlat==selectFlat & t.cacheOfFlat!=0){
                System.out.println("Do you agree with tax payment " + t.payment + "for your flat?");
                t.cacheOfFlat-=t.payment;
                t.payment=0;
                System.out.println("Operation successful. Your tax is paymented (status:" + t.payment + ")");
                caches_.add(t);
            }
        }
    }

    //Наблюдатель для квартиры,оповещает об квартплате в консоль
    public void AddObsForFlats(){
        for (Flat t:FlatsList) {
            t.addObserver(new ConsoleObserver());
        }
    }


    public void ShowHouse(){
        System.out.println(FlatsList);
    }

    public void ShowMeDoc(){
        for (Flat t:FlatsList) {
            System.out.println("№" + t.getNumberFlat() + "Payments:" + t.getPayment());
        }
    }
    //----------------------------SORTED---------------------------------------------------------
    public void CompShowFlat(){
        System.out.println("Sort by number of flat:");
        for (Flat t:flats_) {
            System.out.println("№" + t.getNumberFlat() + " Payments:" + t.getPayment() + " Cache:" + t.getCache());
        }
    }
    public void CompShowPayment(){
        System.out.println("Sort by payment of flat:");
        for (Flat t:payments_) {
            System.out.println("№" + t.getNumberFlat() + " Payments:" + t.getPayment() + " Cache:" + t.getCache());
        }
    }
    public void CompShowCache(){
        System.out.println("Sort by cache of flat:");
        for (Flat t:caches_) {
            System.out.println("№" + t.getNumberFlat() + " Payments:" + t.getPayment() + " Cache:" + t.getCache());
        }
    }
}
