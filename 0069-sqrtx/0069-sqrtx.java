public class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        int left = 1;
        int right = x / 2;
        int answer = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (mid <= x / mid) {
                answer = mid;      // mid is a valid candidate
                left = mid + 1;    // try to find a larger value
            } else {
                right = mid - 1;   // mid is too big
            }
        }

        return answer;
    }
}