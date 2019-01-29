package cn.biosan.trace;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Developing a program as a product. 
 * @Description:
 * @Project light-tracer
 * @Package cn.biosan.trace
 * @author gaozhenyu@biosan.cn
 * @date 2019/1/19 下午5:01
 */
@SpringBootTest
public class CacheLineTest {


    //考虑一般缓存行大小是64字节，一个 long 类型占8字节
    static long[][] arr;

    /**
     *  测试结果
     *  Loop times:26ms
     *  Loop times:120ms
     *  遍历连续内存块内容，利用CPU CacheLine机制可提升几倍性能
     *
     *  缓存行原理：
     *  Cache是由很多个cache line组成的。每个cache line通常是64字节，并且它有效地引用主内存中的一块儿地址。一个Java的long类型变量是8字节，因此在一个缓存行中可以存8个long类型的变量。
     *  CPU每次从主存中拉取数据时，会把相邻的数据也存入同一个cache line。
     *  在访问一个long数组的时候，如果数组中的一个值被加载到缓存中，它会自动加载另外7个。因此你能非常快的遍历这个数组。事实上，你可以非常快速的遍历在连续内存块中分配的任意数据结构。
     */
    @Test
    public void CacheLineEffectTest() {
        /** 构建long数组，存储时每个arr[i][j]之间地址连续 **/
        arr = new long[1024 * 1024][];
        for (int i = 0; i < 1024 * 1024; i++) {
            arr[i] = new long[8];
            for (int j = 0; j < 8; j++) {
                arr[i][j] = 0L;
            }
        }
        long sum = 0L;
        long marked = System.currentTimeMillis();
        /** 连续方式遍历 **/
        for (int i = 0; i < 1024 * 1024; i += 1) {
            for (int j = 0; j < 8; j++) {
                sum = arr[i][j];
            }
        }
        System.out.println("Loop times:" + (System.currentTimeMillis() - marked) + "ms");

        marked = System.currentTimeMillis();
        /** 非连续方式遍历 **/
        for (int i = 0; i < 8; i += 1) {
            for (int j = 0; j < 1024 * 1024; j++) {
                sum = arr[j][i];
            }
        }
        System.out.println("Loop times:" + (System.currentTimeMillis() - marked) + "ms");

    }

}
