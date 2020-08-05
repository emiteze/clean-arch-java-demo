package br.com.mtz.cleanarch.application.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResourceValueResponse {

    private String resource;
    private String value;

    public ResourceValueResponse(String resource, String value) {
        this.resource = resource;
        this.value = value;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
