//package com.oaigptconnector.model;
//
//import com.oaigptconnector.model.request.chat.completion.OAIChatCompletionRequestMessage;
//import com.oaigptconnector.model.request.chat.completion.content.OAIChatCompletionRequestMessageContent;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class OAIChatCompletionRequestMessagesBuilder_Legacy {
//
//    private List<OAIChatCompletionRequestMessage> messages;
//
//    public OAIChatCompletionRequestMessagesBuilder_Legacy() {
//        messages = new ArrayList<>();
//    }
//
//    public OAIChatCompletionRequestMessagesBuilder_Legacy addAssistant(List<OAIChatCompletionRequestMessageContent> content) {
//        messages.add(new OAIChatCompletionRequestMessage(CompletionRole.ASSISTANT, content));
//
//        return this;
//    }
//
//    public OAIChatCompletionRequestMessagesBuilder_Legacy addSystem(List<OAIChatCompletionRequestMessageContent> content) {
//        messages.add(new OAIChatCompletionRequestMessage(CompletionRole.SYSTEM, content));
//
//        return this;
//    }
//
//    public OAIChatCompletionRequestMessagesBuilder_Legacy addUser(List<OAIChatCompletionRequestMessageContent> content) {
//        messages.add(new OAIChatCompletionRequestMessage(CompletionRole.USER, content));
//
//        return this;
//    }
//
//    public List<OAIChatCompletionRequestMessage> build() {
//        return messages;
//    }
//
//}
