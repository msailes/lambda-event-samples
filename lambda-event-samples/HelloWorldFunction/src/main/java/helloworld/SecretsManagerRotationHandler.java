package helloworld;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SecretsManagerRotationEvent;

public class SecretsManagerRotationHandler implements RequestHandler<SecretsManagerRotationEvent, String> {

        public String handleRequest(SecretsManagerRotationEvent event, final Context context) {
            context.getLogger().log(event.toString());

            return "OK";
        }
    }