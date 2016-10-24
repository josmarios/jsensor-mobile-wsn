package projects.MobileWSN.sink;

import jsensor.nodes.Node;
import jsensor.nodes.models.DistributionModelNode;
import jsensor.utils.Configuration;
import jsensor.utils.Position;

public class SinkDistributionModel extends DistributionModelNode {

	@Override
	public Position getPosition(Node arg0) {

		return new Position(1600, arg0.getRandom().nextInt(Configuration.dimY));
	}

}
