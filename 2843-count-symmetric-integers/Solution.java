class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;

        for (int num = low; num <= high; num++) {
            String s = String.valueOf(num);

            if (s.length() % 2 != 0) {
                continue;
            }

            int half = s.length() / 2;
            int leftSum = 0;
            int rightSum = 0;

            for (int i = 0; i < half; i++) {
                leftSum += s.charAt(i) - '0';
                rightSum += s.charAt(i + half) - '0';
            }

            if (leftSum == rightSum) {
                count++;
            }
        }

        return count;
    }
}