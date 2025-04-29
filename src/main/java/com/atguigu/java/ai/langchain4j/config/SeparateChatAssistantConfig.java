package com.atguigu.java.ai.langchain4j.config;

import com.atguigu.java.ai.langchain4j.store.MongoChatMemoryStore;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.store.memory.chat.InMemoryChatMemoryStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SeparateChatAssistantConfig {
    @Autowired
    private MongoChatMemoryStore mongoChatMemoryStore;
    @Bean
    public ChatMemoryProvider chatMemoryProvider() {

        return memoryId -> MessageWindowChatMemory
                .builder()
                .id(memoryId)
                .maxMessages(10)
                .chatMemoryStore(mongoChatMemoryStore)
                .build();
    }

//    @Bean
//    public ChatMemoryProvider chatMemoryProvider() {
//        // 使用匿名内部类实现 ChatMemoryProvider 接口
//        return new ChatMemoryProvider() {
//            @Override
//            public MessageWindowChatMemory get(Object memoryId) {
//                // 创建并返回一个 MessageWindowChatMemory 实例
//                return MessageWindowChatMemory.builder()
//                        .id(memoryId)          // 设置 memoryId
//                        .maxMessages(10)       // 设置最大消息数为10
//                        .build();              // 构建对象
//            }
//        };
//    }
}
