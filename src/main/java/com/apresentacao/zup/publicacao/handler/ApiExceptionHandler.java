package com.apresentacao.zup.publicacao.handler;

import com.apresentacao.zup.publicacao.domain.ErrorMessage;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ApiExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handlerMethodException(Exception exception, HttpServletRequest request) {

        ErrorMessage error = ErrorMessage.builder()
                .setTimestamp(System.currentTimeMillis())
                .setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .setMessage(exception.getMessage())
                .setPath(request.getRequestURI())
                .build();

//        logger.error("[ERROR] payload={}", error, exception);

        return ResponseEntity.internalServerError().body(error);
    }

}
