package pl.itcrowd.tutorials.jug_ejb;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.transaction.TransactionSynchronizationRegistry;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: klex
 * Date: 2/12/13
 * Time: 2:42 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class Hello {
    private static final Logger LOGGER = Logger.getLogger(Hello.class.getCanonicalName());

    private int counter;

    @Resource
    private TransactionSynchronizationRegistry txReg;

    @EJB
    private TransactionDelegate delegate;


    @Resource
    private TimerService timerService;

    @Schedule(hour = "*", minute = "*", second = "0/2")
    public void hello() {
        LOGGER.info("hello" + counter++);
    }


    public void hello2() {
        long duration = 10000;         //10s
        TimerConfig timerConfig = new TimerConfig();
        timerService.createSingleActionTimer(duration, timerConfig);
    }

    @Timeout
    public void timeout() {

        LOGGER.info("hello world!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void TransactionExample() {

        LOGGER.info(""+txReg.getTransactionKey());
        delegate.haveFun();
    }
}
