package valconai.kotlin.restful.api.model

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

data class UpdateProductRequest (
    @field: NotBlank
    var name : String?,

    @field:NotNull
    var price: Long?,

    @field:NotNull
    var quantity: Int?
)