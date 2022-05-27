package com.email.app.actions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AuditableAction implements ActionInterface{

    public AuditableAction(String auditMessage) {
        this.auditMessage = auditMessage;
    }

    private Logger logger  = LoggerFactory.getLogger(getClass());
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
