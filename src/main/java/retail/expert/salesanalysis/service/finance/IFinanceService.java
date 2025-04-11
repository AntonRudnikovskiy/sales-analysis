package retail.expert.salesanalysis.service.finance;

import retail.expert.salesanalysis.dto.finance.CreateFinanceDto;
import retail.expert.salesanalysis.dto.finance.FinanceDto;
import retail.expert.salesanalysis.dto.finance.UpdateFinanceDto;

public interface IFinanceService {
    Long createPrice(CreateFinanceDto dto);
    Long updatePrice(UpdateFinanceDto dto);
    FinanceDto getPrice(Long id);
    void deletePrice(Long id);
}
