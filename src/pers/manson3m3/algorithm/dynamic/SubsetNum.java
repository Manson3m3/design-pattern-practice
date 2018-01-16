package pers.manson3m3.algorithm.dynamic;


/**
 * Created on 2017/12/14.
 * 给定一个包含N个非负数的set，
 * 并且给定K, 从集合中找出一组元素子集， 使得这组子集的各个元素相加起来和是K
 */
public class SubsetNum {


    private static void printSubset(int[] arr) {

        for (int i : arr) {
            System.out.print(i + "  ");
        }
        System.out.println();
    }

    private static void subsetSum(int[] inputArr, int[] flagArr, int sum, int targetSum, int index) {
        flagArr[index] = 1;
        if (sum + inputArr[index] == targetSum) {
            printSubset(flagArr);
        } else if (index + 1 < inputArr.length && sum + inputArr[index] <= targetSum) {
            subsetSum(inputArr, flagArr, sum + inputArr[index], targetSum, index + 1);
        }
        if (index + 1 < inputArr.length && sum + inputArr[index + 1] <= targetSum) {
            flagArr[index] = 0;
            subsetSum(inputArr, flagArr, sum, targetSum, index + 1);
        }

    }


    public static void main(String[] args) {
        int[] inputArr = {2, 4, 6, 8, 10};
        int[] flagArr = new int[5];
        subsetSum(inputArr, flagArr, 0, 20, 0);

    }
}

