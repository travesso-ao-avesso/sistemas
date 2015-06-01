package br.com.travesso.controle.util;

import java.util.Calendar;

public class DateUtil {

	public void configuraDiaUtil(Calendar data) {
		if(data.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
			data.add(Calendar.DAY_OF_MONTH, 2);	
		} else if(data.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
			data.add(Calendar.DAY_OF_MONTH, 1);
		}
	}
	
	public void adicionaDias(Calendar data, int dias){
		data.add(Calendar.DAY_OF_MONTH, dias);
	}
}
