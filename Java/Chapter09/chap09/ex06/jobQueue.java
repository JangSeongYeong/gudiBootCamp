package chap09.ex06;

import java.util.LinkedList;
import java.util.Queue;

public class jobQueue {

	public static void main(String[] args) {
		
		// Queue 는 규격일 뿐이고, 실제로는 링크드 리스트로 만들어졌다.
		Queue<Job> queue = new LinkedList<Job>();
		
		// 데이터 추가 : offer()
		queue.offer(new Job("send SMS", "Alice"));
		queue.offer(new Job("send Mail", "Bryan"));
		queue.offer(new Job("send SMS", "Chriss"));
		queue.offer(new Job("send Mail", "Daniel"));
		queue.offer(new Job("send SMS", "Erick"));
		
		Job job; // 선언을 while 안에서 하면 메모리 낭비가 되기에 밖으로 빼는것이 좋다. (안에서 선언하지 않는게 좋다.) 
		// 하나씩 빼내기 : poll()
		while (!queue.isEmpty()) {
			job = queue.poll();
			// peek() 을 쓰면 확인하고 다시 넣는다.
			System.out.println(job.getTo()+"에게 "+ job.getCommand()+"하기");
		}
		
		
		
	}

}
