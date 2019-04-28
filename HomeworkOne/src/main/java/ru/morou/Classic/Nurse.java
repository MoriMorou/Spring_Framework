package ru.morou.Classic;

public class Nurse {

    /**
     * Метод запрашивает в регистратуре нужного доктора
     * @return registry
     */
    public Registry getRegistry() {
        CentralRegistry registry = new CentralRegistry();
        Doctor doctor1 = new Therapist();
        registry.setDoctors(doctor1);
        return registry;
    }
}
