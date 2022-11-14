package baekjoon;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class E005_MakeBridge {
    public long[] solution(int num, int[][] commands) {

        long[] result = new long[commands.length];
        int n = 0, m = 0;
        for (int c=0; c<commands.length; c++) {
            n = commands[c][0];
            m = commands[c][1];
            long [][] bridge = new long[m+1][m+1];

            for (int i=1; i<=m; i++)
                bridge[i][0] = 1;

            for (int i=1; i<=m; i++) {
                for (int j=1; j<=i; j++) {
                    if (i == j) bridge[i][j] = 1;
                    else
                        bridge[i][j] = bridge[i-1][j] + bridge[i-1][j-1];
                }
            }
            result[c] = bridge[m][n];
        }
        return result;
    }

    @Test
    public void makeBridgeTest() {
        int num = 4;
        int[][] bridge = {
                {2,2},
                {2,3},
                {1,5},
                {13,29},
        };
        long[] result = {1, 3, 5, 67863915};

        assertArrayEquals(result, solution(num, bridge));
    }

    public long[] solution_jaemok(int num, int[][] commands) {
        long[] result = new long[num];
        for(int i = 0; i < commands.length; i++) {
            int n = commands[i][0];
            int m = commands[i][1];
            result[i] = combi(m,n);
        }
        return result;
    }

    public long combi(int m,int n) {
        long result = 1;
        for(int i = 1; i<=n;i++) {
            result = result*(m -i +1) / (i) ;
        }
        return result;
    }

    @Test
    public void test() {
        int input1 = 4;
        int[][] input2  = {{2,2},{2,3}, {1,5},{13,29}};
        long[] result = {1,3, 5,67863915};
        assertArrayEquals(result, solution_jaemok(input1,input2));
    }
}