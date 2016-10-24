package projects.MobileWSN.sensor;

import jsensor.nodes.Node;
import jsensor.nodes.models.MobilityModel;
import jsensor.utils.Position;

public class SensorMobilityModel extends MobilityModel {

	private final int INCREMENT = 10;

	@Override
	public MobilityModel clone() {
		
		return new SensorMobilityModel();
	}

	@Override
	public Position getNextPosition(Node node) {
		Position newPos;
		
			Position currentPos = node.getPosition();
			newPos = new Position(currentPos.getPosX() + INCREMENT, currentPos.getPosY());
			//System.out.println(node.getID()+">>>"+newPos.toString());
			// node.setPosition(newPos);
		
		return newPos;
	}

}
