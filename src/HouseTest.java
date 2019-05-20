import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HouseTest {
    private House testing = new House(9,50,3);
    private List<String> names = new ArrayList<String>();
    //names.add("Lol");

    void TestPay() {
        names.add("Lol");

    //@org.junit.jupiter.api.Test
        testing.FlatsList.add(new Flat(35,1,names));
        System.out.println(testing.FlatsList);

        for(Flat temp : testing.FlatsList) {
            testing.AddPaymentForFlat(temp.numberFlat);
            assertEquals(testing.AddPaymentForFlat(temp.numberFlat),temp.payment);
        }

        //assertEquals(7000,);
        System.out.println(testing.FlatsList);

    }
}