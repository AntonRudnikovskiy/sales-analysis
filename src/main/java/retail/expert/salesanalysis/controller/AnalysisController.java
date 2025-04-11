package retail.expert.salesanalysis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import retail.expert.salesanalysis.dto.analysis.DailyActual;
import retail.expert.salesanalysis.dto.analysis.DailyActualView;
import retail.expert.salesanalysis.dto.analysis.SalesAnalysisView;
import retail.expert.salesanalysis.service.analysis.AnalysisService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/analysis")
public class AnalysisController {
    private final AnalysisService analysisService;

    @GetMapping("/")
    public ResponseEntity<List<SalesAnalysisView>> getSalesAnalysis() {
        return ResponseEntity.ok(analysisService.getSalesAnalysis());
    }

    @GetMapping("/daily")
    public ResponseEntity<List<DailyActualView>> getDailyActual(@RequestBody DailyActual dailyActual) {
        return ResponseEntity.ok(analysisService.getDailyActualByNetworkAndProduct(dailyActual));
    }
}
