package org.springframework.samples.petclinic.system;

// snippet-start:[lambda.java1.invoke.import]
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.AWSLambdaClientBuilder;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.amazonaws.services.lambda.model.ServiceException;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;

import java.nio.charset.StandardCharsets;

import java.util.HashMap;

// snippet-end:[lambda.java1.invoke.import]

public class LambdaFunction {

    public static Integer Invoke(String functionName, HashMap<String,String> inputValues, Regions region, String accessKey, String accessKeySecret){

            // snippet-start:[lambda.java1.invoke.main]

            // String payload = "{\n" +
            // " \"input\": \"" + inputValue + "\" \n" +
            // "}";
            String payload = "{\n";

		    int count =0;
		    for (String key : inputValues.keySet()) {
			if (count!=0)
			{
				payload +=",\n";
			}
			payload += " \""+key+"\": \""+inputValues.get(key)+ "\"";
			count++;
		    }
		    payload += "\n}";

            System.out.println(payload);

            InvokeRequest invokeRequest = new InvokeRequest()
                    .withFunctionName(functionName)
                    .withPayload(payload);
            InvokeResult invokeResult = null;

            try {
                BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, accessKeySecret);

                AWSLambda awsLambda = AWSLambdaClientBuilder.standard()
                        .withCredentials(new AWSStaticCredentialsProvider(credentials))
                        .withRegion(region).build();

                invokeResult = awsLambda.invoke(invokeRequest);

                String ans = new String(invokeResult.getPayload().array(), StandardCharsets.UTF_8);

                //write out the return value
                System.out.println(ans);

            } catch (ServiceException e) {
                System.out.println(e);
            }

            return invokeResult.getStatusCode();
            // snippet-end:[lambda.java1.invoke.main]

    }

}
