package valconai.kotlin.restful.api.model

import jakarta.validation.constraints.NotBlank

data class GetProductRequest (
    @field: NotBlank
    val Id : String?
)