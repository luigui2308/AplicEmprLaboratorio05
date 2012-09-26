package universidad.domain;

import java.io.Serializable;

public class Profesor implements Serializable
{
	private String nombProf;
	private String idProf;
	private String tituloProf;

	public String getNombProf()
	{
		return nombProf;
	}
	
	public void setNombProf(String n)
	{
		nombProf=n;
	}
	
	public String getIdProf()
	{
		return idProf;
	}
	
	public void setIdProf(String id)
	{
		idProf=id;
	}
	
	public String getTituloProf()
	{
		return tituloProf;
	}
	
	public void setTituloProf(String tit)
	{
		tituloProf = tit;
	}
}