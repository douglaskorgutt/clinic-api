package org.korgut.clinicapi.domain.admin.infra.spring;


import org.korgut.clinicapi.domain.admin.core.facades.DoctorFacade;
import org.korgut.clinicapi.domain.admin.core.ports.incoming.CreateDoctor;
import org.korgut.clinicapi.domain.admin.core.ports.outgoing.DoctorDatabase;
import org.korgut.clinicapi.domain.admin.core.ports.outgoing.HealthInsuranceDatabase;
import org.korgut.clinicapi.domain.admin.infra.adapter.DoctorDatabaseAdapter;
import org.korgut.clinicapi.domain.admin.infra.adapter.HealthInsuranceDatabaseAdapter;
import org.korgut.clinicapi.domain.admin.infra.repository.DoctorRepository;
import org.korgut.clinicapi.domain.admin.infra.repository.HealthInsuranceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "org.korgut.clinicapi.domain.admin.infra.repository")
public class AdminDependencyInjectionConfiguration {

    @Bean
    public CreateDoctor createDoctor(HealthInsuranceDatabase healthInsuranceDatabase, DoctorDatabase doctorDatabase) {
        return new DoctorFacade(healthInsuranceDatabase, doctorDatabase);
    }

    @Bean
    public HealthInsuranceDatabase createHealthInsuranceDatabase(HealthInsuranceRepository healthInsuranceRepository) {
        return new HealthInsuranceDatabaseAdapter(healthInsuranceRepository);
    }

    @Bean
    public DoctorDatabase createDoctorDatabase(DoctorRepository doctorRepository) {
        return new DoctorDatabaseAdapter(doctorRepository);
    }
}
