//Быстрая сортировка O(nlogn)-время. O(n) -память
//Этот алгоритм состоит из трёх шагов.
// 1) Сначала из массива нужно выбрать один элемент — его обычно называют опорным.
// 2)Затем другие элементы в массиве перераспределяют так, чтобы элементы меньше опорного оказались до него, а большие или равные — после.
// 3)А дальше рекурсивно применяют первые два шага к подмассивам справа и слева от опорного значения.
//O(nlogn)
package Эффективные_сортировки;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    static int[] arrayNumbers;

    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Загрузки\\SpringSecurityAuthorization\\SortingAlgorithms\\src\\test1.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);

        String [] string =scanner.nextLine().split(" ");
        arrayNumbers = Arrays.stream(string).mapToInt(Integer::parseInt).toArray();

        printArray(arrayNumbers);
        System.out.println();
        quickSort(arrayNumbers);
        printArray(arrayNumbers);
    }
    public static void quickSort(int[] array){
        if(array.length>0){
            quickSortImpl(array, 0, array.length - 1);
        }
    }
    public static void quickSortImpl(int[]array,int l, int r){
        if(l<r){
            //получаем новый опорный элемент q - (сначала это будет правая граница)
            int q=partition(array,l,r);
            //массив делится на две половины, для каждой снова вычисляем ее опорный элемент и снова делим
            quickSortImpl(array,l,q-1);
            quickSortImpl(array,q+1,r);
        }
    }
    public static int partition(int[]array,int l, int r){
        //получаем опорный элемент x - сначала это будет правая граница
        int x = array[r];
        int less = l;
        //идем слева-направо
        for (int i = l; i < r; ++i) {
            //если элемент меньше опорного
            if (array[i] <= x) {
                //делаем элемент новой левой границей
                int temp = array[i];
                array[i] = array[less];
                array[less] = temp;
                //если элемент меньше опорного - ставим его на левую границу - сдвигаем левую границу
                ++less;
            }
        }
        //меняем элементы на левой и правой границах
        int temp = array[less];
        array[less] = array[r];
        array[r] = temp;
        return less;
    }


    public static void printArray(int[]array){
        for(int e:array){
            System.out.print(e+" ");
        }
    }
}
