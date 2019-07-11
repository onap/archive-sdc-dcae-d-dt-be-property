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

import java.util.Properties;

import org.onap.sdc.common.onaplog.OnapLoggerDebug;
import org.onap.sdc.common.onaplog.enums.LogLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


/**
 * SystemProperties contains a list of constants used throughout portions of the
 * application. Populated by Spring from multiple configuration files.
 */
@Configuration
@Component
@PropertySources({
	@PropertySource(value="classpath:application-fe.properties", ignoreResourceNotFound=true),
	@PropertySource(value="file:${jetty.base}/config/dcae-be/application.properties", ignoreResourceNotFound=true)
})
@Scope(value = "singleton")
public class SystemProperties {
	private static OnapLoggerDebug debugLogger = OnapLoggerDebug.getInstance();

	@Autowired
	private Environment env;
	
	private Properties applicationProperties = null;
	
	public SystemProperties() {
		super();
	}
	
	@javax.annotation.PostConstruct
	public void init() {
		debugLogger.log(LogLevel.DEBUG, this.getClass().getName(), "****************************************************************************************************************");
		debugLogger.log(LogLevel.DEBUG, this.getClass().getName(), "Configuration: {}", env);
		if(applicationProperties == null){
			applicationProperties = new Properties();
			applicationProperties.setProperty(DcaeBeConstants.Config.URI,              getVal(env.getProperty(DcaeBeConstants.Config.URI)));
	        applicationProperties.setProperty(DcaeBeConstants.Config.ASDC_CATALOG_URL, getVal(env.getProperty(DcaeBeConstants.Config.ASDC_CATALOG_URL))+":"+getVal(env.getProperty(DcaeBeConstants.Config.URI)));
	        applicationProperties.setProperty(DcaeBeConstants.Config.ASDC_ROOTPATH,    getVal(env.getProperty(DcaeBeConstants.Config.ASDC_ROOTPATH)));
		}
		debugLogger.log(LogLevel.DEBUG, this.getClass().getName(), "****************************************************************************************************************");
	}

	private String getVal(String property) {
		return property != null ? property : "";
	}

	public final Properties getProperties() {
        return applicationProperties;
    }
	
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
	    PropertySourcesPlaceholderConfigurer p =  new PropertySourcesPlaceholderConfigurer();
	    p.setIgnoreResourceNotFound(true);
	
	    return p;
	}
}
