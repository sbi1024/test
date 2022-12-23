package classCollect.lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class lamdaShow {
    public void lamda1() {
        // case1
        lamdaInterfaceAble li = new lamdaInterfaceAble() {
            @Override
            public void lamdaMethod() {
                System.out.println("lamdaMethod() ================== ");
            }
        };

        li.lamdaMethod();
    }

    public void lamda2() {
        List<String> lsStr = new ArrayList<>();
        lsStr.add("1");
        lsStr.add("2");
        lsStr.add("3");
        lsStr.add("4");
        lsStr.add("5");

        List<String> collectResult = lsStr.stream()
                .filter(str -> str.equals("1"))
                .collect(Collectors.toList());

        for (String str : collectResult) {
            System.out.println("str = " + str);
        }
    }

    public void lamda3() {
        List<Integer> a = Arrays.asList(1, 2, 3);
        List<Integer> b = Arrays.asList(4, 5);
        List<Integer> c = Arrays.asList(6, 7, 8);

        List<List<Integer>> listOfListOfInts = Arrays.asList(a, b, c);
        List<Integer> collect = listOfListOfInts.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());
        for(int i : collect){
            System.out.println("i = " + i);
        }
    }

}
