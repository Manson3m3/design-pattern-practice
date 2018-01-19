package pers.manson3m3.algorithm.sort.comparation;

/**
 * Created on 2018/1/16.
 * 算法原理：
 (1)从待排序的n个记录中任意选取一个记录（通常选取第一个记录）为分区标准;

 (2)把所有小于该排序列的记录移动到左边，把所有大于该排序码的记录移动到右边，中间放所选记录，称之为第一趟排序；

 (3)然后对前后两个子序列分别重复上述过程，直到所有记录都排好序。

 最好的情况：是每趟排序结束后，每次划分使两个子文件的长度大致相等，时间复杂度为O（nlog2n）。

 */
public class QuickSort {
    /**
     * 以数组第一个元素为key的快排
     *
     * @param arr
     * @param low
     * @param high
     */
    public static void quickSort(int arr[], int low, int high) {
        if (arr == null) {
            return;
        }
        if (low >= high) {
            return;
        }
        int left = low;
        int right = high;
        int key = arr[low];
        while (left != right) {
            while (left < right && arr[right] > key) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] < key) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = key;
        quickSort(arr, low, left - 1);
        quickSort(arr, left + 1, high);
    }

    /**
     * 获取中位数
     *
     * @param arr
     * @param low
     * @param high
     * @return
     */
    public static int getMidNum(int arr[], int low, int high) {
        if (arr == null) {
            return Integer.MIN_VALUE;
        }
        int length = arr.length;
        if (low >= high) {
            return Integer.MIN_VALUE;
        }
        int left = low;
        int right = high;
        int key = arr[low];
        while (left != right) {
            while (left < right && arr[right] > key) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] < key) {
                left++;
            }
            arr[right] = arr[left];
        }
        if (left == (length - 1) / 2) {
            return arr[left];
        } else if (left > (left - 1) / 2) {
            return getMidNum(arr, low, left - 1);
        }
        return getMidNum(arr, left + 1, high);

    }
}
