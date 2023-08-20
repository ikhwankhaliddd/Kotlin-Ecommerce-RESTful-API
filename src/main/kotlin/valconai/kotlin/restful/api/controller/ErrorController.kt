package valconai.kotlin.restful.api.controller

import jakarta.validation.ConstraintViolationException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import valconai.kotlin.restful.api.error.NotFoundException
import valconai.kotlin.restful.api.error.NotFoundUnauthorizedException
import valconai.kotlin.restful.api.model.WebResponse

@RestControllerAdvice
class ErrorController {

    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(constraintViolationException: ConstraintViolationException) : WebResponse<String>{
        return WebResponse(
            code = 400,
            status = "Bad Request",
            data = constraintViolationException.message!!
        )
    }

    @ExceptionHandler(value = [NotFoundException::class])
    fun notFound(notFoundException: NotFoundException) : WebResponse<String>{
        return WebResponse(
            code = 404,
            status = "Not Found",
            data = "data not found"
        )
    }

    @ExceptionHandler(value = [NotFoundUnauthorizedException::class])
    fun unauthorized(notFoundUnauthorizedException: NotFoundUnauthorizedException) : WebResponse<String>{
        return WebResponse(
            code = 401,
            status = "Unauthorized",
            data = "Please put your X-Api-Key"
        )
    }
}