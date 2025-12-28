class EagerSingletonPattern {

    // Eager initialization
    private static final EagerSingletonPattern instance = new EagerSingletonPattern();

    // Private constructor
    private EagerSingletonPattern() {}

    // Public method to return instance
    public static EagerSingletonPattern getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        EagerSingletonPattern obj1 = EagerSingletonPattern.getInstance();
        EagerSingletonPattern obj2 = EagerSingletonPattern.getInstance();

        System.out.println(obj1);
        System.out.println(obj2);
    }
}
