package pl.itcrowd.tutorials.jug_ejb;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.transaction.TransactionSynchronizationRegistry;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: klex
 * Date: 2/12/13
 * Time: 2:49 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class TransactionDelegate {
    private static final Logger LOGGER = Logger.getLogger(TransactionDelegate.class.getCanonicalName());

    @Resource
    private TransactionSynchronizationRegistry txReg;

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void haveFun(){
         LOGGER.info(""+txReg.getTransactionKey());
    }
}
