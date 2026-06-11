class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        int l = 0, r = arr.length - 1, n = arr[0].length;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[mid][n - 1] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        if (l == arr.length) {
            return false;
        }

        int row = l;
        l = 0;
        r = n - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;

            if (arr[row][mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l < n && arr[row][l] == target;
    }
}
