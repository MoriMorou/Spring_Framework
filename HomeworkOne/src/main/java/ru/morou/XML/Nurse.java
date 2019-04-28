package ru.morou.XML;

import ru.morou.Classic.CentralRegistry;
import ru.morou.Classic.Doctor;
import ru.morou.Classic.Registry;
import ru.morou.Classic.Therapist;

public class Nurse {

    /**
     * Метод запрашивает в регистратуре нужного доктора
     * @return registry
     */
    public Registry getRegistry() {
        System.out.println("Hello, I need a doctor");
        ru.morou.Classic.CentralRegistry registry = new CentralRegistry();
        Doctor doctor1 = new Therapist();
        registry.setDoctors(doctor1);
        return registry;
    }
}
