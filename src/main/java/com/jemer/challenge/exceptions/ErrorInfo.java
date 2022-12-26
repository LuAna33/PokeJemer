package com.jemer.challenge.exceptions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
public class ErrorInfo {

    private String message;

    public ErrorInfo(String mensaje) {
        this.message = mensaje;
    }

    public String getMessage() {
        return message;
    }

}

