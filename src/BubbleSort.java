import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
    static int[] arrayNumbers;
    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Загрузки\\SpringSecurityAuthorization\\SortingAlgorithms\\src\\test1.txt";
        Path path = Paths.get(fileName);
        Scanner scanner = new Scanner(path);

        String [] string =scanner.nextLine().split(" ");
        arrayNumbers = Arrays.stream(string).mapToInt(Integer::parseInt).toArray();

        printArray(arrayNumbers);
        System.out.println();
        bubbleSort2(arrayNumbers);
        printArray(arrayNumbers);

    }

    //идет с конца
    public static void bubbleSort(int[] array){
        for(int i=0;i<array.length;i++){
            int exchanges=0;
            for(int j=array.length-1;j>i;j--){
                if(array[j]<array[j-1]){
                    int temp=array[j];
                    array[j]=array[j-1];
                    array[j-1]=temp;
                    exchanges++;
                }
            }
            if(exchanges==0) break;
        }
    }
    //идет с начала
    public static void bubbleSort2(int[] array){
        for(int i=0;i<array.length;i++){
            int exchanges=0;
            for(int j=0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    exchanges++;
                }
            }
            if(exchanges==0) break;
        }
    }

    public static void printArray(int[]array){
        for(int e:arrayNumbers){
            System.out.print(e+" ");
        }
    }
}
