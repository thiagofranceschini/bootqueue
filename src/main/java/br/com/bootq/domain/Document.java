package br.com.bootq.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.bootq.domain.enums.DocumentType;

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
	
	private Date date;
	private Date dateStartProcess;
	private Date dateEndProcess;
	private String idRobot;
	private String taskStatus;
	private String researchStatus;
	private String resultMessage;
	private String linkAtachment;
	private Integer priority;
	
	
	
	public Document() {
		super();
	}

	//first constructor with minimum s3 data
	public Document(String cnpjMaster, DocumentType docType, String docNumber, String nameInDoc, String researchWeb) {
		this.cnpjMaster=cnpjMaster;
		this.docType=docType.name();
		this.docValue=docNumber;
		this.nameInDoc=nameInDoc;
		this.researchWeb=researchWeb;
		this.taskStatus="WAITING";
		this.priority=10;
	}
	
	//second constructor with differentiated priority
	public Document(String cnpjMaster, DocumentType docType, String docNumber, String nameInDoc, String researchWeb, Integer priority) {
		this.cnpjMaster=cnpjMaster;
		this.docType=docType.name();
		this.docValue=docNumber;
		this.nameInDoc=nameInDoc;
		this.researchWeb=researchWeb;
		this.priority=priority;
		this.taskStatus="WAITING";
	}
	
	
	public Document(String cnpjMaster, DocumentType docType, String docNumber, String nameInDoc, String researchWeb, Integer priority, String dtNasc, String ufOrigin, String ufResearch) {
		this.cnpjMaster=cnpjMaster;
		this.docType=docType.name();
		this.docValue=docNumber;
		this.nameInDoc=nameInDoc;
		this.researchWeb=researchWeb;
		this.priority=priority;
		this.dtNasc=dtNasc;
		this.ufOrigin=ufOrigin;
		this.ufResearch=ufResearch;
		this.taskStatus="WAITING";
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

	public String getDocNumber() {
		return docValue;
	}

	public void setDocNumber(String docNumber) {
		this.docValue = docNumber;
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

	public Date getDateStartProcess() {
		return dateStartProcess;
	}

	public void setDateStartProcess(Date dateStartProcess) {
		this.dateStartProcess = dateStartProcess;
	}

	public Date getDateEndProcess() {
		return dateEndProcess;
	}

	public void setDateEndProcess(Date dateEndProcess) {
		this.dateEndProcess = dateEndProcess;
	}

	public String getIdRobot() {
		return idRobot;
	}

	public void setIdRobot(String idRobot) {
		this.idRobot = idRobot;
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

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public String getComarca() {
		return docValue;
	}

	public void setComarca(String comarca) {
		this.docValue = comarca;
	}

	public String getSource() {
		return nameInDoc;
	}

	public void setSource(String source) {
		this.nameInDoc = source;
	}

	
	public String getDocumentType() {
		return docType;
	}

	public void setDocumentType(String documentType) {
		this.docType = documentType;
	}

	public String getCodeDocument() {
		return cnpjMaster;
	}

	public void setCodeDocument(String codeDocument) {
		this.cnpjMaster = codeDocument;
	}

	public String getResultStatus() {
		return ufResearch;
	}

	public void setResultStatus(String resultStatus) {
		this.ufResearch = resultStatus;
	}

	public String getCode() {
		return cnpjMaster;
	}

	public void setCode(String code) {
		this.cnpjMaster = code;
	}

	public String getStatus() {
		return ufOrigin;
	}

	public void setStatus(String status) {
		this.ufOrigin = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date sdf) {
		this.date = sdf;
	}

	public Integer getId() {
		return jobId;
	}

	public void setId(Integer id) {
		this.jobId = id;
	}

	public String getName() {
		return docType;
	}

	public void setName(String name) {
		this.docType = name;
	}

	public String getCodigo() {
		return cnpjMaster;
	}

	public void setCodigo(String codigo) {
		this.cnpjMaster = codigo;
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

	@Override
	public String toString() {
		return "Documento [id=" + jobId + ", name=" + docType + ", codigo=" + cnpjMaster + ", status=" + ufOrigin
				+ "]";
	}
	
}
