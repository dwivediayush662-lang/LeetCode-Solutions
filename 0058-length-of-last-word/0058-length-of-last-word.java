class Solution {
    public int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        int length = 0;

        // 1. Skip trailing spaces at the end
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // 2. Count characters until the next space or start of the string
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }
}