class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExponent = false;

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (Character.isDigit(curr)) {
                seenDigit = true;
            } else if (curr == '+' || curr == '-') {
                // A sign is only valid at index 0 or immediately after 'e'/'E'
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (curr == 'e' || curr == 'E') {
                // An exponent cannot appear twice and must follow at least one digit
                if (seenExponent || !seenDigit) {
                    return false;
                }
                seenExponent = true;
                // Reset seenDigit because the exponent must be followed by digits
                seenDigit = false;
            } else if (curr == '.') {
                // A dot cannot appear twice or after an exponent
                if (seenDot || seenExponent) {
                    return false;
                }
                seenDot = true;
            } else {
                // Any other character is invalid
                return false;
            }
        }

        // Valid only if we ended with at least one digit
        return seenDigit;
    }
}