package org.onap.sdc.common.onaplog.interfaces;

import org.onap.sdc.common.onaplog.enums.LogLevel;

/**
 * Created by dd4296 on 12/24/2017.
 */
public interface IOnapLogger {
	public void log(LogLevel errorLevel, String className, String message, Object... args);
	void initializeMandatoryFields();
	IOnapLogger clear();
	IOnapLogger startTimer();
	IOnapLogger setKeyRequestId(String keyRequestId);
}
