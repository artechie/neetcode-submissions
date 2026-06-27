class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickselect(nums, nums.length - k, 0, nums.length - 1);
    }

    private int quickselect(int[] arr, int k, int l, int r) {
        int pivot = arr[r], j = l;

        for (int i = l; i < r; i++) {
            if (arr[i] < pivot) {
                swap(arr, j, i);
                j++;
            }
        }
        
        swap(arr, j, r);

        if (j == k) {
            return pivot;
        } else if (j > k) {
            return quickselect(arr, k, l, j - 1);
        } else {
            return quickselect(arr, k, j + 1, r);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[j];
        arr[j] = arr[i];
        arr[i] = t;
    }
}
