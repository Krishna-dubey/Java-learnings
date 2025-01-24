public class Shop {
    public static void main(String args[]){
        Phone myPhone = new PhoneBuilder().setOs("Android").setRam(8).getPhone();

        System.out.println(myPhone);
    }
}
