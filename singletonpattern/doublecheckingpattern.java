public class doublecheckingpattern {
    private static  volatile doublecheckingpattern instance ;
    private doublecheckingpattern(){}

    public static doublecheckingpattern getinstance(){
        if(instance==null){
            synchronized(doublecheckingpattern.class){
                instance = new doublecheckingpattern();
            }
        }
        return instance ;
    }
    public static void main(String args[]){
        doublecheckingpattern instance1 = doublecheckingpattern.getinstance();
        doublecheckingpattern instance2 = doublecheckingpattern.getinstance();
        System.out.println(instance1);
        System.out.println(instance2);
        
    }

}
