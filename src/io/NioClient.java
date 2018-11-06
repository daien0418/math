package io;
import java.awt.geom.FlatteningPathIterator;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

import org.omg.CORBA.PRIVATE_MEMBER;

public class NioClient {

	private Selector selector;
	private SocketChannel socketChannel;

	public void startService() throws IOException{
		selector = Selector.open();
		socketChannel = SocketChannel.open();
		socketChannel.configureBlocking(false);
		socketChannel.connect(new InetSocketAddress(InetAddress.getLocalHost(), 8888));
		socketChannel.register(selector, SelectionKey.OP_CONNECT);
		while(true){
			if(!selector.isOpen()){
				break;
			}
			selector.select();
			Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
			while(iterator.hasNext()){
				SelectionKey sKey =  iterator.next();
				iterator.remove();
				if(sKey.isConnectable()){
					connect(sKey);
				}else if(sKey.isReadable()){
					read(sKey);
				}
		}
	}

	}

	private void connect(SelectionKey sk) throws IOException {
		SocketChannel socketChannel = (SocketChannel)sk.channel();
		if(socketChannel.isConnectionPending()){
			socketChannel.finishConnect();
		}
		socketChannel.configureBlocking(false);
		socketChannel.write(ByteBuffer.wrap(new String("I am client").getBytes()));
		socketChannel.register(selector, SelectionKey.OP_READ);
	}

	private void read(SelectionKey sk) throws IOException {
		SocketChannel socketChannel = (SocketChannel)sk.channel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		socketChannel.read(buffer);
		System.out.println(new String (buffer.array()).trim());
		socketChannel.close();
		sk.selector().close();
	}


	public static void main(String args[]) throws IOException{
		NioClient nioClient = new NioClient();
		nioClient.startService();
	}

}
