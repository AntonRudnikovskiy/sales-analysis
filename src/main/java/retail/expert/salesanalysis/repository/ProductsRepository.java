package retail.expert.salesanalysis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import retail.expert.salesanalysis.model.ProductsEntity;

@Repository
public interface ProductsRepository extends JpaRepository<ProductsEntity, Long> {
}
