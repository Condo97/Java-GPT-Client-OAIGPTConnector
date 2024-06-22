package com.oaigptconnector.model.request.chat.completion;

public class OAIChatCompletionRequestToolChoiceFunction implements OAIChatCompletionRequestToolChoice {

    public static class Function {

        private String name;

        public Function() {

        }

        public Function(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }

    private String type = "function";
    private Function function;

    public OAIChatCompletionRequestToolChoiceFunction() {

    }

    public OAIChatCompletionRequestToolChoiceFunction(Function function) {
        this.function = function;
    }

    public String getType() {
        return type;
    }

    public Function getFunction() {
        return function;
    }

    @Override
    public Object tool_choice() {
        return this;
    }

}
