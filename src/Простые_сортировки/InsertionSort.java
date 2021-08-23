package Простые_сортировки;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

//сортировка вставкой O(n^2)-время. O(n)-память
public class InsertionSort {
    static int[] arrayNumbers;
    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Загрузки\\SpringSecurityAuthorization\\SortingAlgorithms\\src\\test1.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);

        String [] string =scanner.nextLine().split(" ");
        arrayNumbers = Arrays.stream(string).mapToInt(Integer::parseInt).toArray();

        printArray(arrayNumbers);
        System.out.println();
        insertionSort(arrayNumbers);
        printArray(arrayNumbers);
    }
    //сортировка вставкой O(n^2)
    public static void insertionSort(int[] array){
        int i, j, t;
        int a=1;
        int b=array.length;
        for (i = a; i < b; i++)
        {
            t = array[i];
            for (j = i - 1; j >= a - 1 && array[j] > t; j--)
                array[j + 1] = array[j];
            array[j + 1] = t;
        }
    }
    public static void printArray(int[]array){
        for(int e:array){
            System.out.print(e+" ");
        }
    }
}
