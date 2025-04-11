package retail.expert.salesanalysis.service.finance;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import retail.expert.salesanalysis.dto.finance.CreateFinanceDto;
import retail.expert.salesanalysis.dto.finance.FinanceDto;
import retail.expert.salesanalysis.dto.finance.UpdateFinanceDto;
import retail.expert.salesanalysis.exception.SalesAnalysisException;
import retail.expert.salesanalysis.mapper.FinanceMapper;
import retail.expert.salesanalysis.model.PriceEntity;
import retail.expert.salesanalysis.model.ProductsEntity;
import retail.expert.salesanalysis.repository.FinanceRepository;
import retail.expert.salesanalysis.repository.ProductsRepository;

@Service
@RequiredArgsConstructor
public class FinanceService implements IFinanceService {
    private final FinanceRepository financeRepository;
    private final ProductsRepository productsRepository;
    private final FinanceMapper financeMapper;

    @Transactional
    public Long createPrice(CreateFinanceDto dto) {
        try {
            ProductsEntity productsEntity = productsRepository.findById(dto.getProductId())
                    .orElseThrow(() -> new SalesAnalysisException("", HttpStatus.NOT_FOUND));
            PriceEntity priceEntity = financeMapper.toPriceEntity(dto);
            priceEntity.setProduct(productsEntity);
            return financeRepository.saveAndFlush(priceEntity).getId();
        } catch (DataIntegrityViolationException e) {
            throw new SalesAnalysisException("Failed to create Price", HttpStatus.CONFLICT);
        }
    }

    @Transactional
    public Long updatePrice(UpdateFinanceDto dto) {
        try {
            PriceEntity priceEntity = getPriceEntity(dto.getId());
            priceEntity.setPrice(dto.getPrice());
            priceEntity.setNetworkName(dto.getNetworkName());
            financeRepository.save(priceEntity);
            return priceEntity.getId();
        } catch (DataIntegrityViolationException e) {
            throw new SalesAnalysisException("Failed to update Price", HttpStatus.CONFLICT);
        }
    }

    @Transactional(readOnly = true)
    public FinanceDto getPrice(Long id) {
        PriceEntity priceEntity = getPriceEntity(id);
        return financeMapper.toFinanceDto(priceEntity);
    }

    public void deletePrice(Long id) {
        financeRepository.deleteById(id);
    }

    private PriceEntity getPriceEntity(Long id) {
        return financeRepository.findById(id).orElseThrow(
                () -> new SalesAnalysisException("Price not found", HttpStatus.NOT_FOUND));
    }
}
