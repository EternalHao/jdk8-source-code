package debug.string;

/**
 * @author sky
 * @date 2020/3/16 - 7:29 上午
 */
// StringTable ["a","b","ab"]
public class DebugString {
	public static void main(String[] args) {
		String s1 = "a"; //懒惰的行为
		String s2 = "b";
		String s3 = "a" + "b"; // "ab"
		String s4 = s1 + s2; //new StringBulider().append(s1).append(s2).toString
		String s5 = "ab"; // "ab"
		// 将字符串对象尝试放入字符串常量池 如果有则并不会放入  没有则放入串池 会把串池中的对象返回
		String s6 = s4.intern(); // 已经存在"ab" 返回就是"ab"

//		System.out.println(s3 == s4);  // false
//		System.out.println(s3 == s5);  // true
//		System.out.println(s3 == s6);  // true


		String x2 = new String("c") + new String("d");
		String x1 = "cd";
		x2.intern();

		System.out.println(x2 == x1); //false

		//======================================//
		// 24 和 25 交换位置

//		System.out.println(x2 == x1); //true

		// 1.6 的版本
		System.out.println(x2 == x1); //false


	}
}
