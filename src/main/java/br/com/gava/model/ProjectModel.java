package br.com.gava.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.Gson;

public class ProjectModel implements Serializable {

	private static final long serialVersionUID = 81571756450591542L;
	
	@JsonProperty("projId")
	private int projId;

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("height")
	private Double height;

	private Double width;
	
	private Integer grid;
	
	private Integer autosave;

	private String bgcolor;
	
	private byte[] bgimage;
	
	private Timestamp dateCreated;
	
//	private List<Component> components;

//	private List<ComponentsConnection> connections;
	
	private Integer userId;
	
	public ProjectModel() { }

	public int getProjId() {
		return projId;
	}

	public void setProjId(int projId) {
		this.projId = projId;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Integer getGrid() {
		return grid;
	}

	public void setGrid(Integer grid) {
		this.grid = grid;
	}

	public Integer getAutosave() {
		return autosave;
	}

	public void setAutosave(Integer autosave) {
		this.autosave = autosave;
	}

	public String getBgcolor() {
		return bgcolor;
	}

	public void setBgcolor(String bgcolor) {
		this.bgcolor = bgcolor;
	}

	public byte[] getBgimage() {
		return bgimage;
	}

	public void setBgimage(byte[] bgimage) {
		this.bgimage = bgimage;
	}

	public Timestamp getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String toJson() {
		return new Gson().toJson(this);
	}
	
}