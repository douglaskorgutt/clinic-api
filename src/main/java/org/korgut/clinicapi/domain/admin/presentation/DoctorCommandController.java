package org.korgut.clinicapi.domain.admin.presentation;


import org.korgut.clinicapi.domain.admin.core.model.commands.doctor.CreateDoctorCommand;
import org.korgut.clinicapi.domain.admin.core.model.exceptions.CrudException;
import org.korgut.clinicapi.domain.admin.core.model.results.doctor.DoctorHasBeenCreated;
import org.korgut.clinicapi.domain.admin.core.ports.incoming.doctor.CreateDoctor;
import org.korgut.clinicapi.domain.admin.presentation.dto.inbound.CreateDoctorInboundDto;
import org.korgut.clinicapi.domain.admin.presentation.dto.outbound.CreateDoctorOutboundDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController("doctor")
public class DoctorCommandController {
    private final CreateDoctor createDoctor;

    public DoctorCommandController(CreateDoctor createDoctor) {
        this.createDoctor = createDoctor;
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateDoctorOutboundDto> createDoctor(@RequestBody CreateDoctorInboundDto body) throws CrudException {
        // Create Command out of DTO
        CreateDoctorCommand createDoctorCommand = new CreateDoctorCommand(
                body.commandId(),
                body.firstName(),
                body.lastName(),
                body.specialty(),
                body.healthInsuranceId()
        );

        // Create doctor
        DoctorHasBeenCreated result = (DoctorHasBeenCreated) createDoctor.execute(createDoctorCommand);

        return ResponseEntity.ok().body(new CreateDoctorOutboundDto(result.getCommandId(), result.getDoctorId(), result.getName()));
    }
}
