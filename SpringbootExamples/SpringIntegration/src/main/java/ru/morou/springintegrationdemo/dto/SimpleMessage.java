package ru.morou.springintegrationdemo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Nullable;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Data
@NoArgsConstructor
@XmlRootElement
public class SimpleMessage {

    @Nullable
    private Date date = new Date();

}
