package general;

interface Test {
    default void testDefault(){}
    static void testStatic(){}
}
public class InterfaceDefaultMethod implements Test {
    public void testDefault(){
        Test.testStatic();
    }

    public void testStatic() {

    }
}

interface Test1 {
    default void testDefault(){}
}
interface Test2 {
    default void testDefault(){}
}

class TestMultiple implements Test1, Test2 {
    void check() {
        TestMultiple t = new TestMultiple();
        t.testDefault();
    }

    @Override
    public void testDefault() {
        Test1.super.testDefault();
    }
}
