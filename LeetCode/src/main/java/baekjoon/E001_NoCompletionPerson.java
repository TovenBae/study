package baekjoon;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

//완주하지 못한 선수 (해쉬)
//        문제 설명
//        수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
//
//        마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
//        완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
//
//        제한사항
//        마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
//        completion의 길이는 participant의 길이보다 1 작습니다.
//        참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
//        참가자 중에는 동명이인이 있을 수 있습니다.
//
//        입출력 예
//        |participant | completion | return|
//        |["leo", "kiki", "eden"] | ["eden", "kiki"] | "leo"|
//        |["marina", "josipa", "nikola", "vinko", "filipa"] | ["josipa", "filipa", "marina", "nikola"] | "vinko"|
//        |["mislav", "stanko", "mislav", "ana"] | ["stanko", "ana", "mislav"] | "mislav"|
//
//        입출력 예 설명
//        예제 #1
//        "leo"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.
//
//        예제 #2
//        "vinko"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.
//
//        예제 #3
//        "mislav"는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.


public class E001_NoCompletionPerson {
    public String solution(String[] participant, String[] completion) {
        if (participant == null || completion == null) return null;

        String answer = "";

        Map<String, Boolean> map = new HashMap<>();
        for (String s : completion) {
            map.put(s, true);
        }
        for (String s : participant) {
            if (map.get(s) == null) return s;
            else map.remove(s);
        }
        return null;
    }

    @Test
    public void test() {
        String [] participant = {"leo", "kiki", "eden"};
        String [] completion = {"eden", "kiki"};
        String output = "leo";
        assertEquals(output, solution(participant, completion));

        participant = new String[]{"marina", "josipa", "nikola", "vinko", "filipa"};
        completion = new String[]{"josipa", "filipa", "marina", "nikola"};
        output = "vinko";
        assertEquals(output, solution(participant, completion));

        participant = new String[]{"mislav", "stanko", "mislav", "ana"};
        completion = new String[]{"stanko", "ana", "mislav"};
        output = "mislav";
        assertEquals(output, solution(participant, completion));

        participant = null;
        completion = null;
        output = null;
        assertEquals(output, solution(participant, completion));
    }
}
