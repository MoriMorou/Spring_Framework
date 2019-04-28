package ru.morou.Classic;

/**
 * 1 Создать модель Пациент - поликлиника (используя Spring)
 * 2 Использовать 3 варианта: xml, javaConfig, autowired.
 *
 * @author asatyukova (Mori Morou)
 */
public class Patient {

    /**
     * основной метод - медсестра через центральную регистратуру ищет доктора
     * @param args
     */
    public static void main(String[] args) {
        Nurse nurse = new Nurse();
        Registry registry = nurse.getRegistry();
        registry.findDoctor();
    }
}
