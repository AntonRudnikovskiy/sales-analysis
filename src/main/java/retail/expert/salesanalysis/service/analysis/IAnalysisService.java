package retail.expert.salesanalysis.service.analysis;

import retail.expert.salesanalysis.dto.analysis.DailyActual;
import retail.expert.salesanalysis.dto.analysis.DailyActualView;
import retail.expert.salesanalysis.dto.analysis.SalesAnalysisView;

import java.util.List;

public interface IAnalysisService {
    List<SalesAnalysisView> getSalesAnalysis();

    List<DailyActualView> getDailyActualByNetworkAndProduct(DailyActual dailyActual);
}
