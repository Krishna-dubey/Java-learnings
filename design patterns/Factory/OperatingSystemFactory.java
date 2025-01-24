public class OperatingSystemFactory {
    public OS getInstance(String str){
        if (str.equals("A")){
            return new Android();
        } else if (str.equals("W")) {
            return new Windows();
        }else {
            return new IOS();
        }
    }
}
