package functional_inerface;

import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class ConsumerChaining {
    public static void main(String[] args) {
        TreeMap<Emp,String> set = new TreeMap<Emp,String>();
        set.put(new Emp(),null);
        System.out.println(set.size());


    }
}
class Emp{}