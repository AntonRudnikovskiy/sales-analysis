package retail.expert.salesanalysis.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import retail.expert.salesanalysis.dto.finance.CreateFinanceDto;
import retail.expert.salesanalysis.dto.finance.FinanceDto;
import retail.expert.salesanalysis.dto.finance.UpdateFinanceDto;
import retail.expert.salesanalysis.service.finance.FinanceService;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/finance")
public class FinanceController {
    private final FinanceService financeService;

    @PostMapping("/")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Long> createPrice(@RequestBody CreateFinanceDto createFinanceDto) {
        return ResponseEntity.ok(financeService.createPrice(createFinanceDto));
    }

    @PutMapping("/")
    public ResponseEntity<Long> updatePrice(@RequestBody UpdateFinanceDto updateFinanceDto) {
        return ResponseEntity.ok(financeService.updatePrice(updateFinanceDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FinanceDto> getPrice(@PathVariable("id") Long id) {
        return ResponseEntity.ok(financeService.getPrice(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrice(@PathVariable("id") Long id) {
        financeService.deletePrice(id);
        return ResponseEntity.noContent().build();
    }
}
