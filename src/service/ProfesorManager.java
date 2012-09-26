package universidad.service;

import java.util.List;
import java.io.Serializable;
import universidad.domain.Profesor;

public interface ProfesorManager extends Serializable
{
	public List<Profesor> getProfesores();
}