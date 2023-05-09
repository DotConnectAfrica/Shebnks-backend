package com.md.shebanks.util.handler

import org.springframework.http.HttpStatus
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import java.util.*


@RestControllerAdvice
@EnableWebMvc
class AppExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handlerInvalidArg(e: MethodArgumentNotValidException): Map<String, String> {
        val errorMap = hashMapOf<String, String>()
        e.bindingResult.fieldErrors.forEach { error ->
            errorMap[error.field] = error.defaultMessage.toString()
        }
        return errorMap
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AppException::class)
    fun fieldValidationHandler(e: AppException): ErrorModel {
        return ErrorModel(
            status = HttpStatus.BAD_REQUEST,
            timestamp = Date(),
            message = e.localizedMessage,
        )
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun nullHandler(e: HttpMessageNotReadableException): Map<String, String> {
        val errorMap = hashMapOf<String, String>()
        errorMap["error"] = e.message.toString()
        return errorMap
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AuthenticationException::class)
    fun authExceptionHandler(e: AuthenticationException): ErrorModel {
        return ErrorModel(
            status = HttpStatus.BAD_REQUEST,
            timestamp = Date(),
            message = e.localizedMessage
        )
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException::class)
    fun illegalArgumentExceptionHandler(e: IllegalArgumentException): ErrorModel {
        return ErrorModel(
            status = HttpStatus.BAD_REQUEST,
            timestamp = Date(),
            message = e.localizedMessage
        )
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NoSuchElementException::class)
    fun noSuchElementExceptionHandler(e: NoSuchElementException): ErrorModel {
        return ErrorModel(
            status = HttpStatus.BAD_REQUEST,
            timestamp = Date(),
            message = e.localizedMessage
        )
    }



    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UsernameNotFoundException::class)
    fun usernameNotFoundExceptionHandler(e: UsernameNotFoundException): ErrorModel {
        return ErrorModel(
            status = HttpStatus.BAD_REQUEST,
            timestamp = Date(),
            message = e.localizedMessage
        )
    }
}