class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
       List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int j = i + 1;
            int lineLength = words[i].length();
            while (j < words.length && lineLength + 1 + words[j].length() <= maxWidth) {
                lineLength += 1 + words[j].length();
                j++;

        }
        int numWords = j - i;
            int numGaps = numWords - 1;
            StringBuilder line = new StringBuilder();

           
            if (j == words.length || numGaps == 0) {
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) {
                        line.append(" ");
                    }
                }
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } 
           
            else {
                int totalLetters = lineLength - numGaps;
                int totalSpaces = maxWidth - totalLetters;
                int spacesPerGap = totalSpaces / numGaps;
                int extraSpaces = totalSpaces % numGaps;

                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) {
                        int spacesToApply = spacesPerGap + (k - i < extraSpaces ? 1 : 0);
                        for (int s = 0; s < spacesToApply; s++) {
                            line.append(" ");
                        }
                    }
                }
            }

            result.add(line.toString());
            i = j;
        }

        return result;
    }
}