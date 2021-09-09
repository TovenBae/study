package easy;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;


// https://leetcode.com/problems/roman-to-integer/
public class E013_RomanToInt {

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

    public int romanToInt1(String s) {
        // return 값
        int sum = 0;
        // char array 변환
        char [] sArr = s.toCharArray();
        for(int i = 0; i< sArr.length; i++) {
            // 더할 최종 값
            int num = 0;
            // i값
            int num1 = getNum(sArr[i]);
            // for 마지막 번째 필터 및  IV, IX, XL, XC, CD,CM 필터
            if ((i+1 < sArr.length) && getFlag(sArr[i], sArr[i+1])){
                // i+1값
                int num2 = getNum(sArr[i+1]);
                // 위의 경으 IV => V - I, XL => L - X
                num = num2 - num1;
                // 위와 같은 경우 2개가 한 쌍이랑 i를 증가 시켜 다다음으로 넘긴다
                i++;
            } else {
                // 그 외의 경우 i값이 더할 값이 된다
                num = num1;
            }
            sum += num;
        }
        return sum;
    }

    // IV, IX, XL, XC, CD,CM 필터
    public Boolean getFlag (char char1, char char2) {
        if((char1 == 'I' && (char2 == 'V' || char2 == 'X')) || (char1 == 'X' && (char2 == 'L' || char2 == 'C')) ||(char1 == 'C' && (char2 == 'D' || char2 == 'M'))) {
            return true;
        }
        return false;
    }

    public int getNum (char rom) {
        int reNum;
        switch (rom) {
            case 'M' : reNum = 1000;
                break;
            case 'D' : reNum = 500;
                break;
            case 'C' : reNum = 100;
                break;
            case 'L' : reNum = 50;
                break;
            case 'X' : reNum = 10;
                break;
            case 'V' : reNum = 5;
                break;
            case 'I' : reNum = 1;
                break;
            default: reNum = 0;
        }
        return reNum;
    }

    public int romanToInt_n(String s) {
        int result = 0;
        HashMap<String,Integer> romanMap = new HashMap<String,Integer>();
        romanMap.put("I", 1);                     //각 문자별 갖고 있는 값 삽입
        romanMap.put("V", 5);                     //각 문자별 갖고 있는 값 삽입
        romanMap.put("X", 10);                    //각 문자별 갖고 있는 값 삽입
        romanMap.put("L", 50);                    //각 문자별 갖고 있는 값 삽입
        romanMap.put("C", 100);                   //각 문자별 갖고 있는 값 삽입
        romanMap.put("D", 500);                   //각 문자별 갖고 있는 값 삽입
        romanMap.put("M", 1000);                  //각 문자별 갖고 있는 값 삽입
        if(s.length()==1) {                       //문자가 한 개 일땐, 그 값 그대로 추출
            System.out.println(romanMap.get(s));
        }else if(s.length()>1 && s.length()<=15){ //문자의 길이가 2~15일 때
            for(int i = 0; i<s.length()-1; i++) {   //문자의 길이 - 1만큼 반복문을 돌리고
                if(romanMap.get(s.substring(i,i+1))>=romanMap.get(s.substring(i+1,i+2))){
                    //왼쪽에서 부터 비교 문자 1,2의 값을 비교 했을 때
                    result = result + romanMap.get(s.substring(i,i+1));
                    //왼쪽이 크다면 그 값 그대로 더 해준다
                    if(i==s.length()-2) {
                        //비교값의 마지막이라면 한 번 더 더해준다.
                        result = result + romanMap.get(s.substring(i,i+1));
                    }
                }else {
                    //왼쪽에서부터 비교 문자 1,2값의 비교 했을 때
                    result = result + (romanMap.get(s.substring(i+1,i+2)) - romanMap.get(s.substring(i,i+1)));
                    //비교문자 2번이 크다면 비교 문자2의 값 - 비교문자 1의 값을 더 해주고 다음 포인터로 이동한다.
                    i = i+1;
                }
            }
        }
        return result;
    }

    @Test
    public void test() {
        E013_RomanToInt pn = new E013_RomanToInt();
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
