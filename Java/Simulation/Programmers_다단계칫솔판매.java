import java.util.*;

class Solution {

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int member_cnt = enroll.length;
        int[] answer = new int[member_cnt];

        Map<String, String> parentMap = new HashMap<>();
        Map<String, Integer> memberIndexMap = new HashMap<>();

        for (int i = 0; i < member_cnt; i++) {
            parentMap.put(enroll[i], referral[i]);
            memberIndexMap.put(enroll[i], i);
        }

        for (int i = 0; i < seller.length; i++) {
            int v = amount[i] * 100;
            String name = seller[i];

            while (!name.equals("-")) {
                int forParent = v / 10;
                int forMe = v - forParent;

                answer[memberIndexMap.get(name)] += forMe;
                name = parentMap.get(name);

                v = forParent;
                if (v == 0)
                    break;
            }
        }

        return answer;
    }
}