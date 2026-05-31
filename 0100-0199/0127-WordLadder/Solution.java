class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        // Track how many words are in the current transformation sequence.
        int steps = 0;
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for (int k = 0; k < size; k++) {
                String word = queue.poll();
                for (int i = 0; i < word.length(); i++) {
                    for (int j = 0; j < alphabet.length(); j++) {
                        // Try changing one character at the current position.
                        char[] tempArray = word.toCharArray();
                        tempArray[i] = alphabet.charAt(j);
                        String temp = new String(tempArray);

                        // Reaching the target word completes the shortest sequence.
                        if (temp.equals(endWord)) return steps + 1;
                        else if (wordSet.contains(temp)) {
                            queue.offer(temp);

                            // Remove visited words so they are not processed again.
                            wordSet.remove(temp);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
