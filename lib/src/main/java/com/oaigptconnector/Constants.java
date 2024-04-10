package com.oaigptconnector;

import java.net.URI;

public final class Constants {

    /* OpenAI Constants */
    public static URI OPENAI_CHAT_COMPLETION_URI = URI.create("https://api.openai.com/v1/chat/completions");
    public static URI OPENAI_IMAGE_GENERATION_URI = URI.create("https://api.openai.com/v1/images/generations");
    public static URI OPENAI_SPEECH_GENERATION_URI = URI.create("https://api.openai.com/v1/audio/speech");
    public static URI OPENAI_SPEECH_TRANSCRIPTION_URI = URI.create("https://api.openai.com/v1/audio/transcriptions");
    public static long AI_TIMEOUT_MINUTES = 4;

}
