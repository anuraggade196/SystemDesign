class billpugh{
    private billpugh(){}
    public static class singletonhelper {
        private static final billpugh instance  = new billpugh();

    }
    public static billpugh getinstance(){
        return singletonhelper.instance ;
    }
    public static void main(String args []){
        billpugh instance1 = billpugh.getinstance();
        billpugh instance2 = billpugh.getinstance();
        System.out.println(instance1);
        System.out.println(instance2);
    }
}