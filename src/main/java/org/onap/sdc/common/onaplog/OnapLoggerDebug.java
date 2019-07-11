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

package org.onap.sdc.common.onaplog;

import org.onap.sdc.common.onaplog.enums.LogLevel;
import org.onap.sdc.common.onaplog.enums.LogMarkers;
import org.onap.sdc.common.onaplog.interfaces.IOnapMdcWrapper;
import org.slf4j.LoggerFactory;
import org.slf4j.MarkerFactory;

public class OnapLoggerDebug extends OnapLoggerBase {

    private static OnapLoggerDebug instanceLoggerDebug = OnapLoggerFactory.getLogger(OnapLoggerDebug.class);

    OnapLoggerDebug(IOnapMdcWrapper onapMdcWrapper) {
        super(onapMdcWrapper, MarkerFactory.getMarker(LogMarkers.DEBUG_MARKER.text()));
        logger = LoggerFactory.getLogger(this.getClass().getName());
    }

    public static OnapLoggerDebug getInstance() {
        return instanceLoggerDebug;
    }

    @Override
    public void log(LogLevel errorLevel, String className, String message, Object... args) {
        String endOfRecordDelimiter = "|^\\n";
        super.log(errorLevel, className, message + endOfRecordDelimiter, args);
    }

    @Override
    public void initializeMandatoryFields() {
        // nothing to do here
    }

    @Override
    public OnapLoggerDebug clear() {
        return (OnapLoggerDebug) super.clear();
    }

    @Override
    public OnapLoggerDebug startTimer() {
        return (OnapLoggerDebug) super.startTimer();
    }

    @Override
    public OnapLoggerDebug setKeyRequestId(String keyRequestId) {
        return (OnapLoggerDebug) super.setKeyRequestId(keyRequestId);
    }
}
