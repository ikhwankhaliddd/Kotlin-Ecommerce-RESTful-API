package valconai.kotlin.restful.api.repository

import org.springframework.data.jpa.repository.JpaRepository
import valconai.kotlin.restful.api.entity.Product

interface ProductRepository : JpaRepository<Product, String> {

}