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

package org.onap.sdc.dcae.composition.util;

public class DcaeBeConstants {
	public class Health {
		public final static String APP_NAME = "DCAE Designer";
		public final static String UP = "UP";
		public final static String DOWN = "DOWN";
		public final static String OK = "OK";
		public final static String BE = "BE";
		public final static String TOSCA_LAB = "TOSCA_LAB";
	}
	public class Composition{
		
		public class fileNames{
			public final static String EVENT_PROC_BP_YAML = "event_proc_bp.yaml";
			public final static String COMPOSITION_YML = "composition.yml";
			public final static String SVC_REF = "svc_reference.yml";
			public final static String MAPPING_RULE_POSTFIX = "_MappingRules.json";
		}
	}
	public class Config{
	// keys used to reference values in the system properties file
		public static final String ASDC_CATALOG_URL = "asdc_catalog_url";
		public static final String URI              = "uri";
		public static final String BLUEPRINTER_URI  = "blueprinter_uri";
		public static final String ASDC_ROOTPATH    = "asdc_rootPath";
	}
	public enum LifecycleStateEnum {

	     READY_FOR_CERTIFICATION,
	     CERTIFICATION_IN_PROGRESS,
	     CERTIFIED,
	     NOT_CERTIFIED_CHECKIN,
	     NOT_CERTIFIED_CHECKOUT;

	     public static LifecycleStateEnum findState(String state) {
	           for (LifecycleStateEnum lifecycleStateEnum : LifecycleStateEnum.values()) {
	                if (lifecycleStateEnum.name().equals(state)) {
	                     return lifecycleStateEnum;
	                }
	           }
	           return null;
	     }
	}
}
