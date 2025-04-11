package retail.expert.salesanalysis.mapper;

import org.springframework.stereotype.Component;
import retail.expert.salesanalysis.dto.finance.CreateFinanceDto;
import retail.expert.salesanalysis.dto.finance.FinanceDto;
import retail.expert.salesanalysis.model.PriceEntity;

@Component
public class FinanceMapper {

    public PriceEntity toPriceEntity(CreateFinanceDto createFinanceDto) {
        return PriceEntity.builder()
                .networkName(createFinanceDto.getNetworkName())
                .price(createFinanceDto.getPrice())
                .build();
    }

    public FinanceDto toFinanceDto(PriceEntity priceEntity) {
        return FinanceDto.builder()
                .networkName(priceEntity.getNetworkName())
                .price(priceEntity.getPrice())
                .build();
    }
}
