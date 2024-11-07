package com.whl.interview;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: Hello-world
 * @description:
 * @author: whl
 * @create: 2024-11-01 12:02
 **/

public class ShowMeBug {
    private final ReentrantLock lock = new ReentrantLock();
    private HashMap<String, Integer> products = new HashMap<>();
    public void addProduct(String productId, int amount) {
        //添加新的商品和库存量。如果商品 ID 已经存在，应该更新库存量。
        lock.lock();//获取锁
        try {
            if (amount < 0){
                throw new InvalidStockException("无效的库存!!");
            }
            products.put(productId,products.getOrDefault(productId, 0) + amount);
        }finally {
            //释放锁
            lock.unlock();
        }
    }

    public void sellProduct(String productId, int amount) {
        //销售商品。如果库存不足，应抛出库存不足异常。
        lock.lock();
        try {
            Integer concurrentStock = products.get(productId);
            if (amount > concurrentStock){
                throw new InsufficientStockException("库存不足！");
            }
            //更新库存
            int stock = concurrentStock - amount;
            if (amount < 0 || stock <0){
                throw new InvalidStockException("库存不能为负数");
            }
            products.put(productId,stock);
        }finally {
            lock.unlock();
        }

    }

    public int getAmount(String productId) {
        //获取商品 ID 所对应的商品的库存。
        lock.lock();
        try {
            return products.getOrDefault(productId, 0);
        }finally {
            lock.unlock();
        }
    }
}
//库存不足异常
class InsufficientStockException extends RuntimeException{
    public InsufficientStockException(String message) {
        super(message);
    }
}

//无效库存异常
class InvalidStockException extends RuntimeException{
    public InvalidStockException(String message) {
        super(message);
    }

}
