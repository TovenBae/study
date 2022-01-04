package baekjoon;

//문제 설명
//        일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다.
//        그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다.
//        이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다.
//        이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄 작업을 수행합니다.
//
//        1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
//        2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
//        3. 그렇지 않으면 J를 인쇄합니다.
//        예를 들어, 4개의 문서(A, B, C, D)가 순서대로 인쇄 대기목록에 있고 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄하게 됩니다.
//
//        내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 알고 싶습니다. 위의 예에서 C는 1번째로, A는 3번째로 인쇄됩니다.
//
//        현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities와
//        내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지를 알려주는 location이 매개변수로 주어질 때,
//        내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하도록 solution 함수를 작성해주세요.
//
//   Test Case
//
//                              priorities                location           return
//        *example1            [2, 1, 3, 2]                  2                 1
//        *example2            [1, 1, 9, 1, 1, 1]            0                 5
//
//    Constraints
//        현재 대기목록에는 1개 이상 100개 이하의 문서가 있습니다.
//        인쇄 작업의 중요도는 1~9로 표현하며 숫자가 클수록 중요하다는 뜻입니다.
//        location은 0 이상 (현재 대기목록에 있는 작업 수 - 1) 이하의 값을 가지며 대기목록의 가장 앞에 있으면 0, 두 번째에 있으면 1로 표현합니다.

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class E003_Sort {
    public int solution(int[] priorities, int location) {
        if (priorities == null) return 0;

        int answer = location;
        for (int i=1; i<priorities.length; i++) {
            for (int j=0; j<i; j++) {
                if (priorities[i] > priorities[j] ) {
                    boolean isShift = false;
                    int t = priorities[i];
                    for (int k=i; k>j; k--) {
                        priorities[k] = priorities[k-1];

                        if (k-1 == answer) answer = k;
                    }
                    priorities[j] = t;
                    if (isShift) answer++;
                    if (i == answer)
                        answer = j;
                    break;
                }
            }
        }
        return answer+1;
    }

    public int solutionQueue(int[] priorities, int location) {
        if (priorities == null) return 0;

        // Queue 에 등록
        Queue<Integer> queue = new LinkedList<>();
        for (int p : priorities)
            queue.add(p);

        // 우선순위 소팅
        for (int i=1; i<priorities.length; i++) {
            for (int j=0; j<i; j++) {
                if (priorities[i] > priorities[j] ) {
                    int t = priorities[i];
                    for (int k=i; k>j; k--) {
                        priorities[k] = priorities[k-1];
                    }
                    priorities[j] = t;
                    break;
                }
            }
        }

        // Sorting Queue 등록
        Queue<Integer> qSort = new LinkedList<>();
        for (int p : priorities)
            qSort.add(p);

        // find location value
        // 소팅Queue에서 값을 하나씩 뺀후 queue값과 비교
        //  같은 값이고 location 위치값이 0이면 결과 리턴
        //  다른 값이면 lcoation-- 처리후 queue 에서 다음값 비교 loop 수행
        int answer = 0;
        int t = -1;
        int tS = -1;
        boolean isFind = false;
        while(qSort.size() > 0) {
            tS = qSort.poll();
            for (int i=0; i<queue.size(); i++) {
                t = queue.poll();
                if (tS == t) {
                    if (0 == location)
                        isFind = true;
                    location --;
                    break;
                } else {
                    queue.add(t);
                    if (location == 0)
                        location = queue.size()-1;
                    else
                        location --;
                }
            }
            answer++;
            if (isFind)
                break;
        }

        return answer;
    }

    public int priorPrint(int [] priorities, int location) {
        int result = 0;								//결과 값 반환
        int picked_key = 0;							//처음 고른 값의 키
        int picked_value = priorities[location];	//처음 고른 값의 값
        List<HashMap<Integer, Integer>> valueList = new ArrayList<HashMap<Integer, Integer>>();
        for(int i=0; i<priorities.length; i++) {
            HashMap<Integer, Integer> prior_hashmaps = new HashMap<Integer,Integer>();
            prior_hashmaps.put(i+1, priorities[i]);	//키는 index+1로 설정하고 hashmap에 담기
            valueList.add(prior_hashmaps);		 	//ArrayList에 Hashmap담기
            if(i == location) {					 	//선택된 키는 따로 보관
                picked_key = i+1;
            }
        }
        boolean temp = true;
        while(temp) {								 //0번째 값이 그 이후 index의 값보다 작다면 맨뒤로 가는 로직
            temp = false;
            for(int i=1; i<valueList.size(); i++) {
                int input1 = 0;
                int input2 = 0;
                for(Map.Entry<Integer, Integer> elem : valueList.get(0).entrySet()) {
                    input1 = elem.getValue();
                }
                for(Map.Entry<Integer, Integer> elem : valueList.get(i).entrySet()) {
                    input2 = elem.getValue();
                }
                if(input1<input2) {
                    HashMap<Integer, Integer> temp_map = valueList.get(0);
                    valueList.remove(0);
                    valueList.add(temp_map);
                    temp = true;
                    break;
                }
            }
        }
        for(int i=0; i<valueList.size(); i++) {		//정렬이 끝난 valueList의 키와 값을 찾아 초기 가지고 있던 값이랑 비교하여 결과 리턴
            for(Map.Entry<Integer, Integer> elem : valueList.get(i).entrySet()) {
                if(elem.getKey()==picked_key && elem.getValue()==picked_value) {
                    result = i+1;
                    break;
                }
            }
        }
        return result;
    }

    @Test
    public void solutionTest() {
        int [] priorities = {2,1,3,2};
        int location = 2;
        int output = 1;

        assertEquals(output, solution(priorities, location));

        priorities = new int[] {2,1,3,2};
        location = 0;
        output = 2;
        assertEquals(output, solution(priorities, location));

        priorities = new int[] {2,1,3,2};
        location = 3;
        output = 3;
        assertEquals(output, solution(priorities, location));

        priorities = new int[] {1,1,9,1,1,1};
        location = 0;
        output = 2; // 5;
        assertEquals(output, solution(priorities, location));

        priorities = new int[] {1,1,9,1,1,1};
        location = 2;
        output = 1;
        assertEquals(output, solution(priorities, location));

    }

    @Test
    public void solutionQueueTest() {
        int [] priorities = {2,1,3,2};
        int location = 2;
        int output = 1;

        assertEquals(output, solutionQueue(priorities, location));

        priorities = new int[] {2,1,3,2};
        location = 0;
        output = 3;
        assertEquals(output, solutionQueue(priorities, location));

//        priorities = new int[] {2,1,3,2};
//        location = 3;
//        output = 4;
//        assertEquals(output, solutionQueue(priorities, location));

        priorities = new int[] {1,1,9,1,1,1};
        location = 0;
        output = 5;
        assertEquals(output, solutionQueue(priorities, location));

        priorities = new int[] {1,1,9,1,1,1};
        location = 1;
        output = 6;
        assertEquals(output, solutionQueue(priorities, location));

        priorities = new int[] {1,1,9,1,1,1};
        location = 2;
        output = 1;
        assertEquals(output, solutionQueue(priorities, location));

        priorities = new int[] {
                1,1,9,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,9,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,9,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,9,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,9,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        location = 0;
        output = 99;
        assertEquals(output, solutionQueue(priorities, location));

    }

    @Test
    public void priorPrintTest() {
        int [] priorities = {2,1,3,2};
        int location = 2;
        int output = 1;

        assertEquals(output, priorPrint(priorities, location));

        priorities = new int[] {2,1,3,2};
        location = 0;
        output = 3;
        assertEquals(output, priorPrint(priorities, location));

//        priorities = new int[] {2,1,3,2};
//        location = 3;
//        output = 4;
//        assertEquals(output, solutionQueue(priorities, location));

        priorities = new int[] {1,1,9,1,1,1};
        location = 0;
        output = 5;
        assertEquals(output, priorPrint(priorities, location));

        priorities = new int[] {1,1,9,1,1,1};
        location = 1;
        output = 6;
        assertEquals(output, priorPrint(priorities, location));

        priorities = new int[] {
                1,1,9,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,9,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,9,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,9,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                1,1,9,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        location = 0;
        output = 99;
        assertEquals(output, priorPrint(priorities, location));

    }
}
