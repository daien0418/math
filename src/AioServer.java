import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;

public class AioServer {
	AsynchronousServerSocketChannel serverSocketChannel;

	public AioServer() throws IOException {
		this.serverSocketChannel = AsynchronousServerSocketChannel.open();
		serverSocketChannel.bind(new InetSocketAddress(InetAddress.getLocalHost(), 9999));
	}

	public void startServer(){
		serverSocketChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {

			ByteBuffer buffer = ByteBuffer.allocate(1024);

			@Override
			public void completed(AsynchronousSocketChannel channel, Object attachment) {
				buffer.clear();
				try {
					channel.read(buffer).get();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			@Override
			public void failed(Throwable arg0, Object arg1) {
				System.out.println(arg0.getMessage());
			}
		});
	}
}
