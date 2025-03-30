package it.pino.zelchat.api.module.annotation;

import it.pino.zelchat.api.module.priority.ModulePriority;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ChatModuleSettings {
    String pluginOwner();
    ModulePriority priority() default ModulePriority.NORMAL;
}
