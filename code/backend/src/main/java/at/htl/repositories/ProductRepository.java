package at.htl.repositories;

import at.htl.entities.Product;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {

    public Product findByName(String name){
        return find("name = ?1", name).firstResult();
    }

    @Transactional
    public Product insertProduct(Product newProduct){
        return getEntityManager().merge(newProduct);
    }
}
