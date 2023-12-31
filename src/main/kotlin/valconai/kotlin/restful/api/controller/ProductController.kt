package valconai.kotlin.restful.api.controller

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import valconai.kotlin.restful.api.model.*
import valconai.kotlin.restful.api.service.ProductService

@RestController
class ProductController(val productService: ProductService){

    @PostMapping(
        value = ["/api/products"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createProduct(@RequestBody  body: CreateProductRequest): WebResponse<ProductResponse>{
        val productResponse = productService.create(body)

        return WebResponse(
            code = 200,
            status = "OK",
            data = productResponse
        )
    }

    @GetMapping(
        value = ["/api/product/{id}"],
        produces = ["application/json"]
    )
    fun getProduct(@PathVariable("id") id : String) : WebResponse<ProductResponse>{
        val productResponse = productService.getById(id)

        return WebResponse(
            code = 200,
            status = "OK",
            data = productResponse
        )
    }

    @PutMapping(
        value = ["/api/product/{id}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateProduct(@RequestBody body: UpdateProductRequest, @PathVariable("id") id : String) : WebResponse<ProductResponse>{
        val productResponse = productService.update(body, id)

        return WebResponse(
            code = 200,
            status = "OK",
            data = productResponse
        )
    }
    @DeleteMapping(
        value = ["/api/product/{id}"],
        produces = ["application/json"]
    )
    fun deleteProduct(@PathVariable("id") id : String) : WebResponse<String>{
        productService.delete(id)

        return WebResponse(
            code = 200,
            status = "OK",
            data = id
        )
    }

    @GetMapping(
        value = ["/api/products"],
        produces = ["application/json"]
    )
    fun getListProduct(@RequestParam(value = "page", defaultValue = "0") page: Int, @RequestParam(value = "limit", defaultValue = "10") limit: Int) : WebResponse<List<ProductResponse>>{
        val request = GetProductListRequest(page, limit)
        val response = productService.getAll(request)
        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )
    }
}