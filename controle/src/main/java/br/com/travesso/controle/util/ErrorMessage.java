package br.com.travesso.controle.util;

import br.gov.frameworkdemoiselle.message.DefaultMessage;
import br.gov.frameworkdemoiselle.message.Message;
import br.gov.frameworkdemoiselle.message.SeverityType;

public enum ErrorMessage implements Message {
	
    ER001;

    private final DefaultMessage msg;

    private ErrorMessage() {
        msg = new DefaultMessage("{" + this.name() + "}", SeverityType.ERROR);
    }

    @Override
    public String getText() {
        return msg.getText();
    }

    @Override
    public SeverityType getSeverity() {
        return msg.getSeverity();
    }

}
