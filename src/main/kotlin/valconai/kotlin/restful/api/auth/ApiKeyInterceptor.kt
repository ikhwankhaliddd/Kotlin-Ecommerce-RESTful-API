package valconai.kotlin.restful.api.auth

import org.springframework.stereotype.Component
import org.springframework.ui.ModelMap
import org.springframework.web.context.request.WebRequest
import org.springframework.web.context.request.WebRequestInterceptor
import valconai.kotlin.restful.api.error.NotFoundUnauthorizedException
import valconai.kotlin.restful.api.repository.ApiKeyRepository
import java.lang.Exception

@Component
class ApiKeyInterceptor(val apiKeyRepository: ApiKeyRepository) : WebRequestInterceptor {
    override fun preHandle(request: WebRequest) {
        val apiKey = request.getHeader("X-Api-Key")
        if(apiKey == null){
            throw NotFoundUnauthorizedException()
        }
        if(!apiKeyRepository.existsById(apiKey)){
            throw NotFoundUnauthorizedException()
        }

        // Valid
    }

    override fun postHandle(request: WebRequest, model: ModelMap?) {

    }

    override fun afterCompletion(request: WebRequest, ex: Exception?) {

    }

}