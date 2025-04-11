package retail.expert.salesanalysis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import retail.expert.salesanalysis.dto.analysis.DailyActualView;
import retail.expert.salesanalysis.dto.analysis.SalesAnalysisView;
import retail.expert.salesanalysis.model.ActualEntity;

import java.util.List;

@Repository
public interface AnalysisRepository extends JpaRepository<ActualEntity, Long> {

    @Query(value = """
            SELECT 
                c.network_name AS networkName,
                p.category AS category,
                DATE_TRUNC('month', a.delivery_date) AS month,
                SUM(CASE WHEN a.promo_flag = 'Regular' THEN 1 ELSE 0 END) AS regularCount,
                SUM(CASE WHEN a.promo_flag = 'Promo' THEN 1 ELSE 0 END) AS promoCount,
                (SUM(CASE WHEN a.promo_flag = 'Promo' THEN 1.0 ELSE 0 END) * 100.0) / COUNT(*) AS promoSharePercent
            FROM actuals a
            JOIN customers c ON a.customer_id = c.id
            JOIN products p ON a.product_id = p.id
            GROUP BY c.network_name, p.category, DATE_TRUNC('month', a.delivery_date)
            """, nativeQuery = true)
    List<SalesAnalysisView> getSalesAnalysis();


    @Query(value = """
            SELECT 
                a.delivery_date, 
                c.network_name, 
                p.name, 
                COUNT(*) AS count
            FROM actuals a
            JOIN customers c ON a.customer_id = c.id
            JOIN products p ON a.product_id = p.id
            WHERE c.network_name IN :networkNames
              AND p.name IN :productNames
            GROUP BY a.delivery_date, c.network_name, p.name
            ORDER BY a.delivery_date
            """, nativeQuery = true)
    List<DailyActualView> findDailyActual(@Param("networkNames") List<String> networkNames,
                                          @Param("productNames") List<String> productNames);

}
