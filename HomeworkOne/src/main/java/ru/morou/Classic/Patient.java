package ru.morou.Classic;

/**
 * 1 Создать модель Пациент - поликлиника (используя Spring)
 * 2 Использовать 3 варианта: xml, javaConfig, autowired.
 *
 * @author asatyukova (Mori Morou)
 */
public class Patient {

    /**
     * Inversion control - это передача управления (мы передали управление медсестре для поиска доктора)
     * Dependency injection - это внедрение зависимостей
     * Bean - это экземпляр класса, который создал spring
     * Основной метод - медсестра через центральную регистратуру ищет доктора
     * @param args
     */
    public static void main(String[] args) {
        Nurse nurse = new Nurse();
        Registry registry = nurse.getRegistry();
        registry.findDoctor();
    }
}
