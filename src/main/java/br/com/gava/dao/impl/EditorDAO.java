package br.com.gava.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import br.com.gava.dao.IEditorDAO;
import br.com.gava.mappers.ProjectMapper;
import br.com.gava.model.ProjectModel;

@Component
public class EditorDAO extends GenericDAO implements IEditorDAO {
	private static final Logger LOGGER = LoggerFactory.getLogger(EditorDAO.class);

	@Override
	public ProjectModel openProject(Integer projId) {
		try {
			
			List<ProjectModel> list = null;
			
			String query = "select * from EdMap.project WHERE proj_id = :projId";

			MapSqlParameterSource params = new MapSqlParameterSource();
			params.addValue( "projId" , projId);
			
			list = this.getNamedParameterJdbcTemplate().query( query, params, new ProjectMapper() );

			if(list != null && list.size() > 0){
				return list.get(0);
			}
			
			return null;
			
		} catch( Exception e ) {
			LOGGER.error("openProject error", e);
		}

		return null;
	}

//	@Override
//	public Boolean isGisUserAttached(Integer refGrpId) {
//		try {
//			String teste = String.valueOf( this.getJdbcTemplate().queryForObject("select proj_id from EdMap.project WHERE proj_id = ?", new Object[]{projId}, Integer.class) );
//		} catch (Exception ex) {
//			LOGGER.warn("Ocorreu um erro ao abrir o mapa para editar " + ex.getMessage());
//		}
//	}

}