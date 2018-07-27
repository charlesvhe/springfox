package com.github.charlesvhe.springfox.plugin;

import org.springframework.http.MediaType;
import springfox.documentation.spi.DocumentationType;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class GroupDocumentationType extends DocumentationType {
    public Class[] groups;

    public GroupDocumentationType(String name, String version) {
        super(name, version);
    }

    public GroupDocumentationType(String name, String version, MediaType mediaType) {
        super(name, version, mediaType);
    }

    public GroupDocumentationType(DocumentationType documentationType, Class[] groups) {
        super(documentationType.getName(), documentationType.getVersion(), documentationType.getMediaType());
        this.groups = groups;
    }

    public static String buildModelRefId(String refId, Class[] groups) {
        String suffix = Arrays.stream(groups).map(Class::getSimpleName).collect(Collectors.joining("_"));
        if (refId.endsWith("_" + suffix)) {
            return refId;
        }
        return refId + "_" + suffix;
    }

    public String buildModelRefId(String refId) {
        return buildModelRefId(refId, groups);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        if (!super.equals(o)) {return false;}
        GroupDocumentationType that = (GroupDocumentationType) o;
        return Arrays.equals(groups, that.groups);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(groups);
        return result;
    }
}
