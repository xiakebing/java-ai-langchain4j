package com.atguigu.java.ai.langchain4j.config;

import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemoryChatAssistantConfig {
    @Bean
    public  MessageWindowChatMemory chatMemory(){
        MessageWindowChatMemory chatMemory = MessageWindowChatMemory.withMaxMessages(10);
        return chatMemory;
    }
}
