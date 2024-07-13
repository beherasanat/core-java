package general;

public enum SingletonEnum {
    INSTANCE;

    // fields

    //methods

    public void show(){
        System.out.println("Hello World");
    }

    public static void main(String[] args) {
        INSTANCE.show();
    }

    protected Object readResolve() {
        return INSTANCE;
    }
}
