package br.com.travesso.controle.util;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import br.gov.frameworkdemoiselle.message.Message;
import br.gov.frameworkdemoiselle.message.SeverityType;

public class ManagedBeanUtil implements Serializable {

    private static final long serialVersionUID = 1L;

    public static void addMessage(FacesMessage facesMsg) {
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    public static void addMessage(String uiId, FacesMessage facesMsg) {
        FacesContext.getCurrentInstance().addMessage(uiId, facesMsg);
    }

    public static void addMessage(Message message) {
        FacesMessage facesMsg = new FacesMessage();
        String label = message.getText();
        facesMsg.setSummary(label);
        facesMsg.setDetail("");
        facesMsg.setSeverity(getSeverity(message.getSeverity()));
        addMessage(facesMsg);
    }

    private static Severity getSeverity(SeverityType severity) {
        if (severity != null) {
            switch (severity) {
            case ERROR:
                return FacesMessage.SEVERITY_ERROR;
            case FATAL:
                return FacesMessage.SEVERITY_FATAL;
            case INFO:
                return FacesMessage.SEVERITY_INFO;
            case WARN:
                return FacesMessage.SEVERITY_WARN;
            }
        }

        return null;
    }
    
    public static boolean existeMensagem(FacesMessage message) {
    	for (FacesMessage messageInContext : FacesContext.getCurrentInstance().getMessageList()) {
    		if (messageInContext.getSummary().equals(message.getSummary())) {
    			return true;
    		}
    	}
    	return false;
    }

}
