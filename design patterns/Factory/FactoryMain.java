public class FactoryMain {
    public static void main(String arg[]){
        OperatingSystemFactory osf = new OperatingSystemFactory();
        osf.getInstance("A").spec();
    }
}
