package debug.nio;

import java.nio.Buffer;
import java.nio.ByteBuffer;

/**
 * @author sky
 * @date 2020/2/23 - 8:03 下午
 */
public class TestBuffer {
	public static void main(String[] args) {
		testDirectBuffer();
//		testBuffer();
	}

	private static void testDirectBuffer() {
		// 分配直接缓存区
		ByteBuffer allocateDirect = ByteBuffer.allocateDirect(1024);
		System.out.println(allocateDirect.isDirect());
	}

	private static void testBuffer() {
		String str = "abcde";
		// 1. 分配空间
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		System.out.println("-------------allocate()----------------");
		pringBuffer(buffer);

		// 2. 利用 put() 存取数据
		buffer.put(str.getBytes());
		System.out.println("-------------put()----------------");
		pringBuffer(buffer);

		// 切换到读取数据模式
		buffer.flip();
		System.out.println("-------------flip()----------------");
		pringBuffer(buffer);

		// 4. 读取数据
		byte[] result = new byte[buffer.limit()];
		System.out.println("-------------get()----------------");
		buffer.get(result);
		System.out.println(new String(result));
		pringBuffer(buffer);

		// 5. rewind() 可重复读
		buffer.rewind();
		System.out.println("-------------rewind()----------------");
		pringBuffer(buffer);

		// 6. clear() 清空缓存区，但是原来的数据依然存在，只是处于"被遗忘的状态"
		buffer.clear();
		System.out.println("-------------clear()----------------");
		pringBuffer(buffer);
	}

	private static void pringBuffer(Buffer buffer) {
		System.out.println(buffer.position());
		System.out.println(buffer.limit());
		System.out.println(buffer.capacity());
	}
}
