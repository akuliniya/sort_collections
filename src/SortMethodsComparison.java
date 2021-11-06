

import java.text.SimpleDateFormat;
import java.util.*;

public class SortMethodsComparison {
    public static void main(String[] args) {
        List<Integer> arrayListForSort1 = new ArrayList<>();
        for (int i =0; i < 1_000; i++) {
           arrayListForSort1.add((int)(Math.random() * 100));
        }

        List<Integer> arrayListForSort2 = new ArrayList<>();
        for (int i =0; i < 1_000; i++) {
            arrayListForSort2.add((int)(Math.random() * 100));
        }

        List<Integer> arrayListForSort3 = new ArrayList<>();
        for (int i =0; i < 1_000; i++) {
            arrayListForSort3.add((int)(Math.random() * 100));
        }

        List<Integer> arrayListForSort4 = new ArrayList<>();
        for (int i =0; i < 1_000; i++) {
            arrayListForSort4.add((int)(Math.random() * 100));
        }

        List<Integer> linkedListForSort1 = new LinkedList<>();
        for (int i =0; i < 1_000; i++) {
            linkedListForSort1.add((int)(Math.random() * 100));
        }

        List<Integer> linkedListForSort2 = new LinkedList<>();
        for (int i =0; i < 1_000; i++) {
            linkedListForSort2.add((int)(Math.random() * 100));
        }

        List<Integer> linkedListForSort3 = new LinkedList<>();
        for (int i =0; i < 1_000; i++) {
            linkedListForSort3.add((int)(Math.random() * 100));
        }

        List<Integer> linkedListForSort4 = new LinkedList<>();
        for (int i =0; i < 1_000; i++) {
            linkedListForSort4.add((int)(Math.random() * 100));
        }

        //ArrayList
        printCollection(arrayListForSort1);
        checkSortEfficiency(arrayListForSort1, SortMethod.BUBBLE_METHOD);

        printCollection(arrayListForSort2);
        checkSortEfficiency(arrayListForSort2, SortMethod.BY_SELECT_METHOD);

        printCollection(arrayListForSort3);
        checkSortEfficiency(arrayListForSort3, SortMethod.JAVA_SORT);

        printCollection(arrayListForSort4);
        checkSortEfficiency(arrayListForSort4, SortMethod.INSERTION_METHOD);

        //LinkedList
        printCollection(linkedListForSort1);
        checkSortEfficiency(linkedListForSort1, SortMethod.BUBBLE_METHOD);

        printCollection(linkedListForSort2);
        checkSortEfficiency(linkedListForSort2, SortMethod.BY_SELECT_METHOD);

        printCollection(linkedListForSort3);
        checkSortEfficiency(linkedListForSort3, SortMethod.JAVA_SORT);

        printCollection(linkedListForSort4);
        checkSortEfficiency(linkedListForSort4, SortMethod.INSERTION_METHOD);

    }

    public static void bubbleSort(List<Integer> list) {
        for (int i = list.size() - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    public static void sortBySelection(List<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            int min = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list. get(min) > list.get(j)) {
                    min = j;
                }
            }
            int temp = list.get(i);
            list.set(i, list.get(min));
            list.set(min, temp);
        }
    }

    private static void srtFast(List<Integer> list) {
    }

    private static void sortByInjection(List<Integer> list) {
        for (int i = 1; i < list.size() - 1; i++) {
            int temp = list.get(i);
            int j = i;
            while (j > 0 && list.get(j - 1) >= temp) {
                list.set(j,list.get(j - 1));
                j--;
            }
            list.set(j,temp);
        }
    }

    private static void srtPyramid(List<Integer> list) {
    }

    public static void checkSortEfficiency(List<Integer> list, SortMethod sortMethod) {
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        SimpleDateFormat formatter2 = new SimpleDateFormat("mm:ss:SSS");
        long endTime;
        long startTime;

        switch (sortMethod){
            case PYRAMID -> {
                startTime = new Date().getTime();
                srtPyramid(list);
                endTime = new Date().getTime();
            }
            case FAST_SORT -> {
                startTime = new Date().getTime();
                srtFast(list);
                endTime = new Date().getTime();
            }
            case BY_SELECT_METHOD -> {
                startTime = new Date().getTime();
                sortBySelection(list);
                endTime = new Date().getTime();
            }
            case BUBBLE_METHOD -> {
                startTime = new Date().getTime();
                bubbleSort(list);
                endTime = new Date().getTime();
            }
            case INSERTION_METHOD -> {
                startTime = new Date().getTime();
                sortByInjection(list);
                endTime = new Date().getTime();
            }
            case JAVA_SORT -> {
                startTime = new Date().getTime();
                Collections.sort(list);
                endTime = new Date().getTime();
            }
            default -> {
                startTime = new Date().getTime();
                System.out.println("Фигня какая-то, нет у тебя такого метода сортировки.");
                endTime = new Date().getTime();
                System.exit(1);
            }
        }

        System.out.println(sortMethod);
//        System.out.println("Start time " +  formatter1.format(startTime));
//        System.out.println("End time " + formatter1.format(endTime));
        System.out.println("Duration: " + (endTime - startTime) + " ms,   " + formatter2.format((endTime - startTime)));
        System.out.println();
    }

    public static void printCollection(List<Integer> list) {
        System.out.println(list.getClass());
//        for (int i : list) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
    }
}
