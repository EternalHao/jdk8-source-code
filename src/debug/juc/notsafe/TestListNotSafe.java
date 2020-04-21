package debug.juc.notsafe;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Vector;

/**
 * @author sky
 * @date 2020/2/23 - 4:26 下午
 *
 * 1. 故障现象
 * java.util.ConcurrentModificationException
 *
 * 2. 导致原因
 *
 * 3. 解决方法
 *
 *
 * 4. 优化建议
 *
 */
public class TestListNotSafe {
	public static void main(String[] args) {
		List<Object> list = new ArrayList<>(10);
//		List<String> list = new Vector<>();

		for (int i = 0; i <= 30 ; i++) {
			new Thread(()->{
				list.add(UUID.randomUUID().toString().substring(0,8));
				System.out.println(list);
			},String.valueOf(i)).start();
		}

		System.out.println(list);
	}
}

