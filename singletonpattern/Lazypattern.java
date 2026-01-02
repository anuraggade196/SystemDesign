public class Lazypattern {
    private static Lazypattern instance ;
    private  Lazypattern (){}

    public static Lazypattern getinstance(){
        if(instance==null){
            instance = new Lazypattern();
        }
        return instance ;
    }


    public static void main (String arg []){
        Lazypattern instance1 = Lazypattern.getinstance();
        Lazypattern instance2 = Lazypattern.getinstance();
        System.out.println(instance1);
        System.out.println(instance2);
       
    }


     
}