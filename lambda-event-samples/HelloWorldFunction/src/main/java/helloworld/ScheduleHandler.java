package helloworld;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import software.amazon.lambda.powertools.logging.Logging;

public class ScheduleHandler implements RequestHandler<Object, String> {

    @Override
    @Logging(logEvent = true)
    public String handleRequest(Object input, Context context) {
        context.getLogger().log(input.toString());

        return "fin";
    }
}
