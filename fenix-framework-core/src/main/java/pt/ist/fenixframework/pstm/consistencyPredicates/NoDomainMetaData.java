package pt.ist.fenixframework.pstm.consistencyPredicates;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * THIS ANNOTATION IS FOR INTERNAL USE OF THE FENIX-FRAMEWORK ONLY.
 * 
 * Annotates a domain class that is not supposed to have any domain meta data.
 * The framework will not create meta classes or meta objects for domain classes
 * with this annotation. The class cannot define any consistency predicates.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface NoDomainMetaData {
}