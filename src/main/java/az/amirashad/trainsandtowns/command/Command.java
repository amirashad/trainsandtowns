package az.amirashad.assessment.command;

import az.amirashad.assessment.Commuter;

public interface Command {
    Object execute(Commuter commuter);
}
