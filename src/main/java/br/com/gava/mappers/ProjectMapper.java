package br.com.gava.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import br.com.gava.model.ProjectModel;

public class ProjectMapper implements ResultSetExtractor<List<ProjectModel>> {

	@Override
	public List<ProjectModel> extractData(ResultSet rs) throws SQLException, DataAccessException {
	
		List<ProjectModel> list = new LinkedList<>();
		
		if(rs!= null){
			
			while(rs.next()){
				
				ProjectModel dto = new ProjectModel();
			
				dto.setProjId( rs.getInt("proj_id") );
				
//				dto.setAttribute(rs.getString("attribute"));
//				dto.setName(rs.getString("name"));
//				dto.setIntKey(rs.getString("intKey"));
//				dto.setDescr(rs.getString("descr"));
				
				list.add(dto);
				
			}
			
		}
		
		return list;
		
	}
	
}

