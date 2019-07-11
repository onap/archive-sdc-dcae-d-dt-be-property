/*-
 * ============LICENSE_START=======================================================
 * sdc-dcae-d-dt-be-property
 * ================================================================================
 * Copyright (C) 2017 - 2019 AT&T Intellectual Property. All rights reserved.
 * ================================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ============LICENSE_END=========================================================
 */

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
