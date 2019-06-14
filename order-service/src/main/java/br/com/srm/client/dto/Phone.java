package br.com.srm.client.dto;

import lombok.*;
import java.io.Serializable;

@Data
public class Phone implements Serializable {

    private Long id;
    private String name;
    private Integer amount;

}
