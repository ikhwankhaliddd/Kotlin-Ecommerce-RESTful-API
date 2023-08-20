package valconai.kotlin.restful.api.service

import valconai.kotlin.restful.api.model.*

interface ProductService {
    fun create(createProductRequest: CreateProductRequest) : ProductResponse
    fun getById(ID: String) : ProductResponse
    fun update(updateProductRequest: UpdateProductRequest, id : String) : ProductResponse
    fun delete(id : String)
    fun getAll(getProductsRequest: GetProductListRequest) : List<ProductResponse>
}