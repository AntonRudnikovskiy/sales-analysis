package retail.expert.salesanalysis.dto.finance;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FinanceDto {
    private Long id;
    private String networkName;
    private BigDecimal price;
}
