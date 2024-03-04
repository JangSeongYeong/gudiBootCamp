package lv01.ex04_숫자문자열과영단어;

public class Solution {
	/* 1478 → "one4seveneight"
		234567 → "23four5six7"
		10203 → "1zerotwozero3"*/
	
	/* s가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요. */
	
	/* 0	zero
		1	one
		2	two
		3	three
		4	four
		5	five
		6	six
		7	seven
		8	eight
		9	nine*/
	public int solution(String s) {
        
//        StringBuffer buffer = new StringBuffer();
//        
//        // 문자열 분해
//        char[] clist = s.toCharArray();
//        
//        // 문자 비교하면서 값 추가
//        for (int i = 0; i < clist.length; i++) {
//			// 숫자일 경우 그대로 더하기
//        	// 문자일 경우
//        	if(Character.isDigit(clist[i])) {
//				buffer.append(clist[i]);
//			} else if(clist[i] == 'z'){
//        		buffer.append('0');
//        		i += 3;
//        	} else if(clist[i] == 'o') {
//        		buffer.append('1');
//        		i += 2;
//        	} else if(clist[i] == 't') {
//        		if(clist[i+1] == 'w') {
//        			buffer.append('2');
//        			i+= 2;
//        		}else {
//        			buffer.append('3');
//        			i+= 4;
//				}
//        	} else if(clist[i] == 'f') {
//        		if(clist[i+1] == 'o') {
//        			buffer.append('4');
//        		} else {
//        			buffer.append('5');
//				}
//        		i+= 3;
//        	}else if(clist[i] == 's') {
//        		if(clist[i+1] == 'i') {
//        			buffer.append('6');
//        			i += 2;
//        		} else {
//        			buffer.append('7');
//        			i += 4;
//				}
//        	}else if(clist[i] == 'e') {
//        		buffer.append('8');
//        		i += 4;
//        	}else if(clist[i] == 'n') {
//        		buffer.append('9');
//        		i += 3;
//        	}
//        	
//        	if(i == clist.length-1) {
//        		break;
//        	}
//		}
        
        String[] strArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for(int i = 0; i < strArr.length; i++) {
            s = s.replaceAll(strArr[i], Integer.toString(i));
        }
        return Integer.parseInt(s);
        
//        return Integer.parseInt(buffer.toString());
    }
}
