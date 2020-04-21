package debug.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sky
 * @date 2020/4/21 - 7:15 上午
 */
public class SubListFailTest {
	public static void main (String[] args) {
		List masterList = new ArrayList();
		masterList.add("one");
		masterList.add("two");
		masterList.add("three");
		masterList.add("four");
		masterList.add("five");

		List branchList = masterList.subList(0, 3);

		// 主列表的改动会影响子列表
//		masterList.remove(0);
//		masterList.add("ten");
//		masterList.clear();

		branchList.clear();
		branchList.add("six");
		branchList.add("seven");
		branchList.remove(0);

		for (Object t : branchList) {
			System.out.println(t);
		}

		// 子列表的操作影响了主列表
		System.out.println((masterList));
	}
}
