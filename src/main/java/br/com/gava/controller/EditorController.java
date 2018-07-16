package br.com.gava.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ObjectNode;

import br.com.gava.model.ProjectModel;
import br.com.gava.service.IEditorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Endpoint de accesso ao Editor do EdMap
 */
@RestController
@RequestMapping(path="/edmap/api/v1/editor")
@ConditionalOnProperty(value = "rest.edmap.enabled", havingValue = "true", matchIfMissing = true)
@Api(value="Edmap Editor", description="API para integração com editor de Mapa.")
public class EditorController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EditorController.class);
	
	@Autowired
	private MappingJackson2HttpMessageConverter jacksonConverter;
	
	@Autowired
	private IEditorService editorService;
	/*
	 * API REST
	 */
	@ApiOperation(value="Abrir projeto do mapa.")
	@RequestMapping(path="open/{projId}", method=RequestMethod.GET, produces="application/json")
	public @ResponseBody String /*ObjectNode*/ openProject( @PathVariable("projId") Integer projId ) throws Exception {
//		this.jiraService.testIssue( issue );
		LOGGER.debug( "Open Project: " + projId );
		
		ProjectModel p = editorService.openProject( projId );
		
		ObjectNode objNode = this.jacksonConverter.getObjectMapper().createObjectNode();
		
		objNode.put("data", true);
		
		return p.toJson();
//		return objNode;
		
	}

}