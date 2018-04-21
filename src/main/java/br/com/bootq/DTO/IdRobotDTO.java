package br.com.bootq.DTO;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class IdRobotDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	@NotEmpty(message="Informe o Id do agente")
	private String idRobot;

	public IdRobotDTO() {
		super();
	}

	public IdRobotDTO(String idRobot) {
		super();
		this.idRobot = idRobot;
	}

	public String getIdRobot() {
		return idRobot;
	}

	public void setIdRobot(String idRobot) {
		this.idRobot = idRobot;
	}
	
	

}
