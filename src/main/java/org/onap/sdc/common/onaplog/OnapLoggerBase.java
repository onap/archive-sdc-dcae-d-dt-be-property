/*-
 * ============LICENSE_START===============================================
 * ONAP SDC
 * ========================================================================
 * Modifications Copyright (c) 2019 Samsung
 * ========================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ============LICENSE_END=================================================
*/

package org.onap.sdc.common.onaplog;

import org.onap.sdc.common.onaplog.enums.LogLevel;
import org.onap.sdc.common.onaplog.interfaces.IOnapLogger;
import org.onap.sdc.common.onaplog.interfaces.IOnapMdcWrapper;
import org.slf4j.Logger;
import org.slf4j.MDC;
import org.slf4j.Marker;


/**
 * Created by mm288v on 12/27/2017.
 * This class holds the common behavior of all Loger-Typed classes.
 * The Concrete loggers should derive from this one.
 */

public abstract class OnapLoggerBase implements IOnapLogger {

    protected static Logger logger = null;
    private Marker myMarker;
    protected IOnapMdcWrapper onapMDCWrapper;

    OnapLoggerBase(IOnapMdcWrapper onapMDCWrapper, Marker marker) {
        this.onapMDCWrapper = onapMDCWrapper;
        initializeMandatoryFields();
        this.myMarker = marker;
    }

    OnapLoggerBase(){}

    @Override
    public void log(LogLevel errorLevel, String className, String message, Object... args) {
        MDC.put("ClassName", className);
        if (this instanceof OnapLoggerAudit || this instanceof OnapLoggerMetric) {
            MDC.put(OnapLogConfiguration.MDC_SERVER_IP_ADDRESS, OnapMDCWrapper.getInstance().getHostAddress());
            MDC.put(OnapLogConfiguration.MDC_SERVER_FQDN, OnapMDCWrapper.getInstance().getFqdn());
        }

        onapMDCWrapper.validateMandatoryFields();

        if (errorLevel.equals(LogLevel.ERROR)) {
            logger.error(myMarker, message, args);
            return;
        }

        if (errorLevel.equals(LogLevel.WARN)) {
            logger.warn(myMarker, message, args);
            return;
        }

        if (errorLevel.equals(LogLevel.INFO)) {
            logger.info(myMarker, message, args);
            return;
        }

        if (errorLevel.equals(LogLevel.DEBUG)) {
            logger.debug(myMarker, message, args);
        }
    }

    @Override
    public IOnapLogger clear() {
        onapMDCWrapper.clear();
        return this;
    }

    @Override
    public IOnapLogger startTimer() {
        onapMDCWrapper.startTimer();
        return this;
    }

    @Override
    public IOnapLogger setKeyRequestId(String keyRequestId) {
        onapMDCWrapper.setKeyRequestId(keyRequestId);
        return this;
    }

}
