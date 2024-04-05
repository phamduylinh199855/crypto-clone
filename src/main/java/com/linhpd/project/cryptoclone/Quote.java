package com.linhpd.project.cryptoclone;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class Quote {
    private double price;
    private double volume_24h;
    private double volume_change_24h;
    private double percent_change_1h;
    private double percent_change_24h;
    private double percent_change_7d;
    private double percent_change_30d;
    private double percent_change_60d;
    private double percent_change_90d;
    private double market_cap;
    private double market_cap_dominance;
    private double fully_diluted_market_cap;
    private Object tvl;
    private String last_updated;

}
