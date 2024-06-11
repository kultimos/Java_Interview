# redis安装包下载
  [安装包下载地址](https://download.redis.io/releases/?_gl=1*zivcs5*_ga*NjE3NTA2MTM3LjE2ODU2MjAwNjc.*_ga_8BKGRQKRPV*MTY5MDYxNTY2OS40LjEuMTY5MDYxNTcwMy4yNi4wLjA.%29)


# redis集群之主从复制、主从同步
- 主从数据同步原理(一主多从,主从读写分离)
    - 全量同步:
      这里有两个重要概念分别是replid和offset,从节点向主节点发起数据同步请求,主节点会先检查该从节点是否是第一次跟自己建立连接,这个判断是根据
      replid来进行判断的,如果一致的话就表示不是第一次建立连接,已经建立过,那么之后的数据同步就通过repl_baklog来进行,若两个节点的replid不一致,说明
      是第一次建立连接,那么主节点会进行一次bgsave(),把生成的rdb文件发送给从节点,从节点则清空本地数据,执行rdb文件实现全量同步;若不是第一次建立连接,
      说明之前已经rdb过了,所以根据日志文件和offset配合进行同步即可,两个节点之间offset的差值就是需要同步的数据内容;
    - 增量同步:
      增量同步一般在slave重启或后期数据变化的时候;就是根据replId,然后把offset之间差值的数据进行同步;

# 哨兵模式、集群脑裂
哨兵的作用: redis提供了哨兵Sentinel机制来实现主从集群的自动故障恢复;
监控: Sentinel会不断检查集群中master和slave是否按预期工作
自动故障恢复: 如果master故障,Sentinel会将一个salve提升为master,当故障实例恢复后也以新的master为主;
通知: Sentinel充当Redis客户端的服务发现来源,当集群出现故障转移时,会将最新消息推送给redis的客户端

Sentinel是基于心跳机制监测服务状态,每隔1秒内向集群的每个实例发送ping命令
- 主观下线: 如果某sentinel节点发现某实例未在规定时间响应,则认为该实例主观下线;
- 客观下线: 若超过指定数量的sentinel都认为该实例主观下线,则该实例客观下线,这个指定数量最好超过sentinel实例数量的一半;

哨兵选主规则:
- 首先判断主与从节点断开时间长短,如超过指定值就排除该从节点
- 然后判断从节点的slave-priority值,越小优先级越高
- 如果slave-priority一样,则判断slave节点的offset值,越大优先级越高
- 最后是判断slave节点的运行id大小,越小优先级越高;

# 分片集群
主从和哨兵可以解决高可用的问题、高并发读的问题,但是依然有两个问题没有解决:
- 海量数据存储问题
- 高并发写的问题

分片集群特征:
- 集群中有多个master节点,每个master保存不同数据
- 每个master也都可以有多个slave节点
- master之间通过ping检测彼此的健康状态(类哨兵)

分片集群通过哈希槽的算法实现数据读写,就保证了客户端请求可以访问集群任意节点,最终都会被转发到正确节点;根据key计算hash槽,然后进行不同节点直接的转发;