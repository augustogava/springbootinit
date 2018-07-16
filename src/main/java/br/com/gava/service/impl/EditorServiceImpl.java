package br.com.gava.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gava.dao.IEditorDAO;
import br.com.gava.model.ProjectModel;
import br.com.gava.service.IEditorService;

@Service
public class EditorServiceImpl implements IEditorService {
	
	@Autowired
	private IEditorDAO editorDAO;
	
	@Override
	public ProjectModel openProject(Integer projId) {
		return editorDAO.openProject(projId);
	}
}
