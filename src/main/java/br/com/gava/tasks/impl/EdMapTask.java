package br.com.gava.tasks.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;

import br.com.gava.cache.IEditorCache;

public class EdMapTask {

	private static final Logger LOGGER = LoggerFactory.getLogger(EdMapTask.class);
	
	@Value("${schedule.editor.enabled}")
	private boolean doEditorSchedule = false;
	
	@Value("${schedule.viewer.enabled}")
	private boolean doViewerSchedule = false;
	
	@Autowired
	private IEditorCache editorCache;
	
	@Scheduled( initialDelayString="${schedule.editor.delay}", fixedRateString="${schedule.editor.pooling}" )
    private void editorSchedule() {
		if( doEditorSchedule ) {
			LOGGER.debug( "Init Cache do Editor" );
			editorCache.init();
		}
		
    }
	
	@Scheduled( initialDelayString="${schedule.viewer.delay}", fixedRateString="${schedule.viewer.pooling}" )
    private void viewerSchedule() {
		if( doViewerSchedule ) {
			LOGGER.debug( "Init Cache do Viewert" );
		}
    }
}