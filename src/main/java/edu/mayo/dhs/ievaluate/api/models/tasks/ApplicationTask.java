package edu.mayo.dhs.ievaluate.api.models.tasks;

public abstract class ApplicationTask {
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
