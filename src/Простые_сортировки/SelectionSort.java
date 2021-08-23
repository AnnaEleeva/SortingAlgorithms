//сортировка выбором - ищем минимум и ставим его в начало
//О(n^2)-время.  O(n)-память
package Простые_сортировки;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
    static int[] arrayNumbers;
    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Загрузки\\SpringSecurityAuthorization\\SortingAlgorithms\\src\\test1.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);

        String [] string =scanner.nextLine().split(" ");
        arrayNumbers = Arrays.stream(string).mapToInt(Integer::parseInt).toArray();

        printArray(arrayNumbers);
        System.out.println();
        selectionSort(arrayNumbers);
        printArray(arrayNumbers);
    }
    //сортировка выбором - ищем минимум и ставим его в начало (в циклично сдвигающуюся левую границу)
    //О(n^2)
    public static void selectionSort(int[] array){
        int min, temp;

        for (int index = 0; index < array.length-1; index++){
            min = index;
            //ищем минимум
            for (int scan = index+1; scan < array.length; scan++){
                if (array[scan] < array[min])
                    min = scan;
            }

            // Swap the values
            temp = array[min];
            array[min] = array[index];
            array[index] = temp;
        }
    }
    public static void printArray(int[]array){
        for(int e:array){
            System.out.print(e+" ");
        }
    }
}
