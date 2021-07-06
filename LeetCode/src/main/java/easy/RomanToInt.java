package easy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


// https://leetcode.com/problems/roman-to-integer/
public class RomanToInt {

    //    기호	값
    //    I	1
    //    V	5
    //    X	10
    //    L	50
    //    C	100
    //    D	500
    //    M	1000

    // I 이 세개면 III (3) 이고 55는 L (50) + V(5) = LV(55)와 같은 식으로 표기된다. 로마 숫자에는 0에 대한 표기 방법이 없다.
    // 4의 경우는 IV = V - I와 같이 감산 표기법이 적용된 것이다.
    // 감산 표기법은 XL (40), CD (400)과 같은 경우에도 쓰인다.

    public int romanToInt(String s) {
        int rtn = 0;
        int tval = 0;
        int tval2 = 0;
        for(int i=0; i<s.length(); i++) {
            tval = valueRoman(s.charAt(i));
            try {
                tval2 = valueRoman(s.charAt(i+1));
            } catch(Exception e) {
                tval2 = 0;
            }

            if (tval < tval2) {
                rtn += tval2 - tval;
                i++;
            } else {
                rtn += tval;
            }
        }
        return rtn;
    }

    private int valueRoman(char s ) {
        switch (s) {
            case 'M' : return 1000;
            case 'D' : return 500;
            case 'C' : return 100;
            case 'L' : return 50;
            case 'X' : return 10;
            case 'V' : return 5;
            case 'I' : return 1;
        }
        return 0;
    }

    @Test
    public void test() {
        RomanToInt pn = new RomanToInt();
        String x = "III";
        int Output = 3;
        assertEquals(Output, pn.romanToInt(x));

        x = "IV";
        Output = 4;
        assertEquals(Output, pn.romanToInt(x));

        x = "IX";
        Output = 9;
        assertEquals(Output, pn.romanToInt(x));

        x = "XI";
        Output = 11;
        assertEquals(Output, pn.romanToInt(x));

        // xplanation: L = 50, V= 5, III = 3.
        x = "LVIII";
        Output = 58;
        assertEquals(Output, pn.romanToInt(x));

        // Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
        x = "MCMXCIV";
        Output = 1994;
        assertEquals(Output, pn.romanToInt(x));

    }
}
