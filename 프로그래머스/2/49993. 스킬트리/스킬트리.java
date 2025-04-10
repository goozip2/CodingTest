class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for (int t = 0; t < skill_trees.length; t++) {
            String s = skill_trees[t];
            boolean[] learned = new boolean[skill.length()];
            int maxlearned = -1;
            boolean ok = true;

            int prev = -1;
            int now = -1;
            for (int i = 0; i < s.length(); i++) {
                now = skill.indexOf(s.charAt(i));
                if (now != -1) {
                    if (now < prev) {
                        ok = false;
                        break;
                    } else {
                        learned[now] = true;
                        if (now > maxlearned) {
                            maxlearned = now;
                        }
                        prev = now;
                    }
                }
            }
            for (int b = 0; b < maxlearned; b++) {
                if (learned[b] == false) {
                    ok = false;
                }
            }
            if (ok) {
                System.out.println(s);
                answer++;
            }
        }
        return answer;
    }
}

/*
1. 스킬 순서 저장 (String의 indexOf로 순서 비교 가능할 듯)
2. skill_tree 개수만큼 for문 반복하며 가능 여부 판별 (가능할 경우 answer++)
    2-1) skill_tree String을 하나씩 돌아가며 확인
    (prev 인덱스가 -1이 아니고, prev > now 일 경우 문제!!)

*/