package cn.wk;

import java.math.BigDecimal;

import org.junit.Test;

public class Tidu {

	@Test
	public void test() {
		double w = 0;
		double t = 0.2;
		double s = 0.0;
		int lenth = 1000;
		String wei = null;
		// double f=0.0;
		for (int i = 0; i < lenth; i++) {
			s = t * (8 * w + 5);
			System.out.println(w);
			if (8 * w + 5 == 0) {
				System.out.println("w的值：" + w);
				break;
			}
			w = w - s;
			wei = String.valueOf(w).split("\\.")[1];

			if (wei.length() >= 9) {
				BigDecimal b = new BigDecimal(w);
				w = b.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
			}
		}

		
		StringBuilder sb=new StringBuilder();
		StringBuffer sbu=new StringBuffer();
	}

}
