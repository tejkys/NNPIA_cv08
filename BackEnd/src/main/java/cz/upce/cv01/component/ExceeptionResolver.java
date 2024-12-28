package cz.upce.cv01.component;

import graphql.GraphQLError;
        import graphql.GraphqlErrorBuilder;
        import graphql.schema.DataFetchingEnvironment;
        import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
        import org.springframework.graphql.execution.ErrorType;
        import org.springframework.stereotype.Component;

@Component
public class ExceeptionResolver extends DataFetcherExceptionResolverAdapter {
    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
            return GraphqlErrorBuilder.newError()
                    .errorType(ErrorType.NOT_FOUND)
                    .message(ErrorType.NOT_FOUND.toString())
                    .path(env.getExecutionStepInfo().getPath())
                    .location(env.getField().getSourceLocation())
                    .build();

    }
}