class Solution {
    // bandage = [시간 t, 초당 회복량 x, 추가 회복량 y]
    // health = 최대 체력
    // attacks = [공격시간, 피해량]
    public int solution(int[] bandage, int health, int[][] attacks) {
        int t = bandage[0];
        int x = bandage[1];
        int y = bandage[2];

        int curH = health;
        int lastAttack = 0;

        for (int[] attack : attacks) {
            int attackT = attack[0];
            int damage = attack[1];

            int gap = attackT - lastAttack - 1;

            if (gap > 0) {
                curH = Math.min(health, curH + gap * x);
                curH = Math.min(health, curH + (gap / t) * y);
            }

            curH -= damage;
            if (curH <= 0) {
                return -1;
            }

            lastAttack = attackT;
        }

        return curH;
    }
}
