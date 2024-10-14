package com.rodiugurlu.starter.exception;

import com.rodiugurlu.starter.exception.MessageType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage {
    private MessageType messageType;
    private String ofStatic;

    public String prepareErrorMessage() {
        StringBuilder builder = new StringBuilder();
        builder.append(messageType.getMessage());  // MessageType üzerinden mesajı al
        if (ofStatic != null) {
            builder.append(" : ").append(ofStatic);  // Ekstra bilgi varsa ekle
        }
        return builder.toString();
    }
}
