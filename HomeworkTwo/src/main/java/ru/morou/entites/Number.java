package ru.morou.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.function.BiFunction;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Number {

    private int A;
    private int B;

    BiFunction<Integer, Integer, Integer> function = (A, B) -> A + B;
}