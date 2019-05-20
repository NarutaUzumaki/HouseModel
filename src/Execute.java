import java.util.InputMismatchException;
import java.util.Scanner;

//        Створіть наступну модель-
//        Є багатоквартирний дім, модель повинна дозволяти прописувати/виписувати
//        мешканців, нараховувати квартплатню в залежності від площі квартир,
//        давати можливість сплачувати мешканцям квартплату,
//        формувати звіт з платежів та заборгованності.
//        Якщо виникає заборгованність та її термін перевищує місяць з моменту виникнення,
//        повинен нараховуватись штраф в розмірі 10 відсотків від суми її сумиі.
//        Квартплатня нараховується першого числа кожного місяця.
//        Звіти повинні сортуватися та фільтруватися за разними критер

public class Execute {
    public static void main(String[] args) {
        int floors;
        int flats;
        int fOnf;
        while(true) {
            try {
                System.out.println("Create new House.\nSelect a floors, flats, quantity of flats on floor.");
                Scanner in = new Scanner(System.in);
                System.out.print("Floors:");
                floors = in.nextInt();
                System.out.print("Flats:");
                flats = in.nextInt();
                System.out.print("Flats on floor:");
                fOnf = in.nextInt();
                break;
            } catch (InputMismatchException ex) {
                System.out.println("Enter the right information!");
                continue;
            }
        }

        House Model=new House(floors,flats,fOnf);

        Model.CreateFlat();

        Model.ShowHouse();

        //Model.AddPaymentForAll();
        //Model.AddPaymentForFlat();

        Model.ShowHouse();

        //Model.Remove();

        //Model.ShowHouse();
        Model.AddObsForFlats();

        //Model.AddPaymentForFlat();

        Model.PaymentKill();

        Model.ShowHouse();

        Model.Add();

        Model.ShowHouse();
        System.out.println("-------------------");
        Model.CompShowFlat();
        Model.CompShowPayment();
        Model.CompShowCache();
    }
}
