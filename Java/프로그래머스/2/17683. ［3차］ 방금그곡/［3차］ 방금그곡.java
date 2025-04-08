class Solution {
    public String solution(String m, String[] musicinfos) {
        m = changeMelody(m);
        String answer = "(None)";
        int maxTime = -1;

        for (String info : musicinfos) {
            String[] musicinfo = info.split(",");
            String[] start = musicinfo[0].split(":");
            String[] end = musicinfo[1].split(":");

            int startTime = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            int endTime = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);
            int playTime = endTime - startTime;

            String title = musicinfo[2];
            String melody = changeMelody(musicinfo[3]);
            String fullMelody = buildFullMelody(melody, playTime);

            if (fullMelody.contains(m)) {
                if (playTime > maxTime) {
                    maxTime = playTime;
                    answer = title;
                }
            }
        }

        System.out.println(answer); // 필요 없다면 삭제 가능
        return answer;
    }

    public String changeMelody(String melody) {
        return melody.replace("C#", "c")
                     .replace("D#", "d")
                     .replace("F#", "f")
                     .replace("G#", "g")
                     .replace("A#", "a")
                    .replace("B#","b");
    }

    public String buildFullMelody(String melody, int time) {
        StringBuilder sb = new StringBuilder();
        while (sb.length() < time) {
            sb.append(melody);
        }
        return sb.substring(0, time);
    }
}
