package org.controllers.positionOperations;

import org.ApplicationContext;
import org.controllers.OperationTypeController;
import org.entities.Position;
import org.utils.JsonUtilsDataExtractor;
import org.utils.XmlUtilsDataExtractor;

import java.util.List;

public class PositionAddFromFileOperationController implements OperationTypeController {
    @Override
    public String execute(String[] parseCommands) {
        StringBuilder added = new StringBuilder("Added id: ");
        StringBuilder notAdded = new StringBuilder("Not added id: ");
        List<Position> positions = ApplicationContext.INSTANCE.getDataAccessor().getProperties().getProperty("suffix")
                .equals("xml") ?
                XmlUtilsDataExtractor.extractPositions(parseCommands[2]) :
                JsonUtilsDataExtractor.extractPositions(parseCommands[2]);
        for (Position position : positions) {
            if (ApplicationContext.positionDao.addPosition(position.getName(), position.getSalary())) {
                added.append(position.getId());
            } else {
                notAdded.append(position.getId());
            }
        }
        return added.toString() + "\n" + notAdded.toString();
    }
}
