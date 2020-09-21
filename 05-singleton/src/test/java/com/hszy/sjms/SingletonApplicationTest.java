package com.hszy.sjms;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hszy.sjms.singleton.SingletonAtomicReference;
import com.hszy.sjms.singleton.SingletonEnmu;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SingletonApplication.class)
@WebAppConfiguration
public class SingletonApplicationTest {

	@Test
	public void singletonAtomicTest() throws InterruptedException {
		ConcurrentHashMap<Integer, SingletonAtomicReference> map = new ConcurrentHashMap<Integer, SingletonAtomicReference>();
		
		int THREADS = Runtime.getRuntime().availableProcessors() << 1;
		// 初始化线程
        ThreadPoolExecutor executor = new ThreadPoolExecutor(THREADS, THREADS, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10), new ThreadFactory() {
                    private final AtomicInteger nextId = new AtomicInteger(1);

                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r, "thread-" + nextId.getAndIncrement());
                        return thread;
                    }
                }, new ThreadPoolExecutor.AbortPolicy());
        
        for (int i = 0; i < THREADS; i++) {
            final int threadIndex = i;
            executor.execute(() -> getSingleton(threadIndex,map));
        }

        while (executor.getActiveCount() > 0) {
            Thread.sleep(100);
        }

        // 关闭线程池
        executor.shutdown();
        
        int i = 0;
        SingletonAtomicReference firstSingleton = null;
        for(int key : map.keySet()) {
        	if(i == 0) {
        		firstSingleton = map.get(key);
        	} else {
        		System.out.println(firstSingleton.equals(map.get(key)));
        		assertTrue(firstSingleton.equals(map.get(key)));
        	}
        	i ++;
        }
	}
	
	private void getSingleton(int threadIndex,ConcurrentHashMap<Integer, SingletonAtomicReference> map) {
		SingletonAtomicReference instance = SingletonAtomicReference.getInstance();
		if(!map.containsKey(threadIndex)) {
			map.put(threadIndex, instance);
		}
	}
	
	@Test
	public void reflectSingletonTest() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		SingletonAtomicReference instance = SingletonAtomicReference.getInstance();
		Constructor<SingletonAtomicReference> constructor = SingletonAtomicReference.class.getDeclaredConstructor();
		constructor.setAccessible(true);
		SingletonAtomicReference newInstance = constructor.newInstance();
		System.out.println(newInstance.equals(instance));
		assertFalse(newInstance.equals(instance));
	}
	
	@Test
	public void serializableSingletonTest() throws IOException, ClassNotFoundException {
		SingletonAtomicReference instance = SingletonAtomicReference.getInstance();
		instance.setContent("单例序列化");
		
		// 序列化
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(instance);
		
		// 反序列化
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		SingletonAtomicReference newInstance = (SingletonAtomicReference) ois.readObject();
		System.out.println(newInstance.equals(instance));
		assertFalse(newInstance.equals(instance));
	}
	
	@Test
	public void singletonEnmuTest() {
		SingletonEnmu instance = SingletonEnmu.INSTANCE.getSingletonEnmu();
		SingletonEnmu newInstance = SingletonEnmu.INSTANCE.getSingletonEnmu();
		System.out.println(newInstance.equals(instance));
		assertTrue(newInstance.equals(instance));
	}
	
	@Test
	public void reflectSingletonEnmuTest() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		SingletonEnmu instance = SingletonEnmu.INSTANCE.getSingletonEnmu();
		Constructor<SingletonEnmu> constructor = SingletonEnmu.class.getDeclaredConstructor();
		constructor.setAccessible(true);
		SingletonEnmu newInstance = constructor.newInstance();
		System.out.println(newInstance.equals(instance));
		assertFalse(newInstance.equals(instance));
	}
	
	@Test
	public void serializableSingletonEnmuTest() throws IOException, ClassNotFoundException {
		SingletonEnmu instance = SingletonEnmu.INSTANCE.getSingletonEnmu();
		SingletonEnmu.INSTANCE.setContent("单例序列化");
		
		// 序列化
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(instance);
		
		// 反序列化
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		SingletonEnmu newInstance = (SingletonEnmu) ois.readObject();
		System.out.println(newInstance.equals(instance));
		System.out.println(newInstance.getContent());
		assertTrue(newInstance.equals(instance));
	}
}