### light-tracer
#### Why

#### Target
- 支持http和rpc（dubbo）分布式链路日志追踪

#### Feature
1. 业务无侵入、用户无感知
2. 高性能磁盘写入
3. 

#### Dev Plan
1. 数据上报模块
    - Reporter抽象设计
    - Disruptor写磁盘实现
        - Garbage-free，通过RingBuffer固定内存分配，避免频繁分配对象引起GC以及OMM
        - onEvent
    - Appender flush
2. 组件埋点机制
3. 链路透传原理
4. 采样策略

#### Refer
- OpenTracing：https://opentracing.io/specification/
- Disruptor：https://github.com/LMAX-Exchange/disruptor


#### Question
- TraceSpanContext和TraceContext的作用区别是什么