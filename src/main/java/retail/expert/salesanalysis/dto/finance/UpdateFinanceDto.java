package retail.expert.salesanalysis.dto.finance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateFinanceDto {
    private Long id;
    private String networkName;
    private BigDecimal price;
}
