package debug.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author sky
 * @date 2020/4/7 - 8:36 上午
 */
public class NioClient {
	public static void main(String[] args) throws IOException {
		SocketChannel socketChannel = SocketChannel.open();

		socketChannel.configureBlocking(false);

		InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 6666);

		if(!socketChannel.connect(inetSocketAddress)){
			while (!socketChannel.finishConnect()){
				System.out.println("ke hu duan bu hui zu se");
			}
		}

		// 发送数据

		String str = "hello";

		ByteBuffer buffer = ByteBuffer.wrap(str.getBytes());

		socketChannel.write(buffer);

		System.in.read();
	}
}
