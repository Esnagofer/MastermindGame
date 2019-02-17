package com.esnagofer.mastermind.application.v1.api.creategameboard;

import javax.inject.Qualifier;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * The Interface CreateGameBoardCmdQryInvocationSelector.
 */
@Target({ TYPE, METHOD, PARAMETER, FIELD })
@Retention(RUNTIME)
@Documented
@Qualifier 
public @interface CreateGameBoardCmdQryInvocationSelector {
    
    /**
     * A factory for creating Instance objects.
     */
    public static class InstanceFactory {

        /**
         * Gets the.
         *
         * @return the creates the game board cmd qry invocation selector
         */
        public static CreateGameBoardCmdQryInvocationSelector get() {
            return new CreateGameBoardCmdQryInvocationSelector() {
                @Override
                public Class<? extends Annotation> annotationType() {
                    return CreateGameBoardCmdQryInvocationSelector.class;
                }
            };
        }
    }
}
