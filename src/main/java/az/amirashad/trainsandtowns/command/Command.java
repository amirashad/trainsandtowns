package az.amirashad.trainsandtowns.command;

import az.amirashad.trainsandtowns.Commuter;

public interface Command {
    Object execute(Commuter commuter);
}
