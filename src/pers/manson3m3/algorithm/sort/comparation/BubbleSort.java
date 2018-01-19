package pers.manson3m3.algorithm.sort.comparation;

/**
 * Created on 2018/1/17.
 */
public class BubbleSort {
    public static void bubbleSort(int arr[]) {
        if (arr == null) {
            return;
        }
        int length = arr.length;
        for (int i = length - 1; i > 0; i--) {
            boolean swap = false;
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                    swap = true;
                }
            }
            if (!swap) {
                return;
            }
        }
    }

    /**
     * 冒泡优化，
     * 1.每次遍历前查看是否存在交换
     * 2.记录上次便利交换的位置作为参考，分为有序区和无序区
     *
     * @param arr
     */
    public static void sort2(int arr[]) {
        if (arr == null) {
            return;
        }
        int length = arr.length;
        int lastChange = arr.length - 1;
        for (int i = 0; i < length; i++) {
            boolean swap = false;
            for (int j = 0; j < lastChange; j++) {
                if (arr[j] > arr[j + 1]) {
                    arr[j] = arr[j] + arr[j + 1];
                    arr[j + 1] = arr[j] - arr[j + 1];
                    arr[j] = arr[j] - arr[j + 1];
                    swap = true;
                    lastChange = j;
                }
            }
            if (!swap) {
                return;
            }
        }
    }
}
