package com.oaigptconnector.model.response.chat.completion.http;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OAIGPTChatCompletionResponseUsage {
    private Integer prompt_tokens, completion_tokens, total_tokens;

    public OAIGPTChatCompletionResponseUsage() {

    }
    public OAIGPTChatCompletionResponseUsage(Integer prompt_tokens, Integer completion_tokens, Integer total_tokens) {
        this.prompt_tokens = prompt_tokens;
        this.completion_tokens = completion_tokens;
        this.total_tokens = total_tokens;
    }

    public Integer getPrompt_tokens() {
        return prompt_tokens;
    }

    public Integer getCompletion_tokens() {
        return completion_tokens;
    }

    public Integer getTotal_tokens() {
        return total_tokens;
    }

    public void setPrompt_tokens(Integer prompt_tokens) {
        this.prompt_tokens = prompt_tokens;
    }

    public void setCompletion_tokens(Integer completion_tokens) {
        this.completion_tokens = completion_tokens;
    }

    public void setTotal_tokens(Integer total_tokens) {
        this.total_tokens = total_tokens;
    }


    @Override
    public String toString() {
        return "OAIGPTChatCompletionResponseUsage{" +
                "prompt_tokens=" + prompt_tokens +
                ", completion_tokens=" + completion_tokens +
                ", total_tokens=" + total_tokens +
                '}';
    }

}
