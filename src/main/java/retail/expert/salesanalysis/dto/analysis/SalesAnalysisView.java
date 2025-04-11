package retail.expert.salesanalysis.dto.analysis;

import java.time.Instant;

public interface SalesAnalysisView {
    String getNetworkName();

    String getCategory();

    Instant getMonth();

    Long getRegularCount();

    Long getPromoCount();

    Double getPromoSharePercent();
}
