package io;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.rmi.server.Skeleton;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NioServer {

	Selector selector;
	ServerSocketChannel serverSocketChannel;
	ExecutorService executorService = Executors.newCachedThreadPool();
	Map<Socket, Long> time = new HashMap<Socket, Long>();

	public void startService() throws Exception {
		InetSocketAddress inetSocketAddress = new InetSocketAddress(InetAddress.getLocalHost(), 8888);
		selector = Selector.open();
		serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.configureBlocking(false);
		serverSocketChannel.bind(inetSocketAddress);

		SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

		while (true) {
			selector.select();
			Set set = selector.selectedKeys();
			Iterator<SelectionKey> iterator = set.iterator();
			long end = 0;
			while (iterator.hasNext()) {
				SelectionKey sKey = (SelectionKey) iterator.next();
				iterator.remove();
				if (sKey.isAcceptable()) {
					accept(sKey);
				} else if (sKey.isValid() && sKey.isReadable()) {
					if (!time.containsKey(((SocketChannel) sKey.channel()).socket())) {
						time.put(((SocketChannel) sKey.channel()).socket(), System.currentTimeMillis());
						read(sKey);
					}
				} else if (sKey.isValid() && sKey.isWritable()) {
					write(sKey);
					end = System.currentTimeMillis();
					long start = time.remove(((SocketChannel) sKey.channel()).socket());
					System.out.println("ºÄÊ±:" + (end - start) + "ms");
				}
			}
		}

	}

	public void accept(SelectionKey sk) throws IOException {
		ServerSocketChannel serverSocketChannel = (ServerSocketChannel) sk.channel();
		SocketChannel socketChannel = serverSocketChannel.accept();
		socketChannel.configureBlocking(false);
		socketChannel.register(selector, SelectionKey.OP_READ).attach(new MessageQueue());

	}

	public void read(SelectionKey sk) throws IOException{
		SocketChannel socketChannel = (SocketChannel)sk.channel();
		ByteBuffer buffer =  ByteBuffer.allocate(1024);
		int len;
		len = socketChannel.read(buffer);
		if(len < 0){
			sk.channel().close();
			return;
		}
		buffer.flip();
		executorService.submit(new HandleMessage(sk, buffer));
	}

	public void write(SelectionKey sk) throws IOException{
		SocketChannel socketChannel = (SocketChannel)sk.channel();
		MessageQueue messageQueue = (MessageQueue)sk.attachment();
		LinkedList<ByteBuffer> list =  messageQueue.getList();
		ByteBuffer buffer = list.getLast();

		System.out.println(new String(buffer.array()));

		int len = socketChannel.write(buffer);
		if(len ==-1){
			socketChannel.close();
			return;
		}

		if(buffer.remaining() == 0){
			list.removeLast();
		}

		if(list.size() ==0){
			sk.interestOps(SelectionKey.OP_READ);
		}
	}

	public static void main(String args[]) throws Exception {
		NioServer nio = new NioServer();
		nio.startService();
	}

	class HandleMessage implements Runnable{

		SelectionKey selectionKey;
		ByteBuffer buffer;

		public HandleMessage(SelectionKey sk,ByteBuffer buffer) {
			this.selectionKey =sk;
		    this.buffer =  buffer;
		}

		@Override
		public void run() {
			MessageQueue messageQueue = (MessageQueue)selectionKey.attachment();
			messageQueue.add(buffer);
			selectionKey.interestOps(SelectionKey.OP_READ|SelectionKey.OP_WRITE);
			selector.wakeup();
		}

	}

	class MessageQueue {

		private LinkedList<ByteBuffer> list = new LinkedList<ByteBuffer>();

		public LinkedList<ByteBuffer> getList() {
			return list;
		}

		public void add(ByteBuffer buffer) {
			list.addFirst(buffer);
		}
	}
}
