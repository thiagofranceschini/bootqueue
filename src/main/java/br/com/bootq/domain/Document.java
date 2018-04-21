package br.com.bootq.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Document implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer jobId;
	private String cnpjMaster;
	private String docType;
	private String docValue;
	private String nameInDoc;
	private String researchWeb;
	private String dtNasc;
	private String ufOrigin;
	private String ufResearch;
	
	private LocalDateTime date;
	private LocalDateTime dateStartProcess;
	private LocalDateTime dateEndProcess;
	private String idRobot;
	private String taskStatus;
	private String researchStatus;
	private String resultMessage;
	private String linkAtachment;
	private Integer priority;
	
	
	public Document() {
		super();
	}
	

	public Document(String idRobot) {
		this.idRobot = idRobot;
	}


	public Document(String cnpjMaster, String string, String docNumber, String nameInDoc, String researchWeb) {
		this.cnpjMaster=cnpjMaster;
		this.docType=string;
		this.docValue=docNumber;
		this.nameInDoc=nameInDoc;
		this.researchWeb=researchWeb;
		this.taskStatus="WAITING";
		this.priority=10;
	}
	
	
	public Document(String cnpjMaster, String string, String docNumber, String nameInDoc, String researchWeb, Integer priority) {
		this.cnpjMaster=cnpjMaster;
		this.docType=string;
		this.docValue=docNumber;
		this.nameInDoc=nameInDoc;
		this.researchWeb=researchWeb;
		this.priority=priority;
		this.taskStatus="WAITING";
	}
	

	public Document(String cnpjMaster, String string, String docNumber, String nameInDoc, String researchWeb, Integer priority, String dtNasc, String ufOrigin, String ufResearch) {
		this.cnpjMaster=cnpjMaster;
		this.docType=string;
		this.docValue=docNumber;
		this.nameInDoc=nameInDoc;
		this.researchWeb=researchWeb;
		this.priority=priority;
		this.dtNasc=dtNasc;
		this.ufOrigin=ufOrigin;
		this.ufResearch=ufResearch;
		this.taskStatus="WAITING";
	}
	
	
	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
	}

	public String getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(String string) {
		this.taskStatus = string;
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

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public LocalDateTime getDateStartProcess() {
		return dateStartProcess;
	}

	public void setDateStartProcess(LocalDateTime now) {
		this.dateStartProcess = now;
	}

	public LocalDateTime getDateEndProcess() {
		return dateEndProcess;
	}

	public void setDateEndProcess(LocalDateTime dateEndProcess) {
		this.dateEndProcess = dateEndProcess;
	}

	public String getIdRobot() {
		return idRobot;
	}

	public void setIdRobot(String idRobot) {
		this.idRobot = idRobot;
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

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jobId == null) ? 0 : jobId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Document other = (Document) obj;
		if (jobId == null) {
			if (other.jobId != null)
				return false;
		} else if (!jobId.equals(other.jobId))
			return false;
		return true;
	}

	
	
}
