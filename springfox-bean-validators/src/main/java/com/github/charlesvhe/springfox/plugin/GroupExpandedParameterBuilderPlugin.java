package com.github.charlesvhe.springfox.plugin;

import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.service.AllowableValues;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.ExpandedParameterBuilderPlugin;
import springfox.documentation.spi.service.contexts.ParameterExpansionContext;

import java.lang.annotation.Annotation;

public class GroupExpandedParameterBuilderPlugin implements ExpandedParameterBuilderPlugin {
    @Override
    public void apply(ParameterExpansionContext context) {
        // 附加额外配置
        GroupDocumentationType documentationType = (GroupDocumentationType) context.getDocumentationType();
        ParameterExpansionContextAnnotation peca = new ParameterExpansionContextAnnotation(context);
        ParameterBuilderAllowableValues pbav = new ParameterBuilderAllowableValues(context.getParameterBuilder());

        GroupModelPropertyBuilderPlugin.apply(peca, ParameterExpansionContextAnnotation::getAnnotation,
                pbav, ParameterBuilderAllowableValues::hidden, ParameterBuilderAllowableValues::required,
                ParameterBuilderAllowableValues::allowableValues, ParameterBuilderAllowableValues::pattern, documentationType.groups);
    }

    @Override
    public boolean supports(DocumentationType documentationType) {
        return documentationType instanceof GroupDocumentationType;
    }

    public class ParameterExpansionContextAnnotation {
        public ParameterExpansionContext context;

        public ParameterExpansionContextAnnotation(ParameterExpansionContext context) {
            this.context = context;
        }

        public <A extends Annotation> A getAnnotation(Class<A> annotationType) {
            return context.findAnnotation(annotationType).orNull();
        }
    }

    public class ParameterBuilderAllowableValues {
        public ParameterBuilder parameterBuilder;

        public ParameterBuilderAllowableValues(ParameterBuilder parameterBuilder) {
            this.parameterBuilder = parameterBuilder;
        }

        public ParameterBuilder hidden(boolean hidden) {
            return parameterBuilder.hidden(hidden);
        }

        public ParameterBuilder required(boolean required) {
            return parameterBuilder.required(required);
        }

        public ParameterBuilder allowableValues(AllowableValues allowableValues) {
            return parameterBuilder.allowableValues(allowableValues);
        }

        public ParameterBuilder pattern(String pattern) {
            return parameterBuilder.pattern(pattern);
        }
    }
}
