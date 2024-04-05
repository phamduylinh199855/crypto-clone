package com.linhpd.project.cryptoclone;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Builder
@Setter
@Getter
public class CryptoData {
    private int id;
    private String name;
    private String symbol;
    private String slug;
    private int num_market_pairs;
    private String date_added;
    private List<String> tags;
    private double max_supply;
    private double circulating_supply;
    private double total_supply;
    private boolean infinite_supply;
    private Object platform;
    private int cmc_rank;
    private Object self_reported_circulating_supply;
    private Object self_reported_market_cap;
    private Object tvl_ratio;
    private String last_updated;
    private Map<String, Quote> quote;


}
