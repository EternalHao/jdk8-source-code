package debug.list.failfast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author sky
 * @date 2020/4/21 - 7:32 上午
 */
public class ArrayListFailFast {
	public static void main (String [] args) {
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");

		// 添加这行代码 ConcurrentModificationException 会出现\
		// 可以移除倒数第二个
//		list.add("four");

		for (String s : list) {
			if ("two".equals(s)) {
				list.remove(s);
			}
		}

		System.out.println(list);


	}
}
