package com.innova.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Log4j2
public class InnovaValidationDto {

    @NotEmpty(message = "Username alanı bos gecilemez")
    private String userName;

    @NotEmpty(message = "Usersurname alanı bos gecilemez")
    private String userSurname;

    @NotEmpty(message = "Email alanı bos gecilemez")
    @Email(message = "uygun formatta mail giriniz")
    private String emailAddress;

    @Min(value = 18, message = "18 yasından kücüksünüz bu yüzden basvuramazsınız")
    @Max(value = 45, message = "45 yasından büyüksünüz bu yüzden basvuramazsınız")
    private int userAge;

    @NotEmpty(message = "Message alanı bos gecilemez")
    @Size(min=1, max=255)
    private String userMessage;
}
