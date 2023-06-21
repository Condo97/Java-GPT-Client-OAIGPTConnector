package com.oaigptconnector;

import com.oaigptconnector.model.http.client.openaigpt.Role;

import java.net.URI;

public final class Constants {

    /* OpenAI Constants */
    public static URI OPENAI_URI = URI.create("https://api.openai.com/v1/chat/completions");
    public static long AI_TIMEOUT_MINUTES = 4;

}
