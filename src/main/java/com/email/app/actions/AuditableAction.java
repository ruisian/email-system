package com.email.app.actions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public abstract class AuditableAction implements ActionInterface{

    public AuditableAction(String auditMessage) {
        this.auditMessage = auditMessage;
    }

    protected Logger logger  = LogManager.getLogger(getClass());
    private String auditMessage;
    @Override
    public Object executeAction() throws Exception{
        logger.info(auditMessage  +", " +  this);
        return executeAuditableAction();
    }

    @Override
    public Object executeAction(Object o) throws Exception{
        logger.info(auditMessage  + "[" + o + "], " + this);
        return executeAuditableAction(o);
    }

    public abstract Object executeAuditableAction() throws Exception;

    public abstract Object executeAuditableAction(Object o) throws Exception;

}
