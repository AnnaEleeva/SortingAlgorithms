//Сортировка слиянием пригодится для таких структур данных, в которых доступ к элементам осуществляется последовательно
// (например, для потоков).
// Здесь массив разбивается на две примерно равные части и каждая из них сортируется по отдельности.
// Затем два отсортированных подмассива сливаются в один.
//O(nlogn) - времени. O(n) -памяти
package Эффективные_сортировки;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    static int[] arrayNumbers;

    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Загрузки\\SpringSecurityAuthorization\\SortingAlgorithms\\src\\test1.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);

        String [] string =scanner.nextLine().split(" ");
        arrayNumbers = Arrays.stream(string).mapToInt(Integer::parseInt).toArray();

        printArray(arrayNumbers);
        System.out.println();
        mergeSort(arrayNumbers);
        printArray(arrayNumbers);
    }
    public static void mergeSort(int[]array){
        if (array.length>0) {
            int[] buffer=new int[array.length];
            MergeSortImpl(array, buffer, 0, array.length - 1);
        }
    }
    public static void MergeSortImpl(int[]array,int []buffer,int l,int r){
        if (l < r) {
            int m = (l + r) / 2; //делим на два массив и к каждому рекурсивно применяем сортировку
            MergeSortImpl(array, buffer, l, m);
            MergeSortImpl(array, buffer, m + 1, r);

            int k = l;
            for (int i = l, j = m + 1; i <= m || j <= r; ) {
                if (j > r || (i <= m && array[i] < array[j])) {
                    buffer[k] = array[i];
                    ++i;
                } else {
                    buffer[k] = array[j];
                    ++j;
                }
                ++k;
            }
            for (int i = l; i <= r; ++i) {
                array[i] = buffer[i];
            }
        }
    }
    public static void printArray(int[]array){
        for(int e:array){
            System.out.print(e+" ");
        }
    }
}
