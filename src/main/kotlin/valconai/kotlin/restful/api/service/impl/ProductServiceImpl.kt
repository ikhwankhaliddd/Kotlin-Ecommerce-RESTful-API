package valconai.kotlin.restful.api.service.impl

import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import valconai.kotlin.restful.api.entity.Product
import valconai.kotlin.restful.api.error.NotFoundException
import valconai.kotlin.restful.api.model.*
import valconai.kotlin.restful.api.repository.ProductRepository
import valconai.kotlin.restful.api.service.ProductService
import valconai.kotlin.restful.api.validation.ValidationUtil
import java.util.*
import java.util.stream.Collectors

@Service
class ProductServiceImpl(
    val productRepository: ProductRepository,
    val validationUtil: ValidationUtil
) : ProductService {

    override fun create(createProductRequest: CreateProductRequest): ProductResponse {
        validationUtil.validate(createProductRequest)
        val product = Product(
            id = createProductRequest.id!!,
            name = createProductRequest.name!!,
            price = createProductRequest.price!!,
            quantity = createProductRequest.quantity!!,
            createdAt = Date(),
            updatedAt = null
        )
        val previousID = productRepository.existsById(product.id)

        if(previousID){
            val updatedProduct = (product.copy(
                id = product.id,
                name = product.name,
                price = product.price,
                quantity = product.quantity,
                createdAt = product.createdAt,
                updatedAt = Date()
            ))

            productRepository.save(updatedProduct)
            return ProductResponse(
                id = updatedProduct.id,
                name = updatedProduct.name,
                price = updatedProduct.price,
                quantity = updatedProduct.quantity,
                createdAt = updatedProduct.createdAt,
                updatedAt = updatedProduct.updatedAt
        )
        }

        productRepository.save(product)

        return convertProductToProductResponse(product)
    }

    override fun getById(ID: String): ProductResponse {
        val product = productRepository.findByIdOrNull(ID)

        if(product == null) {
            throw NotFoundException()
        }else{
            return convertProductToProductResponse(product)
        }

    }

    override fun update(updateProductRequest: UpdateProductRequest, id: String): ProductResponse {
        val product = productRepository.findByIdOrNull(id)

        if(product == null){
            throw NotFoundException()
        }
        product.apply {
            name = updateProductRequest.name!!
            price = updateProductRequest.price!!
            quantity = updateProductRequest.quantity!!
            updatedAt = Date()
        }
        val updatedProduct = productRepository.save(product)
        return convertProductToProductResponse(updatedProduct)
    }

    override fun delete(id: String) {
        val isExist = productRepository.existsById(id)
        if(!isExist){
            throw NotFoundException()
        }
        productRepository.deleteById(id)
    }

    override fun getAll(getProductsRequest: GetProductListRequest): List<ProductResponse> {
        val productList = productRepository.findAll(PageRequest.of(getProductsRequest.page, getProductsRequest.limit))
        val products : List<Product> = productList.get().collect(Collectors.toList())

        return products.map {
            convertProductToProductResponse(it)
        }
    }


    private fun convertProductToProductResponse(product: Product) : ProductResponse{
        return ProductResponse(
            id = product.id,
            name = product.name,
            price = product.price,
            quantity = product.quantity,
            createdAt = product.createdAt,
            updatedAt = product.updatedAt
        )
    }
}