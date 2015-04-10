package com.example.helloworld;

import java.util.List;

import io.dropwizard.Configuration;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.hibernate.validator.constraints.NotEmpty;

public class HelloWorldConfiguration extends Configuration {
    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultName = "Stranger";

    @NotEmpty 
    private List<String> resources; 
    
    @JsonProperty
    public String getTemplate() {
        return template;
    }

    @JsonProperty
    public void setTemplate(String template) {
        this.template = template;
    }

    @JsonProperty
    public String getDefaultName() {
        return defaultName;
    }

    @JsonProperty
    public List<String> getResources(){
    	return resources;
    }
    
    @JsonProperty
    public void setDefaultName(String name) {
        this.defaultName = name;
    }
    
    @JsonProperty
    public void setResources(List<String> resources){
    	this.resources = resources; 
    }
    
    
}