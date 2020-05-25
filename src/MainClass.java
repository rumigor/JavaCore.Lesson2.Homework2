import java.util.Arrays;
import java.util.Random;

public class MainClass {
    public static void main(String[] args) {
//   Первое задание:  Задать целочисленный массив, состоящий из элементов 0 и 1.
//   Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                array[i] = 0;
            } else {
                array[i] = 1;
            }
        }
        System.out.println(Arrays.toString(array));
//        Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        int[] numbers = new int[8];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i * 3;
        }
        System.out.println(Arrays.toString(numbers));
//    Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
        int[] newArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < newArray.length; i++) {
            if (newArray[i] < 6) {
                newArray[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(newArray));
//        Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
//        и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        int[][] matrix = new int[5][5];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = 1;
            matrix[i][matrix.length - 1 - i] = 1;
        }
        printMatrix(matrix);

//        Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        int [] minMax = new int[10];
        Random random = new Random();
        for (int i = 0; i < minMax.length; i++){
            minMax[i] = random.nextInt(100) - 20;
        }
        System.out.println(Arrays.toString(minMax));
        int min = minMax[0];
        int max = minMax[0];

        for (int i = 0; i < minMax.length; i++) {
            if (minMax[i] < min) {min = minMax[i];}
            if (minMax[i] > max) {max = minMax[i];}
        }
        System.out.println("Минимальное значение - " + min + ", "+  "максимальное значение - "+ max);
//        Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
//        если в массиве есть место, в котором сумма левой и правой части массива равны.
//        Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true,
//        граница показана символами ||, эти символы в массив не входят.
        int [] balancedArray = new int[10];
        for (int i = 0; i < balancedArray.length; i++) {
            balancedArray[i] = random.nextInt(10);
        }

        System.out.println(Arrays.toString(balancedArray));
        System.out.println(checkBalance(balancedArray));
//        Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
//        при этом метод должен сместить все элементымассива на n позиций. Для усложнения задачи нельзя пользоваться
//        вспомогательными массивами.
        System.out.println(Arrays.toString(balancedArray));
        int n = 3;
        if (n >= 0) {
            System.out.println("Сдвиг массива на " + n + " позиции(й) вправо: ");
        }
        else {
            System.out.println("Сдвиг массива на " + n + " позиции(й) влево: ");}
        arrayShift(balancedArray, n);

    }
    static void printMatrix(int [][] matrix) { // вывод на экран двумерного массива
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0 ; j < matrix[i].length; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }
    static boolean checkBalance(int [] array){ //Проверка массива на баланс левой и правой части
        boolean isArrayBalanced = false;
        int leftSum = 0;
        int rightSum = 0;
        exit:
        for (int i = 0; i < array.length - 1 - i; i++) {
            leftSum += array[i];
            for (int j = array.length-1; j > i; j--) {
                rightSum += array[j];
            }
            if (leftSum == rightSum) {
                isArrayBalanced = true;
                System.out.println("Граница проходит после элемента массива № " + i + ". " + leftSum + " - " + rightSum);
                break exit;
            }
            else rightSum = 0;

        }
        return isArrayBalanced;
    }

    static void arrayShift (int [] array, int n) { //Сдвиг элементов массива
        if (n < 0) {
            for (int i = 0; i < Math.abs(n); i++) {
                int temp = array[0];
                array[0] = array[array.length - 1];

                for (int j = 0; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = temp;
            }
        } else {
            for (int i = 0; i < n; i++) {
                int temp = array[array.length - 1];
                array[array.length - 1] = array[0];
                for (int j = array.length - 1; j > 0; j--) {
                    array[j] = array[j - 1];
                }
                array[0] = temp;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
