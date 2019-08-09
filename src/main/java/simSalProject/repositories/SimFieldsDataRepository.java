package simSalProject.repositories;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import simSalProject.models.SimFieldsData;


@Named("SimFieldsDataRep")
@RequestScoped
public class SimFieldsDataRepository extends EntityRepository<SimFieldsData> {

	@Override
	protected String getAllIds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getAllValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<SimFieldsData> getEntityClass() {
		// TODO Auto-generated method stub
		return null;
	}

}
