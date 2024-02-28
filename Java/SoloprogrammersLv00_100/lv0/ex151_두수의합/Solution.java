package lv0.ex151_두수의합;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	/*0 이상의 두 정수가 문자열 a, b로 주어질 때, \
	 *a + b의 값을 문자열로 return 하는 solution 함수를 작성해 주세요.*/
	public String solution(String a, String b) {
        
        ArrayList<Integer> alist = new ArrayList<Integer>();
        ArrayList<Integer> blist = new ArrayList<Integer>();
        ArrayList<Integer> rlist = new ArrayList<Integer>();
        
        int size = a.length() > b.length() ? a.length() : b.length();
        
        int in0 = 0;
        while (in0 < size-a.length()) {
        	alist.add(0);
        	in0++;
		}
        in0 = 0;
        for (int i = 0; i < a.length(); i++) {
			alist.add(Character.getNumericValue(a.charAt(i)));
        }
        
        while (in0 < size-b.length()) {
        	blist.add(0);
        	in0++;
		}
        
        for (int i = 0; i < b.length(); i++) {
			blist.add(Character.getNumericValue(b.charAt(i)));
        }

        Collections.reverse(alist);
        Collections.reverse(blist);
        
        int up = 0;
        int val = 0;
        for (int i = 0; i < size; i++) {
			val = alist.get(i)+blist.get(i) + up;	
			if (val >= 10) {
				up = 1;
				rlist.add(val - 10);
				val = 0;
			} else {
				up = 0;
				rlist.add(val);
				val = 0;
			}
		}
        
        if(up == 1) {
        	rlist.add(1);
        }
        
        Collections.reverse(rlist);
        
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < rlist.size(); i++) {
			buffer.append(rlist.get(i));
        }
        return buffer.toString();
    }
}
