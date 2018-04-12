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