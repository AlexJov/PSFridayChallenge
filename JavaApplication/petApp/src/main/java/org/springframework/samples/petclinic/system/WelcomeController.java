/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.petclinic.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.amazonaws.regions.Regions;

@Controller
class WelcomeController {

	@GetMapping("/")
	public String welcome() {
		return "welcome";
	}
	
	@GetMapping("/lambda")
	public String lambda() {
		
		String functionArn = "arn:aws:lambda:<REGION>:<ACCOUNT_ID>:function:<FUNCTION_NAME>";
		String accessKey = "YOUR_ACCESS_KEY_HERE";
		String accessKeySecret = "YOUR_SECRET_HERE";
		Regions region = Regions.EU_WEST_2;
		String inputPayload = "products";

		LambdaFunction.Invoke(functionArn, inputPayload, region, accessKey, accessKeySecret);

		return "welcome";

	}
}
