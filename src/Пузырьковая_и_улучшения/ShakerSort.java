//O(1)-память
//Сортировка перемешиванием (шейкерная сортировка) - улучшение пузырьковой О(n^2)-время
package Пузырьковая_и_улучшения;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class ShakerSort {
    static int[] arrayNumbers;
    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Загрузки\\SpringSecurityAuthorization\\SortingAlgorithms\\src\\test1.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);

        String [] string =scanner.nextLine().split(" ");
        arrayNumbers = Arrays.stream(string).mapToInt(Integer::parseInt).toArray();

        printArray(arrayNumbers);
        System.out.println();
        shakerSort(arrayNumbers);
        printArray(arrayNumbers);
    }
    //O(n^2)
    public static void shakerSort(int[] array){
        int buff;
        int left = 0;
        int right = array.length - 1;
        do {
            //идем с начала (слева-направо)
            for (int i = left; i < right; i++) {
                //если элемент больше стоящего справа - то меняем их местами
                if (array[i] > array[i + 1]) {
                    buff = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = buff;
                }
            }
            //вытащили максимальный элемент до правого края - сокращаем правую границу
            right--;
            //без этой половины будет обычная сортировка пузырьком - сокращаем правую границу пока она не станет = левой границе =0
            //идем с конца (справа-налево)
            for (int i = right; i > left; i--) {
                //если элемент меньшьше стоящего слева -  то меняем их
                if (array[i] < array[i - 1]) {
                    buff = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = buff;
                }
            }
            //вытащили минимальный элемент до левого края - сокращаем левую границу
            left++;
        }while (left<right);
    }
    public static void printArray(int[]array){
        for(int e:array){
            System.out.print(e+" ");
        }
    }
}
