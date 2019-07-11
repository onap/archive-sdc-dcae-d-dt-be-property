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

/**
 * Created by dd4296 on 12/26/2017.
 * this factory helps decouple the classes for Stopwatch and OnapMDCWrapper from
 * the EcompLogger classes
 */
public class OnapLoggerFactory {

    private OnapLoggerFactory() {
    }

    @SuppressWarnings("unchecked")
    public static <T, V> V getLogger(Class<T> type) {

        if (type.equals(OnapLoggerAudit.class)) {
            return (V) new OnapLoggerAudit(new OnapMDCWrapper(new Stopwatch()));
        }

        if (type.equals(OnapLoggerDebug.class)) {
            return (V) new OnapLoggerDebug(new OnapMDCWrapper(new Stopwatch()));
        }

        if (type.equals(OnapLoggerMetric.class)) {
            return (V) new OnapLoggerMetric(new OnapMDCWrapper(new Stopwatch()));
        }

        if (type.equals(OnapLoggerError.class)) {
            return (V) new OnapLoggerError(new OnapMDCWrapper(new Stopwatch()));
        }

        return null;
    }
}
