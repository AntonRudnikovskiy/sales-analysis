package retail.expert.salesanalysis.service.analysis;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import retail.expert.salesanalysis.dto.analysis.DailyActual;
import retail.expert.salesanalysis.dto.analysis.DailyActualView;
import retail.expert.salesanalysis.dto.analysis.SalesAnalysisView;
import retail.expert.salesanalysis.exception.SalesAnalysisException;
import retail.expert.salesanalysis.repository.AnalysisRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnalysisService implements IAnalysisService {
    private final AnalysisRepository analysisRepository;

    @Transactional(readOnly = true)
    public List<SalesAnalysisView> getSalesAnalysis() {
        try {
            return analysisRepository.getSalesAnalysis();
        } catch (DataIntegrityViolationException e) {
            throw new SalesAnalysisException("Failed to retrieve", HttpStatus.CONFLICT);
        }
    }

    @Transactional(readOnly = true)
    public List<DailyActualView> getDailyActualByNetworkAndProduct(DailyActual dailyActual) {
        try {
            return analysisRepository.findDailyActual(dailyActual.getNetworkNames(), dailyActual.getProductNames());
        } catch (DataIntegrityViolationException e) {
            throw new SalesAnalysisException("Failed to retrieve", HttpStatus.CONFLICT);
        }
    }
}
