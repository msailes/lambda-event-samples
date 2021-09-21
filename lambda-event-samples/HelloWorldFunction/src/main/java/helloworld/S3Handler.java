package helloworld;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;

public class S3Handler implements RequestHandler<S3Event, String> {
    @Override
    public String handleRequest(S3Event input, Context context) {
        context.getLogger().log(input.getRecords().get(0).getEventSource());

        return "ok";
    }
}
