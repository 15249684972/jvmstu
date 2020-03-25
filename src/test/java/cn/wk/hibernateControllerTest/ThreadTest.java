package cn.wk.hibernateControllerTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

public class ThreadTest {

	
	@Test
	public void test() throws InterruptedException, ExecutionException{
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
		ArrayList<Future<String>> futures = new ArrayList<Future<String>>();
		for (int i = 0; i < 5; i++) {
			Future<String> f = fixedThreadPool.submit(new Callable<String>() {
				@Override
				public String call() throws IOException {
					try {
						return getURLContent();
					} finally {
					}
				}

				private String getURLContent() {
					int i=0;
					i=i+1;
					i=i+1;
					return Integer.toString(i);
				}
			});
			futures.add(f);
		}
		for (Future<String> fl : futures) {
			String string = fl.get();
			System.out.println(string);
		}
	}
}
