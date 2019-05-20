
//public interface Comparator<Flat>{
//    int compare(Flat a,Flat b);
//}

class FlatComparator implements java.util.Comparator<Flat> {
    public int compare(Flat num1,Flat num2){
        return num1.getNumberFlat()-num2.getNumberFlat();
    }
}
class PaymentComparator implements java.util.Comparator<Flat> {
    public int compare(Flat pay1, Flat pay2) {
        return pay1.getPayment()-pay2.getPayment();
    }
}
class CacheComparator implements java.util.Comparator<Flat>{
    public int compare(Flat cache1, Flat cache2){
        return cache1.getCache()-cache2.getCache();
    }
}
//class FlatComparator implements java.util.Comparator<Flat> {
//    public int compare(Flat num1,Flat num2){
//        return num1.getNumberFlat().compare(num2.getNumberFlat());
//    }
//}