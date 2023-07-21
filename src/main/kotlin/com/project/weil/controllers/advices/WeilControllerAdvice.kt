package com.project.weil.controllers.advices

import org.springframework.http.HttpStatus
import org.springframework.jms.JmsException
import org.springframework.messaging.support.ErrorMessage
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest

@RestControllerAdvice
class WeilControllerAdvice {

    @ExceptionHandler(JmsException::class)
    @ResponseStatus(HttpStatus.CONFLICT)
    fun handleJmsException(ex: JmsException, request: WebRequest): ErrorMessage = ErrorMessage(ex)

    @ExceptionHandler(RuntimeException::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleRuntimeException(ex: RuntimeException, request: WebRequest): ErrorMessage = ErrorMessage(ex)

}