package Пузырьковая_и_улучшения;//O(n^2) - но может быстрее.  O(1)-память
//Сортировка расчёской — улучшение сортировки пузырьком. Её идея состоит в том, чтобы «устранить» элементы с небольшими значения в конце массива, которые замедляют работу алгоритма
import Пузырьковая_и_улучшения.BubbleSort;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class CombSort {
    static int[] arrayNumbers;
    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Загрузки\\SpringSecurityAuthorization\\SortingAlgorithms\\src\\test1.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);

        String [] string =scanner.nextLine().split(" ");
        arrayNumbers = Arrays.stream(string).mapToInt(Integer::parseInt).toArray();

        printArray(arrayNumbers);
        System.out.println();
        combSort(arrayNumbers);
        printArray(arrayNumbers);
    }
    //Сортировка расческой - улучшение пузырька
    public static void combSort(int[] array){
        final double factor=1.247;
        double  step=array.length-1;

        //убираем черепах
        while (step>=1){
            for(int i=0;i<array.length-step;++i){
                if(array[i]>array[(int) (i+step)]){
                    int temp=array[i];
                    array[i]=array[(int) (i+step)];
                    array[(int) (i+step)]=temp;
                }
            }
            step/=factor;

            BubbleSort.bubbleSort2(array);

        }
    }
    public static void printArray(int[]array){
        for(int e:array){
            System.out.print(e+" ");
        }
    }
}
