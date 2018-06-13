package filereader;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> one = new ArrayList<Integer>();
        one.add(3);
        one.add(1);
        one.add(2);
        List<Integer> two = new ArrayList<Integer>();
        two.add(0);
        two.add(2);
        two.add(4);
        one.removeAll(two);
        System.out.println(one);
    }
}
