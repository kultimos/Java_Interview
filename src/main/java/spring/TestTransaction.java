package spring;

import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionTemplate;

public class TestTransaction {
    public static void main(String[] args) {
//        TransactionDefinition transactionDefinition = new
        PlatformTransactionManager platformTransactionManager = new ChainedTransactionManager();
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        // 开始事务
        TransactionStatus status = platformTransactionManager.getTransaction(def);
        try {
            // 业务逻辑
            someTransactionalMethod();
            // 提交事务
            platformTransactionManager.commit(status);
        } catch (Exception e) {
            // 发生异常，回滚事务
            platformTransactionManager.rollback(status);
            throw e;
        }
    }

    private static void someTransactionalMethod() {
        // 实际的业务逻辑
    }
}
