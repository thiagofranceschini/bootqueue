package br.com.bootq.DTO;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class DocumentDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer jobId;
	@NotEmpty(message="Preenchimento obrigatório.")
	private String cnpjMaster;
	@NotEmpty(message="Preenchimento obrigatório.")
	private String docType;
	@NotEmpty(message="Preenchimento obrigatório.")
	private String docValue;
	@NotEmpty(message="Preenchimento obrigatório.")
	private String nameInDoc;
	@NotEmpty(message="Preenchimento obrigatório.")
	private String researchWeb;
	private String dtNasc;
	private String ufOrigin;
	private String ufResearch;
	private Integer priority;
	@NotEmpty(message="Id do Agente necessário.")
	private String idRobot;
	
	
	public DocumentDTO() {
		super();
	}


	public DocumentDTO(Integer jobId, String cnpjMaster, String docType, String docValue, String nameInDoc, String researchWeb, 
														String dtNasc, String ufOrigin,	String ufResearch, Integer priority,String idRobot) {
		this.jobId = jobId;
		this.cnpjMaster = cnpjMaster;
		this.docType = docType;
		this.docValue = docValue;
		this.nameInDoc = nameInDoc;
		this.researchWeb = researchWeb;
		this.dtNasc = dtNasc;
		this.ufOrigin = ufOrigin;
		this.ufResearch = ufResearch;
		this.priority = priority;
		this.idRobot= idRobot;
	}
	

	public DocumentDTO(Integer jobId, String cnpjMaster, String docType, String docValue, String nameInDoc, String researchWeb) {
		this.jobId = jobId;
		this.cnpjMaster = cnpjMaster;
		this.docType = docType;
		this.docValue = docValue;
		this.nameInDoc = nameInDoc;
		this.researchWeb = researchWeb;
	}
	
	


	public DocumentDTO(String idRobot) {
		this.idRobot = idRobot;
	}
	
	


	public String getIdRobot() {
		return idRobot;
	}


	public void setIdRobot(String idRobot) {
		this.idRobot = idRobot;
	}


	public Integer getJobId() {
		return jobId;
	}
	


	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}


	public String getCnpjMaster() {
		return cnpjMaster;
	}


	public void setCnpjMaster(String cnpjMaster) {
		this.cnpjMaster = cnpjMaster;
	}


	public String getDocType() {
		return docType;
	}


	public void setDocType(String docType) {
		this.docType = docType;
	}


	public String getDocValue() {
		return docValue;
	}


	public void setDocValue(String docValue) {
		this.docValue = docValue;
	}


	public String getNameInDoc() {
		return nameInDoc;
	}


	public void setNameInDoc(String nameInDoc) {
		this.nameInDoc = nameInDoc;
	}


	public String getResearchWeb() {
		return researchWeb;
	}


	public void setResearchWeb(String researchWeb) {
		this.researchWeb = researchWeb;
	}


	public String getDtNasc() {
		return dtNasc;
	}


	public void setDtNasc(String dtNasc) {
		this.dtNasc = dtNasc;
	}


	public String getUfOrigin() {
		return ufOrigin;
	}


	public void setUfOrigin(String ufOrigin) {
		this.ufOrigin = ufOrigin;
	}


	public String getUfResearch() {
		return ufResearch;
	}


	public void setUfResearch(String ufResearch) {
		this.ufResearch = ufResearch;
	}


	public Integer getPriority() {
		return priority;
	}


	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
	
	
}
