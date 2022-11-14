package baekjoon;

//문제 설명
//        피보나치 수는 0과 1로 시작한다. 0번째 피보나치 수는 0이고, 1번째 피보나치 수는 1이다. 그 다음 2번째 부터는 바로 앞 두 피보나치 수의 합이 된다.
//
//        이를 식으로 써보면 Fn = Fn-1 + Fn-2 (n ≥ 2)가 된다.
//
//        n=17일때 까지 피보나치 수를 써보면 다음과 같다.
//
//        0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597
//
//        n이 주어졌을 때, n번째 피보나치 수를 구하는 프로그램을 작성하시오.
//
//        입력
//        첫째 줄에 n이 주어진다. n은 20보다 작거나 같은 자연수 또는 0이다.
//
//        출력
//        첫째 줄에 n번째 피보나치 수를 출력한다.
//
//      Test Case
//        input = 10
//        result = 55

//      참고 사항
//
//        문제는 for문을 사용하여 만들 수 있지만 반드시 재귀함수를 이용해서 만들어주세요.
//        재귀함수를 사용하기 위함입니다!

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class E004_Fibonacci {
    public int solution(int n) {
        if (n > 20 || n < 0) return 0;

        return fibonacci(n);
    }

    public int fibonacci(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public int solution_jaemok(int num){
        if(num > 20 || num < 0) return -1; //20 보다 큰 수나 0보다 작은 수가 들어오면
        return fibo(num);
    }
    public int fibo(int num) {
        if(num == 0) return 0;          //0일때는 0
        else if (num == 1) return 1;    //1일때는 1
        else {
            return fibo(num-1) + fibo(num-2);
        }
    }

    @Test
    public void testSolution() {
        int input = 10;
        int result = 55;

//        assertEquals(result, solution(input));

        input = 3;
        result = 2;
        assertEquals(result, solution(input));

    }
    @Test
    public void testSolutionJaemok() {
        int input = 10;
        int result = 55;

        assertEquals(result, solution_jaemok(input));

        input = 3;
        result = 2;
        assertEquals(result, solution_jaemok(input));
    }

}
