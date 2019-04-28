package ru.morou.javaConfig;

public class Nurse {

    /**
     * Метод запрашивает в регистратуре нужного доктора
     * @return registry
     */
    public Registry getRegistry() {
        System.out.println("Hello, I need a doctor");
        CentralRegistry registry = new CentralRegistry();
        Doctor doctor1 = new Therapist();
        registry.setDoctors(doctor1);
        return registry;
    }
}
