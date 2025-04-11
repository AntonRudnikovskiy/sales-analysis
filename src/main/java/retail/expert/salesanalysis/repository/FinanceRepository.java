package retail.expert.salesanalysis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import retail.expert.salesanalysis.model.PriceEntity;

@Repository
public interface FinanceRepository extends JpaRepository<PriceEntity, Long> {
}
