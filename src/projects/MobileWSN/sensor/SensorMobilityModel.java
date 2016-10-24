package projects.MobileWSN.sensor;

import jsensor.nodes.Node;
import jsensor.nodes.models.MobilityModel;
import jsensor.utils.Position;

public class SensorMobilityModel extends MobilityModel {

	private final int INCREMENT = 10;

	@Override
	public MobilityModel clone() {
		return null;
	}

	@Override
	public Position getNextPosition(Node node) {

		Position currentPos = node.getPosition();
		Position newPos = new Position(currentPos.getPosX() + INCREMENT, currentPos.getPosY());
		node.setPosition(newPos);
		
		return newPos;
	}

}
