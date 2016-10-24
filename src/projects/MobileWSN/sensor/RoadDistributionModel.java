package projects.MobileWSN.sensor;

import jsensor.nodes.Node;
import jsensor.nodes.models.DistributionModelNode;
import jsensor.utils.Position;

public class RoadDistributionModel extends DistributionModelNode {

	@Override
	public Position getPosition(Node arg0) {
		return new Position(1, 300);
	}

}
