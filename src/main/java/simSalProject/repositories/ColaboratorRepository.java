package simSalProject.repositories;

import javax.faces.bean.RequestScoped;
import javax.inject.Named;

import simSalProject.models.Colaborator;

@Named("ColabRep")
@RequestScoped
public class ColaboratorRepository extends EntityRepository<Colaborator> {
	

	@Override
	protected String getAllIds() {
		// TODO Auto-generated method stub
		return Colaborator.ALL_COLABORATOR_IDS;
	}

	@Override
	protected String getAllValues() {
		// TODO Auto-generated method stub
		return Colaborator.ALL_COLABORATOR_VALUES;
	}

	@Override
	public Class<Colaborator> getEntityClass(){
		return Colaborator.class;
	}
}
