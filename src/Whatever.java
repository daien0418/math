import java.awt.Event;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.DoubleConsumer;

import org.omg.PortableServer.portable.Delegate;

enum Day{
	MONDAY,TUESDAY;
	private  Day() {

	}
}

enum Day2{
	MONDAY;
}



 class Whatever implements Serializable{




	public Thread t(int temp) throws ClassNotFoundException {
		 String aString = new String("d");
		 char[] chars = aString.toCharArray();

		 int[] nums1,nums2;

//		 double a = (nums1[0]==null?0:0+nums1[nums1.length-1])*0.5d;
//	     double b = (nums2[0]+nums2[nums2.length-1])*0.5d;

//		Map<String, Object> map = new HashMap<>();
//		map.forEach((k,v)->System.out.println(k));
//		Object
//		AopContext.currentProxy();
		int c=0;
		assert c==1;
		this.getClass().getClassLoader().loadClass("");

		Whatever[] whatever = new Whatever[10];
		Random random = new Random();
		int[] a=new int[10];
		Arrays.stream(a);
		List<Integer> list = new ArrayList<>();
		list.stream().sorted(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return 0;
			}
		}).mapToInt((x) -> x);

		ExecutorService executorService = Executors.newFixedThreadPool(10);
		ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();

		return new Thread(){
			@Override
			public void run() {
				System.out.println(temp);
				super.run();
			}
		};

	}



	private int add(){
		return 1;
	}

	static class Ins{

	}

	public static void main(String args[]) throws IOException {


		Map<String,ExecutorService> cMap = new ConcurrentHashMap<String,ExecutorService>();
		LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>();
		ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
	    Whatever whatever = new Whatever();
	    ReentrantLock reentrantLock =new ReentrantLock();

	    int c = whatever.add();
	    int a = 1;
	    int b[] = new int[10];
        if (whatever instanceof Whatever) {

		}
//        for(int i=0;;){
//        }
//	    LinkedList<E>
//        DefaultListableBeanFactory
//        AbstractBeanFactory
//        WeakReference<T>
//        ThreadLocal<T>
//        SoftReference<T>
//        PhantomReference<T>
//        WeakHashMap<K, V>
//        StringBuffer stringBuffer = new StringBuffer();
//		ScheduledExecutorService scheduledExecutorService=Executors.newScheduledThreadPool(10);

//		LockSupport.park();
//		ExecutorService executorService = Executors.newCachedThreadPool();
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		String aString = new String();
		BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<String>();
		Arrays.sort(new int[8]);
		AtomicInteger atomicInteger = new AtomicInteger();
		AtomicReference<String> atomicReference = new AtomicReference<String>("heall");
		SortedMap<String, String> sortedMap = Collections.synchronizedSortedMap(new TreeMap<>());

		Map<String, String> map = new HashMap<String, String>();
		Map<String, String> table = new Hashtable<>();

		Selector selector = Selector.open();
		selector.select();

		FileOutputStream fileOutputStream = null;
		FileChannel fileChannel = null;

		try {
			fileOutputStream = new FileOutputStream(new File("test.txt"));
			fileChannel = fileOutputStream.getChannel();
			ByteBuffer buffer = ByteBuffer.allocate(1024);
			String content = "µÚÒ»´ÎÐ´¡£¡£¡£";
			Charset charset = Charset.forName("GBK");
			buffer.put(content.getBytes(charset));
			buffer.flip();
			fileChannel.write(buffer);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != fileOutputStream) {
				fileOutputStream.close();
			}
			if (null != fileChannel) {
				fileChannel.close();
			}
		}

	}

	private class inner{
		private void a(){
			add();
		}
	}
}


