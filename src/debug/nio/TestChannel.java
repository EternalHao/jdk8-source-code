package debug.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author sky
 * @date 2020/2/23 - 9:10 下午
 */
public class TestChannel {
	public static void main(String[] args) throws Exception {
//		test01();
		test02();
	}

	// 分散读取 和 聚集写入
	private static void test02() throws Exception {
		RandomAccessFile in = new RandomAccessFile("/Users/sky/hyh/source/jdk1.8-source-analysis/src/debug/nio/1.text", "rw");
		RandomAccessFile out = new RandomAccessFile("/Users/sky/hyh/source/jdk1.8-source-analysis/src/debug/nio/2.text", "rw");

		// 1. 获取通道
		try(FileChannel inChannel = in.getChannel();
		FileChannel outChannel = out.getChannel();){
			// 2. 分配合适大小的缓存区
			ByteBuffer buffer1 = ByteBuffer.allocate(10);
			ByteBuffer buffer2 = ByteBuffer.allocate(20);

			ByteBuffer[] buffers = new ByteBuffer[2];
			buffers[0] = buffer1;
			buffers[1] = buffer2;
			// 3. 分散读取
			inChannel.read(buffers);

			for (ByteBuffer buffer:buffers) {
				buffer.flip();
				System.out.println(new String(buffer.array(),0,buffer.limit()));
			}
			// 4. 聚集写入
			outChannel  .write(buffers);

		}
	}



	// 1.利用通道完成文件复制
	private static void test01() throws IOException {
		try (FileInputStream inputStream = new FileInputStream("/Users/sky/hyh/source/jdk1.8-source-analysis/src/debug/nio/1.text");
		     FileOutputStream outputStream = new FileOutputStream("/Users/sky/hyh/source/jdk1.8-source-analysis/src/debug/nio/2.text");
		     // 1。 获取通道
		     FileChannel inputChannel = inputStream.getChannel();
		     FileChannel outputChannel = outputStream.getChannel();){

			//2。 设置缓存区
			ByteBuffer buf = ByteBuffer.allocate(1024);
			//3。读取文件到缓存区
			while(inputChannel.read(buf) != -1){
				// 4。 切换缓存区为读数据模式
				buf.flip();
				outputChannel.write(buf);
				buf.clear();
			}
			// try resource写法自动关闭资源
		}
	}
}
