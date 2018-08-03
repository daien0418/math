import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.LockSupport;

public class IoClient {
	private static ExecutorService executorService = Executors.newCachedThreadPool();
	private static int sleeptime =1000*1000*1000;

	public static void main(String args[]){
		EchoClient echoClient = new EchoClient();
		for(int i=0;i<60;i++){
			executorService.submit(echoClient);
		}
	}

	static class EchoClient implements Runnable{

		@Override
		public void run() {
			Socket client = null;
			PrintWriter printWriter =  null;
			BufferedReader bufferedReader  = null;
			BufferedReader systemReader = null;
			try {
				client = new Socket();
				client.connect(new InetSocketAddress(InetAddress.getLocalHost(), 8888));
				printWriter = new PrintWriter(client.getOutputStream(),true);
				systemReader = new BufferedReader(new InputStreamReader(System.in));
//				LockSupport.parkNanos(sleeptime);

				printWriter.print(Thread.currentThread().getName());
				printWriter.println();
				printWriter.flush();
				bufferedReader =  new BufferedReader(new InputStreamReader(client.getInputStream()));
				System.out.println("from server:"+bufferedReader.readLine());

//				while (true) {
//					printWriter.print(systemReader.readLine());
//					printWriter.println();
//					printWriter.flush();
//					bufferedReader =  new BufferedReader(new InputStreamReader(client.getInputStream()));
//					System.out.println("from server:"+bufferedReader.readLine());
//				}


			} catch (IOException e) {

			}finally {
				try {
					if(printWriter!=null){
						printWriter.close();
					}

					if(systemReader!=null){
						systemReader.close();
					}

					if(bufferedReader!=null){
						bufferedReader.close();
					}

					if(client!=null){
						client.close();
					}
				} catch (Exception e2) {
				}
			}
		}

	}
}
