import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FlatTest {
    private List<String> names = new ArrayList<String>();
    private Flat temp= new Flat(45,1, names);
//    private Flat lst =  new Flat(98,1, names);

    //@Before
//    public void init(){
//        names.add("Vovan");
//        names.add("Sergey");
//        names.add("Stas");
//    }


//    public void testSize(){
//        assertEquals("Checking names size:", 3, names.size());
//    }

    @org.junit.jupiter.api.Test
    void writeResidentInFlat() {
        //List <String> names=new ArrayList<String>();
        names.add("First");
        //Flat temp= new Flat(45,1, names);
        temp.WriteResidentInFlat("Second",1);
        assertIterableEquals(names,temp.residents,"Test work");

        //names.add("kek");
    }



    @org.junit.jupiter.api.Test
    void findTheResidentAndDel(){
        names.remove("First");
        temp.FindTheResidentAndDel("Second");

        assertIterableEquals(names,temp.residents,"Test work");
    }

}