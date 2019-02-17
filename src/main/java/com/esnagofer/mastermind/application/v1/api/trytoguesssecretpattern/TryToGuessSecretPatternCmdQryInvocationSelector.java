package com.esnagofer.mastermind.application.v1.api.trytoguesssecretpattern;

import javax.inject.Qualifier;
import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * The Interface TryToGuessSecretPatternCommandInvocationSelector.
 */
@Target({ TYPE, METHOD, PARAMETER, FIELD })
@Retention(RUNTIME)
@Documented
@Qualifier 
public @interface TryToGuessSecretPatternCmdQryInvocationSelector {
    
    /**
     * A factory for creating Instance objects.
     */
    public static class InstanceFactory {

        /**
         * Gets the.
         *
         * @return the try to guess secret pattern command invocation selector
         */
        public static TryToGuessSecretPatternCmdQryInvocationSelector get() {
            return new TryToGuessSecretPatternCmdQryInvocationSelector() {
                @Override
                public Class<? extends Annotation> annotationType() {
                    return TryToGuessSecretPatternCmdQryInvocationSelector.class;
                }
            };
        }
    }
}
