package com.oaigptconnector.model.request.chat.completion;

public class OAIChatCompletionRequestToolChoiceFunction {

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

    private OAIChatCompletionRequestToolType type = OAIChatCompletionRequestToolType.FUNCTION;
    private Function function;

    public OAIChatCompletionRequestToolChoiceFunction() {

    }

    public OAIChatCompletionRequestToolChoiceFunction(Function function) {
        this.function = function;
    }

    public OAIChatCompletionRequestToolType getType() {
        return type;
    }

    public Function getFunction() {
        return function;
    }

}
