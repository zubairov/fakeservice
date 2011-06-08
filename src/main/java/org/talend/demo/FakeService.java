/*
 * #%L
 * Service Activity Monitoring :: Server
 * %%
 * Copyright (C) 2011 Talend Inc.
 * %%
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
 * #L%
 */
package org.talend.demo;

import java.io.IOException;

import javax.xml.namespace.QName;

import org.talend.esb.servicelocator.client.SLPropertiesImpl;
import org.talend.esb.servicelocator.client.ServiceLocatorException;
import org.talend.esb.servicelocator.client.internal.ServiceLocatorImpl;

public class FakeService {

	public static void main(String[] args) throws InterruptedException,
			ServiceLocatorException, IOException {
		ServiceLocatorImpl loc = new ServiceLocatorImpl();
		try {
			if (args.length > 0) {
				loc.setLocatorEndpoints(args[0]);
			} else {
				System.out.println("You can specify service locator enrpoints as first argument, for example: java -jar jarfile.jar \"127.0.0.1:2181, sl1.example.com:3210, sl2.example.com:3210, sl3.example.com:3210\"");
			}
			loc.connect();
			SLPropertiesImpl props = new SLPropertiesImpl();
			props.addProperty("version", "1.0");
			props.addProperty("owner", "Hasi");
			props.addProperty("purpose", "Rule the world", "Save the nature");
			loc.register(new QName("http://services.talend.org/CRMService", "CRMService"), "Miro (192.168.299.299)", props);
			loc.register(new QName("http://services.talend.org/CRMService", "CRMService"), "Hasi (442.998.222.555)", props);
			loc.register(new QName("http://services.talend.org/RentalService", "RentService"), "Hasi (442.998.222.555)", props);
		} catch (org.talend.esb.servicelocator.client.ServiceLocatorException e) {
			e.printStackTrace();
		}
		System.out.println("Press ENTER to exit");
		System.in.read();
		System.out.println("Exiting...");
		loc.disconnect();
	}

}
