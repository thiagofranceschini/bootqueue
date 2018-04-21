package br.com.bootq.DTO;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class ReturnDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer jobId;
	private String taskStatus;
	@NotEmpty(message="Retorno deve conter status da pesquisa.")
	private String researchStatus;
	@NotEmpty(message="retorno deve mensagem de status do processo.")
	private String resultMessage;
	private String linkAtachment;

	public ReturnDTO() {
	}

	public ReturnDTO(Integer jobId, String taskStatus, String researchStatus, String resultMessage) {
		this.jobId=jobId;
		this.taskStatus = taskStatus;
		this.researchStatus = researchStatus;
		this.resultMessage = resultMessage;
	}
	
	

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getResearchStatus() {
		return researchStatus;
	}

	public void setResearchStatus(String researchStatus) {
		this.researchStatus = researchStatus;
	}

	public String getResultMessage() {
		return resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public String getLinkAtachment() {
		return linkAtachment;
	}

	public void setLinkAtachment(String linkAtachment) {
		this.linkAtachment = linkAtachment;
	}
	
	
}
