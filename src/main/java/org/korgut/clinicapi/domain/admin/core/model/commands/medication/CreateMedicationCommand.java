package org.korgut.clinicapi.domain.admin.core.model.commands.medication;
public record CreateMedicationCommand(String commandId, String name, String serialNumber) {
    public CreateMedicationCommand {
        if (commandId == null || commandId.isBlank())
            throw new IllegalArgumentException("CommandId cannot be null");

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Medication name cannot be null or blank");
        }

        if (serialNumber == null || serialNumber.isBlank()) {
            throw new IllegalArgumentException("Serial number name cannot be null or blank");
        }
    }
}
