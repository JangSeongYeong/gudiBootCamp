package lv0.ex165_등수매기기;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	/* 영어 점수와 수학 점수의 평균 점수를 기준으로 학생들의 등수를 매기려고 합니다. 
	 * 
	 * 영어 점수와 수학 점수를 담은 2차원 정수 배열 score가 주어질 때, 
	 * 영어 점수와 수학 점수의 평균을 기준으로 매긴 등수를 담은 배열을 return하도록 solution 함수를 완성해주세요.*/
    public int[] solution(int[][] score) {
        // 평균 저장 배열 생성
    	ArrayList<Double> list = new ArrayList<Double>();
    	double[] rankd = new double[score.length];
        for (int i = 0; i < score.length; i++) {
        	double avr = (double)(score[i][0]+score[i][1])/(double)2;
			list.add(avr);
			rankd[i] = avr;
        }
        Collections.sort(list);
        Collections.reverse(list);
        
        int[] rank = new int[score.length];
        int count = 0;
        for (int i = 0; i < rank.length; i++) {
			for (int j = 0; j < rank.length; j++) {
				if(list.get(i) == rankd[j]) {
					rank[j] = i+1;
					count++;
				}
			}
			if (count != 1) {
				i += count-1;
			}
			count = 0;
		}
        
        return rank;
    }
}