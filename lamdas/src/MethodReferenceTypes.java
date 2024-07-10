public class MethodReferenceTypes {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // STATIC METHOD REFERENCE
        //Objects::toString;   (obj)->Objects.toString(obj);

        // MEMBER METHOD REFERENCE
        //Object::toString     (obj)->obj.toString()

        // OBJECT METHOD REFERENCE
        //obj::toString         ()->obj.toString()

        // CONSTRUCTOR METHOD REFERENCE
        //Object::new           ()->new Object()
        
    }
}

