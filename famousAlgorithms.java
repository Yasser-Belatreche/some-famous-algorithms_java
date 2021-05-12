import java.util.*;

public class famousAlgorithms {

  // INSERTION SORT
  public static void insertionSort(int[] num) {
    for (int i = 1; i < num.length; i++) {
      int temp = num[i];
      int j;
      for (j = i - 1; j >= 0 && temp < num[j]; j--) {
        // "<" ==> sort in nonDecreasing order ">" ==> sort in nonIncreasing order
        num[j + 1] = num[j];
      }
      num[j + 1] = temp;
    }
    System.out.println("the sorted array : " + Arrays.toString(num));
  }

  // SELECTION SORT
  public static void selectionSort(int[] num) {
    for (int i = 0; i < num.length; i++) {
      int temp = num[i];
      int index = i;
      for (int j = i + 1; j < num.length; j++) {
        if (num[j] <= temp) {
          // "<" ==> sort in nonDecreasing order ">" ==> sort in nonIncreasing order
          temp = num[j];
          index = j;
        }
      }
      num[index] = num[i];
      num[i] = temp;
    }
    System.out.println("The sorted array is : " + Arrays.toString(num));

  }

  // BUBLLE SORT
  public static void bublleSort(int[] num) {
    int x = num.length;
    for (int i = 0; i < x; i++) {
      for (int j = 0; j < x - 1; j++) {

        if (num[j + 1] <= num[j]) {
          // "<" ==> sort in nonDecreasing order ">" ==> sort in nonIncreasing order
          int temp = num[j];
          num[j] = num[j + 1];
          num[j + 1] = temp;
        }
      }
      x--;
    }
    System.out.println("The sorted array is : " + Arrays.toString(num));

  }

  /**
   * ------MERGE SORT START--------
   */
  public static int[] merge(int[] left, int[] right) {
    int[] sortedArray = new int[left.length + right.length];
    // i = index of left ---- j = index of right ---- k = index of sortedArray
    int i = 0;
    int j = 0;
    int k = 0;
    while (left.length > i && right.length > j) {
      if (left[i] < right[j]) {
        sortedArray[k++] = left[i++];
      } else {
        sortedArray[k++] = right[j++];
      }
    }
    while (left.length > i) {
      sortedArray[k++] = left[i++];
    }
    while (right.length > j) {
      sortedArray[k++] = right[j++];
    }
    return sortedArray;
  }

  public static int[] mergeSort(int[] num) {
    if (num.length == 1) {
      return num;
    }
    int mid = num.length / 2;
    int[] left = new int[mid];
    int[] right = new int[num.length - mid];
    for (int i = 0; i < left.length; i++) {
      left[i] = num[i];
    }
    for (int i = 0; i < right.length; i++) {
      right[i] = num[i + mid];
    }
    left = mergeSort(left);
    right = mergeSort(right);
    int[] result = merge(left, right);
    return result;
  }

  /**
   * ------MERGE SORT END---------
   */

  // BINARY SEARCH
  public static String binarySearch(int[] num, int target) {
    int first = 0, mid = (int) num.length / 2, last = num.length - 1;
    if (num[mid] == target) {
      return "The index of " + target + " in the array is : " + mid;
    }
    while (first <= last) {
      if (num[mid] == target) {
        return "The index of " + target + " in the array is : " + mid;
      } else if (num[mid] < target) {
        first = mid + 1;
        mid = (first + last) / 2;
      } else if (num[mid] > target) {
        last = mid - 1;
        mid = (first + last) / 2;
      }
    }
    return "the num " + target + " is not in the array.";
  }

  // GET THE BIGGEST NUMBER
  public static int max(int[] num) {
    int max = num[0];
    for (int i = 0; i < num.length; i++) {
      if (num[i] >= max) {
        max = num[i];
      }
    }
    return max;
  }

  // Fibonacci RULE
  /*
   * this methode gonna return the number that has the index "x" in the fibonacci
   * rule
   */
  public static int fib(int x) { // x is index of number we wanna get
    if (x == 0) {
      return 0;
    } else if (x == 1) {
      return 1;
    }
    return fib(x - 2) + fib(x - 1);
  }

  // maxSubArray PROBLEM
  /*
   * this methode return the max sum of the subarrays that we can form from the
   * array given
   */
  // iteratively
  public static void maxArray(int[] array) {
    int maxArray = Integer.MIN_VALUE;
    int firstIndex = 0;
    int lastIndex = 1;

    for (int i = 0; i < array.length; i++) {
      int maxArrayTemp = 0;
      for (int j = i; j < array.length; j++) {
        maxArrayTemp += array[j];
        if (maxArray < maxArrayTemp) {
          maxArray = maxArrayTemp;
          firstIndex = i;
          lastIndex = j;
        }
      }
    }
    System.out.println(
        "the max sum is : " + maxArray + " and it's from the index " + firstIndex + " to the index " + lastIndex);
  }

  // recursivley using devide-and-conquer algorithm
  static int maxCrossingSum(int arr[], int l, int m, int h) {
    int sum = 0;
    int left_sum = Integer.MIN_VALUE;
    for (int i = m; i >= l; i--) {
      sum = sum + arr[i];
      if (sum > left_sum) {
        left_sum = sum;
      }
    }
    sum = 0;
    int right_sum = Integer.MIN_VALUE;
    for (int i = m + 1; i <= h; i++) {
      sum = sum + arr[i];
      if (sum > right_sum) {
        right_sum = sum;
      }
    }
    return Math.max(left_sum + right_sum, Math.max(left_sum, right_sum));
  }

  static int maxSubArraySum(int arr[], int l, int h) {
    if (l == h) {
      return arr[l];
    }
    int m = (l + h) / 2;
    return Math.max(Math.max(maxSubArraySum(arr, l, m), maxSubArraySum(arr, m + 1, h)), maxCrossingSum(arr, l, m, h));
  }

  public static void main(String[] args) {
    // Enter your code here
  }
}
