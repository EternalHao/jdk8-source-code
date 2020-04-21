package debug.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

/**
 * @author sky
 * @date 2020/4/7 - 8:15 上午
 */
public class NioServer {
	public static void main(String[] args) throws IOException {
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

		Selector selector = Selector.open();

		serverSocketChannel.socket().bind(new InetSocketAddress(6666));

		serverSocketChannel.configureBlocking(false);

		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

		while (true){
			// 等待一秒
			int second = selector.select(1000);

			if(second == 0){
				System.out.println("fu wu qi deng dai wu lian jie");
				continue;
			}

			Set<SelectionKey> selectionKeys = selector.selectedKeys();
			System.out.println("注册的 selectKeys 的数量"+selectionKeys.size());
			for (SelectionKey key : selectionKeys) {

				if(key.isAcceptable()){
					SocketChannel socketChannel = serverSocketChannel.accept();
					socketChannel.configureBlocking(false);
					System.out.println("ke hu duan lian jie cheng gong :"+socketChannel.hashCode());
					socketChannel.register(selector,SelectionKey.OP_READ, ByteBuffer.allocate(1024));
				}

				if(key.isReadable()){
					SocketChannel channel = (SocketChannel) key.channel();
					ByteBuffer buffer = (ByteBuffer) key.attachment();
					channel.read(buffer);
					System.out.println("from 客户端 :"+new String(buffer.array()));

				}
				selectionKeys.remove(key);
			}

		}



	}
}
