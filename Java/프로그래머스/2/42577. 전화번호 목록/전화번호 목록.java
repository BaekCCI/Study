import java.util.Arrays;

class Solution {
    public boolean solution(String[] phoneBook) {
        Arrays.sort(phoneBook); // 사전순 정렬
        for (int i = 1; i < phoneBook.length; i++) {
            if (phoneBook[i].startsWith(phoneBook[i - 1])) {
                return false;
            }
        }
        return true;
    }
}
