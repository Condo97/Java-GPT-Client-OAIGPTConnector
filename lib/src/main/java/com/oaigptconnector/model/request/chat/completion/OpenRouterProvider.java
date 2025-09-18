package com.oaigptconnector.model.request.chat.completion;

public class OpenRouterProvider {

    private Boolean require_parameters;

    public OpenRouterProvider() {

    }

    public OpenRouterProvider(Boolean require_parameters) {
        this.require_parameters = require_parameters;
    }

    public Boolean getRequire_parameters() {
        return require_parameters;
    }

}
