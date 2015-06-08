	function hideDialogOnSuccess(xhr, status, args, dialogWidgetVar) {
	    if (!args.validationFailed) {
	    	dialogWidgetVar.hide();
	    }
	}
