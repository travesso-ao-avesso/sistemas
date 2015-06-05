package br.com.travesso.controle.exception;

import java.util.ArrayList;
import java.util.List;

import br.gov.frameworkdemoiselle.exception.ApplicationException;
import br.gov.frameworkdemoiselle.message.Message;

@ApplicationException
public class NegocioException extends Exception {
	
	private static final long serialVersionUID = 1L;
	List<Message> messages = new ArrayList<Message>();

	public NegocioException(Message message) {
		super();
		messages.add(message);
	}
	
    public NegocioException(String e, List<Message> msgs) {
        super(e);
        addMessages(msgs);
    }
	
	public NegocioException(List<Message> messages) {
		super();
		addMessages(messages);
	}
	
    private void addMessages(List<Message> msgs) {
        this.messages.addAll(msgs);
    }

	public List<Message> getMessages() {
		return messages;
	}
	
	
	

}
