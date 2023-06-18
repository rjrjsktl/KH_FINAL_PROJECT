package com.kh.kgv.management.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class banner {
    private int screenNo;
    private String cinemaName;
    private int screenName;
    private String screenStyle;
    private int screenSeat;
    private String screenDetail;
}
