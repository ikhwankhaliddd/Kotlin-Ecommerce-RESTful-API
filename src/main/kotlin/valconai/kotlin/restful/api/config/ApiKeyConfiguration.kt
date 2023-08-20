package valconai.kotlin.restful.api.config

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import valconai.kotlin.restful.api.entity.ApiKey
import valconai.kotlin.restful.api.repository.ApiKeyRepository

@Component
class ApiKeyConfiguration(val apiKeyRepository: ApiKeyRepository) : ApplicationRunner {
    val apiKey = "Secret-Key"
    override fun run(args: ApplicationArguments?) {
        if(!apiKeyRepository.existsById(apiKey)){
            val entity = ApiKey(id = apiKey)
            apiKeyRepository.save(entity)
        }
    }

}