package br.com.mtz.cleanarch.domain.exception;

public class NotFoundException extends RuntimeException {

    private String resourceName;
    private String id;

    public NotFoundException(String resourceName, String id) {
        super("Resource not found!");
        this.resourceName = resourceName;
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
