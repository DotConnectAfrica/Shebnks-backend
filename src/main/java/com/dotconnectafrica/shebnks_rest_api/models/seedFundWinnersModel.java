package com.dotconnectafrica.shebnks_rest_api.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigInteger;

@Entity
@Data
@NoArgsConstructor
@Table(name = "seed_fund_winners")
public class seedFundWinnersModel {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "winner_id")
    private BigInteger winner_id;

    @Column(name = "winner_title")
    @Size(max = 50)
    private String winner_title;

    @Column(name = "winner_image_link")
    @Size(max = 200)
    private String winner_image_link;

    @Column(name = "winner_info")
    @Size(max = 200)
    private String winner_info;

    @Column(name = "winner_article_link")
    @Size(max = 200)
    private String winner_article_link;

    @Column(name = "winning_year")
    @Size(max = 50)
    private String winning_year;

}
