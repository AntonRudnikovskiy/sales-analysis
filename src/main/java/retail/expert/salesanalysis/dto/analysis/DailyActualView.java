package retail.expert.salesanalysis.dto.analysis;

import java.time.LocalDate;

public interface DailyActualView {
    LocalDate getDeliveryDate();

    String getNetworkName();

    String getProductName();

    Long getShipmentCount();
}



