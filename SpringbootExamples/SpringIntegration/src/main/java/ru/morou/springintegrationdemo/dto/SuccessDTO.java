package ru.morou.springintegrationdemo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@XmlRootElement
public class SuccessDTO extends ResultDTO {

    {
        setSuccess(true);
    }

}
