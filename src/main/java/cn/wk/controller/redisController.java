package cn.wk.controller;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class redisController {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private Redisson redisson;

	@RequestMapping(value = "/reduce", method = RequestMethod.GET)
	public String reduceKuncun() {
		String uuidkey=UUID.randomUUID().toString();
		String setnxlockKey = "product_001";
		RLock lock = redisson.getLock(setnxlockKey);
		try {
			// Boolean result =stringRedisTemplate.opsForValue().setIfAbsent(setnxlockKey, "zz");
			// stringRedisTemplate.expire(setnxlockKey, 10, TimeUnit.SECONDS);
//			Boolean result = stringRedisTemplate.opsForValue().setIfAbsent(setnxlockKey, uuidkey, 10, TimeUnit.SECONDS);
//			if (!result) {
//				return "error";
//			}
			
			lock.lock(30,TimeUnit.SECONDS);
			int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
			if (stock > 0) {
				int realStock = stock - 1;
				stringRedisTemplate.opsForValue().set("stock", realStock + "");
				System.out.println("扣减库存成功！..剩余库存  " + realStock);
			} else {
				System.out.println("库存不足！");
			}
		} finally {
			lock.unlock();
			
//			if(uuidkey.equals(stringRedisTemplate.opsForValue().get(setnxlockKey))){
//				stringRedisTemplate.delete("zz");
//			}
			
		}
		return "success";
	}
}
