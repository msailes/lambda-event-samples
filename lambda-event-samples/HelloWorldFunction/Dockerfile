#FROM amd64/maven as build-image
#
#WORKDIR "/task"
#COPY src/ src/
#COPY pom.xml ./
#
#RUN mvn -q clean install
#RUN mvn dependency:copy-dependencies -DincludeScope=compile

FROM 628053151772.dkr.ecr.sa-east-1.amazonaws.com/awslambda/java8.al2-runtime:beta

COPY --from=build-image /task/target/classes /var/task/
COPY --from=build-image /task/target/dependency /var/task/lib

# Command can be overwritten by providing a different command in the template directly.
CMD ["helloworld.APIGatewayV2Handler::handleRequest"]