package pl.itcrowd.tutorials.jug_ejb;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.transaction.TransactionSynchronizationRegistry;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: klex
 * Date: 2/12/13
 * Time: 2:40 PM
 * To change this template use File | Settings | File Templates.
 */
@Startup
@Singleton
public class MySingleton {
    private static final Logger LOGGER = Logger.getLogger(MySingleton.class.getCanonicalName());

    @EJB
    private Hello hello;

    @Resource
    private TransactionSynchronizationRegistry txReg;

    @PostConstruct
    public void PostConstruct() {
        LOGGER.info(""+txReg.getTransactionKey());
        hello.hello2();
        hello.TransactionExample();
        LOGGER.info(""+txReg.getTransactionKey());
    }
}
