public class Main {

    public static void main(String[] args) {
        doListTest();
    }

    public static void doListTest(){
        System.out.println("Тест 1.\n");
        TwoDirectionalList twoDirectionalList = new TwoDirectionalLinkedList();
        twoDirectionalList.add("val1");
        twoDirectionalList.add("val2");
        twoDirectionalList.add("val3");
        twoDirectionalList.add("val4");

        TwoDirectionalLinkedList.Node first = (TwoDirectionalLinkedList.Node) twoDirectionalList.getFirst();

        System.out.println(first.getVal());
        System.out.println(first.getNext().getVal());
        System.out.println(first.getNext().getNext().getVal());
        System.out.println(first.getNext().getNext().getNext().getVal());
        System.out.println();
        System.out.println("Первый: "+ ((TwoDirectionalLinkedList.Node) twoDirectionalList.getFirst()).getVal());
        System.out.println("Последний: "+ ((TwoDirectionalLinkedList.Node) twoDirectionalList.getLast()).getVal());
        System.out.println();

        System.out.println("Size: " + twoDirectionalList.size());
        System.out.println();

        TwoDirectionalLinkedList.Node last = (TwoDirectionalLinkedList.Node) twoDirectionalList.getLast();

        System.out.println(last.getVal());
        System.out.println(last.getPrevious().getVal());
        System.out.println(last.getPrevious().getPrevious().getVal());
        System.out.println(last.getPrevious().getPrevious().getPrevious().getVal());
        System.out.println();

        System.out.println("Удаляем val5: " + twoDirectionalList.remove("val5"));
        System.out.println("Удаляем val3: " + twoDirectionalList.remove("val3"));
        System.out.println();

        System.out.println(first.getVal());
        System.out.println(first.getNext().getVal());
        System.out.println(first.getNext().getNext().getVal());
        System.out.println();

        System.out.println("Тест 2. Лист из массива.");

        String[] strArr = {"strval1","strval2","strval3","strval4"};
        TwoDirectionalList twoDirectionalListArr = new TwoDirectionalLinkedList(strArr);
        TwoDirectionalLinkedList.Node first2 = (TwoDirectionalLinkedList.Node) twoDirectionalListArr.getFirst();

        System.out.println(first2.getVal());
        System.out.println(first2.getNext().getVal());
        System.out.println(first2.getNext().getNext().getVal());
        System.out.println(first2.getNext().getNext().getNext().getVal());
        System.out.println();

        System.out.println("Size: " + twoDirectionalListArr.size());
        System.out.println();

        System.out.println("Первый: "+ ((TwoDirectionalLinkedList.Node) twoDirectionalListArr.getFirst()).getVal());
        System.out.println("Последний: "+ ((TwoDirectionalLinkedList.Node) twoDirectionalListArr.getLast()).getVal());
        System.out.println();

        System.out.println("Тест 3. Тестим toString и многопоточный remove\n");
        TwoDirectionalList twoDirectionalLinkedListMultiThreadsTest = new TwoDirectionalLinkedList();

        for (int i = 1; i <= 1000; i++){
            twoDirectionalLinkedListMultiThreadsTest.add(String.valueOf(i));
        }

        System.out.println(twoDirectionalLinkedListMultiThreadsTest);

        System.out.println("Удаляем 3: " + twoDirectionalLinkedListMultiThreadsTest.remove("3"));

        System.out.println(twoDirectionalLinkedListMultiThreadsTest);

        System.out.println("---------------------------------------------");

        System.out.println("Удаляем 997: " + twoDirectionalLinkedListMultiThreadsTest.remove("997"));

        System.out.println(twoDirectionalLinkedListMultiThreadsTest);







    }
}
