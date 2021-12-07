package com.gabrieljuliao.personapi.dto;

import com.gabrieljuliao.personapi.enums.PhoneType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDTO {
    private Long id;
    private PhoneType type;
    private String number;
}
