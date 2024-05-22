package org.korgut.clinicapi.domain.admin.core.model.results;

public abstract class CommandResult {
    String commandId;
    String inboundCommandId;

    public CommandResult(String commandId, String inboundCommandId) {
       this.commandId = commandId;
       this.inboundCommandId = inboundCommandId;
    }

    public String getCommandId() {
        return commandId;
    }

    public void setCommandId(String commandId) {
        this.commandId = commandId;
    }

    public String getInboundCommandId() {
        return inboundCommandId;
    }

    public void setInboundCommandId(String inboundCommandId) {
        this.inboundCommandId = inboundCommandId;
    }
}
