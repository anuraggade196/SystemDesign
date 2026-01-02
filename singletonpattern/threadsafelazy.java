public class threadsafelazy {
    private static threadsafelazy instance ;
    private threadsafelazy(){}
    public static synchronized threadsafelazy getinstance (){
        if(instance==null){
            instance = new threadsafelazy();

        }
        return instance ;
    }
    public static void main (String args []){
        threadsafelazy instance1 = threadsafelazy.getinstance();
        threadsafelazy instance2 = threadsafelazy.getinstance();
        if(instance1==instance2) System.out.println("only one object is created");
        
    }
    
}
