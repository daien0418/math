import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExecutorTest {
	public static void main(String[] args) {
        ExecutorService singleThreadPool= Executors.newSingleThreadExecutor();
        for(int i=1;i<=5;i++){
            int index=i;
        singleThreadPool.execute(new Runnable(){
              @Override
              public void run() {
                try{
                 System.out.println("第"+index+"个线程");
                Thread.sleep(2000);
                 }catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }  });
        }
    }
}